package ExtentReportBasicDemo;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class DemoExtentReport {
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter("ExtentTest.html");
	WebDriver driver;
	
	@BeforeTest
	public void BrowserLaunch(){
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("My Report");
		extent.attachReporter(spark);
		System.setProperty("webdriver.chrome.driver", "D:\\Tushar\\Documents\\Projects\\Java-Test-Automation_Mess-Management-System\\eclipse-workspace\\Project2\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://amazon.in/");			
	}
	
	@AfterTest
	public void tearDown() {
		extent.flush();
		driver.quit();
	}
	@Test
	public void TestCase_001() {
		ExtentTest test = extent.createTest("Verify the page title").assignAuthor("Tushar Jain");
		test.info("I am verifying the page title");
		String title = driver.getTitle().toString();
		test.info("Captures page title= "+title);
		if(title.equals("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in")) {
			test.pass("The page title is verified successfully");
			test.addScreenCaptureFromPath(capturescreenshot(driver));
		}
		else {
			test.fail("Page title cannot be verified successfully");
		}
	}

	

	public static String capturescreenshot(WebDriver driver) {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destinationFilePath = new File("screenshots/"+System.currentTimeMillis()+".png");
		String absolutePathLocation = destinationFilePath.getAbsolutePath();
		try {
			FileUtils.copyFile(srcFile, destinationFilePath);
		}catch(IOException e){
			e.printStackTrace();
		}
		return absolutePathLocation;
	}
}
