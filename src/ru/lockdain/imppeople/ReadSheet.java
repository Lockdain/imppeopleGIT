package ru.lockdain.imppeople;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Класс для парсинга XSSF книг
 * @author Alexander Sergeenko
 * @version 1.0
 */
public class ReadSheet {

	private static XSSFRow row;
	
	/**
	 * Считывает содержимое книги в консоль
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
	
	/**
	 * Возвращает количество вхождений заданной специальности из XLS-файла
	 * @param pathToXls
	 * @return
	 * @throws IOException 
	 */
	@SuppressWarnings("deprecation")
	public int findTextOccurencesQuantity(String pathToXls, String sheetName, String wordToSearch) throws IOException{
		
		ArrayList<String> outputTextArray= new ArrayList<String>();
		
		//Работа с файлом таблицы
		FileInputStream fis = new FileInputStream(new File(pathToXls));
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet spreadsheet = workbook.getSheet(sheetName);
		
		//Проходим итератором по столбцам и строкам таблицы
		Iterator < Row > rowIterator = spreadsheet.iterator();
		while(rowIterator.hasNext()) {
			
			row = (XSSFRow) rowIterator.next();
			Iterator <Cell> cellIterator = row.cellIterator();
			
			while(cellIterator.hasNext()) {
				
				Cell cell = cellIterator.next();
				
				//Среди строковых ячеек ищем ту, что подходит под параметр поиска
				if(cell.getCellType() == Cell.CELL_TYPE_STRING) {
					
					if (cell.getStringCellValue().toLowerCase().equals(wordToSearch.toLowerCase())){
						
						outputTextArray.add(cell.getStringCellValue().toLowerCase());
						
					}
				}
			}
			
		}
		
		fis.close();
		
		return outputTextArray.size();
		
		
	}
	
}
