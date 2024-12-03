package tests;

import org.testng.annotations.Test;

//import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Animations extends BaseClass {
	protected AndroidDriver driver;
	//protected ExtentReports extent;
    protected ExtentTest test;
	
	 @Test
	    public void testActivityTransition() {
	        test = extent.createTest("Test Activity Transition");
	        try {
	        	 // Navigate to the Animation section
	            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Animation\"]")).click();

	            // Perform actions in Animation section
	            
	            // 1. "Activity Transition"
	            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Activity Transition\"]")).click();
	            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/ball")).click();
	            Thread.sleep(3000);  // Wait to observe the animation
	            test.pass("Activity Transition tested successfully.");
	            driver.navigate().back();
	            driver.navigate().back();
	        } catch (Exception e) {
	            test.fail("Action Bar test failed: " + e.getMessage());
	        }
	    }

}
