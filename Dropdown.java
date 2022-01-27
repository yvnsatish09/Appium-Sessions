package AppiumSessions;

import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Dropdown extends BaseClass {

	public static void main(String[] args) throws Throwable {
	
		
		AppiumDriver driver = BaseClass.capabilities();

		// Click on "Views" icon
		driver.findElement(MobileBy.xpath("//android.widget.TextView[@text ='Views']")).click();
		
		driver.manage().timeouts().implicitlyWait(BaseClass.timeout, TimeUnit.SECONDS);
	
		// Click on "Auto Complete" icon
		driver.findElement(MobileBy.xpath("//android.widget.TextView[@text ='Auto Complete']")).click();
		
		driver.manage().timeouts().implicitlyWait(BaseClass.timeout, TimeUnit.SECONDS);
		
		// Click on "Screen Top" button
		driver.findElementByXPath("//android.widget.TextView[@text ='1. Screen Top']").click();
		
		Thread.sleep(1000);
		
		//Enter text in Country box "United" button
		driver.findElement(MobileBy.xpath("//android.widget.EditText[@resource-id='io.appium.android.apis:id/edit']")).sendKeys("united");
		
		//After "Enter" the text and "Delete" one character in textbox 
		
		//KeyEvent is the instance class in Appium java client jar
		//ElementOption is the static class in Appium java Client jar
		((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.ENTER));
		((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.DEL));
		
		driver.manage().timeouts().implicitlyWait(BaseClass.timeout, TimeUnit.SECONDS);
		
		for(int i=0;i<3;i++) {
			
			//scroll until the "United States" dropdown
			Thread.sleep(1000);
			((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.DPAD_DOWN)); 
		}
		
		//Enter the "United States" in drop down
		((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.ENTER)); 
		
		//stop appium server programmatically
		Runtime.getRuntime().exec("taskKill /F /IM node.exe");
		Runtime.getRuntime().exec("taskKill /F /IM cmd.exe");
		
		
		
		
		
	}
	


}
