package opencart.test.login;

import static opencart.utility.GetUtility.getURL;
import static opencart.utility.RandomUtility.generateAlphanumeric;
import static opencart.utility.RandomUtility.generateString;
import static opencart.utility.WaitUtility.isURLLoaded;

import org.testng.Assert;
import org.testng.annotations.Test;

import opencart.pages.LoginPage;
import opencart.pages.RegisterPage;
import opencart.test.base.BaseTest;

public class LoginTest extends BaseTest {

	
	
	@Test
	public void successfulLogin() throws InterruptedException {
		
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

		homePage.clickMyAccount();
		homePage.clickLogout();
		isURLLoaded("route=account/logout");
		
		
		homePage.clickMyAccount();
		LoginPage loginPage = homePage.goToLoginPage();
		
		loginPage.setEmailAddress(email);
		loginPage.setPassword(password);
		loginPage.clickLogin();
		
		String expectedFraction="route=account/account";
		Boolean loadedUrl = isURLLoaded(expectedFraction);
		Assert.assertTrue(loadedUrl,"Invalid URL ("+getURL()+")");
		
	}
}
