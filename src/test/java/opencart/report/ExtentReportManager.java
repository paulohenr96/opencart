package opencart.report;

import static opencart.utility.PropertiesUtil.getProperty;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import opencart.pages.BasePage;

public class ExtentReportManager implements ITestListener {
	public static ExtentSparkReporter  sparkReporter;
	public static ExtentReports extent;
	public ExtentTest test;
	protected static Logger logger = Logger.getLogger(ExtentReportManager.class);

	public static void createInstance() {
		String fileName="report";

		String pathFolder = System.getProperty("user.dir") + "/reports/";
		sparkReporter= new ExtentSparkReporter(pathFolder+fileName+".html");
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("Functional Testing");
		sparkReporter.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Computer Name", getProperty("host"));
		extent.setSystemInfo("Environment", getProperty("execution_env"));
		extent.setSystemInfo("Tester Name", getProperty("testername"));
		extent.setSystemInfo("os", getProperty("os"));
		extent.setSystemInfo("Browser name", getProperty("browser"));
		logger.info("Report set");
		
	}
	


	public void onTestSuccess(ITestResult result) {
		logger.info("Test Success");

		
		test = extent.createTest(getTestName(result));
		test.addScreenCaptureFromPath(captureScreen(result));
		
		test.log(Status.PASS, "Test case PASSED is:" + result.getName());

	}

	public String getTestName(ITestResult result) {
		
		String[] arr = result.getInstanceName().split("\\.");
		String nameOfTheTestClass=arr.length>0?arr[arr.length-1]:result.getInstanceName();
		
		return nameOfTheTestClass;
	}
	public void onTestFailure(ITestResult result) {
		logger.info("Test Failure");
		test = extent.createTest(getTestName(result));
		String captureScreen = captureScreen(result);
		test.addScreenCaptureFromPath(captureScreen);
		test.log(Status.FAIL, "Test case FAILED is: " + result.getName());
		test.log(Status.FAIL, "Test case FAILED cause is:" + result.getThrowable().getMessage());

	}

	public void onTestSkipped(ITestResult result) {
		logger.info("Test Skipped");

		test = extent.createTest(getTestName(result));
		
		test.log(Status.FAIL, "Test case SKIPPED is:" + result.getName());

	}

	
	public static void flush() {
		extent.flush();

	}
	public String captureScreen(ITestResult result) {
		logger.info("Test Capture Screen");

		TakesScreenshot screenshot=(TakesScreenshot) (BasePage.driver);
		File source=screenshot.getScreenshotAs(OutputType.FILE);
		String pathFolder=System.getProperty("user.dir")+
				"/resources/screenshots/";
//		String pathFolder="home/selenium/resources/screenshots/";
		File destination = new File(pathFolder+
						new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date())						
						+result.getName()+".png");	
		
		try {
			FileHandler.copy(source, destination);
		}catch(IOException e) {
			throw new RuntimeException(e);
		}
	
		return destination.toString();
	}

}
