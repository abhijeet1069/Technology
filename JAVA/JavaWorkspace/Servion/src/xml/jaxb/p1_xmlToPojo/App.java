package xml.jaxb.p1_xmlToPojo;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/*
JAXB - Java architecture for XML binding
JAXB provides a fast and convenient way to marshal (write) Java objects into XML 
and unmarshal (read) XML into objects. It supports a binding framework that maps XML 
elements and attributes to Java fields and properties using Java annotations.

The JAXB-2 Maven plugin delegates most of its work to either of the two JDK-supplied tools XJC 
and Schemagen.

Here we will UnMarshall the XML - XML to POJO,

OP:
Ashok
26
 * */

public class App {
	public static void main(String[] args) throws JAXBException {
		String XML = "<employee>"+
					 	"<name>Ashok</name>"+
					 	"<age>26</age>"+
					 "</employee>";
		
		JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		unmarshaller.unmarshal(new StringReader(XML));
		
		Employee pojo = (Employee)unmarshaller.unmarshal(new StringReader(XML));
		
		System.out.println(pojo.getName());
		System.out.println(pojo.getAge());
	}
}
