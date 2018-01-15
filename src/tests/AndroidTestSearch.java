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
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;


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
		    	//System.out.println("i am here");
		        WebElement el = driver.findElementByClassName("android.widget.TextView");
		        el.click();
		        WebElement el2 = driver.findElementByClassName("android.widget.EditText");
		        el2.sendKeys("Ford Focus");
		        //el.sendKeys(arg0);
		        //WebElement res = driver.findElementByClassName("android.widget.EditText");
		        //Assert.assertEquals("Ford", res.getText());
		    	/*
		        WebElement el = driver.findElement(By.xpath(".//*[@text='Animation']"));
		 
		        Assert.assertEquals("Animation", el.getText());
		        el = driver.findElementByClassName("android.widget.TextView");
		        Assert.assertEquals("API Demos", el.getText());
		        el = driver.findElement(By.xpath(".//*[@text='App']"));
		        el.click();
		        List<WebElement> els = driver.findElementsByClassName("android.widget.TextView");
		        Assert.assertEquals("Activity", els.get(2).getText());
		        
		    	*/
		    }
	
}
