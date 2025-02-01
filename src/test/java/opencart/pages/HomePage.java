package opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

	private By btnMyAccount = By.xpath("//i[@class='fa-solid fa-user']");
	private By btnRegister = By.xpath("//a[normalize-space()='Register']");
	private By btnLogin = By.xpath("//a[normalize-space()='Login']");
	private By fieldSearch=By.xpath("//input[@placeholder='Search']");
	private By btnSearch=By.xpath("//button[@class='btn btn-light btn-lg']");
	

	
	public void clickMyAccount() {
		click(btnMyAccount);
	}
	public RegisterPage clickRegister() {
		click(btnRegister);
		return new RegisterPage();
	}
	
	public LoginPage clickLogin() {
		click(btnLogin);
		return new LoginPage();
	}
	
	public void writeSearchBar(String item) {
		set(fieldSearch,item);
	}
	
	public void clickSearch() {
		click(btnSearch);
	}

}
