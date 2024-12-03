package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class HandleTextBoxCheckBoxRadioBtn {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
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
	        Thread.sleep(5000);
	        System.out.println("Application Started");
	        
	      //click on view button
		       driver.findElements(By.id("android:id/text1")).get(12).click();
		    
		       //click on controls
		       driver.findElements(By.id("android:id/text1")).get(4).click();
		      
		       //click on light theme
		       driver.findElements(By.id("android:id/text1")).get(0).click();
		      
		       //enter text in Textbox
		       //io.appium.android.apis:id/edit
		       driver.findElement(By.id("com.touchboarder.android.api.demos:id/edit")).sendKeys("Ashiq");

		       //Checkbox
		       //io.appium.android.apis:id/check1
		       driver.findElement(By.id("com.touchboarder.android.api.demos:id/check1")).click();

		       
		       //Radio button
		       driver.findElement(By.id("com.touchboarder.android.api.demos:id/radio2")).click();

		       
		       Thread.sleep(5000);
		        driver.quit();//CLOSE SESSION

	}

}
