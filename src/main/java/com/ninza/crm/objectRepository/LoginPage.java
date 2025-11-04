package com.ninza.crm.objectRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.ninza.crm.generic.webdriverutility.WebDriverUtility;

public class LoginPage {
	
	WebDriver driver;
	
	public  LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "username")
	private WebElement usernameTextField;
	
	@FindBy(id = "inputPassword")
	private WebElement passwordTextField;
	
	@FindBy(xpath = "//button[text()='Sign In']")
	private WebElement signinButton;

	public WebElement getUsernameTextField() {
		return usernameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getSigninButton() {
		return signinButton;
	}		
	
	public void loginToApp(String url, String username, String password) throws IOException {
		driver.manage().window().maximize();
		WebDriverUtility wu=new WebDriverUtility();
		wu.ImplicitWait(driver);
		driver.get(url);
		getUsernameTextField().sendKeys(username);
		getPasswordTextField().sendKeys(password);
		getSigninButton().click();		
		
	}
	

}
