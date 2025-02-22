package opencart.test.login;

import static opencart.utility.GetUtility.getURL;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import opencart.pages.LoginPage;
import opencart.test.base.BaseTest;
import opencart.test.checkout.TC08_CheckoutTest;

public class TC05_LoginEmptyFieldsTest extends BaseTest {

	private  Logger logger = Logger.getLogger(TC05_LoginEmptyFieldsTest.class);

	
	@Test
	public void emptyFieldsLogin() throws InterruptedException {
		logger.info("*** Starting Test ***");

		
		logger.info("Going to login page...");

		homePage.clickMyAccount();
		LoginPage loginPage = homePage.goToLoginPage();
		
		
		loginPage.clickLogin();
		String actualMessage=loginPage.getNotification();
		String expectedMessage="Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(actualMessage,expectedMessage,"Invalid message ('"+actualMessage+"')");
		
		logger.info("*** Finished Test ***");

	}
}
