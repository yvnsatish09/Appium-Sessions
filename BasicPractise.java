package AppiumSessions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BasicPractise {
	
	public static final String server = "cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"";
	private static final String serverUrl="http://0.0.0.0:4723/wd/hub";

	public static void main(String[] args) throws Throwable  {
		
		
		DesiredCapabilities dc =new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Uiautomator2");
		dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
		dc.setCapability("appPackage", "com.miui.calculator");
		dc.setCapability("appActivity",".cal.CalculatorActivity");
		Thread.sleep(2000);
		//dc.setCapability("autoAcceptAlerts", true);
		//dc.setCapability("autoGrantPermissions", true);
		
		//start Appium server from Command prompt(Programatically)
		
		//Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
		Runtime.getRuntime().exec(server);
		URL url =new URL("http://0.0.0.0:4723/wd/hub"); 
		// Create driver session
		AppiumDriver driver =new AndroidDriver(url,dc);
		
		Thread.sleep(2000);
		
		//Stop Appium server through Programatically
		
		Runtime.getRuntime().exec("taskKill /F /IM node.exe");
		Runtime.getRuntime().exec("taskKill /F /IM cmd.exe");
		
		

	}

}
