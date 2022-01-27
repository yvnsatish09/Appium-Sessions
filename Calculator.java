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

public class Calculator {
	
	static AppiumDriver driver;

	public static void main(String[] args) throws IOException, Throwable {
		
		
		DesiredCapabilities caps =new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi8");
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
		caps.setCapability("appPackage","com.miui.calculator");
		caps.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");
		
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
		URL url =new URL("http://0.0.0.0:4723/wd/hub");
		
		AppiumDriver driver =new AndroidDriver(url,caps);
		
		//Because waiting for need to take the tim
		Thread.sleep(2000);

		// Click on "9" icon
		MobileElement element = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@resource-id='com.miui.calculator:id/btn_9_s']");
		element.click();
		
		Thread.sleep(1000);
		
		//Click on "+" Icon
		driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='plus']")).click();
		
		//Click on "6" Icon
		driver.findElementByXPath("//android.widget.TextView[@resource-id='com.miui.calculator:id/btn_6_s']").click();
		//stop appium server through Programatically
		
		// Click on "Equals" icon
		driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='equals']")).click();
		
		//Print the text
		String text =driver.findElement(By.xpath("//*[@class='android.widget.ListView']")).getAttribute("text");
	    System.out.println("Text is " + text);
		
		
		Runtime.getRuntime().exec("taskKill /F /IM node.exe");
		Runtime.getRuntime().exec("taskKill /F /IM cmd.exe");
	}
	
	public static MobileElement getElement(By locator) {
		
		return (MobileElement) driver.findElement(locator);
	}

}
