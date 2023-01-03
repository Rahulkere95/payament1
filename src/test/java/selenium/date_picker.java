package selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class date_picker {

	String month="July";
	String year="2023";
	String date="6";
	
	@Test
	public void datepicker() {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		
		driver.get("https://www.redbus.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("onward_cal")).click();
		
		// Month Year selection
		
		
			
			
			while(true) {
				
				String monthyear =driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();
				
				String arr[] =monthyear.split(" ");
				
				String mon= arr[0];
				String yr= arr[1];
		       if(year.equals(yr) && month.equals(mon))
		           {
			         break;
		            }
			   else {
			   
				   driver.findElement(By.xpath("//td[@class='next']//button")).click();
		             }
		 
			}
		//  Date selection
		List<WebElement> alldates= driver.findElements(By.xpath("//table//tbody//tr//td"));
		
		
		
		for(WebElement eledates :alldates) {
			
			String dt =eledates.getText();
			if(dt.equals(date)) {
				
				eledates.click();
				break;
			}
		}
		
		
		}
		
		
		
		
		
		
	}
	

