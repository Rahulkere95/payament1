package selenium;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class windowhandle {

	@Test
	public void windowhandles() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		
		driver.get("https://demo.automationtesting.in/Windows.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println(driver.getWindowHandle());  //id of parent window
		System.out.println(driver.getWindowHandles());  //return type set<String>
		
		driver.findElement(By.xpath("//a[@href='#Tabbed']")).click();   //opens new child window
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
		Set<String> windowIds=driver.getWindowHandles(); // handles gives IDs of both parent and chiled windows
		
		Iterator<String> it =windowIds.iterator();
		
		String parent_wind_id=it.next();
		String child_wind_id=it.next();
		
		System.out.println("ID of parent window : "+ parent_wind_id);
		System.err.println("Id of Child Window : "+ child_wind_id);
		
		
		
		driver.switchTo().window(child_wind_id);
		
		System.out.println(driver.getTitle());
		
		driver.switchTo().window(parent_wind_id);
		System.out.println(driver.getTitle());
		driver.switchTo().window(child_wind_id).close();
		
		
		
		
		
	}
}
