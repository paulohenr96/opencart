package opencart.pages.alert;

import org.openqa.selenium.By;

import opencart.pages.BasePage;

public class PaymentMethodAlertPage extends BasePage {

	private By btnContinue = By.xpath("//form[@id='form-payment-method']//button[text()='Continue']");

	public void clickContinue() {
		
		click(btnContinue);

	}
}
