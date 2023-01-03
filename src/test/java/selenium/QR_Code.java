package selenium;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import io.github.bonigarcia.wdm.WebDriverManager;

public class QR_Code {

	@Test
	public void qr_code1() throws IOException, NotFoundException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		String qrcode_url=driver.findElement(By.xpath("//*[@id=\"HTML4\"]/div[1]/img")).getAttribute("src");
		
		URL url=new URL(qrcode_url);
		
		BufferedImage bufferimage=ImageIO.read(url);
		
		LuminanceSource luminancesource= new BufferedImageLuminanceSource(bufferimage);
		
		BinaryBitmap binarybitmap= new BinaryBitmap(new HybridBinarizer(luminancesource));
		
		Result result= new MultiFormatReader().decode(binarybitmap);
		System.out.println(result.getText());
		
	}
	
}
