package ru.lockdain.imppeople;

import java.io.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.*;

import ru.lockdain.imppeople.utils.FileChecker;

/** Класс содержит инструменты для работы с XSSF книгами
 * с помощью Apache POI
 * @author Alexander Sergeenko
 * @version 1.0
*/
public class WorkbookTools {
	
	 /** Создает пустой файл книги
     * @param workBookName - имя и путь к книге
     * @return workbook - книга XSSFWorkbook
    */
	
	public XSSFWorkbook createWorkbookFile(String workBookName) throws IOException {
		
		//Создаем пустую книгу
		XSSFWorkbook workbook = new XSSFWorkbook();
		FileOutputStream out = new FileOutputStream(new File(workBookName));
		
		//Записываем поток
		workbook.write(out);
		out.close();
		
		return workbook;
		
	}
	
	/** Создает пустой файл книги
     * @param workBookName - имя и путь к книге
     * @return workbook - книга XSSFWorkbook
     * @deprecated
    */
	public XSSFWorkbook createWorkbook(String workBookName) throws IOException {
		
		XSSFWorkbook workbook = new XSSFWorkbook(workBookName);
		
		return workbook;
	}
	
	/** Создает новую книгу и лист
     * @param sheetName - имя листа
     * @return workbook - книга XSSFWorkbook
    */
	public static XSSFWorkbook createWorkbookWithSheet(String sheetName) throws IOException {
		
		//Создаем пустую книгу
		XSSFWorkbook workbook = new XSSFWorkbook();
				
		//Создаем новый лист
		XSSFSheet spreadsheet =	workbook.createSheet(sheetName);
		
		return workbook;
	}
	/**
	 * Создает новую ячейку таблицы
	 * @param workbook
	 * @param cellIndex
	 * @param sheetIndex
	 * @param rowIndex
	 * @return cell
	 */
	public XSSFCell createCell(XSSFWorkbook workbook, int cellIndex, int sheetIndex, int rowIndex) {
		
		XSSFSheet spreadsheet = workbook.getSheetAt(sheetIndex);
		XSSFRow row = spreadsheet.createRow(rowIndex);
		
		XSSFCell cell = row.createCell(cellIndex);
		
		return cell;
		
		
	}
	
	/** Сохраняет книгу в заданный файл на диске.
     * @param workBookPath - имя и путь к книге
     * @param workbook - книга XSSFWorkbook
    */
	public void saveWorkbookToFile(XSSFWorkbook workbook, String workBookPath) throws IOException {
		
		FileChecker fCheck = new FileChecker();
		if (fCheck.isFileExists(workBookPath)) {
			System.out.println("ERROR: Can't create the file " + workBookPath + ". The file is already exists");
			return;
		}
		
		//Создаем пустую книгу
		FileOutputStream out = new FileOutputStream(new File(workBookPath));
				
		//Проверяем, не был ли файл с таким именем создан ранее
		
		
		//Записываем поток
		workbook.write(out);
		out.close();
		
		System.out.println("INFO: The workbook " + workBookPath + " has been created successfully");
				
		}

}
