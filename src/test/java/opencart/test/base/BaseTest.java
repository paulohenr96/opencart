package opencart.test.base;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import opencart.pages.BasePage;
import opencart.pages.HomePage;
import opencart.utility.Utility;

public class BaseTest {

	private WebDriver driver;
	protected HomePage homePage;
	protected BasePage basePage;
	private String OPENCART_URL;
	
	
	private Properties p;
	
	
	@BeforeClass
	public void setUp() throws IOException {
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p = new Properties();
		p.load(file);
		OPENCART_URL=p.getProperty("appURL");
		
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@BeforeMethod
	public void loadApplication() {
		driver.get(OPENCART_URL);
		
		basePage=new BasePage();
		basePage.setDriver(driver);
		Utility.setUtilityDriver();
		homePage=new HomePage();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit(); 
	}
}
