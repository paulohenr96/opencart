package opencart.test.base;

import static opencart.utility.PropertiesUtil.getProperty;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import opencart.pages.BasePage;
import opencart.pages.HomePage;
import opencart.report.ExtentReportManager;
import opencart.utility.PropertiesUtil;
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
		PropertiesUtil.loadProperties();
		ExtentReportManager.createInstance();
		PropertyConfigurator.configure(System.getProperty("user.dir") + "/src/test/resources/" + "log4j.properties");
		logger.info("===============================================");

		logger.info("*** Starting Suite ***");

	}

	@BeforeClass
	public void setUp() throws IOException {
//		FileReader file = new FileReader("./src//test//resources//config.properties");
//		p = new Properties();
//		p.load(file);
		OPENCART_URL = getProperty("appURL");

		String os = getProperty("os");
		String br = getProperty("browser");

		if (getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities capabilities = new DesiredCapabilities();

			if (os.equalsIgnoreCase("windows")) {
				capabilities.setPlatform(Platform.WIN10);
			} else if (os.equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);

			} else if (os.equalsIgnoreCase("linux")) {
				capabilities.setPlatform(Platform.LINUX);
			}

			else {
				System.out.println("No matching os");
			}

			switch (br.toLowerCase()) {

			case "chrome":
				capabilities.setBrowserName("chrome");
				break;
			case "edge":
				capabilities.setBrowserName("MicrosoftEdge");
				break;
			case "firefox":
				capabilities.setBrowserName("firefox");
				break;

			default:
				System.out.println("No matching browser name...");
				return;

			}

			try {
				driver = new RemoteWebDriver(new URL("http://host.docker.internal:4444/wd/hub"), capabilities);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {

			driver = new ChromeDriver();

			switch (br.toLowerCase()) {

			case "chrome":
				driver = new ChromeDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;

			default:
				System.out.println("No matching browser name...");
				return;

			}
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@BeforeMethod
	public void loadApplication() {
		logger.info("********* LOADING ENVIRONMENT... *********");

		driver.get(OPENCART_URL);

		basePage = new BasePage();
		basePage.setDriver(driver);
		Utility.setUtilityDriver();
		homePage = new HomePage();
	}

	@AfterClass
	public void tearDown() {
		logger.info("Quitting driver...");

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
