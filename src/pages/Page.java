package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Page {
	Page(WebDriver driver){
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	public WebDriver driver;
	
}
