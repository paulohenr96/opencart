package opencart.test.productslist;

import org.testng.Assert;
import org.testng.annotations.Test;

import opencart.pages.LoginPage;
import opencart.pages.ProductListPage;
import opencart.test.base.BaseTest;

public class WishListTest extends BaseTest {

	@Test
	public void addToWishList() throws InterruptedException {
		homePage.clickMyAccount();
		LoginPage loginPage = homePage.clickLoginPage();

		loginPage.setEmailAddress("paulo123@gmail.com");
		loginPage.setPassword("paulo123");
		loginPage.clickLogin();
		Thread.sleep(5000);

		homePage.clickDesktops();
		ProductListPage productListPage = homePage.clickMac();

		productListPage.addProductToTheWishList(1);
		String expectedMessage="Success: You have added iMac to your wish list!";
		String actualMessage=productListPage.getNotificationSuccess();
		
		Assert.assertEquals(actualMessage,expectedMessage,"Incorrect message ('"+actualMessage+"')");
	
		
	}
}
