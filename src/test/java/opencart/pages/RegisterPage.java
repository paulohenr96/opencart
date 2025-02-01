package opencart.pages;

import static opencart.utility.JavascriptUtility.javascriptClick;
import static opencart.utility.JavascriptUtility.scrollToElement;

import org.openqa.selenium.By;

public class RegisterPage extends HomePage {

	By fieldFirstName = By.xpath("//input[@id='input-firstname']");
	By fieldLastName = By.xpath("//input[@id='input-lastname']");
	By fieldEmail = By.xpath("//input[@id='input-email']");
	By fieldPassword = By.xpath("//input[@id='input-password']");
	By btnNewsletter = By.xpath("//input[@id='input-newsletter']");
	By btnAgree = By.xpath("//input[@name='agree']");
	By btnContinue = By.xpath("//button[normalize-space()='Continue']");

	public void setFirstName(String firstName) {
		set(fieldFirstName, firstName);
	}

	public void setLastName(String lastName) {
		set(fieldLastName, lastName);
	}

	public void setEmail(String email) {
		set(fieldEmail, email);
	}

	public void setPassword(String password) {
		set(fieldPassword, password);
	}

	public void clickNewsletter() {
		scrollToElement(btnNewsletter);
		javascriptClick(btnNewsletter);
	}

	public void clickAgree() {
		scrollToElement(btnNewsletter);

		javascriptClick(btnAgree);
	}
	
	public void clickContinue() {
		click(btnContinue);
	}

}
