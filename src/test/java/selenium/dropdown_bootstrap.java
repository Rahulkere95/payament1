package selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dropdown_bootstrap {

	@Test
	public void bootstarp_dropndwn(){
		
		WebDriverManager.chromedriver().setup();
		
		//ChromeOptions object
	      ChromeOptions op = new ChromeOptions();
	      //disable notification parameter
	      op.addArguments("--disable-notifications");
	      // configure options parameter to Chrome driver
	      WebDriver driver = new ChromeDriver(op);
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      driver.get("https://www.hdfcbank.com/");
	      
	    WebElement ptypedrp= driver.findElement(By.linkText("Select Product Type"));
	    // Select se=new Select(ptypedrp);                                                // dropdown without select tagname
	    // se.selectByIndex(3);
	    ptypedrp.click();
	      
	    List<WebElement> prodtypes =driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']/li"));
	    
	    System.out.println("no of types : "+prodtypes.size());
	    
//	    for(WebElement ptype:prodtypes) {                     approach1
//	    	
//	    	if(ptype.getText().equals("Accounts")) {
//	    		
//	    		ptype.click();
//	    		break;
//	    	}
//	    }                        
//                                     approach2
	    
	    selectoptionfromdropdown(prodtypes, "Accounts");
	    
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.findElement(By.xpath("//div[@class='drp2']")).click();
	    
	   List<WebElement> acctype= driver.findElements(By.xpath("//ul[@class='dropdown2 dropdown-menu']//li"));
	   System.out.println(acctype.size());
	   
//	   for(WebElement option:acctype) {
//		   
//		   if(option.getText().equals("Savings Accounts")) {
//			   option.click();
//			   break;
//		   }
//	   }
	   selectoptionfromdropdown(acctype, "Savings Accounts");
	   
	   driver.findElement(By.linkText("APPLY ONLINE")).click();
	    
	   driver.close(); //close only tab
	   
	   
	      
	}

	private void selectoptionfromdropdown(List<WebElement> options, String value ) {
		
		for(WebElement option :options) {
			
			if(option.getText().equals(value)) {
				option.click();
				break;
			}
		}
		
	}
}
