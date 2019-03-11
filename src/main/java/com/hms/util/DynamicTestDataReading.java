package com.hms.util;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DynamicTestDataReading {

	Map<String, List<Map<String, String>>> testCasesWithSamples = new LinkedHashMap<String, List<Map<String, String>>>();

	/*public static void main(String[] args) throws Exception {
		DynamicTestDataReading dtd = new DynamicTestDataReading();
		dtd.testDataReading("G:\\test data\\login.xlsx", "login","sanity");
		System.out.println(dtd.testCasesWithSamples);
	}*/

	public Map<String, List<Map<String, String>>> testDataReading
	(String excelPath, String sheetName,String testDataType) throws Exception {
		// String filePath = "G:\\test data\\login.xlsx";
		Workbook book = null;
		Sheet sheet = null;
		System.out.println(sheetName+"  "+testDataType+"  "+excelPath);
		FileInputStream fis = new FileInputStream(excelPath);
		if (excelPath.endsWith("xlsx")) {
			book = new XSSFWorkbook(fis);
		} else if (excelPath.endsWith("xls")) {
			book = new HSSFWorkbook(fis);
		}
		sheet = book.getSheet(sheetName);

		List<String> headerList = null;
		List<String> dataList = null;
		Map<String, String> testCasesample = null;
		List<Map<String, String>> testCaseWithSamples = null;

		for (Row row : sheet) {
			if (row.getCell(0).toString().startsWith("Header")) {
				headerList = new ArrayList<String>();
				testCaseWithSamples = new ArrayList<Map<String, String>>();
				for (Cell cell : row) {
					headerList.add(cell.toString());
				}

			} else {
				dataList = new ArrayList<String>();
				for (Cell cell : row) {
					dataList.add(cell.toString());
				}
				testCasesample = new LinkedHashMap<String, String>();

				for (int i = 0; i < headerList.size(); i++) {
					testCasesample.put(headerList.get(i), dataList.get(i));
				}
				
				if(dataList.get(2).equalsIgnoreCase(testDataType) || testDataType.isEmpty()){
				testCaseWithSamples.add(testCasesample);
				}

				if (testCasesWithSamples.get(dataList.get(0)) == null && dataList.get(2).equalsIgnoreCase(testDataType)
				||testDataType.isEmpty()) {
					testCasesWithSamples.put(dataList.get(0), testCaseWithSamples);
				}

			}

		}
		return testCasesWithSamples;
	}

}
