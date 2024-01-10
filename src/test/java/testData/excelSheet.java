package testData;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class excelSheet {
	
	
	public static Workbook book;
	public static Sheet sheet;

	public static String[][] readdata(String sheetname) throws NumberFormatException
	{
		
		FileInputStream file=null;
		try {
			file=new FileInputStream("C:\\Users\\mohan\\eclipse-workspace\\PetStoreAutomationAPI\\src\\test\\java\\testData\\Book1.xlsx");
			
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			book=WorkbookFactory.create(file);
		}
		catch(IOException a) {
			a.printStackTrace();
		}
		
		sheet=book.getSheet(sheetname);
		
		String[][] apidata=new String[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		
		for(int i=0;i<sheet.getLastRowNum();i++) {
			
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++) {
				
				DataFormatter formatter=new DataFormatter();
				try {
				apidata[i][k]=formatter.formatCellValue(sheet.getRow(i+1).getCell(k));
				}catch(NumberFormatException e) {
					
					e.printStackTrace();
				}
				
			}
			
		}
		return apidata;

}
	
	
	
	
	
	
	
	public static String[] readusername(String sheetname) throws NumberFormatException
	{
		
		FileInputStream file=null;
		try {
			file=new FileInputStream("C:\\Users\\mohan\\eclipse-workspace\\PetStoreAutomationAPI\\src\\test\\java\\testData\\Book1.xlsx");
			
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			book=WorkbookFactory.create(file);
			
		}
		catch(IOException a) {
			a.printStackTrace();
		}
		
		sheet=book.getSheet(sheetname);
		
		String[] usernames=new String[sheet.getLastRowNum()];
		
		
		
		
		for(int i=0;i<sheet.getLastRowNum();i++) {
			
			
				
				DataFormatter formatter=new DataFormatter();
				try {
					usernames[i]=formatter.formatCellValue(sheet.getRow(i+1).getCell(1));
				}catch(NumberFormatException e) {
					
					System.out.println("exception handled");
				}
				
			}
			
		
		return usernames;
}
}
