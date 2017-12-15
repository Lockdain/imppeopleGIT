package ru.lockdain.imppeople.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import ru.lockdain.imppeople.ReadSheet;
import ru.lockdain.imppeople.WorkbookTools;
import ru.lockdain.imppeople.WriteSheet;
import ru.lockdain.imppeople.utils.Analyzer;
import ru.lockdain.imppeople.utils.FileChecker;

public class Main {

	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
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
		
		//Test XML parser
		//Test node <position> read from file
		Analyzer analyzer = new Analyzer();
		Document doc = analyzer.getDocumentFromXML("C:\\Java\\workspace\\imppeople\\xml\\inputList.xml");
		System.out.println("1111 " + doc.getFirstChild());
		
		List<String> list = new ArrayList<>();
		list = analyzer.getPositionsMap(doc);
		
		Object[] output = list.toArray();
		System.out.println("OUTPUT length is: " + output.length);
		System.out.println("list values are: ");
		
		for(Object me : output) {
			System.out.println(me.toString());
			
		}
		
	}

}
