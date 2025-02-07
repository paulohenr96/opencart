package opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

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

	public String getProductName() {
		return getInnerText(productName);
	}

	public void addToWishList() {
		click(btnWishList);
	}

	public void selectRadioButton(int index) {
		List<WebElement> radios = findList(fieldRadio);
		radios.get(index).click();
	}

	public void selectCheckbox(int index) {
		List<WebElement> checkboxes = findList(fieldCheckBox);
		checkboxes.get(index).click();
	}

	public void enterText(String text) {
		set(fieldText, text);
	}

	public void selectFromDropdown(String optionText) {
		Select dropdown = getSelect(fieldSelect);
		dropdown.selectByVisibleText(optionText);
	}

	public void enterTextarea(String text) {
		set(fieldTextarea, text);
	}

	public void uploadFile(String filePath) {
		WebElement uploadButton = find(btnUploadFile);
		uploadButton.sendKeys(filePath);
	}

	public void enterDate(String date) {
		set(fieldDate, date);
	}

	public void enterTime(String time) {
		set(fieldTime, time);
	}

	public void enterDateAndTime(String dateTime) {
		set(fieldDateAndTime, dateTime);
	}

	public void setQuantity(String quantity) {
		set(fieldQuantity,quantity);
		
	}

	public void addToCart() {
		click(fieldAddToCart);
	}
}
