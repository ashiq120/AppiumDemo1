package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class AppManagement {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		// TODO Auto-generated method stub

		//Gather Desired capabilities
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		    capabilities.setCapability("deviceName","Xiaomi 2201117TG");
	        capabilities.setCapability("platformname", "Android");     
	        capabilities.setCapability("automationName","uiautomator2");
	        capabilities.setCapability("platformversion", "11");

	        URL url = URI.create("http://127.0.0.1:4723/").toURL();
	        
	        AndroidDriver driver = new AndroidDriver(url, capabilities);
	        Thread.sleep(2000);


		String packageName = "com.touchboarder.android.api.demos";
		
		driver.terminateApp(packageName);
		
		//remove app
		driver.removeApp(packageName);
		
		if(!driver.isAppInstalled(packageName))
		{
		//install application
		driver.installApp("C:E:\\Appium\\ApkFiles\\ApiDemos-debug.apk");
		System.out.println("App sucessfully installed.");

		}
		else
			System.out.println("App already installed.");
		
		//activate the application
		driver.activateApp(packageName);
		
		Thread.sleep(2000);
		driver.quit();//close session
	}

}