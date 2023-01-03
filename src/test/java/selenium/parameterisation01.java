package selenium;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;



public class parameterisation01 {

/*getSheet(“sheetName”) – Get sheet with the given name
  getLastCellNum() – Get the index of the last cell contained in the row Plus one as index starts from ZERO
  getStringCellValue() – Get the value of the cell as a String
  getRow(int) – Returns the row.
  getCell(int) – Get the cell representing a given column
  getNumericCellValue() – Get the value of the cell as a number.
  getDateCellValue() – Get the value of the cell as a date.
  getBooleanCellValue() – Get the value of the cell as a boolean.*/	

		@Test
		static public void parameterisation() throws IOException {
		
		FileInputStream file= new FileInputStream("C:\\Users\\admin\\Documents\\test_data.xlsx");
		 
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        
        XSSFSheet sheet=workbook.getSheet("sadashiv_peth");
        
        int rowcount=sheet.getLastRowNum();
        System.out.println(rowcount);
        
        int colcount=sheet.getRow(0).getLastCellNum();
        
        System.out.println(colcount);
        
        for(int i=0; i<rowcount; i++) {
        	
        	XSSFRow currentrow=sheet.getRow(i);   // focus on current row
        	for(int j=0; j<colcount;j++) {
        		String value=currentrow.getCell(j).toString();
        		System.out.print(" "+ value);
        	}
        	
        	System.out.println();
        	
        	
        }
        
       }
		
		

}
