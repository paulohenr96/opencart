package opencart.pages;

import org.openqa.selenium.By;

public class WishPage extends HomePage{

	private void addItemToCart(int index) {
		click(By.xpath("//div[@id='wishlist']//table//tr["+index+"]//td[6]//button"));
	}
	
	private void removeItem(int index) {
		click(By.xpath("//div[@id='wishlist']//table//tr["+index+"]//td[6]//a"));
	}
}
