package ru.lockdain.imppeople.test;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import ru.lockdain.imppeople.ReadSheet;
import ru.lockdain.imppeople.WorkbookTools;
import ru.lockdain.imppeople.WriteSheet;
import ru.lockdain.imppeople.utils.FileChecker;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WriteSheet ws = new WriteSheet();
		XSSFWorkbook workbook = new XSSFWorkbook();
		WorkbookTools wbTools = new WorkbookTools();
		
		//Заполняем книгу данными
		workbook = ws.fillSpreadsheet();
		
		//Сохраняем книгу в файл
		wbTools.saveWorkbookToFile(workbook, "test.xlsx");
		
		//FileChecker fCheck = new FileChecker();
		//fCheck.isFileExists("test.xlsx");
		
		ReadSheet.getConsoleDataFromWorkbook("test.xlsx");
		
		wbTools.createCell(workbook,(short) 0, (short) 0, (short) 0);
		wbTools.saveWorkbookToFile(workbook, "1.xlsx");
		
	}

}
