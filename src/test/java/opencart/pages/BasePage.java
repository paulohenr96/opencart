package opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {
	
	
	
	public static WebDriver driver;
	
	public void setDriver(WebDriver driver) {
		BasePage.driver=driver;
	}
	
	private WebElement find(By locator) {
		return driver.findElement(locator);
	}
	
	public void click(By locator) {
		find(locator).click();
	}
	
	public void set(By locator,String text) {
		find(locator).sendKeys(text);
	}
	
	public String  getInnerText(By locator) {
		return find(locator).getText();
	}
	
	public List<WebElement> getProductsList(int position){
		
		return driver.findElements(By.xpath("//div[@id='product-list']//div[@class='col mb-3']"));
	}
	
	
}
