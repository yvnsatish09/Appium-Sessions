package AppiumSessions;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Calculator2 {
	
	private static AppiumDriver driver;
	private static final String server = "cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"";
	private static final String serverURL = "http://0.0.0.0:4723/wd/hub";
	

	public static void main(String[] args) throws Throwable {
		
	
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter first input is");
		String x = sc.nextLine();
		
		System.out.println("Enter second  input is");
		String y =sc.nextLine();
		
		
		DesiredCapabilities dc =new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Redmi8");
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Uiautomator2");
		// In my mobile, Manually need to click on "Agree" button
		//thats's why wait condition is applied below
		dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "14");
		dc.setCapability("appPackage", "com.miui.calculator");
		dc.setCapability("appActivity", "com.miui.calculator.cal.CalculatorActivity");
		
		//laucnching server through Programatically
		Runtime.getRuntime().exec(server);
		URL url =new URL(serverURL);
		
	
		//creating driver session
		while(2>1) {
			
			try {
				
				driver =new AndroidDriver(url,dc);
				
			}
			catch(Exception ex) {
				
				System.out.println(ex.getMessage());
			}
		}
		
		//locate and operate elements on 

		
	}
		
		

	}


