package AppiumSessions;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class CalculGenericMethod  extends BaseClass{

	
	public static void main(String[] args) throws Throwable {
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
		dc.setCapability("appPackage", "com.miui.calculator");
		dc.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");
		
		Runtime.getRuntime().exec(BaseClass.server);
		URL url=new URL(BaseClass.serverURL);
		
		driver =new AndroidDriver(url,dc);
		
		Thread.sleep(2000);
		
		By ninthIcon = By.xpath("//android.widget.TextView[@resource-id='com.miui.calculator:id/btn_9_s");
		By plusIcon = By.xpath("//android.widget.ImageView[@content-desc='plus']");
		By sixthIcon = By.xpath("//android.widget.TextView[@resource-id='com.miui.calculator:id/btn_6_s");
	//	By EqualsIcon = By.xpath("//android.widget.ImageView[@content-desc='equals']");
		
		getMobileElement(ninthIcon).click();
		getMobileElement(plusIcon).click();
		getMobileElement(sixthIcon).click();
		

	}
	
	public static WebElement getMobileElement(By locator) {
		
		  return  driver.findElement(locator);
	}

}
