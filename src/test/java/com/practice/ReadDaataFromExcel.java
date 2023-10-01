package com.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDaataFromExcel {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\testdata45.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		int count = sh.getLastRowNum();
		int lastcell = sh.getRow(1).getLastCellNum();
		
		for(int i=1;i<=count;i++) 
		{
			for(int j=0;j<lastcell;j++) 
			{
				String value = sh.getRow(i).getCell(j).getStringCellValue();
				System.out.print(value+"     ");
			}
			System.out.println();
		}
		

	}

}
