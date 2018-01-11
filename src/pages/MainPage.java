package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends Page {
	public MainPage(WebDriver driver){
		super(driver);
	}

	public void search(String brand, String model, String year) {
		driver.findElement(By.cssSelector("#app > div > div.content > div.Layout > div > div.Index__marks-wrap > div.Index__marks > div.simple-search > div > div.Select.Select_js_inited.Select_size_l.Select_mode_radio-check.simple-search__field.Select_with-search.z-index-group_level_3 > button > span.Button__text")).click();
		//driver.findElement(By.linkText(brand)).click();
		driver.findElement(By.xpath("//div[contains(@class,'MenuItem MenuItem_js_inited MenuItem_size_l MenuItem_checked') and (text(),'Ford')]")).click();
		//driver.findElement(By.xpath("//div[@class='MenuItem MenuItem_js_inited MenuItem_size_l MenuItem_checked' and contains(text(), 'Ford')]")).click();;
		//driver.findElement(By.xpath("//*[text()='Ford']")).click();
		driver.findElement(By.cssSelector("#app > div > div.content > div.Layout > div > div.Index__marks-wrap > div.Index__marks > div.simple-search > div > div:nth-child(2) > button > span.Button__text")).click();
		driver.findElement(By.linkText(model)).click();
		driver.findElement(By.cssSelector("#app > div > div.content > div.Layout > div > div.Index__marks-wrap > div.Index__marks > div.simple-search > div > div:nth-child(3) > button > span.Button__text")).click();
		driver.findElement(By.linkText(year)).click();
		driver.findElement(By.cssSelector("#app > div > div.content > div.Layout > div > div.Index__marks-wrap > div.Index__marks > div.simple-search > div > button > span")).click();
		
		
		
	}

	public void checkSearchResul() {
		// TODO Auto-generated method stub
		
	}
}
