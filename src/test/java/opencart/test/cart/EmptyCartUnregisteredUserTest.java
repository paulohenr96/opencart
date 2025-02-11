package opencart.test.cart;

import org.testng.Assert;
import org.testng.annotations.Test;

import opencart.pages.CartPage;
import opencart.test.base.BaseTest;

public class EmptyCartUnregisteredUserTest extends BaseTest {

	
	@Test
	public void emptyCartUnregisteredUserTest() {
	    logger.info("*** Start emptyCartUnregisteredUserTest ***");
        logger.info("Going to shoppingcart page...");
		CartPage cartPage = homePage.goToShoppingCartPage();
		
        logger.info("Checking message...");
		String actualMessage=cartPage.checkMessage();
		String expectedMessage="Your shopping cart is empty!";
		Assert.assertEquals(actualMessage, expectedMessage,"Wrong message : "+actualMessage);

		
	}
}
