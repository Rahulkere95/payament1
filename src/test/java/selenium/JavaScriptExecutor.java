package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutor  extends javascriptUtility {

	@Test
	public void javascript() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		
		driver.get("https://www.nopcommerce.com/en");
		
		WebElement logo = driver.findElement(By.xpath("//img[@title='nopCommerce']"));
		WebElement heading= driver.findElement(By.xpath("//h1"));
		
		//draw border to webelement
		
		javascriptUtility.draw_border(driver, logo);
		javascriptUtility.draw_border(driver, heading);
		
		//get title of web page
		
		String title=javascriptUtility.title_of_page(driver);
		System.out.println(title);
		
		// click by javascript
		
		WebElement getstarted =driver.findElement(By.linkText("Get started"));
		javascriptUtility.clickbyJS(driver, getstarted);
		
		// create alert popup by JS
		
		javascriptUtility.alertbyJS(driver, " Alert created by RAHUL");
		Thread.sleep(4000);
		driver.switchTo().alert().dismiss();
		
		// Refresh page by JS
		
		javascriptUtility.refreshbyJS(driver);
		
		//scroll_Down
		javascriptUtility.scroll_down(driver);
		
		Thread.sleep(4000);
		//scroll UP
		javascriptUtility.scroll_up(driver);
		
		// zoom out
		 javascriptUtility.zoombyJs(driver);
		 Thread.sleep(4000);
		 //ZOOM IN
		 javascriptUtility.zoomIn_byJS(driver);
		 
		 //Flash the element
		
		 WebElement ele= driver.findElement(By.xpath("//h1"));
		 javascriptUtility.flashcolor(driver, ele);
		 
	}
	
}
