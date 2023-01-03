package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dorpdown_Auto_Fill {

	@Test
	public void autofill() {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://maps.google.com/");
		
		WebElement searchbox =driver.findElement(By.xpath("//input[@class='searchboxinput xiQnY']"));
		
		searchbox.clear();
		
		searchbox.sendKeys("Pune");
		
		String text;
		
		do {
			
			searchbox.sendKeys(Keys.ARROW_DOWN);
			text=searchbox.getAttribute("value");
			if(text.contains("Pune International Airport")) {
				
				searchbox.sendKeys(Keys.ENTER);
				break;
			}
			
		}while(!text.isEmpty());
		
		
	}
	
}
