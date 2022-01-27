package AppiumSessions;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class ElementActions {

	public static AppiumDriver driver;
	public static final String server = "cmd.exe /c start cmd.exe /k \" appium -a 0.0.0.0 -p 4723\"";
	public static final String serverURL = "http://0.0.0.0:4723/wd/hub";
	public static String wifiBox = "Appium";

	public static void main(String[] args) throws Throwable {

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi8");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
		caps.setCapability(MobileCapabilityType.UDID, "17fe29ac9807");
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Uiautomator2");
		caps.setCapability("appPackage", "io.appium.android.apis");
		caps.setCapability("appActivity", "io.appium.android.apis.ApiDemos");

		// Start appium server through Programatically
		Runtime.getRuntime().exec(server);
		URL url = new URL(serverURL);
		
		// creating the driver session
		AppiumDriver driver = new AndroidDriver(url, caps);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Click on "Preference" icon
		MobileElement viewsIcon = (MobileElement) ((FindsByAndroidUIAutomator) driver)
				                  .findElementByAndroidUIAutomator("new UiSelector().text(\"Preference\")");
		viewsIcon.click();
		
	    
		//Click on "Preference dependencies" icon
		driver.findElementByXPath("//android.widget.TextView[@content-desc='3. Preference dependencies']").click();
         
		Thread.sleep(1000);
		
		//"wifiSettings" is not displayed
		boolean text =driver.findElementByXPath("//android.widget.TextView[@text='WiFi settings']").isDisplayed();
		System.out.println(text);
		
		//Click on "WIFI" checkBox icon
		By checkBox= MobileBy.id("android:id/checkbox");
		driver.findElement(checkBox).click();
		
		Thread.sleep(2000);
		//For suppose text, resource-id, content-desc are not there,
		// go for the class attribute as tagName, example index is 2
		// ex: driver.findElement(By.xpath("(android.widget.LinearLayout)[2]"))
		
		
		// Click on "Wifi Settings" button
		 driver.findElementByXPath("//android.widget.TextView[@text ='WiFi settings']").click();
		 
		 /* 2nd Way:
		  * =========
		 List<MobileElement> icons =driver.findElementsByClassName("android.widget.TextView");
		 for(MobileElement ele:icons) {
			 if(ele.getText().equals("WiFi settings")) {
				 ele.click();
				 break;
			 }
		 }
		
	  */
		 //under Wifi Settings,Enter the "Appium" text in Editbox
		 driver.findElementById("android:id/edit").sendKeys(wifiBox);
		
		 //Matched with multiple elements, store under List<MobileElement>
		 List<MobileElement> okButton = driver.findElementsByClassName("android.widget.Button");
		 okButton.get(1).click();
		 
		 //Click on checkBox button
		 driver.findElement(checkBox).click();
		 
		// Stop appium server through Programatically
		Runtime.getRuntime().exec("taskKill /F/ IM node.exe");
		Runtime.getRuntime().exec("taskKill /F/ IM node.exe");

	}

}
