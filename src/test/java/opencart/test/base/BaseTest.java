package opencart.test.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import opencart.pages.BasePage;
import opencart.pages.HomePage;

public class BaseTest {

	private WebDriver driver;
	protected HomePage homePage;
	protected BasePage basePage;
	private String OPENCART_URL="http://localhost/opencart/upload/";
	
	@BeforeClass
	public void setUp() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@BeforeMethod
	public void loadApplication() {
		driver.get(OPENCART_URL);
		
		basePage=new BasePage();
		basePage.setDriver(driver);
		
		homePage=new HomePage();
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit(); 
	}
}
