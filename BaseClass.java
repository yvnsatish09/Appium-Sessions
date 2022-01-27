package AppiumSessions;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {
	
	public static AppiumDriver driver;
	public static final String server ="cmd.exe /c start cmd.exe /k\"appium -a 0.0.0.0 -p 4723\"";
	public static final String serverURL = "http://0.0.0.0:4723/wd/hub";
	public static final int timeout =10;

	
	public static AppiumDriver capabilities() throws Throwable {
		
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
		 driver = new AndroidDriver(url, caps);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return  driver;
		
	}
	
	public static void waitForElement() {
		
		final int elementTimeout = 5;
		
	}
}
