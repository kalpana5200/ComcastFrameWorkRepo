package com.comcast.crm.Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	@FindBy (xpath="//img[@title='Create Product...']")
	private WebElement createProdBtn;

	
	@FindBy (xpath="searchBTN")
	private WebElement ele3;
	
	public WebElement getCreateProdBtn() {
		return createProdBtn;
	}
	
	public ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
