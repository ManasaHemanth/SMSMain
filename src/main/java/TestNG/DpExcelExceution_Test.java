package TestNG;

import org.testng.annotations.Test;

public class DpExcelExceution_Test {
	@Test(dataProviderClass = DataProviderExcel_Test.class,dataProvider = "getDataFromExcel")
	
	public void exceuteMethod(String brand,String price,String size)
	{
	
		System.out.println(brand+" "+price+" "+size);
	}
}
