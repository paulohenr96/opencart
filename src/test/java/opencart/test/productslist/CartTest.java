package opencart.test.productslist;

import static opencart.utility.GetUtility.getURL;
import static opencart.utility.RandomUtility.generateAlphanumeric;
import static opencart.utility.RandomUtility.generateString;

import org.testng.Assert;
import org.testng.annotations.Test;

import opencart.pages.LoginPage;
import opencart.pages.ProductListPage;
import opencart.pages.RegisterPage;
import opencart.test.base.BaseTest;

public class CartTest extends BaseTest {

	@Test
	public void addToCart() throws InterruptedException {
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
		
		Thread.sleep(3000);
		String actualURL=getURL();
		Assert.assertTrue(actualURL.contains("route=account/success"),"Invalid URL ("+actualURL+")");

		
		
		
		

		homePage.clickDesktops();
		ProductListPage productListPage = homePage.goToMacPage();

		productListPage.addProductToTheCart(1);
		String expectedMessage="Success: You have added iMac to your shopping cart!";
		String actualMessage=productListPage.getNotificationSuccess();
		
		Assert.assertEquals(actualMessage,expectedMessage,"Incorrect message ('"+actualMessage+"')");
	
		
	}
}
