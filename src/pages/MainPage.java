package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends Page {
	private static final String BRAND_CSS_PATH = "#app > div > div.content > div.Layout > div > div.Index__marks-wrap > div.Index__marks > div.simple-search > div > div.Select.Select_js_inited.Select_size_l.Select_mode_radio-check.simple-search__field.Select_with-search.z-index-group_level_3 > button > span.Button__text";
	private static final String PARENT_BRAND_XPATH_DROP_BOX = "/html/body/div[5]/div/div";
	private static final String MODEL_CSS_PATH = "#app > div > div.content > div.Layout > div > div.Index__marks-wrap > div.Index__marks > div.simple-search > div > div:nth-child(2) > button > span.Icon.Select__tick";
	private static final String PARENT_MODEL_XPATH_DROP_BOX = "/html/body/div[6]/div/div";
	private static final String YEAR_CSS_PATH = "#app > div > div.content > div.Layout > div > div.Index__marks-wrap > div.Index__marks > div.simple-search > div > div:nth-child(3) > button > span.Button__text";
	private static final String PARENT_YEAR_XPATH_DROP_BOX = "/html/body/div[7]/div/div";
	private static final String SEARCH_CSS_PATH = "#app > div > div.content > div.Layout > div > div.Index__marks-wrap > div.Index__marks > div.simple-search > div > button > span";
	private static final String NUM_OF_RESULT_BUTTON_XPATH = "/html/body/div[8]/div/div[2]/div/form/div[2]/div[3]/button/span[2]";
	private static final String SERUAL_OF_SEARCH_XPATH = "/html/body/div[8]/div/div[2]/div/div[1]/div[6]/table";
	private String modelOfCar;
	private String markOfModel;
	private String yearOfCar;

	public MainPage(WebDriver driver){
		super(driver);
	}

	public MainPage(WebDriver driver, String modelOfCar, String markOfModel, String yearOfCar) {
		super(driver);
		this.modelOfCar = modelOfCar;
		this.markOfModel = markOfModel;
		this.yearOfCar = yearOfCar;
	}

	public void search() {
		//driver.get("https://ya.ru/");
		//driver.findElement(By.cssSelector("#app > div > div.content > div.Layout > div > div.Index__marks-wrap > div.Index__marks > div.simple-search > div > div.Select.Select_js_inited.Select_size_l.Select_mode_radio-check.simple-search__field.Select_with-search.z-index-group_level_3 > button")).click();
		driver.findElement(By.cssSelector(BRAND_CSS_PATH)).click();
		setParam(PARENT_BRAND_XPATH_DROP_BOX,modelOfCar);
		
		driver.findElement(By.cssSelector(MODEL_CSS_PATH)).click();
		setParam(PARENT_MODEL_XPATH_DROP_BOX,markOfModel);
		
		driver.findElement(By.cssSelector(YEAR_CSS_PATH)).click();
		setParam(PARENT_YEAR_XPATH_DROP_BOX,yearOfCar);
		
		driver.findElement(By.cssSelector(SEARCH_CSS_PATH)).click();
		
		
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

	public void checkSearchResul( ) {
		String numOfRes = driver.findElement(By.xpath(NUM_OF_RESULT_BUTTON_XPATH)).getText();
		System.out.println(numOfRes);
		
		String text = driver.findElement(By.xpath(SERUAL_OF_SEARCH_XPATH)).getText();
		//System.out.println(text);
		if ( text.toLowerCase().contains(modelOfCar.toLowerCase()) &&
				text.toLowerCase().contains(markOfModel.toLowerCase())
				){
			System.out.println(modelOfCar+" and "+markOfModel+" are in the result\ntest passed!");
		}
		//if ()
	}
}
