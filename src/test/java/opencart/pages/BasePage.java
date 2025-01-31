package opencart.pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
	
	public static WebDriver driver;
	
	public BasePage (WebDriver driver) {
		this.driver=driver;
	}
}
