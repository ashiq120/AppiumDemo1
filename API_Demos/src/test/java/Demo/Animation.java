package Demo;

import java.net.MalformedURLException;


import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Animation {

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
			        
			     // Wait for app to load
		            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		            // Navigate to the Animation section
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Animation\"]")).click();

		            // Perform actions in Animation section
		            
		            // 0. "Activity Transition"
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Activity Transition\"]")).click();
		            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/ball")).click();
		            Thread.sleep(3000);  // Wait to observe the animation
		            driver.navigate().back();
		            driver.navigate().back();

		            // 1. "Bouncing Balls"
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Bouncing Balls\"]")).click();
		            driver.findElement(AppiumBy.xpath("//android.view.View")).click();
		            Thread.sleep(3000);  // Wait to observe the animation

		            // Go back to Animation menu
		            driver.navigate().back();

		            // 2. Tap on "Cloning"
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Cloning\"]")).click();
		            Thread.sleep(2000);

		            // Start the cloning animation by tapping the "Run" button
		            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/startButton")).click();
		            Thread.sleep(3000);  // Wait for cloning animation

		            // Go back to the main menu
		            driver.navigate().back();
		            
		         // 3. Custom Evaluator
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Custom Evaluator\"]")).click();
		            
		            // Start the cloning animation by tapping the "Play" button
		            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/startButton")).click();
		            Thread.sleep(3000);  // Wait to observe animation
		            driver.navigate().back();

		            // 4. Default Layout Animations
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Default Layout Animations\"]")).click();
		            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/addNewButton")).click();  // Add an item
		            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/addNewButton")).click();  // Add another item
		            Thread.sleep(3000);
		            driver.navigate().back();

		            // 5. Events
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Events\"]")).click();
		            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/startButton")).click();  // Start event animation
		            Thread.sleep(3000);  // Observe the animation
		            driver.navigate().back();

		            // 6. Hide-Show Animations
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Hide-Show Animations\"]")).click();
		            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/hideGoneCB")).click();  // Toggle visibility
		            driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"0\"]")).click();
		            Thread.sleep(2000);
		            driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"3\"]")).click();
		            Thread.sleep(3000);
		            driver.navigate().back();

		            // 7. Layout Animations
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Layout Animations\"]")).click();
		            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/addNewButton")).click();  // Add an item
		            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/addNewButton")).click();  // Add another item
		            Thread.sleep(3000);
		            driver.navigate().back();

		            // 8. Loading
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Loading\"]")).click();
		            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/startButton")).click();  // Start loading animation
		            Thread.sleep(3000);  // Observe the animation
		            driver.navigate().back();

		            // 9. Multiple Properties
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Multiple Properties\"]")).click();
		            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/startButton")).click();  // Start multiple property animation
		            Thread.sleep(3000);  // Observe animation
		            driver.navigate().back();

		            // 10. Path Animations
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Path Animations\"]")).click();
		            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/named_components")).click();  // Start path animation
		            Thread.sleep(3000);  // Wait to observe path animation
		            driver.navigate().back();

		            // 11. Reversing
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Reversing\"]")).click();
		            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/startButton")).click();    // Start animation
		            Thread.sleep(2000);
		            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/reverseButton")).click();  // Start reversing animation
		            Thread.sleep(2000);  // Observe animation
		            driver.navigate().back();

		            // 12. Seeking
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Seeking\"]")).click();
		            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/startButton")).click();  // Start seeking animation
		            Thread.sleep(2000);  // Observe animation
		            driver.navigate().back();

		            // 13. Simple Transitions
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Simple Transitions\"]")).click();
		            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/scene1")).click();  // Switch to Scene 1
		            Thread.sleep(2000);
		            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/scene2")).click();  // Switch to Scene 2
		            Thread.sleep(2000);
		            driver.navigate().back();
		            
		            //Scroll 
			          //Get Screen size
			    		Dimension size = driver.manage().window().getSize();
			    		
			    		//find the position where you need to touch
			    		int startX = size.getWidth() / 2;
			    		int startY = size.getHeight() / 2;
			    		
			    		//position till you want to move your finger to swipe
			    		int endX = startX;
			    		int endY = (int) (size.getHeight() * 0.25);
			    		
			    		//PointerInput class to create a sequence of actions 
			    		PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
			    		
			    		//Sequence object, which is a list of actions that will be performed on the device
			    		Sequence sequence = new Sequence(finger1, 1)
			    				.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
			    				.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
			    				.addAction(new Pause(finger1, Duration.ofMillis(200))) //wait for some time
			    				.addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
			    				.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg())); 

			    		//perform the Sequence of action
			    		driver.perform(Collections.singletonList(sequence));
			    		
			    		Thread.sleep(3000);

		            // 14. View Flip
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"View Flip\"]")).click();
		            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/button")).click();  // Flip the view
		            Thread.sleep(3000);  // Observe view flip animation
		            driver.navigate().back();
		            
		            Thread.sleep(2000);
		    		System.out.println("Session closed");
		    		driver.quit();


	}

}
