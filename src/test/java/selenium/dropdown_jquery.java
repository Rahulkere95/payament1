package selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dropdown_jquery {

	@Test
	public void jquery_drop() {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='justAnInputBox']")).click();
		selectmulti(driver, "choice 2 1");
		
		//List<WebElement> options =driver.findElements(By.xpath("//li[@class='ComboTreeItemChlid']"));
//		for(WebElement op :options) {
//			
//			if(op.getText().equals("choice 3"))
//			{
//				op.click();
//				break;
//			}
//		}
		
		
	}

	public static void selectmulti(WebDriver driver, String... value) {
		List<WebElement> options =driver.findElements(By.xpath("//li[@class='ComboTreeItemChlid']"));
		if(!value[0].equalsIgnoreCase("all")) {
			for(WebElement item:options) {
				
				String text=item.getText();
				
				for(String val: value) {
					
					if(text.equalsIgnoreCase(val)) {
						
						item.click();
						break;
					}
					
				}
				
			}
			
		}

		else{
			for(WebElement e:options) {
			e.click();
			}
		}
		
	}
}
