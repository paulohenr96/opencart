package opencart.test.product;

import static opencart.utility.PropertiesUtil.getProperty;
import static opencart.utility.RandomUtility.generateString;

import java.awt.AWTException;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import opencart.pages.MonitorsPage;
import opencart.pages.ProductPage;
import opencart.test.base.BaseTest;
import opencart.test.login.TC07_LoginTest;

public class TC09_AddToCartTest extends BaseTest{

	private  Logger logger = Logger.getLogger(TC09_AddToCartTest.class);

	@Test
	public void addProductToCartProductPageTest() throws InterruptedException, AWTException {
		logger.info("*** Starting Test ***");
		String pathFile="";
		
		if (getProperty("host").equals("docker")) {
			pathFile = "/home/selenium/resources/sample.txt";
		}else {
			pathFile=System.getProperty("user.dir")+"\\resources\\sample.txt";
		}
		String date="111111111";
		String time = "0722";
		String dateTime = "25"+Keys.TAB+"08"+Keys.TAB+"2018"+Keys.TAB+"0722";
		String quantity = "2";
		String textArea = generateString(30);
		String text = generateString(10);
		int indexCheckbox = 2;
		int indexRadioButton = 2;
		int indexSelect = 2;
		int indexProduct = 1;
 
		logger.info("Going to monitorspage...");

		homePage.clickComponents();
		MonitorsPage monitorsPage = homePage.goToMonitorsPage();
		
		
		
		logger.info("Going to productpage...");

		ProductPage productPage = monitorsPage.goToProductPage(indexProduct);
		
		
		logger.info("Setting the fields...");

		logger.info("Radio Button");
		productPage.selectRadioButton(indexRadioButton);
		logger.info("Checkbox");
		productPage.selectCheckbox(indexCheckbox);
		logger.info("Text");
		productPage.enterText(text);
		logger.info("TextArea");
		productPage.enterTextarea(textArea);
		logger.info("Dropdown");
		productPage.selectFromDropdown(indexSelect);
		logger.info("Upload...");
		productPage.uploadFile(pathFile);
		logger.info("Date");
		productPage.enterDate(date);
		logger.info("Time");
		productPage.enterTime(time);
		logger.info("DateTime");
		productPage.enterDateAndTime(dateTime);
		logger.info("Quantity");
		productPage.setQuantity(quantity);
		
		
		logger.info("Adding to the cart...");
//		Thread.sleep(10000);
		productPage.addToCart();
		logger.info("Assert...");

		String actualMsg=productPage.getMessageSuccess();
		Assert.assertTrue(actualMsg.contains("Success: You have added"),"Incorrect message => "+actualMsg);
		
		logger.info("*** Finished Test ***");

	}
}
