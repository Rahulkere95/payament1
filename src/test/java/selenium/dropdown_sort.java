package selenium;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dropdown_sort {

	@Test
	public void dropdown_sorting() {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver= new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		WebElement dropdown=driver.findElement(By.id("animals"));
		 
		Select se= new Select(dropdown);
		
		System.out.println(dropdown.getText());
		
		List<WebElement> options =se.getOptions();
		
		ArrayList orglist=new ArrayList();
		ArrayList templist= new ArrayList();
		
		for(WebElement option:options) {
			orglist.add(option.getText());
			templist.add(option.getText());
			}
		System.out.println("original list : "+ orglist);
		System.out.println("temporary list : "+ templist);
		
		Collections.sort(templist);
		
		System.out.println("after sorting");
		System.out.println("original list : "+ orglist);
		System.out.println("temporary list : "+ templist);
		
		if(templist.equals(orglist)) {
			
			System.out.println("dropdown is Sorted");
		}
		else {
			System.out.println("dropdownis NoT sorted");
		}
		
		
	}
	
}
