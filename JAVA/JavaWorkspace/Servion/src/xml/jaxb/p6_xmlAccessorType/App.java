package xml.jaxb.p6_xmlAccessorType;

/**
@XMLAccessorType - Generally specified in root element

a) XmlAccessType.PUBLIC_MEMBER - Every public getter/setter pair and every public field will be automatically
	bound to XML, unless annotated by XMLTransient.
	
b) XmlAccessType.FIELD - Every non static, non transient field in JAXB-bound class will be automatically
	bound to XML, unless annotated by XMLTransient.		

c) XmlAccessType.PROPERTY - Every getter/setter pair in JAXB-bound class will be automatically
	bound to XML, unless annotated by XMLTransient.

d) XmlAccessType.NONE - None of the field or properties is bound to XML unless they are specifically annotated
	with some of JAXB annotations.
				   		   
Output:
Ashok
26
1234
Company ID : Y2232, Name : Yamaha
 * */

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;

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
