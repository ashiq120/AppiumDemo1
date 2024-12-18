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

public class Animation {

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
        
        capabilities.setCapability("automationName","uiautomator2");
        capabilities.setCapability("platformversion", "11");
        
        
        capabilities.setCapability("browserstack.user", System.getenv("mdashiqurrahman_eWYO1a"));
        capabilities.setCapability("browserstack.key", System.getenv("hoTGzDuen2Wf7dq7ovQk"));
          

        URL url = URI.create("http://127.0.0.1:4723/").toURL();
        
        driver = new AndroidDriver(url, capabilities);
        //Thread.sleep(2000);
        System.out.println("Application Started");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    
    @Test
    public void testActivityTransitionSection() throws InterruptedException, IOException {
        test = extent.createTest("Activity Transition Section Test");
        test.info("Navigating to Animation section");
        try {
        // Navigate to the Animation section
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Animation\"]")).click();
        test.pass("Navigated to Animation section");
        
        // 1. "Activity Transition"
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Activity Transition\"]")).click();
        driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/ball")).click();
        Thread.sleep(3000);  // Wait to observe the animation
//        test.pass("Activity Transition tested successfully.");
        test.log(Status.PASS, "Activity Transition tested successfully");
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();

        test.pass("Activity Transition test completed");
        } catch (Exception e) {
//            test.fail("Activity Transition test failed: " + e.getMessage());
            test.log(Status.FAIL, "Activity Transition test failed: " + e.getMessage());
        }
        
        
    }
        
        
        @Test
        public void testBouncingBallsSection() throws InterruptedException, IOException {
            test = extent.createTest("Bouncing Balls Section Test");
            test.info("Navigating to Animation section");
            
            try {
            // Navigate to the Animation section
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Animation\"]")).click();
            test.pass("Navigated to Animation section");
            
         // 2. "Bouncing Balls"
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Bouncing Balls\"]")).click();
            driver.findElement(AppiumBy.xpath("//android.view.View")).click();
            Thread.sleep(3000);  // Wait to observe the animation
//            test.pass("Bouncing Balls tested successfully.");
            test.log(Status.PASS, "Bouncing Balls tested successfully");
            driver.navigate().back();
            driver.navigate().back();

            test.pass("Bouncing Balls test completed");
            } catch (Exception e) {
//                test.fail("Bouncing Balls test failed: " + e.getMessage());
                test.log(Status.FAIL, "Bouncing Balls test failed: " + e.getMessage());
            }
        }
            
            
            @Test
            public void testCloningSection() throws InterruptedException, IOException {
                test = extent.createTest("Cloning Section Test");
                test.info("Navigating to Animation section");
                
                try {
                // Navigate to the Animation section
                driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Animation\"]")).click();
                test.pass("Navigated to Animation section");
                
                // 3. Tap on "Cloning"
	            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Cloning\"]")).click();
	            Thread.sleep(2000);

	            // Start the cloning animation by tapping the "Run" button
	            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/startButton")).click();
	            Thread.sleep(3000);  // Wait for cloning animation
//                test.pass("Cloning tested successfully.");
                test.log(Status.PASS, "Cloning tested successfully");
                driver.navigate().back();
                driver.navigate().back();

                test.pass("Cloning test completed");
                
                test.pass("Bouncing Balls test completed");
                } catch (Exception e) {
//                    test.fail("Cloning test failed: " + e.getMessage());
                    test.log(Status.FAIL, "Cloning test failed: " + e.getMessage());
                }
            }
                
                
                @Test
                public void testCustomEvaluatorSection() throws InterruptedException, IOException {
                    test = extent.createTest("Custom Evaluator Section Test");
                    test.info("Navigating to Animation section");
                    
                    try {

                    // Navigate to the Animation section
                    driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Animation\"]")).click();
                    test.pass("Navigated to Animation section");
                    
                    // 4. Custom Evaluator
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Custom Evaluator\"]")).click();
		            
		            // Start the cloning animation by tapping the "Play" button
		            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/startButton")).click();
		            Thread.sleep(3000);  // Wait to observe animation
                    test.pass("Custom Evaluator tested successfully.");
                    driver.navigate().back();
                    driver.navigate().back();

                    test.pass("Custom Evaluator test completed");
                    
                    } catch (Exception e) {
                        test.fail("Custom Evaluator test failed: " + e.getMessage());
                    }
                    
                }
                
                    
                    @Test
                    public void testDefaultLayoutAnimationsSection() throws InterruptedException, IOException {
                        test = extent.createTest("Default Layout Animations Section Test");
                        test.info("Navigating to Animation section");
                        
                        try {

                        // Navigate to the Animation section
                        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Animation\"]")).click();
                        test.pass("Navigated to Animation section");
                        
                        // 5. Default Layout Animations
    		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Default Layout Animations\"]")).click();
    		            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/addNewButton")).click();  // Add an item
    		            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/addNewButton")).click();  // Add another item
    		            Thread.sleep(3000);
                        test.pass("Default Layout Animations tested successfully.");
                        driver.navigate().back();
                        driver.navigate().back();

                        test.pass("Default Layout Animations test completed");
                        
                        } catch (Exception e) {
                            test.fail("Default Layout Animations test failed: " + e.getMessage());
                        }
                    }
                        
                        @Test
                        public void testEventsSection() throws InterruptedException, IOException {
                            test = extent.createTest("Events Section Test");
                            test.info("Navigating to Animation section");
                            
                            try {

                            // Navigate to the Animation section
                            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Animation\"]")).click();
                            test.pass("Navigated to Animation section");
                            
                            // 6. Events
        		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Events\"]")).click();
        		            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/startButton")).click();  // Start event animation
        		            Thread.sleep(3000);  // Observe the animation
                            test.pass("Events tested successfully.");
                            driver.navigate().back();
                            driver.navigate().back();

                            test.pass("Events test completed");
                            
                            } catch (Exception e) {
                                test.fail("Events test failed: " + e.getMessage());
                            }
                        }
                            
                            
                           @Test
                            public void testHideShowAnimationsSection() throws InterruptedException, IOException {
                                test = extent.createTest("Hide-Show Animations Section Test");
                                test.info("Navigating to Animation section");
                                
                                try {

                                // Navigate to the Animation section
                                driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Animation\"]")).click();
                                test.pass("Navigated to Animation section");
                                
                                // 7. Hide-Show Animations
            		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Hide-Show Animations\"]")).click();
            		            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/hideGoneCB")).click();  // Toggle visibility
            		            driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"0\"]")).click();
            		            Thread.sleep(2000);
            		            driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"3\"]")).click();
            		            Thread.sleep(3000);
                                test.pass("Hide-Show Animations tested successfully.");
                                driver.navigate().back();
                                driver.navigate().back();

                                test.pass("Hide-Show Animations test completed");
                                
                                } catch (Exception e) {
                                    test.fail("Hide-Show Animations test failed: " + e.getMessage());
                                }
                            }
                            
                                
                                @Test
                                public void testLayoutAnimationsSection() throws InterruptedException, IOException {
                                    test = extent.createTest("Layout Animations Section Test");
                                    test.info("Navigating to Animation section");
                                    
                                    try {

                                    // Navigate to the Animation section
                                    driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Animation\"]")).click();
                                    test.pass("Navigated to Animation section");
                                    
                                    // 8. Layout Animations
                		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Layout Animations\"]")).click();
                		            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/addNewButton")).click();  // Add an item
                		            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/addNewButton")).click();  // Add another item
                		            Thread.sleep(3000);
                                    test.pass("Layout Animations tested successfully.");
                                    driver.navigate().back();
                                    driver.navigate().back();

                                    test.pass("Layout Animations test completed");
                                    
                                    } catch (Exception e) {
                                        test.fail("Layout Animations test failed: " + e.getMessage());
                                    }
                                }
                                    
                                    
                                    @Test
                                    public void testLoadingSection() throws InterruptedException, IOException {
                                        test = extent.createTest("Loading Section Test");
                                        test.info("Navigating to Animation section");
                                        
                                        try {

                                        // Navigate to the Animation section
                                        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Animation\"]")).click();
                                        test.pass("Navigated to Animation section");
                                        
                                     // 9. Loading
                    		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Loading\"]")).click();
                    		            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/startButton")).click();  // Start loading animation
                    		            Thread.sleep(3000);  // Observe the animation
                                        test.pass("Loading tested successfully.");
                                        driver.navigate().back();
                                        driver.navigate().back();

                                        test.pass("Loading test completed");
                                        
                                        } catch (Exception e) {
                                            test.fail("Loading test failed: " + e.getMessage());
                                        }
                                        
                                    }


                                        @Test
                                        public void testMultiplePropertiesSection() throws InterruptedException, IOException {
                                            test = extent.createTest("Multiple Properties Section Test");
                                            test.info("Navigating to Animation section");
                                            
                                            try {

                                            // Navigate to the Animation section
                                            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Animation\"]")).click();
                                            test.pass("Navigated to Animation section");
                                            
                                         // 10. Multiple Properties
                        		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Multiple Properties\"]")).click();
                        		            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/startButton")).click();  // Start multiple property animation
                        		            Thread.sleep(3000);  // Observe animation
                                            test.pass("Multiple Properties successfully.");
                                            driver.navigate().back();
                                            driver.navigate().back();

                                            test.pass("Multiple Properties test completed");
                                            
                                            } catch (Exception e) {
                                                test.fail("Multiple Properties test failed: " + e.getMessage());
                                            }
                                            
                                        }
                                            
                                            
                                            
                                            @Test
                                            public void testPathAnimationsSection() throws InterruptedException, IOException {
                                                test = extent.createTest("Path Animations Section Test");
                                                test.info("Navigating to Animation section");
                                                
                                                try {

                                                // Navigate to the Animation section
                                                driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Animation\"]")).click();
                                                test.pass("Navigated to Animation section");
                                                
                                             // 11. Path Animations
                            		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Path Animations\"]")).click();
                            		            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/named_components")).click();  // Start path animation
                            		            Thread.sleep(3000);  // Wait to observe path animation
                                                test.pass("Path Animations tested successfully.");
                                                driver.navigate().back();
                                                driver.navigate().back();

                                                test.pass("Path Animations test completed");
                                                
                                                } catch (Exception e) {
                                                    test.fail("Path Animations test failed: " + e.getMessage());
                                                }
                                                
                                            }
                                                
                                                
                                                @Test
                                                public void testReversingSection() throws InterruptedException, IOException {
                                                    test = extent.createTest("Reversing Section Test");
                                                    test.info("Navigating to Animation section");
                                                    
                                                    try {

                                                    // Navigate to the Animation section
                                                    driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Animation\"]")).click();
                                                    test.pass("Navigated to Animation section");
                                                    
                                                 // 12. Reversing
                                		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Reversing\"]")).click();
                                		            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/startButton")).click();    // Start animation
                                		            Thread.sleep(2000);
                                		            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/reverseButton")).click();  // Start reversing animation
                                		            Thread.sleep(2000);  // Observe animation
                                                    test.pass("Reversing tested successfully.");
                                                    driver.navigate().back();
                                                    driver.navigate().back();

                                                    test.pass("Reversing test completed");
                                                    
                                                    
                                                    } catch (Exception e) {
                                                        test.fail("Reversing test failed: " + e.getMessage());
                                                    }
                                                }
                                                    
                                                    
                                                    @Test
                                                    public void testSeekingSection() throws InterruptedException, IOException {
                                                        test = extent.createTest("Seeking Section Test");
                                                        test.info("Navigating to Animation section");
                                                        
                                                        try {

                                                        // Navigate to the Animation section
                                                        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Animation\"]")).click();
                                                        test.pass("Navigated to Animation section");
                                                        
                                                     // 13. Seeking
                                    		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Seeking\"]")).click();
                                    		            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/startButton")).click();  // Start seeking animation
                                    		            Thread.sleep(2000);  // Observe animation
                                                        test.pass("Seeking tested successfully.");
                                                        driver.navigate().back();
                                                        driver.navigate().back();

                                                        test.pass("Seeking test completed");
                                                        
                                                        } catch (Exception e) {
                                                            test.fail("Seeking test failed: " + e.getMessage());
                                                        }
                                                        
                                                    }
                                                        
                                                        @Test
                                                        public void testSimpleTransitionsSection() throws InterruptedException, IOException {
                                                            test = extent.createTest("Simple Transitions Section Test");
                                                            test.info("Navigating to Animation section");
                                                            
                                                            try {

                                                            // Navigate to the Animation section
                                                            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Animation\"]")).click();
                                                            test.pass("Navigated to Animation section");
                                                            
                                                         // 14. Simple Transitions
                                        		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Simple Transitions\"]")).click();
                                        		            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/scene1")).click();  // Switch to Scene 1
                                        		            Thread.sleep(2000);
                                        		            driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/scene2")).click();  // Switch to Scene 2
                                        		            Thread.sleep(2000);
                                                            test.pass("Simple Transitions tested successfully.");
                                                            driver.navigate().back();
                                                            driver.navigate().back();

                                                            test.pass("Simple Transitions test completed");
                                                            
                                                            } catch (Exception e) {
                                                                test.fail("Simple Transitions test failed: " + e.getMessage());
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

    
   
  



		           
		            
		        

		           

		           

		           

		           

		            

		         

		           

