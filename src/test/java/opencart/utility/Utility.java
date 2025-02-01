package opencart.utility;

import org.openqa.selenium.WebDriver;

import opencart.pages.BasePage;

public class Utility {

	public static WebDriver driver;
	
	public static void setUtilityDriver() {
		driver=BasePage.driver;
	}
}
