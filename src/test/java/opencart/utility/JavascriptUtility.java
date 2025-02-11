package opencart.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JavascriptUtility extends Utility {

	public static void script(By locator, String script) {
		WebElement element = driver.findElement(locator);

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript(script, element);
	}

	public static void scrollToElement(By locator) {

		script(locator, "arguments[0].scrollIntoView();");
	}

	public static void javascriptClick(By locator) {

		script(locator, "arguments[0].click();");
	}

}
