package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends Page {
	private static final String brandCssPath = "#app > div > div.content > div.Layout > div > div.Index__marks-wrap > div.Index__marks > div.simple-search > div > div.Select.Select_js_inited.Select_size_l.Select_mode_radio-check.simple-search__field.Select_with-search.z-index-group_level_3 > button > span.Button__text";
	private static final String parentBrandXpathDropBox = "/html/body/div[5]/div/div";
	private static final String modelCssPath = "#app > div > div.content > div.Layout > div > div.Index__marks-wrap > div.Index__marks > div.simple-search > div > div:nth-child(2) > button > span.Icon.Select__tick";
	private static final String parentModelXpathDropBox = "/html/body/div[6]/div/div";
	private static final String yearCssPath = "#app > div > div.content > div.Layout > div > div.Index__marks-wrap > div.Index__marks > div.simple-search > div > div:nth-child(3) > button > span.Button__text";
	private static final String parentYearXpathDropBox = "/html/body/div[7]/div/div";
	private static final String searchCssPath = "#app > div > div.content > div.Layout > div > div.Index__marks-wrap > div.Index__marks > div.simple-search > div > button > span";

	public MainPage(WebDriver driver){
		super(driver);
	}

	public void search(String brand, String model, String year) {
		
		driver.findElement(By.cssSelector(brandCssPath)).click();
		setParam(parentBrandXpathDropBox,brand);
		
		driver.findElement(By.cssSelector(modelCssPath)).click();
		setParam(parentModelXpathDropBox,model);
		
		driver.findElement(By.cssSelector(yearCssPath)).click();
		setParam(parentYearXpathDropBox,year);
		
		driver.findElement(By.cssSelector(searchCssPath)).click();
		
		
	}

	private void setParam(String xpathOfParent, String brand) {
		String lines[] = driver.findElement(By.xpath(xpathOfParent)).getText().split("[\r\n]+");
		int i=0;
		for (String line: lines){
			i++;
			if ( line.toLowerCase().equals(brand.toLowerCase()) ){
				driver.findElement(By.xpath(xpathOfParent+"/div["+i+"]")).click();
				break;
			}	
 
		}
		
	}

	public void checkSearchResul() {
		//String textResultSearch = driver.findElement(By.xpath(textResultSearch")).getText();
		//System.out.println(textResultSearch);
		//if ()
	}
}
