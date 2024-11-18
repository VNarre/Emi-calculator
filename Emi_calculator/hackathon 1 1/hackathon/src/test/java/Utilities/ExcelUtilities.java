package Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	
	XSSFSheet sheet;
	

	public static void write1(String sheetName, int rownum, int colnum, String data) throws IOException {
		 
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\TestData\\Excel.xlsx");
		 
		XSSFWorkbook book=new XSSFWorkbook(file);

 
		//Creating the sheet if it does not exist
 
		if(book.getSheetIndex(sheetName)==-1) {
 
			book.createSheet(sheetName);              
 
		}
 
		XSSFSheet sheet=book.getSheet(sheetName);
//		System.out.println(sheet);
 
		if(sheet.getRow(rownum)==null)
 
		{
 
			sheet.createRow(rownum);
 
		}
 
		XSSFRow row =sheet.getRow(rownum);   
 
		// Creating cell
		
 
		XSSFCell cell=row.createCell(colnum);
 
		//Setting the data in the column
 
		cell.setCellValue(data);
		
		FileOutputStream fo=new FileOutputStream(System.getProperty("user.dir")+"\\TestData\\Excel.xlsx");
 
		book.write(fo);
 
		book.close();
 
		file.close();
 
		fo.flush();
 
		fo.close();
 
 
		
	}

}
