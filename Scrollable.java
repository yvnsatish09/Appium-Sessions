package AppiumSessions;

import io.appium.java_client.FindsByAndroidUIAutomator;

public class Scrollable  extends BaseClass{

	
	public static void main(String[] args) throws Throwable {
		
		BaseClass.capabilities();
		driver.findElementByXPath("//*[@text='Views']").click();
		//((FindsByAndroidUIAutomator) driver)
		//.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Progress Bar\"));");
		scrollingElement("Progress Bar");
	}
	
	public static void scrollingElement(String text) {
		
		((FindsByAndroidUIAutomator) driver)
		.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"'"+text+"'\"));");
		
	}

}
