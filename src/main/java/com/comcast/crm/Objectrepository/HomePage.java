package com.comcast.crm.Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * @author Kalpana
 * 
 * contains Home page elements & business lib like navigateToCampaignpage() and logout()
 * 
 */

public class HomePage {
WebDriver driver;
	
	@FindBy(linkText="Organizations")
	private WebElement OrgLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactLink;
	
	@FindBy(linkText="Campaign")
	private WebElement campaignLink;

	@FindBy(linkText="More")
	private WebElement moreLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signOutBtn;
	
	@FindBy(linkText="Products")
	private WebElement productLink;

	public HomePage(WebDriver driver) {
		this.driver=driver;
	PageFactory.initElements( driver, this);	
	}

	public WebElement getOrgLink() {
		return OrgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}
	
	
	public WebElement getProductLink() {
		return productLink;
	}

	/**
	 * This method contains bussiness logic for navigate to campaignpage 
	 */
	public void navigateToCampaignpage() {
		Actions act=new Actions(driver);
		act.moveToElement(moreLink).perform();
		campaignLink.click();
	}
	/**
	 * This method contains bussiness logic for logout functionality 
	 */
	public void logout() {
		Actions act=new Actions(driver);
		act.moveToElement(adminImg).perform();
		signOutBtn.click();
	}
}
