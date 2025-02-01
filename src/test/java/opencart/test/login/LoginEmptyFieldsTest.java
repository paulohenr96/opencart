package opencart.test.login;

import static opencart.utility.GetUtility.getURL;

import org.testng.Assert;
import org.testng.annotations.Test;

import opencart.pages.LoginPage;
import opencart.test.base.BaseTest;

public class LoginEmptyFieldsTest extends BaseTest {

	
	
	@Test
	public void successfulLogin() throws InterruptedException {
		homePage.clickMyAccount();
		LoginPage loginPage = homePage.clickLoginPage();
		
		loginPage.setEmailAddress("paulo123gmail.com");
		loginPage.setPassword("paulo123");
		loginPage.clickLogin();
		String actualMessage=loginPage.getNotification();
		String expectedMessage="Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(actualMessage,expectedMessage,"Invalid message ('"+actualMessage+"')");
		
	}
}
