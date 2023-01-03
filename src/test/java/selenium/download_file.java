package selenium;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class download_file {

	String location= System.getProperty("user.dir")+"\\downloads\\";
	//@Test
	public void download_default_location() {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		// default location
		driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");
		
		driver.findElement(By.xpath("//tbody//tr[1]//td[5]//a[1]")).click();
		
	}
	
	
	//@Test
	public void download_desired_location() throws InterruptedException {
		
		String location= System.getProperty("user.dir")+"\\downloads\\";
		
		HashMap preferences= new HashMap();
		preferences.put("download.default_directory", location);
		
		ChromeOptions options= new ChromeOptions();
		options.setExperimentalOption("prefs", preferences);
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver =new ChromeDriver(options);
		
		driver.get("https://demo.automationtesting.in/FileDownload.html");
		
		driver.findElement(By.linkText("Download")).click();
		
		Thread.sleep(4000);
		
		}
	
	//@Test
       public void download_Edge() throws InterruptedException {
		
		String location= System.getProperty("user.dir")+"\\downloads\\";
		
		HashMap preferences= new HashMap();
		preferences.put("download.default_directory", location);
		
		EdgeOptions options= new EdgeOptions();
		options.setExperimentalOption("prefs", preferences);
		
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver =new EdgeDriver(options);
		
		driver.get("https://demo.automationtesting.in/FileDownload.html");
		
		driver.findElement(By.linkText("Download")).click();
		
		Thread.sleep(4000);
		
		}
	@Test
	public void download_firefox() throws InterruptedException {
		
		FirefoxProfile profile= new FirefoxProfile();
		profile.setPreference("pdfjs.disabled", true);
		profile.setPreference("browser.download.dir", location);
		
		FirefoxOptions options= new FirefoxOptions();
		
		
		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver =new FirefoxDriver(options);
		
		driver.get("https://file-examples.com/index.php/sample-documents-download/sample-doc-download/");
		
		driver.findElement(By.xpath("//tbody//tr[1]//td[5]//a[1]")).click();
		
		
		

		
		
		
		Thread.sleep(4000);
		
	}
	
}
