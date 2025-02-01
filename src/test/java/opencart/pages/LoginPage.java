package opencart.pages;

import org.openqa.selenium.By;

public class LoginPage extends HomePage {

    // Locators for the login fields and button
    By fieldEmailAddress = By.xpath("//input[@id='input-email']");
    By fieldPassword = By.xpath("//input[@id='input-password']");
    By btnLogin = By.xpath("//button[normalize-space()='Login']");
    By notification=By.xpath("//div[@class='alert alert-danger alert-dismissible']");

    public void setEmailAddress(String email) {
        set(fieldEmailAddress, email);
    }

    public void setPassword(String password) {
        set(fieldPassword, password);
    }

    public void clickLogin() {
        click(btnLogin);
    }
    
    public String getNotification() {
    	try {
    		return getInnerText(notification);
    	}catch(Exception e){
    		return e.getMessage();
    	}
    	
    	 
    }
}
