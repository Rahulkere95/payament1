package selenium;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class switching_window {

	@Test
	public void switch_brwser() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://demo.automationtesting.in/Windows.html");
		
		driver.findElement(By.xpath("//a[@href='#Tabbed']")).click();
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
		
		System.out.println("current window "+ driver.getTitle());
		
		
		  Set <String> s= driver.getWindowHandles();
		  
		  for(String e:s) {
			  System.out.println("id of windows"+e);
			  String title= driver.switchTo().window(e).getTitle();
			  System.out.println(title);
			  
			  if(title.contains("Frames & windows")) {
				  
				  driver.close(); 
			  }
			  
			  if(title.contains("Selenium")) {
				  
				  driver.close();
			  }
		  }
		
	}
	
}
