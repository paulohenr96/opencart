package opencart.test.login;

import static opencart.utility.GetUtility.getURL;
import static opencart.utility.RandomUtility.generateAlphanumeric;
import static opencart.utility.RandomUtility.generateString;

import org.testng.Assert;
import org.testng.annotations.Test;

import opencart.pages.LoginPage;
import opencart.pages.RegisterPage;
import opencart.test.base.BaseTest;

public class LoginTest extends BaseTest {

	
	
	@Test
	public void successfulLogin() throws InterruptedException {
		
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

		homePage.clickMyAccount();
		homePage.clickLogout();
		Thread.sleep(1000);
		
		
		homePage.clickMyAccount();
		LoginPage loginPage = homePage.clickLoginPage();
		
		loginPage.setEmailAddress(email);
		loginPage.setPassword(password);
		loginPage.clickLogin();
		Thread.sleep(5000);
		Assert.assertTrue(getURL().contains("route=account/account"));
		
	}
}
