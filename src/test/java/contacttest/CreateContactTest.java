
package contacttest;

import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.comcast.crm.Objectrepository.ContactInfoPage;
import com.comcast.crm.Objectrepository.ContactsPage;
import com.comcast.crm.Objectrepository.CreateNewContactPage;
import com.comcast.crm.Objectrepository.CreateNewOrganisationPage;
import com.comcast.crm.Objectrepository.HomePage;
import com.comcast.crm.Objectrepository.OrganisationInfoPage;
import com.comcast.crm.Objectrepository.Organisationspage;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.listenerUtility.ListImpClass;
import com.concast.crm.basetest.BaseClass;

@Listeners(com.comcast.crm.listenerUtility.ListImpClass.class)
/**
 * This class contains test Scripts
 * @author kalpana
 * 
 */
public class CreateContactTest extends BaseClass {
	@Test(groups = "smokeTest")
	public void createContact() throws Throwable {

		UtilityClassObject.getTest().log(Status.INFO, "read data from excel");

		// read data from excelsheet
		String lastname = elib.getDataFromExcel("contact", 1, 2) + jlib.getRandomNumber();

		/* Navigate to homepage */
		UtilityClassObject.getTest().log(Status.INFO, "navigate to home page");
		HomePage hp = new HomePage(UtilityClassObject.getDriver());
		hp.getContactLink().click();

		UtilityClassObject.getTest().log(Status.INFO, "navigate to contacts page");

		ContactsPage cp = new ContactsPage(UtilityClassObject.getDriver());
		cp.getCreateNewConLnk().click();

		UtilityClassObject.getTest().log(Status.INFO, "navigate to CreateNewContactPage page");
		CreateNewContactPage cnp = new CreateNewContactPage(UtilityClassObject.getDriver());
		cnp.createContact(lastname);
		Thread.sleep(1000);

		ContactInfoPage cip = new ContactInfoPage(UtilityClassObject.getDriver());

		UtilityClassObject.getTest().log(Status.INFO, "validating header msg");
		String headermsg = cip.getHeaderTxt().getText();
		boolean status = headermsg.contains(lastname);
		Assert.assertEquals(status, true);

		Thread.sleep(1000);
		String alname = cip.getLastNmaeVerify().getText();
		SoftAssert sf = new SoftAssert();
		String al = alname.trim();
		sf.assertEquals(al, lastname);

		sf.assertAll();
	}

	@Test(groups = "regressionTest")
	public void CreateContactWithOrganisation() throws Throwable {

		String orgname = elib.getDataFromExcel("contact", 7, 2) + jlib.getRandomNumber();
		String lastname = elib.getDataFromExcel("contact", 7, 2) + jlib.getRandomNumber();

		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Homepage");
		HomePage hp = new HomePage(UtilityClassObject.getDriver());
		hp.getOrgLink().click();

		UtilityClassObject.getTest().log(Status.INFO, "create new organisation page");
		Organisationspage op = new Organisationspage(UtilityClassObject.getDriver());
		op.getCreateNewOrg().click();

		UtilityClassObject.getTest().log(Status.INFO, "creating new organisation");
		CreateNewOrganisationPage cnp = new CreateNewOrganisationPage(UtilityClassObject.getDriver());
		cnp.createOrg(orgname);

		UtilityClassObject.getTest().log(Status.INFO, "Validating the header msg in organisation");
		OrganisationInfoPage oip = new OrganisationInfoPage(UtilityClassObject.getDriver());
		String headerinfo = oip.getHeaderMsg().getText();

		SoftAssert sf = new SoftAssert();
		boolean status = headerinfo.contains(orgname);
		sf.assertEquals(status, true);

//		if (headerinfo.contains(orgname)) {
//			System.out.println(orgname + " is created==pass");
//		} else {
//			System.out.println(orgname + " is not created==fail");
//
//		}

		// step 5: navigate to contact

		UtilityClassObject.getTest().log(Status.INFO, "Navigate to contact page");
		oip.getContactLink().click();

		UtilityClassObject.getTest().log(Status.INFO, "Navigating to create new contact page ");
		ContactsPage cp = new ContactsPage(UtilityClassObject.getDriver());
		cp.getCreateNewConLnk().click();

		CreateNewContactPage cncp = new CreateNewContactPage(UtilityClassObject.getDriver());
		cncp.getConNameEdt().sendKeys(lastname);
		cncp.getOrgPlusBtn().click();

		UtilityClassObject.getTest().log(Status.INFO, "switch to child window for organisation");
		// switch to child window
		wlib.switchToTabOnURL(UtilityClassObject.getDriver(), "module=Accounts");

		cncp.childPopup(orgname);
		UtilityClassObject.getDriver().findElement(By.xpath("//a[text()='" + orgname + "']")).click();

		UtilityClassObject.getTest().log(Status.INFO, "switch to parent window");
		// switch to parent window
		wlib.switchToTabOnURL(UtilityClassObject.getDriver(), "Contacts&action");

		cncp.getConSaveBtn().click();

		ContactInfoPage cip = new ContactInfoPage(UtilityClassObject.getDriver());

		UtilityClassObject.getTest().log(Status.INFO, "validating the header msg");
		String headerinfoo = cip.getHeaderTxt().getText();
		boolean st = headerinfoo.contains(lastname);
		sf.assertEquals(st, true);
//		if (headerinfoo.contains(lastname)) {
//			System.out.println(lastname + " is created==pass");
//		} else {
//			System.out.println(lastname + " is not created==fail");
//
//		}
		String actualinfo = cip.getOrgNameVerify().getText();
		sf.assertEquals(actualinfo.contains(orgname), true);
//		if (actualinfo.contains(orgname)) {
//			System.out.println(orgname + " is created==pass");
//		} else {
//			System.out.println(orgname + " is not created==fail");
//
//		}
		sf.assertAll();
	}

	@Test(groups = "regressionTest")
	public void CreateContactWithSupportDate() throws Throwable {

		String lastname = elib.getDataFromExcel("contact", 4, 2) + jlib.getRandomNumber();

		UtilityClassObject.getTest().log(Status.INFO, "Navigating to contact page ");
		HomePage hp = new HomePage(UtilityClassObject.getDriver());
		hp.getContactLink().click();

		UtilityClassObject.getTest().log(Status.INFO, "Navigating to Create New contact page ");
		ContactsPage cp = new ContactsPage(UtilityClassObject.getDriver());
		cp.getCreateNewConLnk().click();

		String startdate = jlib.getSystemDateYYYYMMDD();
		String afterdate = jlib.getRequiredDateYYYYMMDD(30);

		System.out.println("o " + startdate);
		System.out.println("o " + afterdate);

		UtilityClassObject.getTest().log(Status.INFO, "creating contact with supportdates");
		CreateNewContactPage cnp = new CreateNewContactPage(UtilityClassObject.getDriver());
		cnp.createContactWithSupportDates(lastname, startdate, afterdate);
		Thread.sleep(1000);

		UtilityClassObject.getTest().log(Status.INFO, "validating the dates ");
		ContactInfoPage cip = new ContactInfoPage(UtilityClassObject.getDriver());
		String astart = cip.getSptinfStartDateBx().getText();
		String astartt = astart.trim();

		System.out.println("A " + astart);
		SoftAssert sf = new SoftAssert();
		sf.assertEquals(astartt, startdate);

		String Aafterdate = cip.getSptinfEndtartDateBx().getText();
		String afterdt = Aafterdate.trim();
		sf.assertEquals(afterdt, afterdate);
		sf.assertAll();
	}

}
