package ru.lockdain.imppeople.utils;

import java.io.File;

/**
 * ����� ������
 * @author Alexander Sergeenko
 * @version 1.0
 * @since 13/12/2017
 *
 */
public class FileChecker {

	/**
	 * ����� ���������, ���������� �� ���������� ���� �� �����
	 * @param filename
	 * @return flag
	 */
	public boolean isFileExists(String filename) {
		/**
		 * ���������� - ����, ���������� ���� ��� ���
		 */
		boolean flag = false;
		
		File file = new File(filename);
		
		if(file.exists()) {
			flag = true;
		System.out.println("File " + file.toString() + " already exists");
		}
		return flag;
		
	}
	
}
