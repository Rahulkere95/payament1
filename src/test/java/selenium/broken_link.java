package selenium;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.apache.hc.core5.http.HttpConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByPartialLinkText;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class broken_link {

	private static final String HttpConnection = null;

	@Test
	
	public void brokenlink() throws IOException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		
		driver.get("https://demo.guru99.com/test/newtours/");
		driver.manage().window().maximize();
		
		List <WebElement> links= driver.findElements(By.tagName("a"));
		
		System.out.println(links.size());
		for(int i=0; i<=links.size(); i++) {
			
			WebElement element= links.get(i);
			
			String url= element.getAttribute("href");
			
			URL link= new URL(url);
			
			HttpURLConnection httpconn =(HttpURLConnection)link.openConnection();
			
			httpconn.connect();
			
			int resp_code=httpconn.getResponseCode();
			
			if(resp_code >= 400) {
				System.out.println(url+": invalid url broken link");
			}
			else {
				System.out.println(url+"valid url");
			}
			
			
		}
		
		
	}
}
