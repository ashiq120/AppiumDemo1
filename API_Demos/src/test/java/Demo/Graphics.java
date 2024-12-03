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
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Graphics {

	@SuppressWarnings("deprecation")
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
		            
		         // Navigate to Graphics section
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Graphics\"]")).click();

		            // 1. AlphaBitmap
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"AlphaBitmap\"]")).click();
		            Thread.sleep(3000);  // Observe AlphaBitmap
		            driver.navigate().back();

		            // 2. AnimateDrawables
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"AnimateDrawables\"]")).click();
		            Thread.sleep(3000);  // Observe animation
		            driver.navigate().back();

		            // 3. Arcs
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Arcs\"]")).click();
		            Thread.sleep(3000);  // Observe arcs display
		            driver.navigate().back();

		            // 4. BitmapMesh
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"BitmapMesh\"]")).click();
		            Thread.sleep(3000);  // Observe BitmapMesh
		            driver.navigate().back();

		            // 5. CameraPreview
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"CameraPreview\"]")).click();
		            Thread.sleep(3000);  // Observe camera preview
		            driver.navigate().back();

		            // 6. Clipping
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Clipping\"]")).click();
		            Thread.sleep(3000);  // Observe clipping
		            driver.navigate().back();

		            // 7. ColorFilters
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"ColorFilters\"]")).click(); 
		            Thread.sleep(3000);  // Observe color filters
		            driver.navigate().back();

		            // 8. ColorMatrix
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"ColorMatrix\"]")).click();
		            Thread.sleep(3000);  // Observe color matrix
		            driver.navigate().back();

		            // 9. Compass
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Compass\"]")).click();
		            Thread.sleep(3000);  // Observe compass
		            driver.navigate().back();

		            // 10. CreateBitmap
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"CreateBitmap\"]")).click();
		            Thread.sleep(3000);  // Observe bitmap creation
		            driver.navigate().back();

		            // 11. Density
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Density\"]")).click();
		            Thread.sleep(3000);  // Observe density changes
		            driver.navigate().back();

		            // 12. Drawable
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Drawable\"]")).click();
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"GradientDrawable\"]")).click();
		            Thread.sleep(3000);  // Observe GradientDrawable changes
		            driver.navigate().back();
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"ShapeDrawable\"]")).click();
		            Thread.sleep(3000);  // Observe ShapeDrawable changes
		            driver.navigate().back();
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

		            // 13. FingerPaint
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"FingerPaint\"]")).click();
		         // Perform touch actions to simulate drawing with finger strokes
//		            TouchAction touchAction = new TouchAction(driver);
//
//		            // Example 1: Draw a circle-like pattern with multiple swipes
//		            System.out.println("Drawing a circle-like pattern.");
//		            touchAction.press(PointOption.point(500, 900))  // Start at bottom
//		                       .waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
//		                       .moveTo(PointOption.point(600, 800))  // Move to top right
//		                       .waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
//		                       .moveTo(PointOption.point(500, 700))  // Move to top
//		                       .waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
//		                       .moveTo(PointOption.point(400, 800))  // Move to top left
//		                       .waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)))
//		                       .moveTo(PointOption.point(500, 900))  // Complete the loop
//		                       .release()
//		                       .perform();

		            Thread.sleep(3000);  // Test finger paint feature
		            driver.navigate().back();

		            // 14. Layers
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Layers\"]")).click();
		            Thread.sleep(3000);  // Observe layers
		            driver.navigate().back();

		            // 15. MeasureText
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"MeasureText\"]")).click();
		            Thread.sleep(3000);  // Observe text measurements
		            driver.navigate().back();

		            // 16. OpenGL ES
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"OpenGL ES\"]")).click();
		            Thread.sleep(3000);  // Observe OpenGL
		            
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Compressed Texture\"]")).click();
		            Thread.sleep(3000);  // Observe Compressed Texture
		            driver.navigate().back();
		            
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Cube Map\"]")).click();
		            Thread.sleep(3000);  // Observe Cube Map
		            driver.navigate().back();
		            
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Frame Buffer Object\"]")).click();
		            Thread.sleep(3000);  // Observe Frame Buffer Object
		            driver.navigate().back();
		            
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"GLSurfaceView\"]")).click();
		            Thread.sleep(3000);  // Observe GLSurface View
		            driver.navigate().back();
		            
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Kube\"]")).click();
		            Thread.sleep(3000);  // Observe Kube
		            driver.navigate().back();
		            
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Matrix Palette Skinning\"]")).click();
		            Thread.sleep(3000);  // Observe Matrix Palette Skinning
		            driver.navigate().back();
		            
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"OpenGL ES 2.0\"]")).click();
		            Thread.sleep(3000);  // Observe OpenGL ES 2.0
		            driver.navigate().back();
		            
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Sprite Text\"]")).click();
		            Thread.sleep(3000);  // Observe Sprite Text
		            driver.navigate().back();
		            
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Touch Rotate\"]")).click();
//		            // Perform touch actions to rotate the object
//		            TouchAction touchAction2 = new TouchAction(driver);
//
//		            // Example 1: Swipe Right
//		            System.out.println("Performing swipe right to rotate.");
//		            touchAction2.press(PointOption.point(200, 800))  // Start at left side
//		                       .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
//		                       .moveTo(PointOption.point(800, 800))  // Move to right side
//		                       .release()
//		                       .perform();
//		            Thread.sleep(3000);  // Observe vertices display
//
//		            // Example 2: Swipe Left
//		            System.out.println("Performing swipe left to rotate.");
//		            touchAction2.press(PointOption.point(800, 800))  // Start at right side
//		                       .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
//		                       .moveTo(PointOption.point(200, 800))  // Move to left side
//		                       .release()
//		                       .perform();
//		            Thread.sleep(3000);  // Observe vertices display
//
//		            // Example 3: Swipe Down (simulate a different rotation)
//		            System.out.println("Performing swipe down to rotate.");
//		            touchAction2.press(PointOption.point(500, 400))  // Start at top center
//		                       .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
//		                       .moveTo(PointOption.point(500, 1200))  // Move to bottom center
//		                       .release()
//		                       .perform();

		            Thread.sleep(3000);  // Observe Touch Rotate
		            driver.navigate().back();
		            
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Sprite Text\"]")).click();
		            Thread.sleep(3000);  // Observe Sprite Text
		            driver.navigate().back();
		            driver.navigate().back();

		            // 17. PathEffects
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"PathEffects\"]")).click();
		            Thread.sleep(3000);  // Observe Translucent GLSurface View
		            driver.navigate().back();

		            // 18. PathFillTypes
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"PathFillTypes\"]")).click();
		            Thread.sleep(3000);  // Observe path fill types
		            driver.navigate().back();

		            // 19. Patterns
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Patterns\"]")).click();
		            Thread.sleep(3000);  // Observe patterns
		            driver.navigate().back();

		            // 20. Pictures
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Pictures\"]")).click();
		            Thread.sleep(3000);  // Observe pictures
		            driver.navigate().back();

		            // 21. Points
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Points\"]")).click();
		            Thread.sleep(3000);  // Observe points display
		            driver.navigate().back();

		            // 22. PolyToPoly
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"PolyToPoly\"]")).click();
		            Thread.sleep(3000);  // Observe PolyToPoly effect
		            driver.navigate().back();

		            // 23. Regions
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Regions\"]")).click();
		            Thread.sleep(3000);  // Observe regions
		            driver.navigate().back();
		            
		           //Scroll 
		          //Get Screen size
		    		Dimension size1 = driver.manage().window().getSize();
		    		
		    		//find the position where you need to touch
		    		int startX1 = size1.getWidth() / 2;
		    		int startY1 = size1.getHeight() / 2;
		    		
		    		//position till you want to move your finger to swipe
		    		int endX1 = startX1;
		    		int endY1 = (int) (size1.getHeight() * 0.25);
		    		
		    		//PointerInput class to create a sequence of actions 
		    		PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
		    		
		    		//Sequence object, which is a list of actions that will be performed on the device
		    		Sequence sequence1 = new Sequence(finger2, 1)
		    				.addAction(finger2.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX1, startY1))
		    				.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
		    				.addAction(new Pause(finger2, Duration.ofMillis(200))) //wait for some time
		    				.addAction(finger2.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX1, endY1))
		    				.addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg())); 

		    		//perform the Sequence of action
		    		driver.perform(Collections.singletonList(sequence1));
		    		
		    		Thread.sleep(2000);

		            // 24. RoundRects
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"RoundRects\"]")).click();
		            Thread.sleep(3000);  // Observe round rectangles
		            driver.navigate().back();

		            // 25. ScaleToFit
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"ScaleToFit\"]")).click();
		            Thread.sleep(3000);  // Observe scaling
		            driver.navigate().back();

		            // 26. SensorTest
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"SensorTest\"]")).click();
		            Thread.sleep(3000);  // Observe sensor test
		            driver.navigate().back();

		            // 27. Shadow Card Drag
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Shadow Card Drag\"]")).click();
		            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/shape_select")).click();
		            Thread.sleep(3000);  // Observe shadow card drag
		            driver.navigate().back();

		            // 28. Shadow Card Stack
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Shadow Card Stack\"]")).click();
		            Thread.sleep(5000);  // Observe shadow card stack
		            driver.navigate().back();

		            // 29. Surface Window
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Surface Window\"]")).click();
		            Thread.sleep(5000);  // Observe surface window
		            driver.navigate().back();

		            // 30. SurfaceView Overlay
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"SurfaceView Overlay\"]")).click();
		            Thread.sleep(3000);  // Observe surface view overlay
		            driver.navigate().back();

		            // 31. Sweep
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Sweep\"]")).click();
		            Thread.sleep(3000);  // Observe sweep effect
		            driver.navigate().back();

		            // 32. Text Align
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Text Align\"]")).click();
		            Thread.sleep(3000);  // Observe text alignment
		            driver.navigate().back();

		            // 33. Typefaces
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Typefaces\"]")).click();
		            Thread.sleep(3000);  // Observe Type faces
		            driver.navigate().back();

		            // 34. UnicodeChart
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"UnicodeChart\"]")).click();
		            Thread.sleep(3000);  // Observe Unicode chart
		            driver.navigate().back();

		            // 35. Vertices
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Vertices\"]")).click();
//		         // Perform touch actions to interact with vertices
//
//		            TouchAction touchAction1 = new TouchAction(driver);
//
//		            // Example 1: Tap on a point
//		            System.out.println("Performing a tap action to interact with vertices.");
//		            touchAction1.tap(PointOption.point(500, 800)).perform();
//
//		            // Example 2: Swipe horizontally across the screen
//		            System.out.println("Performing a swipe to interact with vertices.");
//		            touchAction1.press(PointOption.point(200, 800))  // Start at left side
//		                       .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
//		                       .moveTo(PointOption.point(800, 800))  // Move to right side
//		                       .release()
//		                       .perform();
//		            Thread.sleep(3000);  // Observe vertices display
//
//		            // Example 3: Multi-point interaction (if vertices respond to multiple touchpoints)
//		            System.out.println("Performing multiple taps in different locations.");
//		            touchAction1.tap(PointOption.point(300, 700)).perform();
//		            touchAction1.tap(PointOption.point(700, 900)).perform();
//		            touchAction1.tap(PointOption.point(500, 1000)).perform();

		            Thread.sleep(3000);  // Observe vertices display
		            driver.navigate().back();

		            // 36. Xfermodes
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Xfermodes\"]")).click();
		            Thread.sleep(3000);  // Observe xfermodes
		            driver.navigate().back();
		            
		            Thread.sleep(3000);
		    		System.out.println("Session closed");
		    		driver.quit();
		            
		            

	}

}
