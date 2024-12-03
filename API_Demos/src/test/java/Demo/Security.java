package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Security {

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

		            // Navigate to the Security section
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Security\"]")).click();

		            // Select KeyStore
		            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/text1\"]")).click();
		            
		            // Wait to observe the KeyStore screen
		            Thread.sleep(2000);

		            // Enter text in Plaintext field
		            WebElement plaintextField = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.touchboarder.android.api.demos:id/plaintext\"]"));
		            plaintextField.sendKeys("Ashiq");
		            System.out.println("Entered text in Plaintext field.");
		            Thread.sleep(3000);

		            // Enter alias in Entry alias field
		            WebElement aliasField = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.touchboarder.android.api.demos:id/entry_name\"]"));
		            aliasField.sendKeys("Ashiq");
		            System.out.println("Entered alias in Entry alias field.");
		            Thread.sleep(3000);

		            // Generate a Key
		            WebElement generateButton = driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/generate_button"));
		            generateButton.click();
		            System.out.println("Clicked on Generate button.");
		            Thread.sleep(3000);  // Wait for key generation to complete
		            
		            driver.findElement(AppiumBy.xpath("//android.widget.CheckedTextView[@resource-id=\"android:id/text1\"]")).click();
		            Thread.sleep(3000);

		            // Sign the Plaintext
		            WebElement signButton = driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/sign_button"));
		            signButton.click();
		            System.out.println("Clicked on Sign button.");
		            Thread.sleep(3000);  // Wait to observe the sign operation

		            // Verify the Signature
		            WebElement verifyButton = driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/verify_button"));
		            verifyButton.click();
		            System.out.println("Clicked on Verify button.");
		            Thread.sleep(3000);  // Wait to observe the verify operation

		            // Delete the Key
		            WebElement deleteButton = driver.findElement(AppiumBy.id("com.touchboarder.android.api.demos:id/delete_button"));
		            deleteButton.click();
		            System.out.println("Clicked on Delete button.");
		            Thread.sleep(3000);  // Wait to confirm key deletion
		            
		            driver.navigate().back();
		            
		            Thread.sleep(3000);
		    		System.out.println("Session closed");
		    		driver.quit();


	}

}
