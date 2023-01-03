package selenium;

import java.io.File;
import java.io.IOException;

import javax.swing.Action;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class action_class {

	
	
	//@Test
	public void move_mouse() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		//move mouse
		driver.get("https://demo.guru99.com/test/drag_drop.html");
		
		
		
		
		WebElement money= driver.findElement(By.linkText("5000"));
		Actions act= new Actions(driver);
		Thread.sleep(4000);
		act.moveToElement(money).build().perform();    // u can use perform() only as it calls build() internally
		
		
		//darg and drop
		WebElement amount1=driver.findElement(By.xpath("//ol[@id='amt7']"));
		act.dragAndDrop(money, amount1).build().perform();
		WebElement amount2= driver.findElement(By.xpath("//ol[@id='amt8']"));
		
		act.clickAndHold(money).moveToElement(amount2).release().build().perform();  
		JavascriptExecutor js=(JavascriptExecutor)driver;                                //scroll down
		js.executeScript("arguments[0].scrollIntoView();", amount2);
		
		File screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
		FileUtils.copyFile(screenshot, new File("C:\\Users\\admin\\Documents\\test_resourse\\screenshot\\darg&drop.png"));
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
		
		
		}
	
	//@Test
	public void contextclick() {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.navigate().to("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		Actions act= new Actions(driver);
		
		WebElement button =driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		act.contextClick(button).build().perform();
		
		driver.findElement(By.xpath("//li[@class='context-menu-item context-menu-icon context-menu-icon-copy']")).click();
		
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		}
	
	@Test
	public void slider_resizable() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		//driver.navigate().to("https://jqueryui.com/slider/");
		Actions act= new Actions(driver);
		//driver.switchTo().frame(0);
		/*WebElement slider1=driver.findElement(By.xpath("//span[@style='left: 0%;']"));
		act.moveToElement(slider1).dragAndDropBy(slider1, 400, 0).build().perform();*/
		
		//resizable
		driver.navigate().to("https://jqueryui.com/resizable/");
		
		driver.switchTo().frame(0);
		WebElement resizable=driver.findElement(By.xpath("//*[@id='resizable']//div[3]"));
		Thread.sleep(4000);
		act.moveToElement(resizable).dragAndDropBy(resizable, 50, 50).build().perform();
		
		
		
	}
	
}
