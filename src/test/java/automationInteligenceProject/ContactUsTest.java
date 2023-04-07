package automationInteligenceProject;


import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import automationInteligenceProject.ContactUsPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ContactUsTest extends BaseTest{

	
		@Test
		public void submitContactForm() throws IOException {
		// Initialize variable of Contactus with return ContactUsPage object 
		contactUsPage.acceptSiteCookiesPopupWindow();
		contactUsPage.handleFrame();
		contactUsPage.enterPersonDetails("RWS", "SKR", "Gotam", "skr@RWS.com", "81781899199");
		contactUsPage.countrySelect("Canada");
		contactUsPage.enquiryDetails("nothing");
		contactUsPage.hearAboutUsSelect("Web Search");
		contactUsPage.agreementCheckbox();
		//take Screenshot
		contactUsPage.getScreenshot("submitContactForm");
	}

}
