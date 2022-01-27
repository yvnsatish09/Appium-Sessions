package AppiumSessions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AndroidUiAutomator {
	
	public static AppiumDriver driver;
	public static final String server ="cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723 \"";
	public static final String serverURL= "http://0.0.0.0:4723/wd/hub";

	public static void main(String[] args) throws Throwable {
		
		DesiredCapabilities caps =new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi8");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
		caps.setCapability(MobileCapabilityType.UDID, "17fe29ac9807");
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Uiautomator2");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 10);
		caps.setCapability("appPackage", "io.appium.android.apis");
		caps.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		
		try {
			Runtime.getRuntime().exec(server);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		URL url =new URL(serverURL);
		

		 driver =new AndroidDriver(url,caps);
		
		 // findElementByAndroidUIAutomator("attribute("value")");
		// By using the "text", getting the Views
		MobileElement element = (MobileElement)((FindsByAndroidUIAutomator) driver)
				.findElementByAndroidUIAutomator("new UiSelector().text(\"Views\")");
		
		System.out.println("Text is " + element.getText());
		
		
		//By using the "ClassName"
		
		MobileElement ele=(MobileElement) ((FindsByAndroidUIAutomator) driver) 
				           .findElementsByAndroidUIAutomator("new UiSelector().className(\"android.widget.TextView\")").get(2);
		System.out.println(ele.getText());
		
		
		
		//Using the "description" [content-desc ="Content"]
		
		MobileElement text =(MobileElement) ((FindsByAndroidUIAutomator) driver)
		                       .findElementByAndroidUIAutomator("new UiSelector().description(\"Content\")");
		System.out.println(text.getText());
		
		// Using the resourceID
		
		MobileElement resourceTxt = (MobileElement) ((FindsByAndroidUIAutomator) driver)
		.findElementsByAndroidUIAutomator("new UiSelector().resourceId(\"android:id/text1\")").get(5);
		System.out.println("Resource is "+ resourceTxt.getText() );
		
		
		// findElementsByAndroidUIAutomator("new UiSelector().property("value")")
		// clickable is the property
		System.out.println(((FindsByAndroidUIAutomator) driver).findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size());
	}

}
