package AppiumSessions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class Swipe1 extends BaseClass {

	public static void main(String[] args) throws Throwable{
		
		BaseClass.capabilities();
		Swipe1 buttons =new Swipe1();
		//buttons.PressElement();
		//buttons.swipeActions();
		buttons.invisible_To_VisibleElement();

	}

	public static void TapElement() {
		
		driver.findElement(By.xpath("//*[@text='Views']")).click();
		
		By controlButton = MobileBy.xpath("//android.widget.TextView[@text='Buttons']");
		
		TouchAction touch =new  TouchAction(driver);
		touch.tap(ElementOption.element(driver.findElement(controlButton)))
		                       .waitAction(WaitOptions.waitOptions(Duration.ofMillis(BaseClass.timeout))).perform();
	}
	
	public static void PressElement() {
		
		
		driver.findElement(By.xpath("//*[@text='Views']")).click();
		// Scrollable to the "Popup Menu" and Click link
		((FindsByAndroidUIAutomator) driver)
		.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Popup Menu\"));").click();
		
		//Press on "Make A Popup" alert
		By popMenu = MobileBy.xpath("//android.widget.Button[@text='MAKE A POPUP!']");
		TouchAction touch =new TouchAction(driver);
		touch.longPress(ElementOption.element(driver.findElement(popMenu)))
		                          .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(timeout)))
		                          .release().perform();
		
	}
	 
	  public static void swipeActions() {
		  
		  By views = MobileBy.xpath("//*[@text='Views']");
		  driver.findElement(views).click();
		  
		  // Swipe 3 times 
		  for(int i=0;i<3;i++) {
			  
		    Dimension element =driver.manage().window().getSize();
		    int startx = element.width/2;
		    int starty = startx;
		    int endX= (int)(element.height * 0.7);
		    int endY= (int)(element.height * 0.2);
		  
		  // by using swipe actions
		  TouchAction touch  =new TouchAction(driver);
		  touch.press(PointOption.point(startx,starty))
		       .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
		       .moveTo(PointOption.point(endX,endY)).release().perform();
		  }
	  }
	  
	  public static void invisible_To_VisibleElement() {
		  
		    //Click on "Views" icon
			driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		  
		  By grid = MobileBy.xpath("//*[@text='Grid']");
		  By animation = MobileBy.xpath("//*[@text='Animation']");
		  
		  TouchAction touch =new TouchAction(driver);
		  touch.press(ElementOption.element(driver.findElement(grid))) //grid --is starting element
		                           .waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000)))
		                           .moveTo(ElementOption.element(driver.findElement(animation))).release().perform();
		                           
		      // Animation --- is the second element              
		 
		  
		  
		  
		  
	  }
}
