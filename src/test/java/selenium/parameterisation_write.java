package selenium;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class parameterisation_write {

	@Test
	public void write_data() throws IOException {
		
		FileOutputStream file= new FileOutputStream("C:\\Users\\admin\\Documents\\test_resourse\\test_data1.xlsx");
		XSSFWorkbook workbook= new XSSFWorkbook();
		
		XSSFSheet sheet1=workbook.createSheet("data1");
		XSSFSheet sheet2=workbook.createSheet("data2");
		
		for(int i=0;i<5;i++) {
			
			XSSFRow currentrow= sheet1.createRow(i);
			XSSFRow currentro2= sheet2.createRow(i);
			for(int j=0; j<3; j++) {
				
				currentrow.createCell(j).setCellValue("rahul");
				currentro2.createCell(j).setCellValue("akash");
				
			}
		}
		
		workbook.write(file);
		file.close();
		
	}
}
