package opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

	private By btnMyAccount = By.xpath("//i[@class='fa-solid fa-user']");
	private By btnRegister = By.xpath("//a[normalize-space()='Register']");
	private By btnLogin = By.xpath("//a[normalize-space()='Login']");
	private By fieldSearch=By.xpath("//input[@placeholder='Search']");
	private By btnSearch=By.xpath("//button[@class='btn btn-light btn-lg']");
	private By btnDesktops=By.xpath("//a[normalize-space()='Desktops']");
	private By btnMac=By.xpath("//a[normalize-space()='Mac (1)']");
	private By btnWishList=By.xpath("//a[@id='wishlist-total']//i[@class='fa-solid fa-heart']");
	private By btnShoppingCart=By.xpath("//span[normalize-space()='Shopping Cart']");
	private By btnLogout=By.xpath("//a[@class='dropdown-item'][normalize-space()='Logout']");
	
	
	public void clickLogout() {
		click(btnLogout);
	}
	
	public CartPage clickShoppingCart() {
		
		click(btnShoppingCart);
		
		return new CartPage();
	}
	
	public void clickMyAccount() {
		click(btnMyAccount);
	}
	public RegisterPage clickRegisterPage() {
		click(btnRegister);
		return new RegisterPage();
	}
	
	public LoginPage clickLoginPage() {
		click(btnLogin);
		return new LoginPage();
	}
	
	public void writeSearchBar(String item) {
		set(fieldSearch,item);
	}
	
	public void clickSearch() {
		click(btnSearch);
	}
	
	public void clickDesktops() {
		click(btnDesktops);
	}
	
	public ProductListPage clickMac() {
		click(btnMac);
		
		return new ProductListPage();

	}
	
	public void clickWishList() {
		click(btnWishList);
	}
}
