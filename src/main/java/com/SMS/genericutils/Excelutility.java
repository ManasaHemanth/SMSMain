package com.SMS.genericutils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.commons.collections4.iterators.ObjectArrayIterator;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Excelutility {

	public String readExcelData(String sheetName, int rowNo,int cellNo) throws EncryptedDocumentException, FileNotFoundException, IOException
	{
		Workbook wb=WorkbookFactory.create(new FileInputStream(IpathConstants.excelPath));
	Sheet sh = wb.getSheet(sheetName);
	Row row = sh.getRow(rowNo);
	Cell cell = row.getCell(cellNo);
	cell.toString();
	return sheetName;
	
	}
	/**
	 * This method will fetch count rows created in excelsheet
	 * @param sheetname
	 * @param row
	 * @param cellno
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws EncryptedDocumentException 
	 */

	public int getrowCount(String sheetname) throws EncryptedDocumentException, FileNotFoundException, IOException {
		Workbook wb=WorkbookFactory.create(new FileInputStream(IpathConstants .excelPath));
		Sheet sh=wb.getSheet(sheetname);
		 int row=sh.getLastRowNum();
		return row;
	}
	/**
	 * This method will used to write data into excelsheet
	 * @param sheetname
	 * @param rowno
	 * @param cellno
	 * @param value
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws EncryptedDocumentException 
	 */
	public void writeDataInExcelSheet(String sheetname,int rowno,int cellno,String value) throws EncryptedDocumentException, FileNotFoundException, IOException
	{
	Workbook wb=WorkbookFactory.create(new FileInputStream(IpathConstants.excelPath));
	Sheet sh = wb.getSheet(sheetname);
	Row row = sh.createRow(rowno);
	Cell cell = row.createCell(cellno);
	cell.setCellValue(value);
	FileOutputStream fos=new FileOutputStream(IpathConstants.excelPath);
	wb.write(fos);
	wb.close();
	
}
public HashMap<String,String> getMultipleDataFromExcel(String sheetname,int keyColumn,int valueColumn, WebDriver driver, JavaUtility jlib) throws EncryptedDocumentException, IOException
{
   FileInputStream fis=new FileInputStream(IpathConstants.excelPath);
	Workbook wb=WorkbookFactory.create(fis);
	
	Sheet sh = wb.getSheet(sheetname);
	int count=sh.getLastRowNum();
	HashMap<String,String> map= new HashMap<String,String>();
	for(int i=1;i<=count;i++) {
		String key=sh.getRow(i).getCell(keyColumn).getStringCellValue();
		String value=sh.getRow(i).getCell(valueColumn).getStringCellValue();
		map.put(key, value);
	}
	
	return map;
}
//dataprovider
public Object[][] getMultiplesetofData(String sheetName) throws Throwable, FileNotFoundException, IOException
{
	Workbook wb=WorkbookFactory.create(new FileInputStream(IpathConstants.excelPath));
Sheet sh = wb.getSheet(sheetName);
int lastrow = sh.getLastRowNum();
int lastcell = sh.getRow(0).getLastCellNum();
Object[][] obj=new Object[lastrow+1][lastcell];
for(int i=0;i<=lastrow;i++) {
	for(int j=0;j<lastcell;j++) 
	{
		obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
	}
}
return obj;


}

}
