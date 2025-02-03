package opencart.utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility extends Utility{

	
	
	public static Boolean isURLLoaded(String fraction) {
		
		int seconds=5;
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(seconds));
		return wait.until(ExpectedConditions.urlContains(fraction));
		
	}
}
