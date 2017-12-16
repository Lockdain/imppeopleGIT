package ru.lockdain.imppeople.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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
		Document doc = analyzer.getDOMDocumentFromXML("C:\\Java\\workspace\\imppeople\\xml\\inputList.xml");
		//Рекурсивно идем по дереву документа и ищем значения интересующих узлов
		analyzer.stepThroughDomDoc(doc.getDocumentElement(), "position");
		
		List <String> resultList = new ArrayList<>();
		
		resultList = analyzer.getResultList();
		
		for (String iter : resultList) {
			System.out.println(iter);
		}
	}

}
