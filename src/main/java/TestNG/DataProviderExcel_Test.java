package TestNG;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.SMS.genericutils.Excelutility;
import com.SMS.genericutils.IpathConstants;

public class DataProviderExcel_Test {
	@Test(dataProvider = "datafromExcel")
	public void getData(String brand,String price,String size) 
	{
		System.out.println(brand+" "+price+" "+size);
	}
	
	
@DataProvider
public Object[][] getDataFromExcel() throws Throwable {
	FileInputStream fis=new FileInputStream(IpathConstants.excelPath);
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("Sheet3");
	int lastrow = sh.getLastRowNum();
	int lastcell = sh.getRow(0).getLastCellNum();
	
	Object[][] obj = new Object[lastrow+1][lastcell];
	for(int i=0;i<=lastrow;i++) {
		for(int j=0;j<lastcell;j++) {
			obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
		}
		
	}
	return obj;
}
@DataProvider
public Object[][] datafromExcel() throws Throwable, IOException, Throwable
{
	Excelutility elib=new Excelutility();
	Object[][] value = elib.getMultiplesetofData("Sheet3");
	return value;
}

}

