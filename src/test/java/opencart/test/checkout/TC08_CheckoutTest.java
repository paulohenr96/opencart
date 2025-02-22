package opencart.test.checkout;

import static opencart.utility.GetUtility.getURL;
import static opencart.utility.RandomUtility.generateAlphanumeric;
import static opencart.utility.RandomUtility.generateNumeric;
import static opencart.utility.RandomUtility.generateString;
import static opencart.utility.WaitUtility.isURLLoaded;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import opencart.pages.CheckoutPage;
import opencart.pages.LoginPage;
import opencart.pages.ProductListPage;
import opencart.pages.RegisterPage;
import opencart.pages.alert.PaymentMethodAlertPage;
import opencart.pages.alert.ShippingMethodAlertPage;
import opencart.test.base.BaseTest;

public class TC08_CheckoutTest extends BaseTest {
	private  Logger logger = Logger.getLogger(TC08_CheckoutTest.class);

	@Test
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

		logger.info("Checking the url...");
		String expectedFractionURL = "route=account/success";
		Boolean urlLoaded = isURLLoaded(expectedFractionURL);
		Assert.assertTrue(urlLoaded, "Invalid URL (" + getURL() + ")");

		
		logger.info("Going to MacPage...");

		homePage.clickDesktops();
		ProductListPage productListPage = homePage.goToMacPage();

		int indexOfTheSelectedProduct = 1;

		logger.info("Adding item to the cart...");

		productListPage.addProductToCartByIndex(indexOfTheSelectedProduct);
		String expectedMessage = "Success: You have added iMac to your shopping cart!";
		String actualMessage = productListPage.getNotificationSuccess();
		Assert.assertEquals(actualMessage, expectedMessage, "Incorrect message ('" + actualMessage + "')");

		
		logger.info("Going to checkout page...");

		CheckoutPage checkoutPage = homePage.goToShoppingCartPage().goToCheckoutPage();

		
		logger.info("Registering address...");
		String company = generateString() + " Corp";
		String address1 = generateString() + " Street";
		String address2 = generateString() + " Avenue";
		String city = generateString();
		String postCode = generateNumeric();
		String country = "United States";
		String state = "New York";

		checkoutPage.setFirstName(firstName);
		checkoutPage.setLastName(lastName);
		checkoutPage.setCompany(company);
		checkoutPage.setAddress1(address1);
		checkoutPage.setAddress2(address2);
		checkoutPage.setCity(city);
		checkoutPage.setPostCode(postCode);
		checkoutPage.selectCountry(country);
		Thread.sleep(1000);
		checkoutPage.selectState(state);
		checkoutPage.clickContinue();

		Thread.sleep(1000);
		logger.info("Shipping method...");

		ShippingMethodAlertPage shippingMethodAlertPage = checkoutPage.clickChooseShippingMethod();
		shippingMethodAlertPage.clickContinue();

		Thread.sleep(1000);
		logger.info("Payment method...");
		PaymentMethodAlertPage paymentMethodAlertPage = checkoutPage.clickPaymentMethod();
		paymentMethodAlertPage.clickContinue();

		
		logger.info("Confirm method...");
		checkoutPage.clickConfirmOrder();
		Boolean loaded = isURLLoaded("route=checkout/success");
		Assert.assertTrue(loaded, "Invalid URL (" + getURL() + ")");
		logger.info("*** Finished Test ***");

	}
}
