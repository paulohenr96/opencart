package opencart.pages.alert;

import org.openqa.selenium.By;

import opencart.pages.BasePage;

public class ShippingMethodAlertPage extends BasePage{

	private By radioShippingRate=By.xpath("//button[@id='button-shipping-methods']");
	private By btnContinue=By.xpath("//form[@id='form-shipping-method']//button[text()='Continue']");
	
	public void selectFlatShippingRate() {
		click(radioShippingRate);
	}
	
	public void clickContinue() {
		click(btnContinue);
	}
}
