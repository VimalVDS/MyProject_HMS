package com.corejava;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReading {

	public static void main(String[] args) throws Exception {

		String filePath = "G:\\test data\\login.xlsx";
		Workbook book = null;
		Sheet sheet = null;

		FileInputStream fis = new FileInputStream(filePath);

		if (filePath.endsWith("xlsx")) {
			book = new XSSFWorkbook(fis);
		} else if (filePath.endsWith("xls")) {
          book=new HSSFWorkbook(fis);
		}
		sheet=book.getSheet("credentials");
		Row row=sheet.getRow(0);
		System.out.println(row.getCell(0));
		System.out.println(row.getCell(1));
		System.out.println(row.getCell(2));
		
		for(Row row1:sheet){
			
			for (Cell cell : row1) {
				System.out.print(cell.toString()+" ");
			}
			System.out.println();
		}
		
		
		
		
		
		
		
		
		
		
		

	}

}
