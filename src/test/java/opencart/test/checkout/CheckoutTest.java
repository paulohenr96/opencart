package opencart.test.checkout;

import static opencart.utility.GetUtility.getURL;
import static opencart.utility.RandomUtility.generateAlphanumeric;
import static opencart.utility.RandomUtility.generateNumeric;
import static opencart.utility.RandomUtility.generateString;

import org.testng.Assert;
import org.testng.annotations.Test;

import opencart.pages.CheckoutPage;
import opencart.pages.LoginPage;
import opencart.pages.ProductListPage;
import opencart.pages.RegisterPage;
import opencart.pages.alert.PaymentMethodAlertPage;
import opencart.pages.alert.ShippingMethodAlertPage;
import opencart.test.base.BaseTest;

public class CheckoutTest extends BaseTest {

	@Test
	public void addToCart() throws InterruptedException {
		homePage.clickMyAccount();
		
		
		RegisterPage registerPage = homePage.clickRegisterPage();

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
		ProductListPage productListPage = homePage.clickMac();

	
		// Add the first element to the card
		productListPage.addProductToTheCart(1);
		String expectedMessage="Success: You have added iMac to your shopping cart!";
		String actualMessage=productListPage.getNotificationSuccess();
		Assert.assertEquals(actualMessage,expectedMessage,"Incorrect message ('"+actualMessage+"')");
	
		CheckoutPage checkoutPage = homePage.clickShoppingCart().clickCheckout();
		
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
		
		ShippingMethodAlertPage shippingMethodAlertPage = checkoutPage.clickChooseShippingMethod();
		shippingMethodAlertPage.clickContinue();
		
		Thread.sleep(1000);
		
		PaymentMethodAlertPage paymentMethodAlertPage = checkoutPage.clickPaymentMethod();
		paymentMethodAlertPage.clickContinue();
	
		checkoutPage.clickConfirmOrder();
		Thread.sleep(3000);
		String expectedURL=getURL();
		Assert.assertTrue(expectedURL.contains("route=checkout/success"),"Invalid URL ("+expectedURL+")");
		
	}
}
