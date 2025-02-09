package opencart.test.product;

import static opencart.utility.RandomUtility.generateString;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import opencart.pages.MonitorsPage;
import opencart.pages.ProductPage;
import opencart.test.base.BaseTest;

public class AddToCartTest extends BaseTest{

	
	@Test
	public void addProductToCartProductPageTest() throws InterruptedException, AWTException {
		homePage.clickComponents();
		MonitorsPage monitorsPage = homePage.goToMonitorsPage();
		
		ProductPage productPage = monitorsPage.goToProductPage(1);
		
		productPage.selectRadioButton(2);
		productPage.selectCheckbox(2);
		productPage.enterText(generateString(10));
		productPage.enterTextarea(generateString(30));
		productPage.selectFromDropdown(2);
		productPage.uploadFile(System.getProperty("user.dir")+"\\resources\\sample.txt");
		productPage.enterDate("25082018");
		productPage.enterTime("0722");
		productPage.enterDateAndTime("25082018 0722");
		productPage.setQuantity("2");
		productPage.addToCart();
		String actualMsg=productPage.getMessageSuccess();
		Assert.assertTrue(actualMsg.contains("Success: You have added"),"Incorrect message => "+actualMsg);
	}
}
