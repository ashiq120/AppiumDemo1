package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class DropDownHandling {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		// TODO Auto-generated method stub


		//Gather Desired capabilities
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		    capabilities.setCapability("deviceName","Xiaomi 2201117TG");
	        capabilities.setCapability("platformname", "Android");     
	        capabilities.setCapability("automationName","uiautomator2");
	        capabilities.setCapability("platformversion", "11");
	        
	        capabilities.setCapability("appPackage","com.touchboarder.android.api.demos");
	        capabilities.setCapability("appActivity", "com.example.android.apis.ApiDemos");
	        
	      //io.appium.android.apis/io.appium.android.apis.ApiDemos
	        
	        

	        URL url = URI.create("http://127.0.0.1:4723/").toURL();
	        
	        AndroidDriver driver = new AndroidDriver(url, capabilities);
	        Thread.sleep(2000);
	        System.out.println("Application Started");

		//click on view button
		driver.findElements(By.id("android:id/text1")).get(12).click();

		//click on controls
		driver.findElements(By.id("android:id/text1")).get(4).click();

		//click on light theme
		driver.findElements(By.id("android:id/text1")).get(0).click();

		WebElement dropdown = driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\"]"));
		dropdown.click();
		
		Thread.sleep(2000);
		
		WebElement earthOption = driver.findElement(By.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Earth\"]"));
		earthOption.click();
			
		
		Thread.sleep(2000);
		System.out.println("Session closed");
		driver.quit();
	}

}