package selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class upload_file {

	@Test
	
	public void uploadfile() throws AWTException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.foundit.in/");
		driver.findElement(By.xpath("//i[@class='mqfihd-upload']")).click();
		
		//driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\admin\\Downloads\\Lic 1.pdf");
		
		// using ROBOT CLASS
		
		//driver.findElement(By.id("file-upload")).click();
		WebElement button =driver.findElement(By.id("file-upload"));
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeAsyncScript("arguments[0].click();", button);
		
		/* copy path
		 * ctrl+v
		 * enter
		*/
		
		Robot rb= new Robot();
		rb.delay(2000);
		// copy
		StringSelection ss= new StringSelection("C:\\Users\\admin\\eclipse-workspace\\PaymentGateway\\downloads\\samplefile.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().setScriptTimeout(Duration.ofSeconds(30));
		
		// ctrl+v
		
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		
		// enter
		
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		
	}
}
