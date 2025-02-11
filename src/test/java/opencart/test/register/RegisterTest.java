package opencart.test.register;

import static opencart.utility.GetUtility.getURL;
import static opencart.utility.RandomUtility.generateAlphanumeric;
import static opencart.utility.RandomUtility.generateString;
import static opencart.utility.WaitUtility.isURLLoaded;

import org.testng.Assert;
import org.testng.annotations.Test;

import opencart.pages.RegisterPage;
import opencart.test.base.BaseTest;

public class RegisterTest extends BaseTest {

	@Test
	public void successfulRegister() throws InterruptedException {
		
		logger.info("*** Starting RegisterTest ***");

		homePage.clickMyAccount();
		RegisterPage registerPage = homePage.goToRegisterPage();

		
		logger.info("Setting fields... ");
		String firstName = generateString();
		String lastName = generateString();
		String email = generateString() + "@example.com"; 
		String password = generateAlphanumeric();

		registerPage.setFirstName(firstName);
		registerPage.setLastName(lastName);
		registerPage.setEmail(email);
		registerPage.setPassword(password);
		registerPage.clickNewsletter(); 
		registerPage.clickAgree();
		
		
		logger.info("Clicking continue... ");
		registerPage.clickContinue();
		
		String expectedFractionUrl="route=account/success";
		
		Boolean url = isURLLoaded(expectedFractionUrl);
		
		Assert.assertTrue(url,"Invalid URL ("+getURL()+")");

	}
}
