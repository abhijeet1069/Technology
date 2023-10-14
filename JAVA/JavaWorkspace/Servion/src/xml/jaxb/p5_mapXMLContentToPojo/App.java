package xml.jaxb.p5_mapXMLContentToPojo;

/**
Name Property - Mapping XML content to POJO class

Here we have to create a JAVA class for company as it has both attribute and value.

Output:
	Ashok
	26
	1234

 * */

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class App {

	public static void main(String[] args) throws JAXBException {
		String XML = "<employee id=\"1234\">"+
			 	"<myName>Ashok</myName>"+
			 	"<myAge>26</myAge>"+
			 	"<company id=\"Y2232\">Yamaha</company>"+
			 "</employee>";

		JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		unmarshaller.unmarshal(new StringReader(XML));
		
		Employee pojo = (Employee)unmarshaller.unmarshal(new StringReader(XML));
		
		System.out.println(pojo.getName());
		System.out.println(pojo.getAge());
		System.out.println(pojo.getId());
		System.out.println(pojo.getCompany());
	}
}
