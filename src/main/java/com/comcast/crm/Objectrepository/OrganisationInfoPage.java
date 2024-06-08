package com.comcast.crm.Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * @author Kalpana
 * 
 * contains OrganisationInfoPage elements 
 */
public class OrganisationInfoPage {
	WebDriver driver;
	public OrganisationInfoPage(WebDriver driver) {
		this.driver=driver;
	PageFactory.initElements( driver, this);	
	}
	
	@FindBy(className="dvHeaderText")
	private WebElement headerMsg;
	
	@FindBy(linkText="Contacts")
	private WebElement contactLink;
	
	@FindBy(id="mouseArea_Industry")
	private WebElement industry;
	
	public WebElement getHeaderMsg() {
		return headerMsg;
	}

	public WebElement getContactLink() {
		return contactLink;
	}
	public WebElement getIndustry() {
		return industry;
	}

	
	
	
}
