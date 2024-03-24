package com.ws.utils;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * Title : ExcelUtil
 * Description : ExcelUtil class which contains elements and it's methods
 * Developed By : Farheen
 * Email Id : Farheen@gmail.com
 * Developed Date : 03/22/2024
 * Reviewed By : 
 * Approved By :  
 */

public class ExcelUtil {
	XSSFWorkbook wb ;
	
	/*
	 * This constructor is used to load the Excel sheet
	 */
	public ExcelUtil(String excelpath) {
		try 
		{
			File file = new File(excelpath);
			FileInputStream fis = new FileInputStream(file);     //to take values/data from Excel sheet
			wb = new XSSFWorkbook();
		}
		catch (Exception e)          //handle exception
		{ 
			System.out.println("Unable to read the Excel sheet. Please check!");
			e.printStackTrace();
		}
	}
	/*
	 * This method is used to retrieve active row count
	 */
	public int getRowCount(int SheetNo) {
		int count = wb.getSheetAt(SheetNo).getLastRowNum()+1 ;
		return count ;
	}
	/*
	 * This method is used to retrieve data from cell
	 */
	public String getCellData(int sheetNo, int row, int cell) {
		String data = wb.getSheetAt(sheetNo).getRow(row).getCell(cell).toString();
		return data ;
	}
}
