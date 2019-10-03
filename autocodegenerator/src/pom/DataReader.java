package pom;

import java.io.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class DataReader {
	
	public static final String EXCELFILELOCATION = "C:\\Users\\shubh\\git\\Auto-Code-Generator\\autocodegenerator\\src\\pom\\Auto-Code-Generator Excel.xlsx";
	private static FileInputStream fis;
	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	static DataFormatter formatter = new DataFormatter();
	static String locator,elementType,elementName;
	
	public static void dataProviderMethod() throws IOException{
		
		File file = new File(EXCELFILELOCATION);
		fis = new FileInputStream(file);
		workbook = new XSSFWorkbook(fis);
		
		sheet = workbook.getSheetAt(0);
		int rowcount = sheet.getLastRowNum();
		PageGenerator page = new PageGenerator();
		
		//For creating elements in page
		for(int i = 0; i < rowcount; i ++ ) 
		{
			locator = formatter.formatCellValue(sheet.getRow(i + 1).getCell(0));
			elementName = formatter.formatCellValue(sheet.getRow(i + 1).getCell(1));
			page.elementPathCreation(locator, elementName);
		}
		
		//For creating methods in page
		for(int i = 0; i < rowcount; i ++ ) 
		{
			elementName = formatter.formatCellValue(sheet.getRow(i + 1).getCell(1));
			elementType = formatter.formatCellValue(sheet.getRow(i + 1).getCell(2));
			page.methodCreation(elementName, elementType);
		}
		
		//For creating method to read from JSON in page 
		for(int i = 0; i < rowcount; i ++ ) 
		{
			elementName = formatter.formatCellValue(sheet.getRow(i + 1).getCell(1));
			elementType = formatter.formatCellValue(sheet.getRow(i + 1).getCell(2));
			page.elementValueCreation(elementName.substring(0, 1).toLowerCase() + elementName.substring(1));
		}
		
		//For calling methods in page
		for(int i = 0; i < rowcount; i ++ ) 
		{
			elementName = formatter.formatCellValue(sheet.getRow(i + 1).getCell(1));
			elementType = formatter.formatCellValue(sheet.getRow(i + 1).getCell(2));
			page.pageCreation(elementName,elementType);
		}
		
		page.fileData();
	}
	
	public static void main (String args[]) throws IOException {
		dataProviderMethod();
	}
}
