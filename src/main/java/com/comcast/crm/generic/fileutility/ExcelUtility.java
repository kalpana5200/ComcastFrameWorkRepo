package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import interfaceiconstant.Iconstant;

public class ExcelUtility {
	String path=Iconstant.excelpath;
	public String getDataFromExcel(String sheetName,int row,int cell) throws Throwable {
		FileInputStream fis=new FileInputStream(path);
		DataFormatter df=new DataFormatter();
		Workbook book=WorkbookFactory.create(fis);
		String data=df.formatCellValue(book.getSheet(sheetName).getRow(row).getCell(cell));
		book.close();
		return data;
	}
	public int getRowCount(String sheetName) throws Throwable {
		FileInputStream fis=new FileInputStream(path);
		Workbook book=WorkbookFactory.create(fis);
		int rowcount=book.getSheet(sheetName).getLastRowNum();
		book.close();
       return rowcount;		
   }
	public int getCellCount(String sheetName) throws Throwable {
		FileInputStream fis=new FileInputStream(path);
		Workbook book=WorkbookFactory.create(fis);
		int rowcount=book.getSheet(sheetName).getRow(0).getLastCellNum();
		book.close();
       return rowcount;		
   }
	public void setDataIntoExcel(String sheetName,int row,int cell,String value) throws Throwable {
		FileInputStream fis=new FileInputStream(path);
		Workbook book=WorkbookFactory.create(fis);
		book.getSheet(sheetName).getRow(row).createCell(cell).setCellValue(value);;
		
		FileOutputStream fos=new FileOutputStream(path);
		book.write(fos);
		book.close();
	}
	
}
