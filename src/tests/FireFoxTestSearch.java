package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.MainPage;

public class FireFoxTestSearch {
	
	
		 private WebDriver driver;
		 
		    @Before
		    public void setUp() throws Exception {
		        //File classpathRoot = new File(System.getProperty("user.dir"));
		        //File appDir = new File(classpathRoot, "../../");
		    	System.setProperty("webdriver.gecko.driver","D:\\work\\testing\\auto.ru\\geckodriver.exe");
		    	driver = new FirefoxDriver();
		    	driver.get("https://auto.ru/");

		    }
		 
		    @After
		    public void tearDown() throws Exception {
		        driver.quit();
		    }
		 
		    @Test
		    public void search(){
		        MainPage page = new MainPage(driver);
		        page.search("Ford", "Focus", "2010");
		        page.checkSearchResul();
		    }
	
}
