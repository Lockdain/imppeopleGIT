package ru.lockdain.imppeople;

import java.io.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.*;

import ru.lockdain.imppeople.utils.FileChecker;

/** ����� �������� ����������� ��� ������ � XSSF �������
 * � ������� Apache POI
 * @author Alexander Sergeenko
 * @version 1.0
*/
public class WorkbookTools {
	
	 /** ������� ������ ���� �����
     * @param workBookName - ��� � ���� � �����
     * @return workbook - ����� XSSFWorkbook
    */
	
	public XSSFWorkbook createWorkbookFile(String workBookName) throws IOException {
		
		//������� ������ �����
		XSSFWorkbook workbook = new XSSFWorkbook();
		FileOutputStream out = new FileOutputStream(new File(workBookName));
		
		//���������� �����
		workbook.write(out);
		out.close();
		
		return workbook;
		
	}
	
	/** ������� ������ ���� �����
     * @param workBookName - ��� � ���� � �����
     * @return workbook - ����� XSSFWorkbook
     * @deprecated
    */
	public XSSFWorkbook createWorkbook(String workBookName) throws IOException {
		
		XSSFWorkbook workbook = new XSSFWorkbook(workBookName);
		
		return workbook;
	}
	
	/** ������� ����� ����� � ����
     * @param sheetName - ��� �����
     * @return workbook - ����� XSSFWorkbook
    */
	public static XSSFWorkbook createWorkbookWithSheet(String sheetName) throws IOException {
		
		//������� ������ �����
		XSSFWorkbook workbook = new XSSFWorkbook();
				
		//������� ����� ����
		XSSFSheet spreadsheet =	workbook.createSheet(sheetName);
		
		return workbook;
	}
	/**
	 * ������� ����� ������ �������
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
	
	/** ��������� ����� � �������� ���� �� �����.
     * @param workBookPath - ��� � ���� � �����
     * @param workbook - ����� XSSFWorkbook
    */
	public void saveWorkbookToFile(XSSFWorkbook workbook, String workBookPath) throws IOException {
		
		FileChecker fCheck = new FileChecker();
		if (fCheck.isFileExists(workBookPath)) {
			System.out.println("ERROR: Can't create the file " + workBookPath + ". The file is already exists");
			return;
		}
		
		//������� ������ �����
		FileOutputStream out = new FileOutputStream(new File(workBookPath));
				
		//���������, �� ��� �� ���� � ����� ������ ������ �����
		
		
		//���������� �����
		workbook.write(out);
		out.close();
		
		System.out.println("INFO: The workbook " + workBookPath + " has been created successfully");
				
		}

}
