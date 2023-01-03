package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class calender {

	@Test
	public void calender() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://demoqa.com/automation-practice-form");
		Thread.sleep(3000);
		
		
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		
		WebElement calender=driver.findElement(By.xpath("//input[@id='dateOfBirthInput']"));
		
		js.executeScript("arguments[0].scrollIntoView();", calender);
		
		calender.click();
		Thread.sleep(4000);
		
		Select year= new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__year-select']")));
		
		year.selectByValue("2025");
		
		Select month = new Select(driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']")));
		month.selectByIndex(7);
		
		driver.findElement(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--015']")).click();
		
		WebElement date=driver.findElement(By.xpath("//input[@value='15 Aug 2025']"));
		System.out.println(date.getText());
		
	}
	
}
