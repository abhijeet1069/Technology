package org.example;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.print.Doc;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/*
Reading XML is called parsing. The file is read from to disk and Document Object Tree is made in memory.
*   Get the Document Builder
    Get Document
    Normalize the XML structure
    Get all the element by the tag name

* */

public class XMLParser {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("/Users/satyam/Personal/Reference/JAVA/XML/Code/ParseXML/laptops.xml"));
        document.getDocumentElement().normalize();
        NodeList laptopList = document.getElementsByTagName("laptop");

        for(int i = 0 ; i < laptopList.getLength(); i++) {
            Node laptop = laptopList.item(i);
            if(laptop.getNodeType() == Node.ELEMENT_NODE){
                Element laptopElement = (Element)laptop;
                System.out.println(laptopElement.getAttribute("name"));
                NodeList laptopDetails = laptop.getChildNodes();
                for(int j = 0 ; j < laptopDetails.getLength(); j++){
                    Node detail = laptopDetails.item(j);
                    if(detail.getNodeType() == Node.ELEMENT_NODE){
                        Element detailElement = (Element)detail;
                        System.out.println(" "+detailElement.getTagName()+" "+detailElement.getAttribute("value"));
                    }
                }
            }
        }
    }
}