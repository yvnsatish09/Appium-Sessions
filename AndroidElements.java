package AppiumSessions;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AndroidElements {
	
	public static AppiumDriver driver;
	public static final String server = "cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"";
	public static final String serverURL= "http://0.0.0.0:4723/wd/hub";

	public static void main(String[] args) throws Throwable {
		
		DesiredCapabilities dc =new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi8");
		dc.setCapability(MobileCapabilityType.UDID, "17fe29ac9807");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
		dc.setCapability("appPackage", "io.appium.android.apis");
		dc.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		
		
		Runtime.getRuntime().exec(server);
		URL url =new URL(serverURL);
		
		driver =new AndroidDriver(url,dc);
		
		Thread.sleep(2000);
		
		// By using "id"
		MobileElement text =(MobileElement) driver.findElement(By.id("android:id/text1"));
		System.out.println("Fetching Text is " + text.getText());
		
		// By using the "className"
		
		List<MobileElement> text1 =  driver.findElements(By.className("android.widget.TextView"));
		System.out.println("Fetching className is " + text1.get(6).getText());
		
		// using "Text"
		MobileElement app =  (MobileElement)driver.findElementByXPath("//*[@text='App']");
		System.out.println(app.getText());
		
		// Using description(nothing but content-desc)
		
		MobileElement content = (MobileElement)driver.findElementByXPath("//android.widget.TextView[@content-desc='Views']");
		System.out.println(content.getText());

	}

}
