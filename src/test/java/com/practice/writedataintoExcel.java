package com.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class writedataintoExcel {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\testdata45.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		  sh.createRow(10).createCell(0).setCellValue("BMW");//add data into row 10
		  sh.getRow(10).createCell(1).setCellValue("bangalore");//add data into cell 1
		  FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\testdata45.xlsx");
		  wb.write(fos);
		  wb.close();

	}

}
