package ru.lockdain.imppeople.utils;

import java.io.File;

/**
 * Класс утилит
 * @author Alexander Sergeenko
 * @version 1.0
 * @since 13/12/2017
 *
 */
public class FileChecker {

	/**
	 * Метод проверяет, существует ли переданный файл на диске
	 * @param filename
	 * @return flag
	 */
	public boolean isFileExists(String filename) {
		/**
		 * Переменная - флаг, существует файл или нет
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
