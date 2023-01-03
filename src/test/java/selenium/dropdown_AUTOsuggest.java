package selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dropdown_AUTOsuggest {

	@Test
	public void autosuggestion() {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));     //implicite wait
		driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("selenium");
		
		List<WebElement> suggestions=driver.findElements(By.xpath("//ul[@class='G43f7e']//li"));
		
		System.out.println("no of suggestions : "+ suggestions.size());
		
		for(WebElement item :suggestions) {
			
			if(item.getText().contains(" webdriver download")) {
				
				item.click();
				break;
			}
		}
		
		
		
	}
	
	
}
