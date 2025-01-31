package opencart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	@FindBy(xpath = "//div[@class='col text-end']//i[@class='fa-solid fa-caret-down']")
	private WebElement myAccount;
	@FindBy(xpath = "//a[normalize-space()='Register']")
	private WebElement register;
	@FindBy(xpath = "//a[normalize-space()='Login']")
	private WebElement login;
	
	
	
}
