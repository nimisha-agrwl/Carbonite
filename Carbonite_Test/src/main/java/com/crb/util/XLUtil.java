package com.crb.util;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtil {


	public static FileInputStream fis;
	public static XSSFWorkbook workBook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static String[][] getData(String fileName,String sheetName) throws IOException{

		 fis = new FileInputStream(fileName);
		 workBook = new XSSFWorkbook(fis);
		 sheet = workBook.getSheet(sheetName);
		// XSSFSheet sheet = workBook.getSheetAt(0) //1st sheet
		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();
		String data[][] = new String[rowCount][colCount];
		String cellData="";

		for(int i=1 ; i<=rowCount ; i++) {
			 row= sheet.getRow(i);
			for(int j=0;j<colCount;j++) {
				//	System.out.print(row.getCell(j).getStringCellValue()+"  ");
				cell = row.getCell(j);
				try {
					DataFormatter formatter = new DataFormatter();
		            cellData = formatter.formatCellValue(cell);
		           }
				catch (Exception e) 
				{
					cellData="";
				}
				data[i-1][j]=cellData;
			}
			
		}
		
		workBook.close();
		fis.close();
		
		return data;
	}

	



}
