package com.utill;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.model.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.TestBase.TestBase;

public class Utility extends TestBase {
	public static long PAGE_LOAD_TIME_OUT = 3;
	public static long IMPLECITELY_WAIT_TIME = 3;

	// use for DataProvider
	public static String TESTDATA_SHEET_PATH = "/Users/khosruzzaman/Desktop/"
			+ "NEW_PROJECTS/PNT_CLASS/MulticartAutomationSuit/TEST_DATA/NewUsers.xlsx";
	public static XSSFWorkbook book;
	public static XSSFSheet sheet;
	public static FileInputStream file;

	public static Object[][] getTestData(String sheetName) {
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		
		book = XSSFWorkbook.class.cast(file);
		
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		System.out.println(sheet.getLastRowNum() + " ====== " + sheet.getRow(1).getFirstCellNum());

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j] = sheet.getRow(i + 1).getCell(0).toString();
				System.out.println(data[i][j] + " ");

			}
		}
		return data;
	}

	public static WebElement selectClass(WebElement value) {
		Select select = new Select(value);
		return value;

	}

}
