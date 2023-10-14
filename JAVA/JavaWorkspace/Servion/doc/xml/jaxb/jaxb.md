#JAXB
JAXB - Java architecture for XML binding
JAXB provides a fast and convenient way to marshal (write) Java objects into XML 
and unmarshal (read) XML into objects. It supports a binding framework that maps XML 
elements and attributes to Java fields and properties using Java annotations.

The JAXB-2 Maven plugin delegates most of its work to either of the two JDK-supplied tools XJC 
and Schemagen.

UnMarshall - XML to POJO
Marshall - POJO to XML

# Generate POJO from XSD
C:\Program Files\Java\jdk-1.8\bin> 
xjc -d C:\Personal\NRICodeExp\Learning\doc -p sample C:\Personal\NRICodeExp\UnderstandNRI\res\Framework\IDFC_CVP_IVR\xsd\application.xsd