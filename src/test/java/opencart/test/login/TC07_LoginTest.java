package opencart.test.login;

import static opencart.utility.GetUtility.getURL;
import static opencart.utility.RandomUtility.generateAlphanumeric;
import static opencart.utility.RandomUtility.generateString;
import static opencart.utility.WaitUtility.isURLLoaded;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import opencart.pages.LoginPage;
import opencart.pages.RegisterPage;
import opencart.test.base.BaseTest;

public class TC07_LoginTest extends BaseTest {

	
	private  Logger logger = Logger.getLogger(TC07_LoginTest.class);

	@Test
	public void successfulLogin() throws InterruptedException {
		logger.info("*** Starting Test ***");

		
		logger.info("Going to register page...");

		homePage.clickMyAccount();
		RegisterPage registerPage = homePage.goToRegisterPage();
				
		
		logger.info("Generating fields...");

		String firstName = generateString();
		String lastName = generateString();
		String email = generateString() + "@example.com"; 
		String password = generateAlphanumeric();

		
		logger.info("Setting fields...");

		registerPage.setFirstName(firstName);
		registerPage.setLastName(lastName);
		registerPage.setEmail(email);
		registerPage.setPassword(password);
		registerPage.clickNewsletter(); 
		registerPage.clickAgree();
		registerPage.clickContinue();
		
		String expectedFractionURL="route=account/success";
		Boolean urlLoaded = isURLLoaded(expectedFractionURL);
		Assert.assertTrue(urlLoaded,"Invalid URL ("+getURL()+")");

		
		logger.info("Logging out...");

		homePage.clickMyAccount();
		homePage.clickLogout();
		isURLLoaded("route=account/logout");

		
		logger.info("Going to login page...");
		
		homePage.clickMyAccount();
		LoginPage loginPage = homePage.goToLoginPage();
		
		
		logger.info("Setting fields...");

		loginPage.setEmailAddress(email);
		loginPage.setPassword(password);
		
		
		logger.info("Clicking login...");
		loginPage.clickLogin();
		
		String expectedFraction="route=account/account";
		Boolean loadedUrl = isURLLoaded(expectedFraction);
		Assert.assertTrue(loadedUrl,"Invalid URL ("+getURL()+")");
		
		
		logger.info("*** Finished Test ***");

	}
}
