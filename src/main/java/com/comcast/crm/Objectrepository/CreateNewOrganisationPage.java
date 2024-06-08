package com.comcast.crm.Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
/**
 * @author Kalpana
 * 
 * contains CreateNewOrganisationPage  elements & business lib like navigateToCampaignpage() and logout()
 * 
 */
public class CreateNewOrganisationPage {
	WebDriver driver;
	public CreateNewOrganisationPage(WebDriver driver) {
		this.driver=driver;
	PageFactory.initElements( driver, this);
	
	}
	
	@FindBy(name="accountname")
	private WebElement orgNameEdit;
	
	@FindBy(name="industry")
	private WebElement industryDD;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	@FindBy(id="phone")
	private WebElement phTextBx;
	
	//id("mouseArea_Phone")
	
	@FindBy(id="mouseArea_Phone")
	private WebElement phTextBxVerify;
	
	public WebElement getOrgNameEdit() {
		return orgNameEdit;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	
	
	public WebElement getPhTextBxVerify() {
		return phTextBxVerify;
	}

	/**
	 * This method contains bussiness logic for createOrg using orgname parameter
	 * @param orgname
	 */
	public void createOrg(String orgname) {
		orgNameEdit.sendKeys(orgname);
		savebtn.click();
	}
	/**
	 * This method contains bussiness logic for createOrg using parameter orgname and industry
	 * @param orgname
	 * @param industry
	 */
	public void createOrg(String orgname,String industry) {
		orgNameEdit.sendKeys(orgname);
		Select s=new Select(industryDD);
		s.selectByVisibleText(industry);
		savebtn.click();
	}
	/**
	 * This method contains bussiness logic for createOrg using parameter orgname and phno
	 * @param orgname
	 * @param phno
	 */
	public void createOrgP(String orgname,String phno) {
		orgNameEdit.sendKeys(orgname);
		phTextBx.sendKeys(phno);
		savebtn.click();
	}
	

}
