package roughwork;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	public static void main(String args[]) {
		
		String url = "https://www.intelligencebank.com/contact-us/";

		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();

		driver.get(url);
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//driver.switchTo().frame("popup__iframe");
		
		// To check whether site cookies popup appears or not
		if (driver.findElement(By.xpath("//div[@id='cookie-law-info-bar']")).isDisplayed()) {
			
			//Xpath for Cookies setting "//a[contains(text(), 'Cookie Settings')]"
			// click on accept button in popup
			driver.findElement(By.xpath("//a[@id='cookie_action_close_header']")).click();
		}
		
		int size = driver.findElements(By.tagName("iframe")).size();
		
		System.out.print(size);
		
		
		//Here iframes are there and we need to handle iframe P+ shadow dom
		driver.switchTo().frame(driver.findElement(By.xpath("(//iframe)[3]")));
		
		
		
		driver.findElement(By.cssSelector("#Companypi_Company")).sendKeys("RWS");
		System.out.print(1);
		driver.findElement(By.xpath("//input[@id=\'First_Namepi_First_Name\']")).sendKeys("RWS");

		driver.findElement(By.xpath("//input[@id=\'Last_Namepi_Last_Name\']")).sendKeys("GOTAM");
		System.out.print(1);
		driver.findElement(By.xpath("//input[@id=\'Emailpi_Email\']")).sendKeys("SKR@RWS.COM");
		System.out.print(1);
		driver.findElement(By.xpath("//input[@id=\'941293_138982pi_941293_138982\']")).sendKeys("8139304903");
		
		Select ms = new Select(driver.findElement(By.xpath("//select[@id=\'941293_138980pi_941293_138980\']")));
		ms.selectByVisibleText("India");
		
		driver.findElement(By.xpath("//textarea[@id=\'941293_138986pi_941293_138986\']")).sendKeys("Nothing");
		
		
		Select mns = new Select(driver.findElement(By.xpath("//select[@id=\'941293_178033pi_941293_178033\']")));
		mns.selectByVisibleText("Web Search");
		
		driver.findElement(By.cssSelector("label.inline")).click();
		
		//driver.quit();
	}

}
