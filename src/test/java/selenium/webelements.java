package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class webelements {

	@Test
	public void register() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		
		driver.get("https://demoqa.com/automation-practice-form");
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("rtja");
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("kere");
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("rahul@gmail.com");

		//System.out.println(driver.findElement(By.xpath("//label[@for='gender-radio-2']")).isSelected());
		//driver.findElement(By.xpath("//label[@for='gender-radio-2']")).click();
		
		/*WebDriverWait wait= new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(gender)); */
		
//		JavascriptExecutor executor = (JavascriptExecutor)driver;
//		executor.executeScript("arguments[0].click();", gender);
			//gender.sendKeys(Keys.ENTER);
		
		
		driver.findElement(By.xpath("//input[@id='userNumber']")).sendKeys("989898");
	//	driver.findElement(By.xpath("//input[@id='dateOfBirthInput']")).click();
	//	WebElement year= driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']"));
		
		//Select yr= new Select(year);
	//	yr.selectByVisibleText("2026");
		
		//WebElement month= driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
		
		//driver.findElement(By.id("hobbies-checkbox-1")).click();
		//driver.findElement(By.linkText("Select State")).click();
	
		
	
		

		
				
		
	}
}
