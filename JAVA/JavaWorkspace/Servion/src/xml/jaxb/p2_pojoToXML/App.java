package xml.jaxb.p2_pojoToXML;

/*
Output : 
<?xml version="1.0" encoding="UTF-8" standalone="yes"?><employee><age>23</age><name>Satyam</name></employee>
 * */

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import xml.jaxb.p1_xmlToPojo.Employee;

public class App {
	public static void main(String[] args) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
		Marshaller marshaller = jaxbContext.createMarshaller();
		
		Employee pojo = new Employee();
		
		pojo.setName("Satyam");
		pojo.setAge(23);
		
		StringWriter sw = new StringWriter();
		marshaller.marshal(pojo, sw);
		
		System.out.println(sw);
	}
}
