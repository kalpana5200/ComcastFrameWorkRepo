package com.concast.crm.basetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.Objectrepository.HomePage;
import com.comcast.crm.Objectrepository.LoginPage;
import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebdriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver = null;
	public DataBaseUtility dlib = new DataBaseUtility();
	public FileUtility flib = new FileUtility();
	public ExcelUtility elib = new ExcelUtility();
	public WebdriverUtility wlib = new WebdriverUtility();
	public JavaUtility jlib = new JavaUtility();
	public static WebDriver edriver;

	@BeforeSuite(groups = { "smokeTest", "regressionTest" })
	public void configBS() throws Throwable {
		System.out.println("connect to Database");
		dlib.getDbConnection();
	}

	// @Parameters("browser")
	@BeforeClass(groups = { "smokeTest", "regressionTest" })

	// public void configBc(String browser) throws Throwable {
	public void configBc() throws Throwable {
		System.out.println("launch browser");

		String browser = flib.getDataFromPropertyFile("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		edriver = driver;
		UtilityClassObject.setDriver(driver);
	}

	@BeforeMethod(groups = { "smokeTest", "regressionTest" })
	public void configBm() throws Throwable {

		System.out.println("login");
		UtilityClassObject.setDriver(driver);

		String url = flib.getDataFromPropertyFile("url");
		String username = flib.getDataFromPropertyFile("username");
		String password = flib.getDataFromPropertyFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(url, username, password);
	}

	@AfterMethod(groups = { "smokeTest", "regressionTest" })
	public void configAm() {
		System.out.println("logout");
		HomePage hp = new HomePage(driver);
		hp.logout();
	}

	@AfterClass(groups = { "smokeTest", "regressionTest" })
	public void configAc() {
		System.out.println("closing the browser");
		driver.quit();
	}

	@AfterSuite(groups = { "smokeTest", "regressionTest" })
	public void configAs() throws Throwable {
		System.out.println("close the DBconnection");
		dlib.closeDbconnection();
	}

}
