package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NinzaCRM {

	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream fis=new FileInputStream("./data/CommonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");

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
		
		FileInputStream fs=new FileInputStream("./data/Ninza_CRM.xlsx");
		Workbook wb=WorkbookFactory.create(fs);
		String cName = wb.getSheet("NinzaCRM").getRow(1).getCell(0).getStringCellValue();
		String tSize = wb.getSheet("NinzaCRM").getRow(1).getCell(1).getStringCellValue();
		driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		driver.findElement(By.name("campaignName")).sendKeys(cName);
		driver.findElement(By.name("targetSize")).sendKeys(tSize);
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
		
		//Add Product
		Thread.sleep(3);
		driver.findElement(By.xpath("//a[text()='Products']")).click();
		driver.findElement(By.xpath("//span[text()='Add Product']")).click();
		FileInputStream f=new FileInputStream("./data/Ninza_CRM.xlsx");
		Workbook w=WorkbookFactory.create(f);
		Random r=new Random();
		int randomNo=r.nextInt(1000);
		String pName = w.getSheet("NinzaCRM").getRow(4).getCell(0).getStringCellValue()+randomNo;
		driver.findElement(By.name("productName")).sendKeys(pName);
		 
		WebElement pCategory = driver.findElement(By.name("productCategory"));
		 Select s=new Select(pCategory);
		 s.selectByValue("Electronics");
		 String quantity = w.getSheet("NinzaCRM").getRow(4).getCell(1).getStringCellValue();
		driver.findElement(By.name("quantity")).sendKeys(quantity);
		
		WebElement vendor = driver.findElement(By.name("vendorId"));
		Select ss=new Select(vendor);
		ss.selectByIndex(24);
		driver.findElement(By.xpath("//button[text()='Add']")).click();
		WebElement add = driver.findElement(By.xpath("//div[@role='alert']"));
		WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(5));
		wt.until(ExpectedConditions.visibilityOf(add));
		
		if(add.isDisplayed()==true)
			System.out.println("Product is added successfully");
		else
			System.out.println("Product is not added");
		driver.quit();
	
	}

}
