package selenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class screenshots {

	@Test
	public void screenshot() throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		
		driver.get("https://www.primevideo.com/region/eu/storefront/home/ref=atv_dp_mv_c_9zZ8D2_1_0");
		
		// Full Page Screenshot
		
		TakesScreenshot ts= (TakesScreenshot)driver;
		
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target= new File("C:\\Users\\admin\\eclipse-workspace\\PaymentGateway\\src\\test\\resources\\screenshot\\amazon.png");
		
		FileUtils.copyFile(source, target); 
		
		// Section of page screenshot
		
		WebElement welcome=driver.findElement(By.xpath("//div[@id='pv-nav-main-menu']"));
		
		File src=welcome.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(src, target);
		
		
		
		
		
		
		
	}
	
	
	
}
