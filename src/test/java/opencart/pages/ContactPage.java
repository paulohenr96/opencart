package opencart.pages;

import static opencart.utility.JavascriptUtility.javascriptClick;

import org.openqa.selenium.By;

public class ContactPage extends HomePage {

	private By fieldYourName = By.xpath("//input[@id='input-name']");
	private By fieldEmailAddress = By.xpath("//input[@id='input-email']");
	private By fieldEnquiry = By.xpath("//textarea[@id='input-enquiry']");
	private By btnSubmit = By.xpath("//button[normalize-space()='Submit']");
	
	private By msgSuccess=By.xpath("//div[@id='content']//p");
	
	
	public void setFieldYourName(String yourName ) {
		set(fieldYourName,yourName);
	}
	public void setFieldEmailAddress(String email ) {
		set(fieldEmailAddress,email);
	}
	public void setFieldEnquiry(String enquiry ) {
		set(fieldEnquiry,enquiry);
	}
	
	public void submitForm() {
		javascriptClick(btnSubmit);
	}
	
	
}
