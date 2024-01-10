package apiUtilities;

import org.testng.annotations.DataProvider;

import testData.excelSheet;

public class dataproviders {
	
	@DataProvider(name="alldata")
	public String[][] getAlldata()
	
	{
		
		String[][] data=excelSheet.readdata("sheet1");
		return data;
		
		
	}
	
	@DataProvider(name="usernames")
	public String[] getuserName()
	{
		String Uname[]=excelSheet.readusername("sheet1");
		
		
		return Uname;
	}

}
