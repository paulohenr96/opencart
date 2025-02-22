package opencart.test.cart;

import static opencart.utility.GetUtility.getURL;
import static opencart.utility.RandomUtility.generateAlphanumeric;
import static opencart.utility.RandomUtility.generateString;
import static opencart.utility.WaitUtility.isURLLoaded;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import opencart.pages.ProductListPage;
import opencart.pages.RegisterPage;
import opencart.test.base.BaseTest;

//@Test(testName = "TC01_CartTest",description = "Test description")
@Test
public class TC01_CartTest extends BaseTest {

	private Logger logger = Logger.getLogger(TC01_CartTest.class);

	
	public void addToCart() throws InterruptedException {
        logger.info("*** Start Test ***");
        logger.info("Going to register page...");

		homePage.clickMyAccount();
		
		RegisterPage registerPage = homePage.goToRegisterPage();
      
		logger.info("Generating data...");

		String firstName = generateString();
		String lastName = generateString();
		String email = generateString() + "@example.com"; 
		String password = generateAlphanumeric();

		logger.info("Setting the fields...");
		registerPage.setFirstName(firstName);
		registerPage.setLastName(lastName);
		registerPage.setEmail(email);
		registerPage.setPassword(password);
		registerPage.clickNewsletter(); 
		registerPage.clickAgree();
		registerPage.clickContinue();
		
			
		logger.info("Checking the URL...");
		String expectedFractionURL="route=account/success";
		Boolean urlLoaded = isURLLoaded(expectedFractionURL);
		Assert.assertTrue(urlLoaded,"Invalid URL ("+getURL()+")");
		

		logger.info("Going to MacPage...");
		homePage.clickDesktops();
		ProductListPage productListPage = homePage.goToMacPage();

		int indexOfProduct=1;
		

		productListPage.addProductToCartByIndex(indexOfProduct);
		logger.info("Checking message...");
		String expectedMessage="Success: You have added iMac to your shopping cart!";
		String actualMessage=productListPage.getNotificationSuccess();
		
		Assert.assertEquals(actualMessage,expectedMessage,"Incorrect message ('"+actualMessage+"')");
        logger.info("*** Finished Test ***");

		
	}
}
