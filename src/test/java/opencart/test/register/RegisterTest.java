package opencart.test.register;

import static opencart.utility.GetUtility.getURL;
import static opencart.utility.RandomUtility.generateAlphanumeric;
import static opencart.utility.RandomUtility.generateString;

import org.testng.Assert;
import org.testng.annotations.Test;

import opencart.pages.RegisterPage;
import opencart.test.base.BaseTest;

public class RegisterTest extends BaseTest {

	@Test
	public void successfulRegister() throws InterruptedException {
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

	}
}
