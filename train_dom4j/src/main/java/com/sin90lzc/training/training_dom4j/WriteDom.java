package com.sin90lzc.training.training_dom4j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
 * 该类展示了dom4j是如何输出XML文件的。
 * 
 * @author tim
 *
 */
public class WriteDom {

	private static final String XMLTEXT = "<school><class level='1'><teacher><name>tim</name></teacher><teacher><name>rain</name></teacher></class></school>";

	private static final String CREATEBYSTRING = "target/createByString.xml";
	private static final String CREATEBYDOMELEMENT = "target/createByDomElement.xml";

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		domCreateByString(XMLTEXT, CREATEBYSTRING);
		createByDomElement(CREATEBYDOMELEMENT);
	}

	public static void domCreateByString(String xml, String outputFileName)
			throws Exception {
		Document document = DocumentHelper.parseText(xml);
		FileWriter writer = new FileWriter(outputFileName);
		document.write(writer);
		writer.flush();
		writer.close();
	}

	public static void createByDomElement(String outputFileName)
			throws IOException {
		Document document = DocumentHelper.createDocument();
		Element root = document.addElement(ReadDom.TAG_SCHOOL);
		Element clazz = root.addElement(ReadDom.TAG_CLASS).addAttribute(
				ReadDom.ATTR_LEVEL, "1");
		clazz.addElement("teacher").addElement("name").addText("tim");
		clazz.addElement("teacher").addElement("name").addText("rain");
		XMLWriter writer = new XMLWriter(new FileOutputStream(new File(
				outputFileName)), OutputFormat.createPrettyPrint());
		writer.write(document);
		writer.close();
	}

}
