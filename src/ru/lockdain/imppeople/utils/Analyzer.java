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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * ����� �������� ������ ������� ����������� �������
 * @author Alex Sergeenko
 * @version 1.0
 * @since 14/12/2017
 *
 */
public class Analyzer {
	/**
	 * ���������� �������� �������� �� ���������� XML
	 * @param path
	 * @return doc
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException 
	 */
	public Document getDocumentFromXML(String path) throws ParserConfigurationException, SAXException, IOException {
		
		DocumentBuilderFactory f = DocumentBuilderFactory.newInstance();
		f.setValidating(false);
		DocumentBuilder builder = f.newDocumentBuilder();
		
		Document doc = builder.parse(new File(path));	
		
		return doc;
	}
	
	/**
	 * ���������� �������� �������� ����� Position 
	 * �� ��������� ��������� DOM
	 * @param doc
	 * @return map
	 */
	public List getPositionsMap(Document doc) {
		
		List<String> list = new ArrayList<>();
		//Node node = null;
		NodeList children = doc.getChildNodes();
		
		for(int i = 0; i < children.getLength(); i++) {
			Node node = children.item(i);
			
			if (node.getNodeName().equals("list")){
				System.out.println("Found a new position!");
				list.add(node.getNodeValue());
			}
		}
				
		return list;
	}

}
