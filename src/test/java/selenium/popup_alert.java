package selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class popup_alert {

	@Test
		public void alert1() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver= new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
Thread.sleep(3000);
		driver.switchTo().alert().accept();
Thread.sleep(3000);
		driver.close();
		}
	
	@Test
	public void alert2() throws InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
Thread.sleep(4000);
		driver.switchTo().alert().accept();
		
		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
Thread.sleep(4000);
		driver.switchTo().alert().dismiss();
Thread.sleep(3000);
		driver.close();
		
		}
	
	@Test
	public void alert3() throws InterruptedException {
		
        WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		
		Alert alertpop= driver.switchTo().alert();
		
		System.out.println(alertpop.getText());
		Thread.sleep(5000);
		alertpop.sendKeys("rahul welcome");
		
		alertpop.accept();
		driver.close();
	}
	
	@Test
	public void basic_auth() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://rahul:kere@the-internet.herokuapp.com/basic_auth");
		
Thread.sleep(4000);
		driver.close();
		
	}
	
	@Test
	public void permission_popup() {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--disable-notification-");
		ChromeDriver driver= new ChromeDriver();
		
		driver.get("https://webcamtests.com/");
		driver.findElement(By.xpath("//button[@id='webcam-launcher']")).click();
		
		
		
		
	}

	

}
