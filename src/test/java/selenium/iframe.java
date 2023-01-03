package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class iframe {

	@Test
	
	public void iframe() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?org/openqa/selenium/package-summary.html");
		
		Thread.sleep(2000);
		
		//driver.switchTo().frame(0);                                                parent frame
		driver.switchTo().frame("packageListFrame");                                           
		
		Thread.sleep(2000);

		driver.findElement(By.linkText("org.openqa.selenium.cli")).click();
		//                                                                  switch back to parent frame
		driver.switchTo().defaultContent();
		//                                                                            child1 frame
		
		driver.switchTo().frame("packageFrame");
		
		driver.findElement(By.linkText("CliCommand")).click();
		
		driver.findElement(By.xpath("//a[@title='class in org.openqa.selenium.cli']")).click();
		//driver.switchTo().defaultContent();                                //switch back to parent frame              
		driver.switchTo().parentFrame();
		
		
		driver.switchTo().frame("classFrame");                                       // child 2
		driver.findElement(By.xpath("//ul[@class='subNavList']//li[5]//a")).click();
		
	Thread.sleep(4000);
		
		/// Nested iframes

		driver.navigate().to("https://demo.automationtesting.in/Frames.html");
		
		driver.findElement(By.linkText("Iframe with in an Iframe")).click();
		
	WebElement mainframe=driver.findElement(By.xpath("//*[@id=\"Multiple\"]/iframe"));
	 driver.switchTo().frame(mainframe);
	 
		WebElement nestedframe=driver.findElement(By.xpath("//*[@class='iframe-container']//iframe"));
	
	 driver.switchTo().frame(nestedframe);
	 driver.findElement(By.xpath("//input[@type='text']")).sendKeys("hello");
	 
	 
	 
	 
		
		
	}
	
}
