package xml.jaxb.p3_attribValue;

/*
Dealing with XML attribute. Here, id in employee tag

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
			 	"<name>Ashok</name>"+
			 	"<age>26</age>"+
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
