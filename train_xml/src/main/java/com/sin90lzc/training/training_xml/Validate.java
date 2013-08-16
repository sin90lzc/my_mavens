package com.sin90lzc.training.training_xml;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.SAXException;

public class Validate {

	/**
	 * @param args
	 * @throws DocumentException
	 * @throws SAXException 
	 */
	public static void main(String[] args) throws DocumentException, SAXException {
		SAXReader reader = new SAXReader();
		reader.setValidation(true);
		reader.setFeature("http://xml.org/sax/features/validation", true);  
        reader.setFeature("http://apache.org/xml/features/validation/schema", true);  
        reader.setFeature("http://apache.org/xml/features/validation/schema-full-checking",true); 
        assert reader.isValidating()==true;
		Document doc=reader.read(Validate.class.getClassLoader().getResourceAsStream(
				"unique.xml"));
		Element root=doc.getRootElement();
		System.out.println(root.getName());
	}

}
