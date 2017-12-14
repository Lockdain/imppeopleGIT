package ru.lockdain.imppeople;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *  ласс дл€ парсинга XSSF книг
 * @author Alexander Sergeenko
 * @version 1.0
 */
public class ReadSheet {

	private static XSSFRow row;
	
	/**
	 * —читывает содержимое книги в консоль
	 * @param workbookPath
	 * @throws IOException 
	 * 
	 */
	public static void getConsoleDataFromWorkbook(String workbookPath) throws IOException {
		
		FileInputStream fis = new FileInputStream(new File(workbookPath));
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet spreadsheet = workbook.getSheetAt(0);
		
		Iterator < Row > rowIterator = spreadsheet.iterator();
		System.out.println("INFO: xlsx parser output: ");
		while(rowIterator.hasNext()) {
			
			row = (XSSFRow) rowIterator.next();
			Iterator < Cell > cellIterator = row.cellIterator();
			
			while(cellIterator.hasNext()) {
				
				Cell cell = cellIterator.next();
				
				switch (cell.getCellType()) {
				
				case Cell.CELL_TYPE_NUMERIC:
					System.out.println(cell.getNumericCellValue() + " \t\t ");
					break;
					
				case Cell.CELL_TYPE_STRING:
					System.out.println(cell.getStringCellValue() + " \t\t ");
					break;
					
				}
			}
			
			System.out.println();
		}
		
		fis.close();
		
		
	}
	
}
