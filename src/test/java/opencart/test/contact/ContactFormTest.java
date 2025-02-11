package opencart.test.contact;

import static opencart.utility.RandomUtility.generateString;
import static opencart.utility.WaitUtility.isURLLoaded;

import org.testng.Assert;
import org.testng.annotations.Test;

import opencart.pages.ContactPage;
import opencart.test.base.BaseTest;

public class ContactFormTest extends BaseTest{
	
	
	@Test
	public void contactFormSuccessful() throws InterruptedException {
		
		logger.info("*** Starting contactFormSuccessful ***");

		
		logger.info("Going to contact page...");

		ContactPage contactPage = homePage.goToContactPage();
		
		
		logger.info("Setting fields ...");

		contactPage.setFieldYourName(generateString());
		contactPage.setFieldEmailAddress(generateString()+"@email.com");
		contactPage.setFieldEnquiry(generateString(50));
		contactPage.submitForm();
		
		
		Boolean loaded = isURLLoaded("route=information/contact.success");
		
		Assert.assertTrue(loaded,"The url wasnt loaded");
	}

}
