package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class waits {

	@Test
	public void waits() {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));                   implicit wait : for all web ele
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Selenium");
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(Keys.ENTER);
		
		/*WebDriverWait expwait= new WebDriverWait(driver, Duration.ofSeconds(10));            explicit wait : ele specific   appraoch 1
		
		WebElement ele =expwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3"))); 
		
		ele.click(); */
		By ele=By.xpath("//h3");
		waitforelementpresent(driver, ele, 10).click();
		
		
		
		}
	
	public static WebElement waitforelementpresent(WebDriver driver ,By locator, int timeout) {            // generic method for all element
		
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		return driver.findElement(locator);
		
	}
	
}
