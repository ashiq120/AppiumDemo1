package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import  io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import io.appium.java_client.android.AndroidDriver;

@SuppressWarnings("deprecation")
public class DragAndDropDemo {

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
	        Thread.sleep(5000);
	        System.out.println("Application Started");
	        
	        
	        //find view button
	       WebElement viewBtn =  driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Views\"]"));
	       viewBtn.click(); //perform click action on view button
	       
	       //find drag and drop button
	       WebElement dragAndDropBtn =  driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Drag and Drop\"]"));
	       dragAndDropBtn.click(); //perform click action on drag and drop button
	       
	       WebElement source =  driver.findElement(By.xpath("//android.view.View[@resource-id=\"com.touchboarder.android.api.demos:id/drag_dot_1\"]"));
	     
	       WebElement destination =  driver.findElement(By.xpath("//android.view.View[@resource-id=\"com.touchboarder.android.api.demos:id/drag_dot_2\"]"));

	       
	       //By using touch action class
	       TouchAction action = new TouchAction(driver); //deprecate

	   		action.longPress(longPressOptions().withElement(element(source))).moveTo(element(destination)).release().perform();
	
			 Thread.sleep(2000);
	        driver.quit();//CLOSE SESSION
	}

}