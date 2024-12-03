package Demo;

import java.net.MalformedURLException;

import java.net.URI;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class HardwareAndMedia {

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
	          

	        URL url = URI.create("http://127.0.0.1:4723/").toURL();
	        
	        AndroidDriver driver = new AndroidDriver(url, capabilities);
	        Thread.sleep(2000);
	        System.out.println("Application Started");
	        
	     // Set implicit wait
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // Navigate to the Hardware section
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Hardware\"]")).click();

            // Select Consumer IR
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\"]")).click();
            
            // Wait to observe the Consumer IR screen
            Thread.sleep(2000);

            // Interact with Consumer IR elements if present (replace these with actual element IDs if necessary)
            try {
                WebElement transmitButton = driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/get_freqs_button"));
                transmitButton.click();  // Attempt to get Carrier Frequencies
                Thread.sleep(3000);
                System.out.println("Got Carrier Frequencies");
                
//                WebElement irFrequency = driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/get_freqs_button"));
//                System.out.println("IR Frequency: " + irFrequency.getText());

            } catch (Exception e) {
                System.out.println("Consumer IR elements not found or interaction not available on this device.");
            }

            // Navigate back to the Hardware section
            driver.navigate().back();
            driver.navigate().back();
            
            
         // Navigate to the Media section
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Media\"]")).click();

            // 1. AudioFx
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"AudioFx\"]")).click();
            Thread.sleep(2000);  // Wait to observe the AudioFx screen
            driver.navigate().back();

            // 2. MediaPlayer
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"MediaPlayer\"]")).click();
            
         // Start the "Video" and "Audio" by tapping the "Play" button
            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/localvideo")).click();
            Thread.sleep(5000);  // Wait to observe the MediaPlayer screen
            driver.navigate().back();
            
            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/streamvideo")).click();
            Thread.sleep(5000);  // Wait to observe the MediaPlayer screen
            driver.navigate().back();
            
            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/localaudio")).click();
            Thread.sleep(3000);  // Wait to observe the MediaPlayer screen
            driver.navigate().back();
            
            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/resourcesaudio")).click();
            Thread.sleep(3000);  // Wait to observe the MediaPlayer screen
            
            driver.navigate().back();
            driver.navigate().back();
            

            // 3. MediaProjection
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"MediaProjection\"]")).click();
            driver.findElement(AppiumBy.xpath("//android.widget.Spinner[@resource-id=\"com.touchboarder.android.api.demos:id/spinner\"]")).click();
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"1600x900\"]")).click();
            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/screen_sharing_toggle")).click();
            driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")).click();
            Thread.sleep(3000);  // Wait to observe the MediaProjection screen
            driver.navigate().back();

            // 4. VideoView
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"VideoView\"]")).click();
            Thread.sleep(2000);  // Wait to observe the VideoView screen
            
            // Try playing video in VideoView
            try {
            	driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/surface_view")).click();
                WebElement videoPlayButton = driver.findElement(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Play\"]"));  // Placeholder ID
                videoPlayButton.click();  // Play video
                System.out.println("Video playback started.");
                Thread.sleep(10000);  // Allow video to play for a few seconds
            } catch (Exception e) {
                System.out.println("Video play button not found or video cannot be played.");
            }
            
            driver.navigate().back();
            
            Thread.sleep(2000);
    		System.out.println("Session closed");
    		driver.quit();


	}

}
