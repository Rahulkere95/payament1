package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class webele_location_size {

	@Test
	public void location_size() {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		
		driver.get("https://www.nopcommerce.com/en");
		
		WebElement logo =driver.findElement(By.xpath("//img[@title='nopCommerce']"));
		
		System.out.println("location of logo : "+logo.getLocation());
		
		System.out.println("coordinates of x : "+logo.getLocation().getX());
		System.out.println("coordinates of y : "+logo.getLocation().getY());
		
		System.out.println("size of logo : "+logo.getSize());
		System.out.println("width of logo : "+logo.getSize().getWidth());
		System.out.println("height of logo : "+logo.getSize().getHeight());
		
	}
}
