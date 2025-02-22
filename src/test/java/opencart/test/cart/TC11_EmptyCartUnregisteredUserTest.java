package opencart.test.cart;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import opencart.pages.CartPage;
import opencart.test.base.BaseTest;

public class TC11_EmptyCartUnregisteredUserTest extends BaseTest {

	private Logger logger = Logger.getLogger(TC11_EmptyCartUnregisteredUserTest.class);

	@Test
	public void emptyCartUnregisteredUserTest() {
	    logger.info("*** Start Test ***");
        logger.info("Going to shoppingcart page...");
		CartPage cartPage = homePage.goToShoppingCartPage();
		
        logger.info("Checking message...");
		String actualMessage=cartPage.checkMessage();
		String expectedMessage="Your shopping cart is empty!";
		Assert.assertEquals(actualMessage, expectedMessage,"Wrong message : "+actualMessage);

	    logger.info("*** Finished Test ***");

	}
}
