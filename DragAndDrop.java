package AppiumSessions;

import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class DragAndDrop {
	
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
		
		 driver.findElementByXPath("//android.widget.TextView[@text ='Views']").click();
		 //Click on "Drag and Drop"
		 driver.findElementByXPath("//android.widget.TextView[@text ='Drag and Drop']").click();
		 
		 MobileElement dragMe = (MobileElement) driver
				 .findElementByXPath("//android.view.View[@resource-id='io.appium.android.apis:id/drag_dot_1']");
		 MobileElement dropMe = (MobileElement) driver
				 .findElementByXPath("//android.view.View[@resource-id='io.appium.android.apis:id/drag_dot_2']");

		 
		 //Performing Drag and Drop
		 TouchAction touch =new TouchAction(driver);
		 touch.longPress(ElementOption.element(dragMe))
		                              .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		                              .moveTo(ElementOption.element(dropMe)).release().perform();
		 //"Dropped" text is displayed or not
		 System.out.println(driver.findElementByXPath("//android.widget.TextView[@text ='Dropped!']").isDisplayed());
	}

}
