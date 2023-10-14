package xml.jaxb.p4_nameProperty;

/**
Name Property - Mapping variable of a POJO to an XML tag explicity


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
			 "</employee>";

		JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
		unmarshaller.unmarshal(new StringReader(XML));
		
		Employee pojo = (Employee)unmarshaller.unmarshal(new StringReader(XML));
		
		System.out.println(pojo.getName());
		System.out.println(pojo.getAge());
		System.out.println(pojo.getId());
	}
}
