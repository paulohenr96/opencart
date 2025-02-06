package opencart.pages;

import static opencart.utility.JavascriptUtility.javascriptClick;

import org.openqa.selenium.By;

public class CartPage extends HomePage{
	
	private By btnCheckout=By.xpath("//a[@class='btn btn-primary']");
	private By message=By.xpath("//div[@id='content']//p");
	
	public CheckoutPage goToCheckoutPage() {
		javascriptClick(btnCheckout);
		
		return new CheckoutPage();
	}
	
	public String checkMessage() {
		
		try {
			return getInnerText(message);
		}catch(Exception e) {
			return e.getLocalizedMessage();
		}
	}
}
