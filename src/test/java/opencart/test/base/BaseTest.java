package opencart.test.base;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import opencart.pages.BasePage;
import opencart.pages.HomePage;
import opencart.report.ExtentReportManager;
import opencart.utility.Utility;

public class BaseTest {

	private WebDriver driver;
	protected HomePage homePage;
	protected BasePage basePage;
	private String OPENCART_URL;
    protected static Logger logger = Logger.getLogger(BaseTest.class);

	// Get the properties
	private Properties p;
	
	@BeforeSuite
	public void setSuite() {
		ExtentReportManager.createInstance();
        PropertyConfigurator.configure(System.getProperty("user.dir")+"/src/test/resources/"+"log4j.properties");
        logger.info("===============================================");

        logger.info("*** Starting Suite ***");

	}
	
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
        logger.info("********* LOADING ENVIRONMENT... *********");

		driver.get(OPENCART_URL);
		
		basePage=new BasePage();
		basePage.setDriver(driver);
		Utility.setUtilityDriver();
		homePage=new HomePage();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit(); 
        logger.info("********* TEST ENDED *********");

	}
	
	@AfterSuite
	public void flushSuite() {
        logger.info("*** Flushing report... ***");

		ExtentReportManager.flush();
        logger.info("*** Suite Ended ***");
        logger.info("===============================================");

	}
}
