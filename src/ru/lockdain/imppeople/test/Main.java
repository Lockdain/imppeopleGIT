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
import ru.lockdain.imppeople.utils.XmlAnalyzer;
import ru.lockdain.imppeople.utils.FileChecker;

public class Main {

	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
		// TODO Auto-generated method stub
		WriteSheet ws = new WriteSheet();
		XSSFWorkbook workbook = new XSSFWorkbook();
		WorkbookTools wbTools = new WorkbookTools();
		
		//��������� ����� �������
		workbook = ws.fillSpreadsheet();
		
		//��������� ����� � ����
		wbTools.saveWorkbookToFile(workbook, "test.xlsx");
		
		//FileChecker fCheck = new FileChecker();
		//fCheck.isFileExists("test.xlsx");
		
		ReadSheet.getConsoleDataFromWorkbook("test.xlsx");
		
		wbTools.createCell(workbook,(short) 0, (short) 0, (short) 0);
		wbTools.saveWorkbookToFile(workbook, "1.xlsx");
		
		//Test XML parser
		//Test node <position> read from file
		XmlAnalyzer analyzer = new XmlAnalyzer();
		Document doc = analyzer.getDOMDocumentFromXML("C:\\Java\\workspace\\imppeople\\xml\\inputList.xml");
		//���������� ���� �� ������ ��������� � ���� �������� ������������ �����
		analyzer.stepThroughDomDoc(doc.getDocumentElement(), "position");
		
		List <String> resultList = new ArrayList<>();
		
		resultList = analyzer.getResultList();
		
		//����� ������ ����������
		for (String iter : resultList) {
			System.out.println(iter);
		}
		//���� ������ ������������
		ArrayList<String> test = new ArrayList<>();
		test.add("FfffFFfSdFgGH");
		test.add("ddd//DDDDddSFggE");
		
		ArrayList<String> result = new ArrayList<>();
		
		result = WorkbookTools.normalizeArrayOfString(test);
		
		//����� ������ �� ������
		int i = 0;
		for(String curr : result) {
			i++;
			System.out.println(i + " " + curr);
		}
		
		ReadSheet rs = new ReadSheet();
		rs.getConsoleDataFromWorkbook("positions_test.xlsx");
		
		System.out.println("������ " + rs.findTextOccurencesQuantity("positions_test.xlsx", "������", "�������-��������"));
		
		}
	}


