package opencart.pages;

import static opencart.utility.WaitUtility.waitUntilEnabledElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
	
	
	
	public static WebDriver driver;
	
	
	public void selectFieldByIndex(By locator,int index) {
		new Select(waitUntilEnabledElement(locator)).selectByIndex(index);
	}
	
	public void setDriver(WebDriver driver) {
		BasePage.driver=driver;
	}
	
	protected WebElement find(By locator) {
		return driver.findElement(locator);
	}
	protected List<WebElement> findList(By locator){
		return driver.findElements(locator);
	}
	public boolean isVisible(By locator) {
		return driver.findElement(locator).isDisplayed();
	}
	
	public void click(By locator) {
		waitUntilEnabledElement(locator).click();
	}
	
	public void set(By locator,String text) {
		WebElement element = find(locator);
		element.clear();
		element.sendKeys(text);
	}
	
	public String  getInnerText(By locator) {
		return find(locator).getText();
	}
	
//	public List<WebElement> getProductsList(int position){
//		
//		return driver.findElements(By.xpath("//div[@id='product-list']//div[@class='col mb-3']"));
//	}
	
	public Select getSelect(By locator) {
		return  new Select(waitUntilEnabledElement(locator));
		
	}
	
}
