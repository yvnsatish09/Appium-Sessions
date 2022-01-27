package AppiumSessions;

import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class TouchAction1 {

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
			
			By viewsIcon =MobileBy.xpath("//android.widget.TextView[@text='Views']");
			By focusIcon = MobileBy.xpath("//android.widget.TextView[@content-desc='Gallery']");
			By photosIcon = MobileBy.xpath("//android.widget.TextView[@content-desc='1. Photos']");
			
			
			//using Tap() method
			TouchAction tapIcon= new TouchAction(driver);
			tapIcon.tap(ElementOption.element(driver.findElement(viewsIcon))).perform();
			
			//using press()method --"Focus" icon
			tapIcon.press(ElementOption.element(driver.findElement(focusIcon)))
			                           .waitAction(WaitOptions.waitOptions(Duration.ofMillis(10))) //waitFor 
			                           .release().perform(); //After pressing and we need to release
			 
		
			//press-- on "Photos" icon
			tapIcon.press(ElementOption.element(driver.findElement(photosIcon)))
			                           .waitAction(WaitOptions.waitOptions(Duration.ofMillis(8)))
			                           .release().perform();
			
			List<MobileElement> image=  driver.findElements(By.className("android.widget.ImageView"));
			System.out.println(image.get(0).getText());
			
			// Still need to longPress on Image ?
			
			
		}          

}
