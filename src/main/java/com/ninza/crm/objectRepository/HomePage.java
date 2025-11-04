package com.ninza.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Campaigns']")
	private WebElement campaigns;
	
	@FindBy(xpath = "//a[text()='Products']")
	private WebElement products;
	
	@FindBy(xpath = "//div[@class='user-icon']")
	private WebElement profile;
	
	@FindBy(xpath = "//div[@role='alert']")
	private WebElement campaignSuccessfullyAdded;
	
	@FindBy(xpath = "//div[@role='alert']")
	private WebElement productSuccessfullyAdded;
	
	public WebElement getCampaigns() {
		return campaigns;
	}

	public WebElement getProducts() {
		return products;
	}

	public WebElement getProfile() {
		return profile;
	}

	public WebElement getCampaignSuccessfullyAdded() {
		return campaignSuccessfullyAdded;
	}

	public WebElement getProductSuccessfullyAdded() {
		return productSuccessfullyAdded;
	}
	
	


}
