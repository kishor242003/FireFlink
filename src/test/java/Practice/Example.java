package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Example {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\User\\Desktop\\CommonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String BROWSER = p.getProperty("browser");
		String URL = p.getProperty("url");
		String USERNNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		WebDriver driver=null;
		
		
		if(BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}
		else if (BROWSER.equals("firefox")) {
			driver=new FirefoxDriver();
		}else if(BROWSER.equals("edge")) {
			System.setProperty("webdriver.edge.driver","./edge/msedgedriver.exe");
			driver=new EdgeDriver();
		}
		System.out.println(URL);
		
	    driver.get(URL);
		driver.findElement(By.id("username")).sendKeys(USERNNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);	
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		
	}
	

}
