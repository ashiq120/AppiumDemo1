package Demo;

import java.io.File;

import java.io.IOException;


import java.awt.Desktop;
//import java.io.File;
//import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class App {

    private AndroidDriver driver;
    private ExtentReports extent;
    private ExtentTest test;

    @BeforeClass
    public void setup() throws MalformedURLException, InterruptedException {
        // Setup ExtentReports
        extent = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("AppiumTestReport1.html");
        ExtentSparkReporter failedspark = new ExtentSparkReporter("AppiumFailedTestReport1.html").filter().statusFilter().as(new Status [] {Status.FAIL}).apply();
        failedspark.config().setDocumentTitle("Appium Failed Test Report");
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("Appium Test Report");
        spark.config().setReportName("API Demos Test Results");
        extent.attachReporter(spark, failedspark);

        // Log setup in the report
//        test = extent.createTest("Appium Test Setup");
//        test.info("Setting up Desired Capabilities");

        // Setup Desired Capabilities for Appium
        DesiredCapabilities capabilities = new DesiredCapabilities();
		
	    capabilities.setCapability("deviceName","Xiaomi 2201117TG");
        capabilities.setCapability("platformname", "Android");     
        capabilities.setCapability("automationName","uiautomator2");
        capabilities.setCapability("platformversion", "11");
        
        capabilities.setCapability("appPackage","com.touchboarder.android.api.demos");
        capabilities.setCapability("appActivity", "com.example.android.apis.ApiDemos");
          

        URL url = URI.create("http://127.0.0.1:4723/").toURL();
        
        driver = new AndroidDriver(url, capabilities);
        //Thread.sleep(2000);
        System.out.println("Application Started");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    
    
    @Test
    public void testActionBarSection() throws InterruptedException, IOException {
        test = extent.createTest("Action Bar Section Test");
        test.info("Navigating to App section");
        try {
        // Navigate to the App section
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"App\"]")).click();
        Thread.sleep(2000);
        test.pass("Navigated to App section");
        
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
//        test.pass("Activity Transition tested successfully.");
        test.log(Status.PASS, "Action Bar tested successfully");
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();

        test.pass("Action Bar test completed");
        } catch (Exception e) {
//            test.fail("Activity Transition test failed: " + e.getMessage());
            test.log(Status.FAIL, "Action Bar test failed: " + e.getMessage());
        }
        
        
    }
            
    @Test
    public void testActivitySection() throws InterruptedException, IOException {
        test = extent.createTest("Activity Section Test");
        test.info("Navigating to App section");
        try {
        // Navigate to the App section
        	driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"App\"]")).click();
        test.pass("Navigated to App section");
     // 2. Activity
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Activity\"]")).click();
//        driver.navigate().back();
        
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
//        driver.navigate().back();
        
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
        // Scroll to the "TextSwitcher" option
           driver.findElement(AppiumBy.androidUIAutomator(
                   "new UiScrollable(new UiSelector().scrollable(true))" +
                           ".scrollIntoView(new UiSelector().text(\"TextSwitcher\"));"
           ));
           test.pass("Successfully scrolled to 'TextSwitcher' option.");
    		
    		Thread.sleep(3000);

    		 //  Set WallPaper
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"SetWallpaper\"]")).click();
            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/randomize")).click();
            Thread.sleep(2000);
            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/setwallpaper")).click();
            Thread.sleep(2000);
            driver.navigate().back();
//        test.pass("Activity Transition tested successfully.");
        test.log(Status.PASS, "App tested successfully");
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();

        test.pass("App test completed");
        } catch (Exception e) {
//            test.fail("Activity Transition test failed: " + e.getMessage());
            test.log(Status.FAIL, "App test failed: " + e.getMessage());
        }
        
        
    }
    
    
    @Test
    public void testAlarmSection() throws InterruptedException, IOException {
        test = extent.createTest("Alarm Section Test");
        test.info("Navigating to App section");
        
        try {
        	 // Navigate to the App section
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"App\"]")).click();
        test.pass("Navigated to App section");
        
     // 3. Alarm
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Alarm\"]")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Alarm Controller\"]")).click();
        Thread.sleep(2000);
        driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/one_shot")).click();  // Set one-shot alarm
        Thread.sleep(2000);
        driver.navigate().back();
        driver.navigate().back();
//        test.pass("Alarm tested successfully.");
        test.log(Status.PASS, "Alarm tested successfully");
        driver.navigate().back();
        driver.navigate().back();

        test.pass("Alarm test completed");
        } catch (Exception e) {
//            test.fail("Alarm test failed: " + e.getMessage());
            test.log(Status.FAIL, "Alarm test failed: " + e.getMessage());
        }
    }
    
    
    @Test
    public void testAlertDialogsSection() throws InterruptedException, IOException {
        test = extent.createTest("Alert Dialog Section Test");
        test.info("Navigating to App section");
        
        try {
        	 // Navigate to the App section
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"App\"]")).click();
        test.pass("Navigated to App section");
        
        // 4. Alert Dialogs
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Alert Dialogs\"]")).click();
        driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/two_buttons")).click();
        driver.findElement(AppiumBy.id("android:id/button1")).click();  // Click OK button
        driver.navigate().back();
        driver.navigate().back();
//        test.pass("Alert Dialog tested successfully.");
        test.log(Status.PASS, "Alert Dialog tested successfully");
        driver.navigate().back();
        driver.navigate().back();

        test.pass("Alert Dialogtest completed");
        } catch (Exception e) {
//            test.fail("Alert Dialog test failed: " + e.getMessage());
            test.log(Status.FAIL, "Alert Dialog test failed: " + e.getMessage());
        }
    }
    
    
    @Test
    public void testDeviceAdminSection() throws InterruptedException, IOException {
        test = extent.createTest("Device Admin Section Test");
        test.info("Navigating to App section");
        
        try {
        	 // Navigate to the App section
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"App\"]")).click();
        test.pass("Navigated to App section");
        
        // 5. Device Admin
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Device Admin\"]")).click();
        Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("//android.widget.ListView[@resource-id=\"android:id/list\"]/android.widget.LinearLayout[1]/android.widget.RelativeLayout")).click();
        Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("(//android.widget.CheckBox[@resource-id=\"android:id/checkbox\"])[1]")).click();
        Thread.sleep(2000);
        
    //Scroll
        // Scroll to the "TextSwitcher" option
           driver.findElement(AppiumBy.androidUIAutomator(
                   "new UiScrollable(new UiSelector().scrollable(true))" +
                           ".scrollIntoView(new UiSelector().text(\"TextSwitcher\"));"
           ));
           test.pass("Successfully scrolled to 'TextSwitcher' option.");
    		
    		Thread.sleep(2000);
    		driver.findElement(AppiumBy.id("com.android.settings:id/cancel_button")).click(); 
        driver.navigate().back();
        driver.navigate().back();
//        test.pass("Device Admin tested successfully.");
        test.log(Status.PASS, "Device Admin tested successfully");
        driver.navigate().back();
        driver.navigate().back();

        test.pass("Device Admin test completed");
        } catch (Exception e) {
//            test.fail("Device Admin test failed: " + e.getMessage());
            test.log(Status.FAIL, "Device Admin test failed: " + e.getMessage());
        }
    }
    
    @Test
    public void testFragmentSection() throws InterruptedException, IOException {
        test = extent.createTest("Fragment Section Test");
        test.info("Navigating to App section");
        
        try {
        	 // Navigate to the App section
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"App\"]")).click();
        test.pass("Navigated to App section");
        
     // 6. Fragment
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Fragment\"]")).click();
        Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Hide and Show\"]")).click();
        Thread.sleep(2000);
        driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/frag1hide")).click();  // Hide fragment 1
        Thread.sleep(2000);
        driver.navigate().back();
        driver.navigate().back();
//        test.pass("Fragment tested successfully.");
        test.log(Status.PASS, "Fragmenttested successfully");
        driver.navigate().back();
        driver.navigate().back();

        test.pass("Fragment test completed");
        } catch (Exception e) {
//            test.fail("Fragment test failed: " + e.getMessage());
            test.log(Status.FAIL, "Fragment test failed: " + e.getMessage());
        }
    }
    
    
    @Test
    public void testLauncherShortcutsSection() throws InterruptedException, IOException {
        test = extent.createTest("Launcher Shortcuts Section Test");
        test.info("Navigating to App section");
        
        try {
        	 // Navigate to the App section
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"App\"]")).click();
        test.pass("Navigated to App section");
        
     // 7. Launcher Shortcuts
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Launcher Shortcuts\"]")).click();
        Thread.sleep(2000);
        driver.navigate().back();
//        test.pass("Launcher Shortcuts tested successfully.");
        test.log(Status.PASS, "Launcher Shortcuts tested successfully");
        driver.navigate().back();
        driver.navigate().back();

        test.pass("Launcher Shortcuts test completed");
        } catch (Exception e) {
//            test.fail("Launcher Shortcuts test failed: " + e.getMessage());
            test.log(Status.FAIL, "Launcher Shortcuts test failed: " + e.getMessage());
        }
    }
    
    @Test
    public void testLoaderSection() throws InterruptedException, IOException {
        test = extent.createTest("Loader Section Test");
        test.info("Navigating to App section");
        
        try {
        	 // Navigate to the App section
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"App\"]")).click();
        test.pass("Navigated to App section");
        
     // 8. Loader
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Loader\"]")).click();
        Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Cursor\"]")).click();
        Thread.sleep(2000);
        driver.findElement(AppiumBy.id("android:id/text1")).click();  
        driver.navigate().back();
        driver.navigate().back();
//        test.pass("Loader tested successfully.");
        test.log(Status.PASS, "Loader tested successfully");
        driver.navigate().back();
        driver.navigate().back();

        test.pass("Loader test completed");
        } catch (Exception e) {
//            test.fail("Loader test failed: " + e.getMessage());
            test.log(Status.FAIL, "Loader test failed: " + e.getMessage());
        }
    }
    
    
    @Test
    public void testMenuSection() throws InterruptedException, IOException {
        test = extent.createTest("Menu Section Test");
        test.info("Navigating to App section");
        
        try {
        	 // Navigate to the App section
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"App\"]")).click();
        test.pass("Navigated to App section");
        
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
//        test.pass("Menu tested successfully.");
        test.log(Status.PASS, "Menu tested successfully");
        driver.navigate().back();
        driver.navigate().back();

        test.pass("Menu test completed");
        } catch (Exception e) {
//            test.fail("Menu test failed: " + e.getMessage());
            test.log(Status.FAIL, "Menu test failed: " + e.getMessage());
        }
    }
    
    @Test
    public void testNotificationSection() throws InterruptedException, IOException {
        test = extent.createTest("Notification Section Test");
        test.info("Navigating to App section");
        
        try {
        	 // Navigate to the App section
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"App\"]")).click();
        test.pass("Navigated to App section");
        
        // 10. Notification
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Notification\"]")).click();
        Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Status Bar\"]")).click();
        Thread.sleep(2000);
        driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/happy")).click();  // Show notification
        Thread.sleep(2000);
        driver.navigate().back();
        driver.navigate().back();
//        test.pass("Notification tested successfully.");
        test.log(Status.PASS, "Notification tested successfully");
        driver.navigate().back();
        driver.navigate().back();

        test.pass("Notification test completed");
        } catch (Exception e) {
//            test.fail("Notification test failed: " + e.getMessage());
            test.log(Status.FAIL, "Notification test failed: " + e.getMessage());
        }
    }
    
    @Test
    public void testPrintSection() throws InterruptedException, IOException {
        test = extent.createTest("Print Section Test");
        test.info("Navigating to App section");
        
        try {
        	 // Navigate to the App section
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"App\"]")).click();
        test.pass("Navigated to App section");
        
        // 11. Print
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Print\"]")).click();
        Thread.sleep(2000);
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Print HTML from screen\"]")).click();
        Thread.sleep(2000);
        driver.navigate().back();
        driver.navigate().back();
//        test.pass("Print tested successfully.");
        test.log(Status.PASS, "Print tested successfully");
        driver.navigate().back();
        driver.navigate().back();

        test.pass("Print test completed");
        } catch (Exception e) {
//            test.fail("Print test failed: " + e.getMessage());
            test.log(Status.FAIL, "Print test failed: " + e.getMessage());
        }
    }
    
    
    @Test
    public void testSearchSection() throws InterruptedException, IOException {
        test = extent.createTest("Search Section Test");
        test.info("Navigating to App section");
        
        try {
        	 // Navigate to the App section
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"App\"]")).click();
        test.pass("Navigated to App section");
        
     // 12. Search
      driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Search\"]")).click();
      driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Invoke Search\"]")).click();
      driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/btn_start_search")).sendKeys("Appium");  // Type "Appium" in the search bar
      driver.navigate().back();
      driver.navigate().back();
        //test.pass("Search tested successfully.");
        test.log(Status.PASS, "Search tested successfully");
        driver.navigate().back();
        driver.navigate().back();

        test.pass("Search test completed");
        } catch (Exception e) {
//            test.fail("Search test failed: " + e.getMessage());
            test.log(Status.FAIL, "Search test failed: " + e.getMessage());
        }
    }
    
    @Test
    public void testServiceSection() throws InterruptedException, IOException {
        test = extent.createTest("Service Section Test");
        test.info("Navigating to App section");
        
        try {
        	 // Navigate to the App section
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"App\"]")).click();
        test.pass("Navigated to App section");
        

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
        // test.pass("Service tested successfully.");
        test.log(Status.PASS, "Service tested successfully");
        driver.navigate().back();
        driver.navigate().back();

        test.pass("Service test completed");
        } catch (Exception e) {
//            test.fail("Service test failed: " + e.getMessage());
            test.log(Status.FAIL, "Service test failed: " + e.getMessage());
        }
    }
    
    
    @Test
    public void testTextToSpeechSection() throws InterruptedException, IOException {
        test = extent.createTest("Text-To-Speech Section Test");
        test.info("Navigating to App section");
        
        try {
        	 // Navigate to the App section
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"App\"]")).click();
        test.pass("Navigated to App section");
        


        // 14. Text-To-Speech
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Text-To-Speech\"]")).click();
        Thread.sleep(2000);
        driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/again_button")).click();
        Thread.sleep(2000);
        driver.navigate().back();
        // test.pass("Text-To-Speech tested successfully.");
        test.log(Status.PASS, "Text-To-Speech tested successfully");
        driver.navigate().back();
        driver.navigate().back();

        test.pass("Text-To-Speech test completed");
        } catch (Exception e) {
//            test.fail("Text-To-Speech test failed: " + e.getMessage());
            test.log(Status.FAIL, "Text-To-Speech test failed: " + e.getMessage());
        }
    }
    
    
    
    @Test
    public void testVoiceRecognitionSection() throws InterruptedException, IOException {
        test = extent.createTest("Voice Recognition Section Test");
        test.info("Navigating to App section");
        
        try {
        	 // Navigate to the App section
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"App\"]")).click();
        test.pass("Navigated to App section");
        
    //Scroll
        // Scroll to the "TextSwitcher" option
           driver.findElement(AppiumBy.androidUIAutomator(
                   "new UiScrollable(new UiSelector().scrollable(true))" +
                           ".scrollIntoView(new UiSelector().text(\"TextSwitcher\"));"
           ));
           test.pass("Successfully scrolled to 'TextSwitcher' option.");
        



//         // 15. Voice Recognition
         driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Voice Recognition\"]")).click();
         driver.navigate().back();
        // test.pass("Voice Recognition tested successfully.");
        test.log(Status.PASS, "Voice Recognition tested successfully");
        driver.navigate().back();
        driver.navigate().back();

        test.pass("Voice Recognition test completed");
        } catch (Exception e) {
//            test.fail("Voice Recognition test failed: " + e.getMessage());
            test.log(Status.FAIL, "Voice Recognition test failed: " + e.getMessage());
        }
    
    
    Thread.sleep(2000);
    System.out.println("Session closed");
    driver.quit();


        // Flush ExtentReports
        extent.flush();
        Desktop.getDesktop().browse(new File("AppiumTestReport1.html").toURI());
        Desktop.getDesktop().browse(new File("AppiumFailedTestReport1.html").toURI());
    
    

	}

}
