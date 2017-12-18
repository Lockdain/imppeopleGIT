package ru.lockdain.imppeople.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Класс содержит методы анализа содержимого таблицы
 * @author Alex Sergeenko
 * @version 1.0
 * @since 14/12/2017
 *
 */
public class XmlAnalyzer {
	/**
	 * Возвращает корневой документ из указанного XML
	 * @param path
	 * @return doc
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException 
	 */
	static List <String> resultList = new ArrayList<>();

	public Document getDOMDocumentFromXML(String path) throws ParserConfigurationException, SAXException, IOException {
		
		Document doc = null;
		try {
		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
		f.setValidating(false);
		DocumentBuilder builder = f.newDocumentBuilder();		
		doc = builder.parse(new File(path));	
		}
		catch (Exception e) {
			System.out.println("Problems occuried while parsing the file: " + path + " " + e.getMessage());
		}
		return doc;
	}
	
	/**
	 * Возвращает перечень значений узлов Position 
	 * из заданного документа DOM
	 * @param doc
	 * @return list
	 */
	public List getPositionsMap(Document doc) {
		/**
		 * Корневой элемент документа
		 */
		Element root = doc.getDocumentElement();
		System.out.println("The root element's name is: " + root.getNodeName());
	
		//Считываем узлы
		List<String> list = new ArrayList<>();
		NodeList children = null;
	
		try {
		children = root.getChildNodes();
		}
		catch (Exception e) {
			System.out.println("ERROR: Problems while trying to getChildNodes from document " + e.getMessage());
		}
		
		System.out.println("getPositionMap: Found " + children.getLength() +" nodes");
		
		//Обходим список узлов
		for(int i = 0; i < children.getLength(); i++) {
			Node node = children.item(i);
			
			if (node.getNodeName().equals("position")){
				System.out.println("Found a new position!");
				list.add(node.getNodeValue());
			}
		}
				
		return list;
	}
	
	/**
	 * Рекурсивный обход дерева документа
	 * с формированием списка всех значений узла данного
	 * имени на уровне экземпляра класса
	 * @param node - узел, с которого начинается поиск вглубь
	 * @param nodeForSearchName - имя узла, значения которого требуется запомнить
	 * 
	 */
	public void stepThroughDomDoc(Node root, String nodeForSearchName) {

		System.out.println("Recursive search has started: " + root.getNodeName() + "= " + root.getNodeValue());
		for (Node child = root.getFirstChild(); child != null; child = child.getNextSibling()) {
			if(child.getNodeName().equals(nodeForSearchName)) {
				
				resultList.add(child.getTextContent());
				
			}
			stepThroughDomDoc(child, nodeForSearchName);
		}
	}
	
	public List getResultList() {
		return this.resultList;
	}

}
