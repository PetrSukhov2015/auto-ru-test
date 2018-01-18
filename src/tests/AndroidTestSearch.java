package tests;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PressesKeyCode;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import pages.AndroidView;


public class AndroidTestSearch {
	
	
		 private AppiumDriver<WebElement> driver;
		 
		    @Before
		    public void setUp() throws Exception {
		        //File classpathRoot = new File(System.getProperty("user.dir"));
		        //File appDir = new File(classpathRoot, "../../");
		        File app = new File( "D:\\work\\testing\\auto.ru\\ru.auto.ara-1.apk");
		        DesiredCapabilities capabilities = new DesiredCapabilities();
		        capabilities.setCapability("deviceName","LGE Nexus 4");
		        capabilities.setCapability("platformVersion", "4.4");
		        capabilities.setCapability("app", app.getAbsolutePath());
		        capabilities.setCapability("appPackage", "ru.auto.ara");
		        
		        //capabilities.setCapability("unicodeKeyboard", "true");                                     
		        //capabilities.setCapability("resetKeyboard", "true");
		        //capabilities.setCapability("appActivity", ".ApiDemos");
		        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		        //System.out.println("i am here");
		    }
		 
		    @After
		    public void tearDown() throws Exception {
		        driver.quit();
		    }
		 
		    @Test
		    public void search(){
		    	MobileElement el1 = (MobileElement) driver.findElementByClassName("android.widget.ImageView");
			    el1.click();		        
		        
		    	MobileElement el2 = (MobileElement) driver.findElementById("ru.auto.ara:id/do_search_btn");
		        System.out.println(el2.getText());
		        el2.click();
		        MobileElement el3 = (MobileElement) driver.findElementById("ru.auto.ara:id/name");
		        System.out.println(el3.getText());
		        //AndroidView ap = new AndroidView(driver);
		    	//ap.smokeTestReasrch();
		    	
		    }
	
}
