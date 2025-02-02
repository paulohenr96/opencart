package opencart.pages;

import static opencart.utility.JavascriptUtility.javascriptClick;

import org.openqa.selenium.By;

public class CartPage extends HomePage{
	
	private By btnCheckout=By.xpath("//a[@class='btn btn-primary']");
	
	
	public CheckoutPage clickCheckout() {
		javascriptClick(btnCheckout);
		
		return new CheckoutPage();
	}
}
