package selenium;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openxmlformats.schemas.presentationml.x2006.main.STIndex;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class parametersation_regi extends baseclass_param {

	@Test
	public void registration() throws IOException, InterruptedException {
		
	WebDriverManager.chromedriver().setup();
		
		//ChromeDriver driver= new ChromeDriver();
		
		//driver.get("https://demo.guru99.com/test/newtours/");
		
		FileInputStream file=new FileInputStream("C:\\Users\\admin\\Documents\\test_resourse\\test_data.xlsx");
		
		XSSFWorkbook workbook= new XSSFWorkbook(file);
		XSSFSheet sheet= workbook.getSheet("reg_data");
		
	    int rowcount=sheet.getLastRowNum();
		int colcount=sheet.getRow(0).getLastCellNum();
		System.out.println("total no of rows"+rowcount);
		System.out.println("total no of collumn"+colcount);
		
		for(int i=0;i<rowcount; i++) {
			
			XSSFRow currentrow=sheet.getRow(i);
			for(int j=0; j<colcount; j++) {
				
				String value=  currentrow.getCell(j).toString();
				System.out.print(" "+ value);
				
			}System.out.println();
			
		}
		
		for(int row=1; row<rowcount; row++) {
			
			XSSFRow current_row=sheet.getRow(row);
			String First_name = current_row.getCell(0).toString();
			String last_name= current_row.getCell(1).toString();
			int phone_no=(int) current_row.getCell(2).getNumericCellValue();
			String email_id= current_row.getCell(3).toString();
			String address= current_row.getCell(4).toString();
			String city= current_row.getCell(5).toString();
			String state= current_row.getCell(6).toString();
			String postal_code= current_row.getCell(7).toString();
			String county= current_row.getCell(8).toString();
			String username= current_row.getCell(9).toString();
			String password= current_row.getCell(10).toString();
			
			
		
		 
		// entering contact details
			driver.findElement(By.xpath("//a[@href='register.php']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(First_name);
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(last_name);
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(String.valueOf(phone_no));
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys(email_id);
		Thread.sleep(4000);
		//scrolldown
	    WebElement ele=driver.findElement(By.xpath("//input[@name='submit']"));
	    JavascriptExecutor js= (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView();", ele);
	    
		driver.findElement(By.xpath("//input[@name='address1']")).sendKeys(address);
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys(city);
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys(state);
		driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys(postal_code);
		//dropdown
		Select dropdown= new Select(driver.findElement(By.xpath("//select[@name='country']")));
		dropdown.selectByValue(county);
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys(county);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='confirmPassword']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		Thread.sleep(4000);
		}
		}
	@Test
	public void verify_regi() throws InterruptedException {
		
		/*WebElement webelement=driver.findElement(By.xpath("//font[@face='Arial, Helvetica, serifsans-serif']"));
		String login_msg="Arial, Helvetica, sans-serif";
		
		if(webelement.isDisplayed()) {
			
			System.out.println("user registered successfully");
		}
		
		else {
			System.out.println("user unsuccessfull to register");
		}*/
		
			driver.manage().window().maximize();
			Thread.sleep(4000);
			
			//Take the screenshot
	        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        
	        //Copy the file to a location and use try catch block to handle exception
	        try {
	            FileUtils.copyFile(screenshot, new File("C:\\Users\\admin\\Documents\\test_resourse\\screenshot\\registred.png"));
	        } 
	        catch (IOException e) {
	            System.out.println(e.getMessage());
	        }
	        
	        String exp_title= driver.getTitle();
	        String act_title= exp_title;
	        
	        Assert.assertEquals(exp_title, act_title);
	        
	        			
		}
	}
	
	

