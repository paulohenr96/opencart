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
		String pathFile=System.getProperty("user.dir")+"\\resources\\sample.txt";
		String date="25082018";
		String time = "0722";
		String dateTime = "25082018 0722";
		String quantity = "2";
		String textArea = generateString(30);
		String text = generateString(10);
		int indexCheckbox = 2;
		int indexRadioButton = 2;
		int indexSelect = 2;
		int indexProduct = 1;
 
		homePage.clickComponents();
		MonitorsPage monitorsPage = homePage.goToMonitorsPage();
		
		ProductPage productPage = monitorsPage.goToProductPage(indexProduct);
		
		productPage.selectRadioButton(indexRadioButton);
		productPage.selectCheckbox(indexCheckbox);
		productPage.enterText(text);
		productPage.enterTextarea(textArea);
		productPage.selectFromDropdown(indexSelect);
		productPage.uploadFile(pathFile);
		productPage.enterDate(date);
		productPage.enterTime(time);
		productPage.enterDateAndTime(dateTime);
		productPage.setQuantity(quantity);
		
		productPage.addToCart();
		
		String actualMsg=productPage.getMessageSuccess();
		Assert.assertTrue(actualMsg.contains("Success: You have added"),"Incorrect message => "+actualMsg);
	}
}
