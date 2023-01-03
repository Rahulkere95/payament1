package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class webtable {

	@Test
	
	public void webtable() {
	
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver= new ChromeDriver();
		
		driver.get("https://www.selenium.dev/ecosystem/");
		
		List<WebElement> headcolcount = driver.findElements(By.xpath("/html/body/div/main/div[4]/div/table/thead/tr/th"));
		System.out.println("no od collumn heading :"+headcolcount.size());
		
		for(WebElement t:headcolcount) {
			
			System.out.print(" "+t.getText());
			}
		
		
		List<WebElement> rowcount =driver.findElements(By.xpath("/html/body/div/main/div[4]/div/table/tbody/tr"));
		System.out.println("row count "+rowcount.size());
//		for(WebElement r:rowcount) {
//			
//			System.out.print(" "+r.getText());
//			System.out.println();
//		}
		
		
		
		//int rowcount = driver.findElements(By.xpath("//table//tbody//tr[3]")).size();
		//System.out.println("no of col :"+rowcount);
		
		for(int i=1; i<rowcount.size(); i++) {
			
			for(int j=1; j<headcolcount.size(); j++) {
				
				String value =driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td["+j+"]")).getText();
				System.out.println(value);
			
		}
		
	}}}
	

