package tests;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;

import io.appium.java_client.android.AndroidDriver;

public class BaseClass extends ExtentReportsDemo{
	
	protected AndroidDriver driver;
	ExtentReports extent;
	
	@BeforeTest
    public void setupDriver() throws MalformedURLException, InterruptedException {
		
		//Gather Desired capabilities
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		    capabilities.setCapability("deviceName","Xiaomi 2201117TG");
	        capabilities.setCapability("platformname", "Android");     
	        capabilities.setCapability("automationName","uiautomator2");
	        capabilities.setCapability("platformversion", "11");
	        
	        capabilities.setCapability("appPackage","com.touchboarder.android.api.demos");
	        capabilities.setCapability("appActivity", "com.example.android.apis.ApiDemos");
	          

	        URL url = URI.create("http://127.0.0.1:4723/").toURL();
	        
	        AndroidDriver driver = new AndroidDriver(url, capabilities);
	        Thread.sleep(2000);
	        System.out.println("Application Started");
	}
	
	@AfterTest
    public void teardownDriver() {
       
    }

}
