package selenium;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class cookies_ {

	@Test
	public void cookies() {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.nopcommerce.com/en");
		
		// how to capture no of cookies from browser
		
		Set<Cookie> cookycount=driver.manage().getCookies();
		
		System.out.println("no of cookies : "+ cookycount.size());
		
		// to print cookies
		for(Cookie cooky:cookycount) {
			
			System.out.println(cooky.getName()+" : "+ cooky.getValue());
		}
		// how to add cookie
		
		Cookie cookobj=new Cookie("mycooky123", "9834");
		driver.manage().addCookie(cookobj);
   
	Set<Cookie> cookycount1=driver.manage().getCookies();
		
		System.out.println("no of cookies : "+ cookycount1.size());  // +1

		// how to delete cookie
		
		driver.manage().deleteCookie(cookobj);
	Set<Cookie> cookycount12=driver.manage().getCookies();
		
		System.out.println("no of cookies : "+ cookycount12.size());  // -1
		
		driver.manage().deleteAllCookies();
		
Set<Cookie> cookycount13=driver.manage().getCookies();
		
		System.out.println("no of cookies : "+ cookycount13.size());
		
	}
	
}
