package opencart.test.login;

import static opencart.utility.GetUtility.getURL;

import org.testng.Assert;
import org.testng.annotations.Test;

import opencart.pages.LoginPage;
import opencart.test.base.BaseTest;

public class LoginTest extends BaseTest {

	
	
	@Test
	public void successfulLogin() throws InterruptedException {
		homePage.clickMyAccount();
		LoginPage loginPage = homePage.clickLoginPage();
		
		loginPage.setEmailAddress("paulo123@gmail.com");
		loginPage.setPassword("paulo123");
		loginPage.clickLogin();
		Thread.sleep(5000);
		Assert.assertTrue(getURL().contains("route=account/account"));
		
	}
}
