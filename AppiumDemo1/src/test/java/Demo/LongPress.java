package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class LongPress {
	
	static AndroidDriver driver;

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		// TODO Auto-generated method stub
		
		//Gather Desired capabilities
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		   capabilities.setCapability("deviceName","Xiaomi 2201117TG");
	        capabilities.setCapability("platformname", "Android");     
	        capabilities.setCapability("automationName","uiautomator2");
	        capabilities.setCapability("platformversion", "11");
	        
	        capabilities.setCapability("appPackage","com.google.android.dialer");
	        capabilities.setCapability("appActivity", "com.google.android.dialer.extensions.GoogleDialtactsActivity");
	        
	        

	        URL url = URI.create("http://127.0.0.1:4723/").toURL();
	        
	        driver = new AndroidDriver(url, capabilities);
	        Thread.sleep(2000);
	        System.out.println("Application Started");
	        
	        //click dial pad
		       driver.findElement(By.id("com.google.android.dialer:id/dialpad_fab")).click();
		    
		       //com.google.android.dialer:id/one
		     //  com.google.android.dialer:id/dialpad_voice_call_button
		       
		       //09810
		       driver.findElement(By.id("com.google.android.dialer:id/zero")).click();
		       driver.findElement(By.id("com.google.android.dialer:id/nine")).click();
		       driver.findElement(By.id("com.google.android.dialer:id/eight")).click();
		       driver.findElement(By.id("com.google.android.dialer:id/one")).click();
		       driver.findElement(By.id("com.google.android.dialer:id/zero")).click();
		    
		       //Long press on backspace/delete button
		       WebElement deleteBtn = driver.findElement(By.id("com.google.android.dialer:id/deleteButton"));
		       
		       deleteBtn.click(); //remove one digit

		       
		       Thread.sleep(2000);
		        
		       longPress(deleteBtn);
		       driver.quit();//close session

	}
	
	
        	static void longPress(WebElement el) {
        		//find location of the web element
        		Point location = el.getLocation();
        		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        		
        		Sequence longpress = new Sequence(finger, 1);
        				longpress.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), location.x, location.y));
        				longpress.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        				longpress.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), location.x, location.y));
        				longpress.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg())); 

        		//perform the long press of action
        		driver.perform(Collections.singletonList(longpress));
        		
        	}

}
