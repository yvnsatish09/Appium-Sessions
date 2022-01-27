package AppiumSessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;

public class TappingElement extends BaseClass{

	public static void main(String[] args) throws Throwable{
		
		BaseClass.capabilities();
		
		driver.findElementByXPath("//*[@text='Views']").click();
		// Controls
		
		driver.manage().timeouts().implicitlyWait(BaseClass.timeout, TimeUnit.SECONDS);
		//Click on "Controls" link
		driver.findElementByXPath("//*[@text='Controls']").click();
		driver.manage().timeouts().implicitlyWait(BaseClass.timeout, TimeUnit.SECONDS);
		
		// Click on 'Light Theme' link
		
		driver.findElementByXPath("//*[@content-desc='1. Light Theme']").click();
		driver.manage().timeouts().implicitlyWait(BaseClass.timeout, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//android.widget.EditText[@text='hint text']")).sendKeys("selenium");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//android.widget.CheckBox[@text='Checkbox 1']")).click();
		driver.findElement(By.xpath("//android.widget.CheckBox[@text='Checkbox 2']")).click();
		
		Thread.sleep(1000);
		
		// scroll to the "(And all inside of a ScrollView!)" text
		MobileElement element =(MobileElement) ((FindsByAndroidUIAutomator) driver)
		.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector())"
				+ ".scrollIntoView(text(\"(And all inside of a ScrollView!)\"));");
		System.out.println(element.isDisplayed());
		System.out.println(element.getText());

	}

}
