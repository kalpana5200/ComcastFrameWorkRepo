package com.comcast.crm.Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * @author Kalpana
 * 
 * contains CreateNewContactPage  elements & business lib like createContactWithSupportDates() and createContact()
 * 
 */
public class CreateNewContactPage {
	WebDriver driver;
	@FindBy(name="lastname")
	private WebElement ConNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement conSaveBtn ;
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
	private WebElement orgPlusBtn ;
	
	@FindBy(name="search_text")
	private WebElement orgPlusSearchTb ;
	
	@FindBy(name="search")
	private WebElement orgPlusSearchBtnn ; 
	
	
	@FindBy(name="support_start_date")
	private WebElement sptSDateTb ; 
	
	@FindBy(name="support_end_date")
	private WebElement sptEndDateTb ; 
	
	
	public CreateNewContactPage(WebDriver driver) {
		this.driver=driver;
	PageFactory.initElements( driver, this);	
	}
	/**
	 * This method contains bussiness logic for createcontact using lastname parameter
	 * @param lastname
	 */
	public void createContact(String lastname) {
		ConNameEdt.sendKeys(lastname);
		conSaveBtn.click();
	}
	/**
	 * This method contains bussiness logic for createcontact using lastname,startDate,EndDate parameter
	 * @param lastname
	 * @param startDate
	 * @param EndDate
	 */
	public void createContactWithSupportDates(String lastname,String startDate,String EndDate) {
		ConNameEdt.sendKeys(lastname);
		sptSDateTb.clear();
		sptSDateTb.sendKeys(startDate);
		sptEndDateTb.clear();
		sptEndDateTb.sendKeys(EndDate);
		conSaveBtn.click();
	}

	public WebElement getOrgPlusBtn() {
		return orgPlusBtn;
	}

	public WebElement getConNameEdt() {
		return ConNameEdt;
	}

	public WebElement getConSaveBtn() {
		return conSaveBtn;
	}
    
	public WebElement getOrgPlusSearchTb() {
		return orgPlusSearchTb;
	}

	public WebElement getOrgPlusSearchBtnn() {
		return orgPlusSearchBtnn;
	}
/**
 * This method contains logic for switch to child popup window
 * @param orgname
 */
	public void childPopup(String orgname) {
		orgPlusSearchTb.sendKeys(orgname);
		orgPlusSearchBtnn.click();
	}

}
