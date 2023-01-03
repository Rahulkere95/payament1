package selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class checkbox {

	@Test
	public void checkbox_handling() {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver= new ChromeDriver();
		
		driver.get("https://demos.jquerymobile.com/1.4.5/checkboxradio-checkbox/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		List<WebElement> options=driver.findElements(By.xpath("//div[@class='ui-checkbox']"));
		
		System.out.println(options.size());
		
//		for(int i=1; i<=4; i++) {
//			
//			options.get(i).click();
//		}
		
		for(WebElement option:options) {
			
			 String checkbox_name=option.getAttribute("id");
			 if(checkbox_name.equals("checkbox-v-2b") || checkbox_name.equals("checkbox-v-2c")) {
				 option.click();
				 
			 }
		}
		
		
		
		
}
}