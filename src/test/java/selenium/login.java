package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class login {

	@Test
	public void submit() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	Thread.sleep(5000);	
	
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Rahul");
		driver.findElement(By.xpath("//input[contains(@name,'password')]")).sendKeys("rsk123");
		
		driver.findElement(By.xpath("//button[contains(@type,'submit')]")).sendKeys("uhb");
		System.out.println("complete");
		
	}
}
