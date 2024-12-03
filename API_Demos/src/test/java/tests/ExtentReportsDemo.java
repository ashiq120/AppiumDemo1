package tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsDemo {
	
	//ExtentSparkReporter spark;
	ExtentReports extent;
	
	@BeforeSuite
    public void reportSetup() {
		 extent = new ExtentReports();
		 ExtentSparkReporter spark = new ExtentSparkReporter("AppiumTestReport.html");
		spark.config().setTheme(Theme.STANDARD);
        spark.config().setDocumentTitle("Appium Test Report");
        spark.config().setReportName("API Demos Test Results");
		extent.attachReporter(spark);

    }
	
	public void createTestReport() {
        if (extent == null) {
            System.out.println("ExtentReports is not initialized!");
            return;
        }
        ExtentTest test = extent.createTest("Sample Test");
        test.pass("Test passed successfully!");
    }
	
	@AfterSuite
    public void teardown() {
		
		extent.flush();
        
    }


}
