package com.ninza.crm.campaigns;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ninza.crm.generic.fileutility.ExcelUtility;
import com.ninza.crm.generic.fileutility.PropertyUtility;

public class CreateExpectedDate {

	public static void main(String[] args) throws IOException, InterruptedException {
		PropertyUtility pu=new PropertyUtility();	
		String URL = pu.getDataFromPropertiesFile("url");
		String USERNAME = pu.getDataFromPropertiesFile("username");
		String PASSWORD = pu.getDataFromPropertiesFile("password");

		ChromeOptions options=new ChromeOptions();
		Map<String, Object> prefs=new HashMap<>();
		prefs.put("profile.password_manager_leak_detection", false);
		options.setExperimentalOption("prefs",prefs);
		
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(URL);
		driver.findElement(By.id("username")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		
		ExcelUtility eu=new ExcelUtility();
		String cName = eu.getDataFromExcel("NinzaCRM", 1, 0);
		String tSize = eu.getDataFromExcel("NinzaCRM", 1, 1);
		String cStatus = eu.getDataFromExcel("NinzaCRM", 1, 2);
		driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		driver.findElement(By.name("campaignName")).sendKeys(cName);
		driver.findElement(By.name("targetSize")).sendKeys(tSize);
		driver.findElement(By.name("campaignStatus")).sendKeys(cStatus);
		
		Date d=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("dd-MM-yyyy");
		sim.format(d);
		Calendar c=sim.getCalendar();
		c.add(Calendar.DAY_OF_MONTH, 10);
		String eDate = sim.format(c.getTime());
		driver.findElement(By.name("expectedCloseDate")).sendKeys(eDate);
		Thread.sleep(5);
		
		driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
		WebElement verify = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(verify));
		
		if(verify.getText().contains(cName)) {
			System.out.println("Campaign successfully Created");
		}
		else
			System.out.println("Campaign not Created");
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		driver.quit();
	}
}

