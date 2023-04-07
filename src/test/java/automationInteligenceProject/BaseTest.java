package automationInteligenceProject;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import automationInteligenceProject.ContactUsPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public ContactUsPage contactUsPage;
	
	public WebDriver driver;
	
	public WebDriver InitializeDriver() throws IOException {
		
		//Need to redirect on = "https://www.intelligencebank.com/contact-us/";
		
		//Setup the Property file
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\globalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		
		// invoking the browser
		if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();		
		}
		else if (browserName.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();		
		}
		
		// public driver auto-initialized when reach to if statements
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		return driver;
	}
	
	
	@BeforeMethod
	public ContactUsPage launchApplication() throws IOException {
		
		driver = InitializeDriver();
		contactUsPage = new ContactUsPage(driver);
		contactUsPage.gotoURL();
		return contactUsPage;
	}
	
	
	 @AfterMethod
	 public void tearDown() { 
		 driver.close(); 
		 }
	 
	
}
