package Demo;

import java.net.MalformedURLException;

import java.net.URI;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Text {

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
	          

	        URL url = URI.create("http://127.0.0.1:4723/").toURL();
	        
	        AndroidDriver driver = new AndroidDriver(url, capabilities);
	        Thread.sleep(2000);
	        System.out.println("Application Started");
	        
	     // Set implicit wait
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            
         // Navigate to the Text section
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Text\"]")).click();
            
         // Navigate to Linkify
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Linkify\"]")).click();
            System.out.println("Opened Linkify.");
            
            // Interact with Linkify Text-1
            try {
                // Click on the first clickable link
                WebElement linkElement = driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/text1"));
                String linkText = linkElement.getText();
                System.out.println("Found link with text: " + linkText);

                // Click the link to open it
                linkElement.click();
                System.out.println("Clicked on the link: " + linkText);

                // Assuming the link opens a browser or a webview
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));  // Wait for the link to open
                System.out.println("Link opened successfully.");

                // Navigate back to the Linkify screen after viewing the link
                driver.navigate().back();
                System.out.println("Returned to Linkify.");

            } catch (Exception e) {
                System.out.println("No clickable link found in Linkify, or unable to click.");
                e.printStackTrace();
            }
            
            Thread.sleep(3000); 
            

            // Go back to the Text menu
            driver.navigate().back();

            // Interact with LogTextBox
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"LogTextBox\"]")).click();
            System.out.println("Navigated to LogTextBox.");

            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/add")).click();
            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/add")).click();
            Thread.sleep(3000); 

            // Go back to the Text menu
            driver.navigate().back();

            // Interact with Marquee
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Marquee\"]")).click();
            System.out.println("Navigated to Marquee.");

            // Verify the scrolling text (usually static but scrolls visually)
            WebElement marqueeText = driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"THIS USE THE DEFAULT MARQUEE ANIMATION LIMIT OF 3\"]"));
            //System.out.println("Marquee text: " + marqueeText.getText());

            // Wait briefly to observe the scrolling effect
            Thread.sleep(3000);

            // Go back to the main screen
            driver.navigate().back();
            
            Thread.sleep(2000);
    		System.out.println("Session closed");
    		driver.quit();

	}

}
