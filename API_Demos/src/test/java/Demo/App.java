package Demo;

import java.net.MalformedURLException;

import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class App {

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
            
            // Navigate to the App section
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"App\"]")).click();
            Thread.sleep(2000);

            // 1. Action Bar
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Action Bar\"]")).click();
            Thread.sleep(2000);
            
         //  Action Bar Navigation
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Action Bar Navigation\"]")).click();
            Thread.sleep(2000);
            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/newactivity")).click();
            Thread.sleep(2000);
            driver.navigate().back();
            driver.navigate().back();
            
            //  Action Bar Tabs
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Action Bar Tabs\"]")).click();
            Thread.sleep(2000);
            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/btn_toggle_tabs")).click();
            Thread.sleep(2000);
            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/btn_add_tab")).click();
            Thread.sleep(2000);
            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/btn_add_tab")).click();
            Thread.sleep(2000);
            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/btn_remove_all_tabs")).click();
            Thread.sleep(2000);
            driver.navigate().back();
            
        //  Action Provider
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Action Provider\"]")).click();
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Settings Action Provider\"]")).click();
            Thread.sleep(2000);
            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/button")).click();
            Thread.sleep(2000);
            driver.findElement(AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.android.settings:id/scroll_headers\"]/android.widget.LinearLayout[5]")).click();
            Thread.sleep(2000);
            driver.findElement(AppiumBy.id("android:id/checkbox")).click();
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Share Action Provider\"]")).click();
            Thread.sleep(2000);
            driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Share with\"]")).click();
            Thread.sleep(2000);
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and @text=\"See all\"]")).click();
            Thread.sleep(2000);
            driver.findElement(AppiumBy.xpath("(//android.widget.LinearLayout[@resource-id=\"android:id/list_item\"])[1]")).click();
            Thread.sleep(2000);
            driver.navigate().back();
            driver.navigate().back();
            
            
            //  Display Options
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Display Options\"]")).click();
            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/toggle_navigation")).click();
            Thread.sleep(2000);
            driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"NAVIGATION_MODE_TABS\"]")).click();
            Thread.sleep(2000);
            driver.navigate().back();
            driver.navigate().back();

            // 2. Activity
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Activity\"]")).click();
//            driver.navigate().back();
            
        //  Animation
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Animation\"]")).click();
            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/fade_animation")).click();
            //Thread.sleep(2000);
            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/select_button")).click();
            driver.navigate().back();
            driver.navigate().back();
            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/zoom_animation")).click();
            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/text_entry_button")).click();
         // Enter text entry in name and password field
            WebElement nameField = driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/username_edit"));
            nameField.sendKeys("Ashiq");
            System.out.println("Entered text in name field.");
            Thread.sleep(2000);
            WebElement passField = driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/password_edit"));
            passField.sendKeys("1234");
            System.out.println("Entered text in password field.");
            driver.findElement(AppiumBy.id("android:id/button1")).click();
            Thread.sleep(2000);
            driver.navigate().back();
            driver.navigate().back();
            
        //  Dialog
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Dialog\"]")).click();
            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/add")).click();
            Thread.sleep(2000);
            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/add")).click();
            Thread.sleep(2000);
            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/remove")).click();
            Thread.sleep(2000);
            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/remove")).click();
            Thread.sleep(2000);
            driver.navigate().back();
            
        //  Finish Activity
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Finish Affinity\"]")).click();
            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/nest")).click();
            Thread.sleep(2000);
            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/finish")).click();
//            driver.navigate().back();
            
        //  Intent Activity Flags
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Intent Activity Flags\"]")).click();
            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/flag_activity_clear_task")).click();
            Thread.sleep(2000);
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"08. Photos\"]")).click();
            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/add")).click();
            Thread.sleep(2000);
            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/add")).click();
            Thread.sleep(2000);
            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/clear")).click();
            Thread.sleep(2000);
            driver.navigate().back();
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"10. Single choice list\"]")).click();
            Thread.sleep(2000);
            driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Documentary\"]")).click();
            Thread.sleep(2000);
            driver.navigate().back();
            
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"10. Single choice list\"]")).click();
            Thread.sleep(2000);
            driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Documentary\"]")).click();
            Thread.sleep(2000);
            driver.navigate().back();
            
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"11. Multiple choice list\"]")).click();
            Thread.sleep(2000);
            driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Action\"]")).click();
            Thread.sleep(2000);
            driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Children\"]")).click();
            Thread.sleep(2000);
            driver.navigate().back();
            driver.navigate().back();
            driver.navigate().back();
            
         // Navigate to the App section
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"App\"]")).click();
         // 2. Activity
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Activity\"]")).click();
            
            //  Intents
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Intents\"]")).click();
            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/get_image")).click();
            Thread.sleep(2000);
            driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"Preview the file received_491920997336238.jpeg\"]/android.widget.ImageView")).click();
            Thread.sleep(2000);
            driver.findElement(AppiumBy.xpath("(//android.widget.ImageView[@resource-id=\"android:id/icon\"])[1]")).click();
            Thread.sleep(2000);
            driver.navigate().back();
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

	    		 //  Set WallPaper
	            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"SetWallpaper\"]")).click();
	            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/randomize")).click();
	            Thread.sleep(2000);
	            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/setwallpaper")).click();
	            Thread.sleep(2000);
	            driver.navigate().back();
	            
	           

            // 3. Alarm
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Alarm\"]")).click();
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Alarm Controller\"]")).click();
            Thread.sleep(2000);
            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/one_shot")).click();  // Set one-shot alarm
            Thread.sleep(2000);
            driver.navigate().back();
            driver.navigate().back();

            // 4. Alert Dialogs
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Alert Dialogs\"]")).click();
            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/two_buttons")).click();
            driver.findElement(AppiumBy.id("android:id/button1")).click();  // Click OK button
            driver.navigate().back();

            // 5. Device Admin
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Device Admin\"]")).click();
            Thread.sleep(2000);
            driver.findElement(AppiumBy.xpath("//android.widget.ListView[@resource-id=\"android:id/list\"]/android.widget.LinearLayout[1]/android.widget.RelativeLayout")).click();
            Thread.sleep(2000);
            driver.findElement(AppiumBy.xpath("(//android.widget.CheckBox[@resource-id=\"android:id/checkbox\"])[1]")).click();
            Thread.sleep(2000);
          //Scroll 
	          //Get Screen size
	    		Dimension size1 = driver.manage().window().getSize();
	    		
	    		//find the position where you need to touch
	    		int startX1 = size1.getWidth() / 2;
	    		int startY1 = size1.getHeight() / 2;
	    		
	    		//position till you want to move your finger to swipe
	    		int endX1 = startX;
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
	    		driver.findElement(AppiumBy.id("com.android.settings:id/cancel_button")).click(); 
            driver.navigate().back();
            driver.navigate().back();
           

            // 6. Fragment
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Fragment\"]")).click();
            Thread.sleep(2000);
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Hide and Show\"]")).click();
            Thread.sleep(2000);
            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/frag1hide")).click();  // Hide fragment 1
            Thread.sleep(2000);
            driver.navigate().back();
            driver.navigate().back();

            // 7. Launcher Shortcuts
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Launcher Shortcuts\"]")).click();
            Thread.sleep(2000);
            driver.navigate().back();

            // 8. Loader
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Loader\"]")).click();
            Thread.sleep(2000);
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Cursor\"]")).click();
            Thread.sleep(2000);
            driver.findElement(AppiumBy.id("android:id/text1")).click();  
            driver.navigate().back();
            driver.navigate().back();

            // 9. Menu
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Menu\"]")).click();
            Thread.sleep(2000);
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\"]")).click();
            Thread.sleep(2000);
            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/spinner")).click();
            Thread.sleep(2000);
            driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Title and Icon\"]")).click();
            Thread.sleep(2000);
            driver.navigate().back();
            driver.navigate().back();

            // 10. Notification
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Notification\"]")).click();
            Thread.sleep(2000);
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Status Bar\"]")).click();
            Thread.sleep(2000);
            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/happy")).click();  // Show notification
            Thread.sleep(2000);
            driver.navigate().back();
            driver.navigate().back();

            // 11. Print
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Print\"]")).click();
            Thread.sleep(2000);
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Print HTML from screen\"]")).click();
            Thread.sleep(2000);
            driver.navigate().back();
            driver.navigate().back();

//            // 12. Search
//            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Search\"]")).click();
//            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Invoke Search\"]")).click();
//            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/btn_start_search")).sendKeys("Appium");  // Type "Appium" in the search bar
//            driver.navigate().back();
//            driver.navigate().back();

            // 13. Service
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Service\"]")).click();
            Thread.sleep(2000);
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Foreground Service Controller\"]")).click();
            Thread.sleep(2000);
            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/start_foreground")).click();
            Thread.sleep(2000);
            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/stop")).click();
            Thread.sleep(2000);
            driver.navigate().back();
            driver.navigate().back();

            // 14. Text-To-Speech
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Text-To-Speech\"]")).click();
            Thread.sleep(2000);
            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/again_button")).click();
            Thread.sleep(2000);
            driver.navigate().back();

//            // 15. Voice Recognition
//            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Voice Recognition\"]")).click();
//            driver.navigate().back();
            
            Thread.sleep(2000);
    		System.out.println("Session closed");
    		driver.quit();

	}

}
