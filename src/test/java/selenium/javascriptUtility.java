package selenium;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class javascriptUtility {

	public static void draw_border(WebDriver driver, WebElement element) 
	{
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid red'", element);
		
	}
	
	public static String title_of_page(WebDriver driver) {
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String title=js.executeScript("return document.title;").toString();
		return title;
		
		}
	
	public static void clickbyJS(WebDriver driver, WebElement element) {
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
		
	}
	
	public static void alertbyJS(WebDriver driver, String message) {
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		
		js.executeScript("alert('" + message +"')");
		
	}
	
	public static void refreshbyJS(WebDriver driver) {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		
		js.executeScript("history.go(0)");
		
		}
	
	public static void scroll_down(WebDriver driver) {
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}
	
	public static void scroll_up(WebDriver driver) {
		JavascriptExecutor js=  (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		
		
	}
	
	public static void zoombyJs(WebDriver driver) {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("document.body.style.zoom='50%'");  // zoom out 
		
	}
	
	public static void zoomIn_byJS(WebDriver driver	) {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("document.body.style.zoom='120%'"); // zoom In
		
		
	}
	
	public static void changecolor(WebDriver driver , WebElement element, String color) {
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.backgroundColor='" +color+ "'", element);
		try {
			Thread.sleep(200);
		}
		catch(InterruptedException e){
			
		}
		
	}
	
	public static void flashcolor(WebDriver driver, WebElement element) {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		String bgcolor =element.getCssValue("backgroundColor");
		
		for(int i=0;i<=10; i++) {
			
			changecolor(driver, element, "#000000");
			changecolor(driver, element, bgcolor);
			
		}
		
	}
	
}
