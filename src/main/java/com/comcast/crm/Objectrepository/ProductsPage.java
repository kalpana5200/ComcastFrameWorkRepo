
package com.comcast.crm.Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	@FindBy (xpath="//img[@title='Create Product...']")
	private WebElement createProdBtn;
	
	@FindBy(name="search")
	private WebElement ele2;

	public WebElement getCreateProdBtn() {
		return createProdBtn;
	}
	
	public ProductsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getEle2() {
		return ele2;
	}

}
