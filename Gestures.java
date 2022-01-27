package AppiumSessions;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;



public class Gestures {

	public static AppiumDriver driver;
	public static String server = "cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"";
	public static String serverURL ="http://0.0.0.0:4723/wd/hub";
	public static final int timeout =10;
		
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
		
		Runtime.getRuntime().exec(server);
		URL url =new URL(serverURL);
		
		driver =new AndroidDriver(url,caps);

		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		
		//Click on "Views" Icon
		((FindsByAndroidUIAutomator) driver).findElementByAndroidUIAutomator("new UiSelector().text(\"Views\")").click();
		
		// Click on "Date Widgets" Icon
		((FindsByAndroidUIAutomator) driver).findElementByAndroidUIAutomator("new UiSelector().text(\"Date Widgets\")").click();
		
		//Click on "InLine"  
		
		((FindsByAndroidUIAutomator) driver).findElementByAndroidUIAutomator("new UiSelector().text(\"2. Inline\")").click();
		
		// Click on '9' 
		driver.findElementByXPath("//*[@content-desc='9']").click();
		
		// long press on element //on element //on 3 sec // move to element and release 
		
		MobileElement ten = (MobileElement) driver.findElementByXPath("//*[@content-desc='10']");
		MobileElement forty = (MobileElement) driver.findElementByXPath("//*[@content-desc='40']");
		
		// Move from 10 to 40 
		TouchAction touch =new TouchAction(driver);
		touch.longPress(ElementOption.element(ten))
		         .waitAction(WaitOptions.waitOptions(Duration.ofMillis(timeout)))
		         .moveTo(ElementOption.element(forty)).release().perform();
		
		
		
		
	}

}
