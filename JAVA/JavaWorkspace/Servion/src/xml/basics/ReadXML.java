package xml.basics;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class ReadXML {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		// ./ is relative path of workspace
		File file = new File("./doc/xml/basics/employee.xml");
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(file);
		doc.getDocumentElement().normalize();
		
		System.out.println("Root Element: "+doc.getDocumentElement().getNodeName());
	}
}
