package com.comcast.crm.listenerUtility;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.concast.crm.basetest.BaseClass;
import com.google.common.io.Files;


public class ListImpClass implements ITestListener,ISuiteListener {
	public ExtentSparkReporter spark;
	public static ExtentReports report;
	public static ExtentTest test;
	
	@Override
	public void onStart(ISuite suite) {
		System.out.println("Report configuration");
		// spark report config
		String time=new Date().toString().replace(" ", "_").replace(":", "_");
				spark = new ExtentSparkReporter("./AdvanceReport/report"+time+".html");
				spark.config().setDocumentTitle("CRM Test suite Results");
				spark.config().setReportName("CRM Report");
				spark.config().setTheme(Theme.DARK);

				// add environment information
			    report = new ExtentReports();
				report.attachReporter(spark);
				report.setSystemInfo("OS", "WINDOW-10");
				report.setSystemInfo("Browser", "chrome-100");
	}
	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("report backup");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String name = result.getMethod().getMethodName();
	  System.out.println("=========>"+name+">===Start====");
	         test = report.createTest(name);
	         UtilityClassObject.setTest(test);
	         test.log(Status.INFO, name+"====>STARTED <======");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		 System.out.println("=========>"+result.getMethod().getMethodName()+">===end====");
		 test.log(Status.PASS, result.getMethod().getMethodName()+">===COMPLETED====");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName=result.getMethod().getMethodName();
		TakesScreenshot ts=(TakesScreenshot)BaseClass.edriver;
		String src=ts.getScreenshotAs(OutputType.BASE64);
	//	File src1=ts.getScreenshotAs(OutputType.FILE);
		
		String time=new Date().toString().replace(" ", "_").replace(":", "_");
		
		File dst=new File("./screenshot/"+testName+"+"+time+".png");
		//String p=src1.getAbsolutePath();
		
        try {
		//	Files.copy(src1, dst);
        	test.addScreenCaptureFromBase64String(src,"testName"+"_"+time);
        	//test.addScreenCaptureFromPath(p);
		} catch (Exception e) {
			
		}
        test.log(Status.FAIL, testName+"====>FAILED<======");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.FAIL, result.getMethod().getMethodName()+"====>SKIPPED<======");
		
	}
  
	
	


	
	

	
	
}


