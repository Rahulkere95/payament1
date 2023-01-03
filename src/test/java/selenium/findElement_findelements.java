package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class findElement_findelements {

	@Test
	public void test01() {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		
		WebElement searchbox= driver.findElement(By.id("small-searchterms"));
		
		searchbox.sendKeys("rahul");
		
		
		WebElement footer= driver.findElement(By.xpath("//div[@class='footer-upper']//a"));  // 22 matches
		
		System.out.println(footer.getText());  // findelemwnt() return only first element\
		
		driver.close();
		
		}
	
	@Test
	
	public void test02()
	{
		
		ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("https://demo.nopcommerce.com/");
		
		List<WebElement> footer= driver.findElements(By.xpath("//div[@class='footer-upper']//a"));
		
		System.out.println("number of loops present "+footer.size()); //22
		
		for(WebElement ele:footer) {
			
			System.out.println(ele.getText());
			
			//List<WebElement> element=driver.findElements(By.xpath("//a[@class='footpper']")); // wrong xpath
			//System.out.println(element.size());
			
		}
		
		
		
		
	}
	
}
