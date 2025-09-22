package com.Conference.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	
	
	public static  Object[][] getTestData(String filepath, String sheetname) throws IOException {
		FileInputStream fis = new FileInputStream(filepath);
		//FileInputStream fis = new FileInputStream(new File(filePath));
		XSSFWorkbook xl = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = xl.getSheet(sheetname);
		
		int totalRows = sheet.getPhysicalNumberOfRows();
		int cols = sheet.getRow(0).getLastCellNum(); // no of cells i a coloumn
		
		Object [][] data = new Object [totalRows -1][cols];
		
		for(int i=1; i<totalRows; i++) {
			XSSFRow row = sheet.getRow(i);
		//	System.out.println(row);
			for(int j=0; j<cols; j++) {
				data[i-1][j] = row.getCell(j).toString(); // for ever i & j increments arrays should be ordered
			}
		}
		return data;
	}
}
