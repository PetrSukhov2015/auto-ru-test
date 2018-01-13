package tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;

public class ChromeTestSearch {
	
	
		 private WebDriver driver;
		 
		    @Before
		    public void setUp() throws Exception {
		        System.setProperty("webdriver.chrome.driver", "D:\\work\\testing\\auto.ru\\chromedriver.exe");
		    	driver = new ChromeDriver();
		    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    	driver.get("https://auto.ru/");

		    }
		 
		    @After
		    public void tearDown() throws Exception {
		        driver.quit();
		    }
		 
		    @Test
		    public void search(){
   	
		        MainPage page = new MainPage(driver,"Ford","Focus","2010");
		        page.search();
		        page.checkSearchResul();
		    }
	
}
