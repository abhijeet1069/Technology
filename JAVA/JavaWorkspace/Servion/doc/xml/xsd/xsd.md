# XSD
XSD is a way to validate XML. The other XML being:
	
	a) Well Formed - We trust the user to write a well formed XML.
		
		Rules for a well formed XML are:
			It must begin with an XML declaration.
			It must have one unique root element.
			Start-tags must have matching end tags.
			Elements are case sensitive.
			All elements must be closed.
			All elements must be properly nested.
			All attribute values must be quoted.
			Entities must be used for special characters.
			 
	b) DTD
		Document Type Definition. A prior technology to XSD.

## XSD building blocks
	Elements and attributes that may appear in the document
	Number and order of children
	DataTypes for elements and attributes
	Defaults and fixed values for elements and attributes
	
	<xs:complexType>
		Allows elements in their content. May carry attributes.
	
	<xs:simpleType>
		Contains only text. For ex, 
			xs:boolean 
			xs:string 
			xs:date 
			xs:time
			No other attributes or elements.
		
	<xs:sequence>
		Must go in mentioned xsd sequence
		
	minOccurs="0"
		Optional
	
	default="0"
		If value not passed, assume a value of 0
		
	<hello/>
		Singleton or a self closing tag