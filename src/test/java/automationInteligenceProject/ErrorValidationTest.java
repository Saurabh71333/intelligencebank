package automationInteligenceProject;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ErrorValidationTest extends BaseTest {

	@Test
	public void tocheckFirstNameValidation1() throws IOException {
		// Initialize variable of Contactus
		contactUsPage.acceptSiteCookiesPopupWindow();
		contactUsPage.handleFrame();
		contactUsPage.enterPersonDetails("RWS", " ", "Gotam", "skr@RWS.com", "81781899199");
		contactUsPage.countrySelect("Canada");
		contactUsPage.enquiryDetails("nothing");
		contactUsPage.hearAboutUsSelect("Web Search");
		contactUsPage.agreementCheckbox();
		contactUsPage.submitContactUS();
		Assert.assertEquals(contactUsPage.getTopErrMessage(), "Please cect the errors below:");
		Assert.assertEquals(contactUsPage.getErrMessage(), "This field is required.");
	}

	@Test
	public void tocheckEmailFieldValidation() throws IOException { // //
		// Initialize variable of Contactus
		contactUsPage.acceptSiteCookiesPopupWindow();
		contactUsPage.handleFrame();
		contactUsPage.enterPersonDetails("RWS", "SKR", "Gotam", "skr", "81781899199");
		contactUsPage.countrySelect("Canada");
		contactUsPage.enquiryDetails("nothing");
		contactUsPage.hearAboutUsSelect("Web Search");
		contactUsPage.agreementCheckbox();
		contactUsPage.submitContactUS();
		Assert.assertEquals(contactUsPage.getTopErrMessage(), "Please correct the errors below:");
		Assert.assertEquals(contactUsPage.getErrMessage(),
				"Please input a valid email address from a non-free provider.");
	}

	@Test
	public void tocheckCountryFieldValidation() throws IOException { //
		// Initialize variable of ContactusPage
		contactUsPage.acceptSiteCookiesPopupWindow();
		contactUsPage.handleFrame();
		contactUsPage.enterPersonDetails("RWS", "SKR", "Gotam", "skr@gmail.com", "81781899199");
		contactUsPage.enquiryDetails("nothing");
		contactUsPage.hearAboutUsSelect("Web Search");
		contactUsPage.agreementCheckbox();
		contactUsPage.submitContactUS();
		contactUsPage.getScreenshot("tocheckCountryFieldValidation");
		Assert.assertEquals(contactUsPage.getTopErrMessage(), "Please correct the errors below:");
		Assert.assertEquals(contactUsPage.getErrMessage(), "This field is required");
		
	}

	@Test
	public void toVerifyCheckboxValidation() throws IOException { // //
		// Initialize variable of ContactusPage
		contactUsPage.acceptSiteCookiesPopupWindow();
		contactUsPage.handleFrame();
		contactUsPage.enterPersonDetails("RWS", "SKR", "Gotam", "skr@gmail.com", "81781899199");
		contactUsPage.countrySelect("Canada");
		contactUsPage.enquiryDetails("nothing");
		contactUsPage.hearAboutUsSelect("Web Search");
		contactUsPage.submitContactUS();
		Assert.assertEquals(contactUsPage.getTopErrMessage(), "Please correct the errors below:");
		Assert.assertEquals(contactUsPage.getErrMessage(), "This field is required");
	}

}
