package opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

	private By btnMyAccount = By.xpath("//i[@class='fa-solid fa-user']");
	private By btnRegister = By.xpath("//a[normalize-space()='Register']");
	private By btnLogin = By.xpath("//a[normalize-space()='Login']");
	private By fieldSearch=By.xpath("//input[@placeholder='Search']");
	private By btnSearch=By.xpath("//button[@class='btn btn-light btn-lg']");
	
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	public void clickMyAccount() {
		click(btnMyAccount);
	}
	public void clickRegister() {
		click(btnRegister);
	}
	
	public void clickLogin() {
		click(btnLogin);
	}
	
	public void writeSearchBar(String item) {
		set(fieldSearch,item);
	}
	
	public void clickSearch() {
		click(btnSearch);
	}

}
