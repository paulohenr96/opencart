package opencart.test.wishlist;

import static opencart.utility.GetUtility.getURL;
import static opencart.utility.RandomUtility.generateAlphanumeric;
import static opencart.utility.RandomUtility.generateString;
import static opencart.utility.WaitUtility.isURLLoaded;

import org.testng.Assert;
import org.testng.annotations.Test;

import opencart.pages.LoginPage;
import opencart.pages.ProductListPage;
import opencart.pages.RegisterPage;
import opencart.test.base.BaseTest;

public class WishListTest extends BaseTest {

	@Test
	public void addToWishList() throws InterruptedException {
		
		homePage.clickMyAccount();
		RegisterPage registerPage = homePage.goToRegisterPage();

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
		
		homePage.clickDesktops();
		ProductListPage productListPage = homePage.goToMacPage();

		int indexProduct=1;
		productListPage.addProductToTheWishList(indexProduct);
		
		String expectedMessage="Success: You have added iMac to your wish list!";
		String actualMessage=productListPage.getNotificationSuccess();
		boolean successNotification = productListPage.successNotification();
		
		Assert.assertTrue(successNotification,"The notification isnt visible.");
		Assert.assertEquals(actualMessage,expectedMessage,"Incorrect message ('"+actualMessage+"')");
	
		
	}
}
