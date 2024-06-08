package com.comcast.crm.Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * @author Kalpana
 * 
 * contains ContactInfoPage elements 
 */
public class ContactInfoPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement headerTxt ;
	
	@FindBy(xpath="//td[@id='mouseArea_Last Name']")
	private WebElement lastNmaeVerify;

	@FindBy(id="mouseArea_Organization Name")
	private WebElement orgNameVerify;
	
	@FindBy(id="mouseArea_Support Start Date")
	private WebElement sptinfStartDateBx;
	
	@FindBy(id="mouseArea_Support End Date")
	private WebElement sptinfEndtartDateBx;

	public ContactInfoPage(WebDriver driver) {
		this.driver=driver;
	PageFactory.initElements( driver, this);	
	}
	
	public WebElement getHeaderTxt() {
		return headerTxt;
	}

	public WebElement getLastNmaeVerify() {
		return lastNmaeVerify;
	}

	public WebElement getOrgNameVerify() {
		return orgNameVerify;
	}

	public WebElement getSptinfStartDateBx() {
		return sptinfStartDateBx;
	}

	public WebElement getSptinfEndtartDateBx() {
		return sptinfEndtartDateBx;
	}
	
	

}
