package xml.basics;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;

public class XMLValidation {
    public static void main(String[] args) {
        String xmlFile = "./doc/xml/basics/employee.xml";
        String xsdFile = "./doc/xml/basics/Employee.xsd";
        
        try {
            // Create a SchemaFactory and specify XML Schema language
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            
            // Compile the XSD schema
            Schema schema = factory.newSchema(new StreamSource(xsdFile));
            
            // Create a validator
            Validator validator = schema.newValidator();
            
            // Validate the XML file
            validator.validate(new StreamSource(xmlFile));
            
            System.out.println("VALID\n"+xmlFile+"\n"+ xsdFile);
        } catch (Exception e) {
        	System.out.println("INVALID\n"+xmlFile+"\n"+ xsdFile);
            System.err.println(e.getMessage());
        }
    }
}
