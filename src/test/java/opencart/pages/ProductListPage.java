package opencart.pages;

import static opencart.utility.JavascriptUtility.javascriptClick;

import org.openqa.selenium.By;

public class ProductListPage extends HomePage {

	public By notificationCard=By.xpath("//div[@class='alert alert-success alert-dismissible']");
	
	public void addProductToTheWishList(int index) {

		javascriptClick(By.xpath("//div[@id='product-list']//div[@class='col mb-3'][" + index + "]//button[2]"));
	}

	public void addProductToCartByIndex(int index) {

		javascriptClick(By.xpath("//div[@id='product-list']//div[@class='col mb-3'][" + index + "]//button[1]"));
	}
	
	public boolean successNotification() {
		return isVisible(notificationCard);
	}
	
	public String getNotificationSuccess() {
		try {
			
			return getInnerText(notificationCard);
		}catch (Exception e) {
			return e.getLocalizedMessage();
		}
	}
	

}
