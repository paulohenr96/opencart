package opencart.report;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import opencart.pages.BasePage;

public class ExtentReportManager implements ITestListener {
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;

	public void onStart(ITestContext context) {
		String fileName="Test-Report_"+context.getName()+"_"+new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/"+fileName+".html");

		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("Functional Testing");
		sparkReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Computer Name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester Name", "Paulo Henrique");
		extent.setSystemInfo("os", "Windows10");
		extent.setSystemInfo("Browser name", "Chrome");

	}

	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.addScreenCaptureFromPath(captureScreen(result));

		test.log(Status.PASS, "Test case PASSED is:" + result.getName());

	}

	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.addScreenCaptureFromPath(captureScreen(result));
		test.log(Status.FAIL, "Test case FAILED is:" + result.getName());
		test.log(Status.FAIL, "Test case FAILED cause is:" + result.getThrowable());

	}

	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		
		test.log(Status.FAIL, "Test case SKIPPED is:" + result.getName());

	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}
	
	
	public String captureScreen(ITestResult result) {
		
		TakesScreenshot screenshot=(TakesScreenshot) (BasePage.driver);
		File source=screenshot.getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir")+
						"/resources/screenshots/"+
						LocalDate.now()+result.getName()+".png");	
		
		try {
			FileHandler.copy(source, destination);
		}catch(IOException e) {
			throw new RuntimeException(e);
		}
		System.out.println("Screen shot located at "+destination);
		
		return destination.toString();
	}

}
