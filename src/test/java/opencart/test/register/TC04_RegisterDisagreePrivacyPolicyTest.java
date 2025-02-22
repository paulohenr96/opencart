package opencart.test.register;

import static opencart.utility.GetUtility.getURL;
import static opencart.utility.RandomUtility.generateAlphanumeric;
import static opencart.utility.RandomUtility.generateString;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import opencart.pages.RegisterPage;
import opencart.test.base.BaseTest;
import opencart.test.wishlist.TC02_WishListTest;

public class TC04_RegisterDisagreePrivacyPolicyTest extends BaseTest {
	private  Logger logger = Logger.getLogger(TC04_RegisterDisagreePrivacyPolicyTest.class);

	@Test
	public void disagreePrivacyPolicyRegister() throws InterruptedException {
		logger.info("*** Starting Test ***");

		logger.info("Going to register page...");
		homePage.clickMyAccount();
		RegisterPage registerPage = homePage.goToRegisterPage();

		
		logger.info("Setting fields...");
		String firstName = generateString();
		String lastName = generateString();
		String email = generateString() + "@example.com"; 
		String password = generateAlphanumeric();

		registerPage.setFirstName(firstName);
		registerPage.setLastName(lastName);
		registerPage.setEmail(email);
		registerPage.setPassword(password);
		registerPage.clickNewsletter(); 
		
		logger.info("Clicking continue...");
		registerPage.clickContinue();
		String expectedMessage="Warning: You must agree to the Privacy Policy!";
		String actualMessage=registerPage.getNotificationCard();
		Assert.assertEquals(actualMessage,expectedMessage,"Invalid message ('"+actualMessage+"')");
		logger.info("*** Finished Test ***");

	}
}
