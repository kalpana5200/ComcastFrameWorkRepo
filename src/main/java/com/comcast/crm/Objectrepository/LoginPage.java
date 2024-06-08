package com.comcast.crm.Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebdriverUtility;
/**
 * @author Kalpana
 * 
 * contains login page elements & business lib like login()
 * 
 */


public class LoginPage extends WebdriverUtility{
	
	WebDriver driver;
	
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	 
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	PageFactory.initElements( driver, this);	
	}

	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	/**
	 * login to application based on username, password,url arguments
	 * @param url
	 * @param username
	 * @param password
	 */
	public void loginToApp(String url,String username, String password) {
		driver.get(url);
		driver.manage().window().maximize();
		waitForPageToLoad(driver);
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
		
	}
	

}
