package opencart.test.wishlist;

import static opencart.utility.GetUtility.getURL;
import static opencart.utility.RandomUtility.generateAlphanumeric;
import static opencart.utility.RandomUtility.generateString;
import static opencart.utility.WaitUtility.isURLLoaded;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import opencart.pages.LoginPage;
import opencart.pages.ProductListPage;
import opencart.pages.RegisterPage;
import opencart.test.base.BaseTest;
import opencart.test.product.TC09_AddToCartTest;

public class TC02_WishListTest extends BaseTest {
	private  Logger logger = Logger.getLogger(TC02_WishListTest.class);

	@Test
	public void addToWishList() throws InterruptedException {
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
		registerPage.clickAgree();
		registerPage.clickContinue();
		
		String expectedFractionURL="route=account/success";
		Boolean urlLoaded = isURLLoaded(expectedFractionURL);
		Assert.assertTrue(urlLoaded,"Invalid URL ("+getURL()+")");
		
		
		logger.info("Going to macpage...");
		homePage.clickDesktops();
		ProductListPage productListPage = homePage.goToMacPage();

		
		logger.info("Adding to wishlist...");
		int indexProduct=1;
		productListPage.addProductToTheWishList(indexProduct);
		
		String expectedMessage="Success: You have added iMac to your wish list!";
		String actualMessage=productListPage.getNotificationSuccess();
		boolean successNotification = productListPage.successNotification();
		
		Assert.assertTrue(successNotification,"The notification isnt visible.");
		Assert.assertEquals(actualMessage,expectedMessage,"Incorrect message ('"+actualMessage+"')");
	
		logger.info("*** Finished Test ***");

	}
}
