package AppiumSessions;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class TouchAction2 {

	
	public static AppiumDriver driver;
	public static final String server ="cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"";
	public static final String appiumServer ="http://0.0.0.0:4723/wd/hub";
	public static final int timeout = 10;
	
	public static void main(String[] args) throws Throwable {
	
		DesiredCapabilities caps =new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi");
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
		caps.setCapability(MobileCapabilityType.UDID, "17fe29ac9807");
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Uiautomator2");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 10);
		caps.setCapability("appPackage", "io.appium.android.apis");
		caps.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		
		
		Runtime.getRuntime().exec(server);
		URL url =new URL(appiumServer);
		
		driver=new AndroidDriver(url,caps);
		
		driver.manage().timeouts().implicitlyWait(TouchAction2.timeout, TimeUnit.SECONDS);
		
		//Click on "Views" icon
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		
		//Click on "Expandable Lists" icon
		driver.findElementByXPath("//android.widget.TextView[@content-desc='Expandable Lists']").click();
		
		//Tap on the "Custom Adapter" icon
		//using TouchActions method
		By customIcon =MobileBy.xpath("//android.widget.TextView[@text='1. Custom Adapter']");
		TouchAction ta= new TouchAction(driver);
		//ta.tap(ElementOption.element(driver.findElement(By.xpath("//android.widget.TextView[@text='1. Custom Adapter']")))).perform();
		
		//ta.tap(ElementOption.element(driver.findElement(customIcon))).perform();
		         // (or)
		ta.tap(TapOptions.tapOptions()
				.withElement(ElementOption.element(driver.findElement(customIcon)))).perform();
	
		//by performing "longPress" using TouchActions method
		//LongPressing on "PeopleNames"Icon
		By pepNamesIcon= MobileBy.xpath("//android.widget.TextView[@text='People Names']");
		ta.longPress(ElementOption.element(driver.findElement(pepNamesIcon)))
		                          .waitAction(WaitOptions.waitOptions(Duration.ofMillis(4)))
		                          .release().perform(); // we need to release and perform the method

		//Back to the "Home" key
	   ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.HOME));
	}

}
