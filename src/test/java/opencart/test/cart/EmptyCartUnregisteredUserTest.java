package opencart.test.cart;

import org.testng.Assert;
import org.testng.annotations.Test;

import opencart.pages.CartPage;
import opencart.test.base.BaseTest;

public class EmptyCartUnregisteredUserTest extends BaseTest {

	
	@Test
	public void emptyCartUnregisteredUserTest() {
		CartPage cartPage = homePage.goToShoppingCartPage();
		
		String actualMessage=cartPage.checkMessage();
		String expectedMessage="Your shopping cart is empty!";
		Assert.assertEquals(actualMessage, expectedMessage,"Wrong message : "+actualMessage);

		
	}
}
