package AppiumSessions;

import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

public class Practise1 extends BaseClass {
	
	public static void main(String[] args) throws Throwable {

	
	AppiumDriver driver = BaseClass.capabilities();

	// Click on "Views" icon
	driver.findElement(MobileBy.xpath("//android.widget.TextView[@text ='Views']")).click();
	
	driver.manage().timeouts().implicitlyWait(BaseClass.timeout, TimeUnit.SECONDS);
	
	//switch from one application to the another application
	((AndroidDriver)driver).startActivity(new Activity("com.miui.calculator","com.miui.calculator.cal.CalculatorActivity"));
	
	}
}
