package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class APKInstall {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		//Gather desired capabilities
		//Virtual Device
		
//		DesiredCapabilities capabilities = new DesiredCapabilities();
//		
//		capabilities.setCapability("deviceName","AndroidEmulator");
//		capabilities.setCapability("platformName","Android");
//		capabilities.setCapability("automationName","uiautomator2");
//		capabilities.setCapability("app","E:\\Appium\\ApkFiles\\example.apk");
//		capabilities.setCapability("platformVersion","13");
//		
//		URL url = URI.create("http://127.0.0.1:4723/").toURL();
//		AndroidDriver driver = new AndroidDriver(url, capabilities);
//		Thread.sleep(5000);
//		System.out.println("Application Started");
//		driver.quit();
		
		//Real Device
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		    capabilities.setCapability("deviceName","Xiaomi 2201117TG");
	        capabilities.setCapability("platformname", "Android");     
	        capabilities.setCapability("automationName","uiautomator2");
	        capabilities.setCapability("app", "E:\\Appium\\ApkFiles\\example.apk");
	        capabilities.setCapability("platformversion", "11");
	        
	        

	        URL url = URI.create("http://127.0.0.1:4723/").toURL();
	        
	        AndroidDriver driver = new AndroidDriver(url, capabilities);
	       
	        Thread.sleep(5000);
	        System.out.println("Application Started");
	        driver.quit();//CLOSE SESSION
	}

}
