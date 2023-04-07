package automationInteligenceProject;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContactUsPage {
	
	WebDriver driver;
	
	
	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	} 
	
	
	// Field options
	@FindBy(xpath="//div[@id='cookie-law-info-bar']")
	WebElement popupWindow;
	
	@FindBy(xpath="//a[@id='cookie_action_close_header']")
	WebElement acceptButton;

	@FindBy(xpath="(//iframe)[3]")
	WebElement frameHandle;
	
	@FindBy(css="#Companypi_Company")
	WebElement companyNameElement;
	
	@FindBy(xpath="//input[@id=\'First_Namepi_First_Name\']")
	WebElement firstNameElement;
	
	@FindBy(xpath="//input[@id=\'Last_Namepi_Last_Name\']")
	WebElement lastNameElement;
	
	@FindBy(xpath="//input[@id=\'Emailpi_Email\']")
	WebElement emailFieldElement;
	
	@FindBy(xpath="//input[@id=\'941293_138982pi_941293_138982\']")
	WebElement phoneFieldElement;
	
	
	@FindBy(xpath="//select[@id=\'941293_138980pi_941293_138980\']")
	WebElement countrydropdownElement;
	
	@FindBy(xpath="//textarea[@id=\'941293_138986pi_941293_138986\']")
	WebElement enquiryFieldElement;
	
	@FindBy(xpath="//select[@id=\'941293_178033pi_941293_178033\']")
	WebElement hearAboutUsDropdownElement;
	
	@FindBy(css="label.inline")
	WebElement agreeCheckboxElement;
	
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement btnContactUs;
	
	//Error messages/ label
	
	@FindBy(xpath="//p[@class='errors']")
	WebElement firsterrMsg;
	
	@FindBy(xpath="//p[@class='error no-label']")
	WebElement errMsg;
	
	
	
	public void acceptSiteCookiesPopupWindow() {
		if(popupWindow.isDisplayed()) {
			acceptButton.click();
		}
	}
	
	public void gotoURL() {
		driver.get("https://www.intelligencebank.com/contact-us/");
	}
	
	public void handleFrame() {
		driver.switchTo().frame(frameHandle);
	}
	
	
	public void enterPersonDetails(String comp, String frname, String lsname, String email, String num) {
		companyNameElement.sendKeys(comp);
		firstNameElement.sendKeys(frname);
		lastNameElement.sendKeys(lsname);
		emailFieldElement.sendKeys(email);
		phoneFieldElement.sendKeys(num);
	}
	
	public void countrySelect(String cont) {
		Select cou = new Select(countrydropdownElement);
		cou.selectByVisibleText(cont);
	} 
	
	public void enquiryDetails(String endetails) {
		enquiryFieldElement.sendKeys(endetails);
	}
	
	public void hearAboutUsSelect(String hearabt) {
		Select cou = new Select(hearAboutUsDropdownElement);
		cou.selectByVisibleText(hearabt);
	}
	
	public void agreementCheckbox() {
		agreeCheckboxElement.click();
	}
	
	public void submitContactUS() {
		btnContactUs.click();
	}
	
	public String getTopErrMessage() {
		waitforElementVisible(firsterrMsg);
		String errmsg = firsterrMsg.getText();
		return errmsg;
	}
	
	public String getErrMessage() {
		waitforElementVisible(errMsg);
		String errmsg = errMsg.getText();
		return errmsg;
	}
	
	public void waitforElementVisible(WebElement findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public String getScreenshot(String testCaseName) throws IOException {
		TakesScreenshot scrShot =((TakesScreenshot) driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File(System.getProperty("user.dir")+"//Reports//"+testCaseName+".png");
        FileUtils.copyFile(SrcFile, DestFile);
		return System.getProperty("user.dir")+"//Reports//"+ testCaseName +".png";
	}
}
