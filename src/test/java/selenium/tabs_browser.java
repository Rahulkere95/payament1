package selenium;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class tabs_browser {

	@Test
	public void new_tabs() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		
		driver.get("https://www.primevideo.com/region/eu/storefront/home/ref=atv_dp_mv_c_9zZ8D2_1_0");
		
		//String tab=Keys.chord(Keys.CONTROL, Keys.RETURN);    // ctrl tab to open in new tab
		
		//driver.findElement(By.linkText("Go to Homepage")).sendKeys(tab);    //approach 1
		
		driver.findElement(By.linkText("Go to Homepage")).sendKeys(Keys.CONTROL, Keys.RETURN);
		
		
		// open one application in two diff tabs
		
		
		driver.get("https://www.nopcommerce.com/en");
		
		driver.switchTo().newWindow(WindowType.TAB);
		
		driver.get("https://www.youtube.com/watch?v=3x7nf3tZ05w&t=555s");
		
		//open one app in two diff WINDOWS
		
		driver.get("https://www.nopcommerce.com/en");
		
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		driver.get("https://www.youtube.com/watch?v=3x7nf3tZ05w&t=555s");
		
		
	}
}
