package opencart.pages;

import static opencart.utility.JavascriptUtility.javascriptClick;
import static opencart.utility.JavascriptUtility.scrollToElement;
import static opencart.utility.WaitUtility.waitAlert;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class ProductPage extends ProductListPage {

	By productName = By.xpath("h1");
	By btnWishList = By.xpath("//button[@aria-label='Add to Wish List']");
	By fieldRadio = By.xpath("//div[@id='input-option-218']//input");
	By fieldCheckBox = By.xpath("//div[@id='input-option-223']//input");
	By fieldText = By.xpath("//input[@id='input-option-208']");
	By fieldSelect = By.xpath("//select[@id='input-option-217']");
	By fieldTextarea = By.xpath("//textarea[@id='input-option-209']");
	By btnUploadFile = By.xpath("//button[@id='button-upload-222']");

	By fieldDate = By.xpath("//input[@id='input-option-219']");
	By fieldTime = By.xpath("//input[@id='input-option-221']");
	By fieldDateAndTime = By.xpath("//input[@id='input-option-220']");
	By fieldQuantity = By.xpath("//input[@id='input-quantity']");
	By fieldAddToCart = By.xpath("//button[@id='button-cart']");
	By successMessage=By.xpath("//div[@class='alert alert-success alert-dismissible']");
	public String getProductName() {
		return getInnerText(productName);
	}

	public void addToWishList() {
		click(btnWishList);
	}

	public void selectRadioButton(int indexRadioButton) {
		javascriptClick( By.xpath("//div[@id='input-option-218']//div["+indexRadioButton+"]//input"));
	}

	public void selectCheckbox(int indexCheckbox) {
		javascriptClick( By.xpath("//div[@id='input-option-223']//div["+indexCheckbox+"]//input"));

	}

	public void enterText(String text) {
		set(fieldText, text);
	}

	public void selectFromDropdown(int indexSelect) {
		selectFieldByIndex(fieldSelect, indexSelect);
	}

	public void enterTextarea(String textArea) {
		set(fieldTextarea, textArea);
	}

	public String getMessageSuccess() {
		try {
			
			return getInnerText(successMessage);
		}catch(Exception e) {
			return e.getLocalizedMessage();
		}
		
	}
	public void uploadFile(String filePath) throws AWTException, InterruptedException {
		WebElement uploadButton = find(btnUploadFile);
		uploadButton.sendKeys(filePath);
		
		
		StringSelection filePathSelection=new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePathSelection, null);

		Robot rb=new Robot();
		
		Thread.sleep(5000);

		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		
		Thread.sleep(5000);
		
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

//		rb.keyPress(KeyEvent.VK_ENTER);
//		rb.keyRelease(KeyEvent.VK_ENTER);
		waitAlert().accept();
	}

	public void enterDate(String date) {
		set(fieldDate, date);
//		javascriptClick(fieldDate);
	}

	public void enterTime(String time) {
//		scrollToElement(fieldTime);
//		javascriptClick(fieldTime);
		
		set(fieldTime, time);
	}

	public void enterDateAndTime(String dateTime) {
//		set(fieldDateAndTime, dateTime);
		driver.findElement(fieldDateAndTime).sendKeys(dateTime.split(" ")[0]+Keys.TAB+dateTime.split(" ")[1]);

	}

	public void setQuantity(String quantity) {
		set(fieldQuantity,quantity);
		
	}

	public void addToCart() {
		click(fieldAddToCart);
	}
}
