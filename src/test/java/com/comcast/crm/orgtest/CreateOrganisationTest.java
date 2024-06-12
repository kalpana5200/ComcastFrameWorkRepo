
package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.Objectrepository.CreateNewOrganisationPage;
import com.comcast.crm.Objectrepository.HomePage;
import com.comcast.crm.Objectrepository.LoginPage;
import com.comcast.crm.Objectrepository.OrganisationInfoPage;
import com.comcast.crm.Objectrepository.Organisationspage;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebdriverUtility;
import com.concast.crm.basetest.BaseClass;

import interfaceiconstant.Iconstant;
/**
 * This class contains CreateOrganisationTest test Scripts
 * @author kalpana
 * 
 */
@Listeners(com.comcast.crm.listenerUtility.ListImpClass.class)
public class CreateOrganisationTest extends BaseClass {
	@Test(groups = "smokeTest")
	public void CreateOrganisation() throws Throwable {
		
		UtilityClassObject.getTest().log(Status.INFO, "read data from excelsheet");
		// read data from excelsheet
		String orgname = elib.getDataFromExcel("org", 4, 2) + jlib.getRandomNumber();

		UtilityClassObject.getTest().log(Status.INFO, "navigate to homepage");
		HomePage hp = new HomePage(UtilityClassObject.getDriver());
		hp.getOrgLink().click();

		UtilityClassObject.getTest().log(Status.INFO, "navigate to createNewOrg page");
		Organisationspage op = new Organisationspage(UtilityClassObject.getDriver());
		op.getCreateNewOrg().click();

		CreateNewOrganisationPage cnp = new CreateNewOrganisationPage(UtilityClassObject.getDriver());
		cnp.createOrg(orgname);

		UtilityClassObject.getTest().log(Status.INFO, "validating header msg");
		OrganisationInfoPage oip = new OrganisationInfoPage(UtilityClassObject.getDriver());
		String headerinfo = oip.getHeaderMsg().getText();
		boolean status = headerinfo.contains(orgname);
		Assert.assertEquals(status, true);

		String actualinfo = UtilityClassObject.getDriver()
				.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
		SoftAssert sf = new SoftAssert();
		boolean status1 = actualinfo.contains(orgname);

		sf.assertEquals(status1, true);

		sf.assertAll();
	}

	@Test(groups = "regressionTest")
	public void CreateOrganisationWithIndustry() throws Throwable {

		String orgname = elib.getDataFromExcel("org", 4, 2) + jlib.getRandomNumber();
		String industry = elib.getDataFromExcel("org", 4, 3);
		String type = elib.getDataFromExcel("org", 4, 4);

		UtilityClassObject.getTest().log(Status.INFO, "Navigate to homepage");
		HomePage hp = new HomePage(UtilityClassObject.getDriver());
		hp.getOrgLink().click();

		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Organisationspage");
		Organisationspage op = new Organisationspage(UtilityClassObject.getDriver());
		op.getCreateNewOrg().click();

		UtilityClassObject.getTest().log(Status.INFO, "creating new organisation");
		CreateNewOrganisationPage cnp = new CreateNewOrganisationPage(UtilityClassObject.getDriver());
		cnp.createOrg(orgname, industry);

		UtilityClassObject.getTest().log(Status.INFO, "Validating header msg");
		OrganisationInfoPage oip = new OrganisationInfoPage(UtilityClassObject.getDriver());
		String headerinfo = oip.getHeaderMsg().getText();

		boolean status2 = headerinfo.contains(orgname);
		Assert.assertEquals(status2, true);

//		if (headerinfo.contains(orgname)) {
//			System.out.println(orgname + " is created==pass");
//		} else {
//			System.out.println(orgname + " is not created==fail");
//		}
		UtilityClassObject.getTest().log(Status.INFO, "Validating Actual industry");
		String actualindustry = oip.getIndustry().getText();
		SoftAssert sf1 = new SoftAssert();
		boolean status3 = actualindustry.trim().equals(industry);

		sf1.assertEquals(status3, true);

		sf1.assertAll();
	}

	@Test(groups = "regressionTest")
	public void CreateOrganisationWithPhone() throws Throwable {
		
		UtilityClassObject.getTest().log(Status.INFO, "read data from excelsheet");
		// read data from excelsheet
		String lastname = elib.getDataFromExcel("org", 7, 2) + jlib.getRandomNumber();
		String phno = elib.getDataFromExcel("org", 7, 3);

		UtilityClassObject.getTest().log(Status.INFO, "Navigating homepage");
		HomePage hp = new HomePage(UtilityClassObject.getDriver());
		hp.getOrgLink().click();

		UtilityClassObject.getTest().log(Status.INFO, "Navigating to Organisation page");
		Organisationspage op = new Organisationspage(UtilityClassObject.getDriver());
		op.getCreateNewOrg().click();

		CreateNewOrganisationPage cnp = new CreateNewOrganisationPage(UtilityClassObject.getDriver());
		cnp.createOrgP(lastname, phno);

		UtilityClassObject.getTest().log(Status.INFO, "validating actualphno");
		SoftAssert sf2 = new SoftAssert();
		String actualphno = cnp.getPhTextBxVerify().getText();
		boolean st = actualphno.trim().equals(phno);
		sf2.assertEquals(st, true);

	}
}
