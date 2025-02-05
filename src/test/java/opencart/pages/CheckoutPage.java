package opencart.pages;

import static opencart.utility.JavascriptUtility.javascriptClick;
import static opencart.utility.WaitUtility.waitUntilEnabledElement;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import opencart.pages.alert.PaymentMethodAlertPage;
import opencart.pages.alert.ShippingMethodAlertPage;

public class CheckoutPage extends BasePage {

	private By btnChooseShippingMethod = By.xpath("//button[@id='button-shipping-methods']");

	private By btnChoosePaymentMethod = By.xpath("//button[@id='button-payment-methods']");

	private By btnConfirmOrder = By.xpath("//button[@id='button-confirm']");

	private By selectAddress = By.xpath("//select[@id='input-shipping-address']");

	private By newAddress = By.xpath("//label[@for='input-shipping-new']");

	private By fieldFirstName = By.xpath("//input[@id='input-shipping-firstname']");
	private By fieldLastName = By.xpath("//input[@id='input-shipping-lastname']");
	private By fieldCompany = By.xpath("//input[@id='input-shipping-company']");
	private By fieldAddress1 = By.xpath("//input[@id='input-shipping-address-1']");
	private By fieldAddress2 = By.xpath("//input[@id='input-shipping-address-2']");
	private By fieldCity = By.xpath("//input[@id='input-shipping-city']");
	private By fieldPostCode = By.xpath("//input[@id='input-shipping-postcode']");
	private By selectCountry = By.xpath("//select[@id='input-shipping-country']");
	private By selectState = By.xpath("//select[@id='input-shipping-zone']");
	private By btnContinue = By.xpath("//button[text()='Continue']");
	
	public void setFirstName(String firstName) {
		set(fieldFirstName, firstName);
	}
	
	public void clickContinue() {
		javascriptClick(btnContinue);
	}
	public void setLastName(String lastName) {
		set(fieldLastName, lastName);
	}

	public void setCompany(String company) {
		set(fieldCompany, company);
	}

	public void setAddress1(String address1) {
		set(fieldAddress1, address1);
	}

	public void setAddress2(String address2) {
		set(fieldAddress2, address2);
	}

	public void setCity(String city) {
		set(fieldCity, city);
	}

	public void setPostCode(String postCode) {
		set(fieldPostCode, postCode);
	}

	public void selectCountry(String country) {
		
		getSelect(selectCountry).selectByVisibleText(country);
	}

	public void selectState(String state) {
		getSelect(selectState).selectByVisibleText(state);
		
	}

	public void clickConfirmOrder() {
		javascriptClick(btnConfirmOrder);

	}

	public ShippingMethodAlertPage clickChooseShippingMethod() {
		javascriptClick(btnChooseShippingMethod);
		return new ShippingMethodAlertPage();
	}

	public PaymentMethodAlertPage clickPaymentMethod() {
		javascriptClick(btnChoosePaymentMethod);
		return new PaymentMethodAlertPage();
	}
	
	public void selectExistingAddess(int index) {
		click(selectAddress);
		selectFieldByIndex(selectAddress, index);
	}
	
}
