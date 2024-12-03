package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class AutomateCalc {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		
		//Gather Desired capabilities
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		   capabilities.setCapability("deviceName","Xiaomi 2201117TG");
	        capabilities.setCapability("platformname", "Android");     
	        capabilities.setCapability("automationName","uiautomator2");
	        capabilities.setCapability("platformversion", "11");
	        
	        capabilities.setCapability("appPackage","com.miui.calculator");
	        capabilities.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");
	        
	        

	        URL url = URI.create("http://127.0.0.1:4723/").toURL();
	        
	        AndroidDriver driver = new AndroidDriver(url, capabilities);
	        Thread.sleep(5000);
	        System.out.println("Application Started");
	        
	        
	        //click on agree button
			//driver.findElements(By.id("android:id/button1")).get(1).click();
	        
	        //click on number 8
	       WebElement num8 =  driver.findElement(By.id("com.miui.calculator:id/btn_8_s")); 
	       num8.click(); //perform click action on number 8
	       
	       //click on plus sign
	       WebElement plus =  driver.findElement(By.id("com.miui.calculator:id/btn_plus_s"));
	       plus.click(); //perform click action on number 8
	    
	        //click on number 2
	       WebElement num2 =  driver.findElement(By.id("com.miui.calculator:id/btn_2_s"));
	       num2.click(); //perform click action on number 8
	    
	       
	        //click on equal sign
	       WebElement equal =  driver.findElement(By.id("com.miui.calculator:id/btn_equal_s"));
	       equal.click(); //perform click action on number 8
	    
	       
	       //click on result sign
	       WebElement result =  driver.findElement(By.id("com.miui.calculator:id/result"));
	      String resultString = result.getText();
	      
	      if(resultString.equals("10"))
	      {
	    	  System.out.println("Pass");
	      }
	      else
	      {
	    	  System.out.println("fail");
	      }
	      
	    
	 
	        driver.quit();//CLOSE SESSION

	}

}
