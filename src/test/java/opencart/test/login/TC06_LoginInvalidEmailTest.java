package opencart.test.login;

import static opencart.utility.GetUtility.getURL;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import opencart.pages.LoginPage;
import opencart.test.base.BaseTest;

public class TC06_LoginInvalidEmailTest extends BaseTest {

	private  Logger logger = Logger.getLogger(TC06_LoginInvalidEmailTest.class);

	
	@Test
	public void invalidEmailTest() throws InterruptedException {
		
		logger.info("*** Starting Test *** ");

		
		logger.info("Going to login page...");
		homePage.clickMyAccount();
		LoginPage loginPage = homePage.goToLoginPage();
		
		
		
		logger.info("Setting fields...");
		loginPage.setEmailAddress("paulo123gmail.com");
		loginPage.setPassword("paulo123");
		
		logger.info("Click login button...");

		loginPage.clickLogin();
		String actualMessage=loginPage.getNotification();
		String expectedMessage="Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(actualMessage,expectedMessage,"Invalid message ('"+actualMessage+"')");
		
	
		logger.info("*** Finished Test *** ");

	
	}
}
