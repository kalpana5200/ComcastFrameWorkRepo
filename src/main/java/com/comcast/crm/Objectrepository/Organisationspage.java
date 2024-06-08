package com.comcast.crm.Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * @author Kalpana
 * 
 * contains Organisationspage elements 
 */
public class Organisationspage {
	WebDriver driver;
	public Organisationspage(WebDriver driver) {
		this.driver=driver;
	PageFactory.initElements( driver, this);	
	}
	
	@FindBy(name="search_text")
	private WebElement searchEdt;
	
	@FindBy(name="search_field")
	private WebElement searchDD;
	
	@FindBy(name="submit")
	private WebElement searchBtn;
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createNewOrg;
	
	public WebElement getCreateNewOrg() {
		return createNewOrg;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchDD() {
		return searchDD;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}
	
	
	
	


}
