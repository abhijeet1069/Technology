package com.satyam.xmlValidator.core;

import java.io.File;
import java.io.PrintWriter;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXParseException;

public class XMLValidator {
	
	private String xmlValidation(String xsdPath, String xmlPath) {
		String status = "OK";
		try {
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = factory.newSchema(new File(xsdPath));
			Validator validator = schema.newValidator();
			validator.validate(new StreamSource(new File(xmlPath)));
		}
		catch(SAXParseException e) {
			int lineNum = e.getLineNumber();
			int colNum = e.getColumnNumber();
			status = "Exception occurs at the Line Number "+ lineNum + " and in the column " + colNum+ " \nError: " + e.getMessage();
			status += "\n"+xmlPath;
			return status;
		}
		catch(Exception e) {
			status += "Exception occured while validation: "+e.getMessage()+" : "+xmlPath;
			return status;
		}
		return status;
	}
	
	private static String saveStringToFile(String path, String str) {
		try(PrintWriter pw = new PrintWriter(path)){
			pw.println(str);
		}
		catch(Exception e) {
			return e.toString();
		}
		return "OK";
	}
	
	public String xmlValidate(String xsd, String xml) {
		String status="";
		String xmlPath = "temp//temp.xml";
		String xsdPath = "temp//temp.xsd";
		
		status = saveStringToFile(xmlPath,xml);
		status += saveStringToFile(xsdPath,xsd);
		
		if("OKOK".equalsIgnoreCase(status)) {
			status = xmlValidation(xsdPath,xmlPath);
		}
		
		return "<html>"+ status +"</html>";
	}

}
