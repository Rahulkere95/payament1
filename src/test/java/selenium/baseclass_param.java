package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseclass_param {

	
	
	public static WebDriver driver;
	@BeforeClass
	public void browser() {
		
		WebDriverManager.chromedriver().setup();
		
		driver= new ChromeDriver();
		
		driver.get("https://demo.guru99.com/test/newtours/");
		driver.findElement(By.xpath("//a[@href='register.php']")).click();
		
	}
	
	
//	public void webtable() {
//		
//		driver.get("https://demo.guru99.com/test/table.html");
//	}
	
	//@AfterClass
	//public void closebrowser() {
		
		//driver.close();
	//}
}
