package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class webtable_Dynamic {

	@Test
	public void dynamic_webtable() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		
		driver.get("https://demo.opencart.com/admin/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("input-username")).sendKeys("demo");
		driver.findElement(By.id("input-password")).sendKeys("demo");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.xpath("//button[@class='btn-close']")).click();
		//driver.findElement(By.id("button-menu")).click();
		WebElement sales =driver.findElement(By.xpath("//li[@id='menu-sale']//a//i"));
		Thread.sleep(5000);
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		Actions action = new Actions(driver); 
		action.moveToElement(sales); 
		wait.until(ExpectedConditions.elementToBeClickable(sales));
		sales.click();
		driver.findElement(By.xpath("//ul[@id='collapse-4']//li[1]//a")).click();
		
		//showing total no of pages
		String pagetext =driver.findElement(By.xpath("//div[@class='col-sm-6 text-end']")).getText();  
		System.out.println(pagetext);
		int pagecount=Integer.valueOf(pagetext.substring(pagetext.indexOf("(")+1, pagetext.indexOf("Pages")-1));
		
		System.out.println("total no of pages : "+pagecount);
		
	}
}
