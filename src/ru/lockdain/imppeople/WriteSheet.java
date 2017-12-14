package ru.lockdain.imppeople;

import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/** Класс для наполнения книги данными
 * с помощью <b>Apache POI</b>
 * @author Alexander Sergeenko
 * @version 1.0
*/
public class WriteSheet {

	 /** Заполняет книгу значениями
     * @return <b>workbook</b> - книга XSSFWorkbook
    */
		public XSSFWorkbook fillSpreadsheet() throws IOException {
			//Создаем новую книгу с листом
			WorkbookTools wb = new WorkbookTools();
			XSSFWorkbook workbook = wb.createWorkbookWithSheet("info");
			XSSFSheet spreadsheet = workbook.getSheet("info");
			//Переменная строки
			XSSFRow row;
			
			//Данные для записи в таблицу
			Map < String, Object[] > empinfo = new TreeMap <String, Object[] >();
			empinfo.put("1", new Object[] {"ID", "Name", "Designation"});
			empinfo.put("2", new Object[] {"ID01", "Pete", "Director"});
			empinfo.put("3", new Object[] {"ID02", "Alex", "Assasin"});
			empinfo.put("4", new Object[] {"ID03", "Surge", "Fool"});
			empinfo.put("5", new Object[] {"ID04", "Bezel", "Master"});
			empinfo.put("6", new Object[] {"ID05", "Man", "Director"});
			empinfo.put("7", new Object[] {"ID06", "Fooler", "Engineer"});
			
			//Цикл по данным и запись в таблицу
			Set < String > keyid = empinfo.keySet();
			int rowid = 0;
			
			for (String key : keyid) {
				row = spreadsheet.createRow(rowid++);
				Object [] objectArr = empinfo.get(key);
				
				int cellid = 0;
				
				for (Object obj : objectArr) {
					Cell cell = row.createCell(cellid++);
					cell.setCellValue(obj.toString());
				}
			}
			
			///wb.saveWorkbookToFile(workbook, "test.xlsx");
			return workbook;
		}
}
