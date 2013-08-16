package com.sin90lzc.training.training_dom4j;

import java.io.File;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.ElementHandler;
import org.dom4j.ElementPath;
import org.dom4j.Node;
import org.dom4j.VisitorSupport;
import org.dom4j.io.SAXReader;

/**
 * 在这个类中主要展示了dom4j各种解析XML的各种方式。解析XML文件为classpath下的documentForRead.xml文件。 <br />
 * <br />
 * {@link ReadDom#parseByDomElement(Document)}方法使用dom4j的
 * {@link org.dom4j.Element}、{@link org.dom4j.Attribute}、
 * {@link org.dom4j.Document}的API来解析XML <br />
 * <br />
 * {@link ReadDom#parseByVisitor(Document)}
 * 使用dom4j的观察者模式来解析XML，那么就可以选择自己关心的节点来解析XML <br />
 * <br />
 * {@link ReadDom#parseByXPath(Document)}通过XPath来读取XML的数据。具体的XPath语法请参考 <a
 * href="http://www.w3school.com.cn/xpath/index.asp">w3school的XPath教程</a>
 * 注意，使XPATH还需要添加jaxen.jar包<br />
 * <br />
 * {@link ReadDom#parseByEvent()}使用了dom4j的事件驱动方式来解析XML文档<br />
 * <br />
 * {@link ReadDom#domToString(Document)}通过{@link Document#asXML()}可以以字符串形式返回整个Document的XML形式
 * 
 * @author tim
 * 
 */
public class ReadDom {

	public static final String TAG_SCHOOL = "school";
	public static final String TAG_CLASS = "class";
	public static final String ATTR_LEVEL = "level";
	public static final String TAG_TEACHERS = "teachers";
	public static final String TAG_STUDENTS = "students";
	public static final String TAG_NAME = "name";
	public static final String ATTR_NAME = "name";
	public static final String TAG_SUBJECT = "subject";
	public static final String TAG_TEACHER = "teacher";
	public static final String TAG_STUDENT = "student";
	public static final String TAG_ONDUTY = "onduty";
	public static final String ATTR_ONDUTY = TAG_ONDUTY;

	public static void main(String[] args) throws Exception {
		Document document = getDocumentBySAXReader(new File(ReadDom.class
				.getClassLoader().getResource("documentForRead.xml").toURI()));

		domToString(document);

		parseByDomElement(document);

		parseByVisitor(document);

		parseByXPath(document);

		parseByEvent();
	}

	/**
	 * 使用dom4j的{@link org.dom4j.Element}、{@link org.dom4j.Attribute}、
	 * {@link org.dom4j.Document}的API来解析XML
	 * 
	 * @param document
	 */
	public static void parseByDomElement(Document document) {
		assert document != null;

		// 获取文档的根元素<school>。
		Element root = document.getRootElement();
		assert root.getName().equals(TAG_SCHOOL);

		// 获取<school>元素下第一个出现的<class>元素
		Element class1 = root.element(TAG_CLASS);
		assert class1.getName().equals(TAG_CLASS);

		// 获取<class>元素的属性level
		Attribute attr_level = class1.attribute(0);
		assert attr_level.getName().equals(ATTR_LEVEL);
		assert attr_level.getValue().equals("1");
		attr_level = class1.attribute(ATTR_LEVEL);
		assert attr_level.getValue().equals("1");

		// 获取属性level的父节点，实际就是<class>元素
		Element class1_ = attr_level.getParent();
		assert class1_ == class1;

		// 获取<class>元素下的所有<teacher>元素集，并解析每个<teacher>元素
		for (Object t : class1.elements(TAG_TEACHER)) {
			Element teacher = (Element) t;
			String name = teacher.elementText(TAG_NAME);
			name = name == null ? teacher.attributeValue(ATTR_NAME) : name;
			String subject = teacher.elementText(TAG_SUBJECT);
			subject = subject == null ? teacher.attributeValue(TAG_SUBJECT)
					: subject;
			if (name.equals("王海")) {
				assert subject.equals("语文");
			} else if (name.equals("刘文辉")) {
				assert subject.equals("数学");
			}
		}

		// 获取<class>元素下的所有<student>元素集，并解析每个<student>元素
		for (Object s : class1.elements(TAG_STUDENT)) {
			Element student = (Element) s;
			String name = student.elementText(TAG_NAME);
			name = name == null ? student.attributeValue(ATTR_NAME) : name;
			boolean onDuty = "true".equals(student.elementText(TAG_ONDUTY))
					|| student.attributeValue(ATTR_ONDUTY).equals("true");
			if (name.equals("张三") || name.equals("吴广")) {
				assert !onDuty;
			} else if (name.equals("李四") || name.equals("陈胜")) {
				assert onDuty;
			}
		}

	}

	/**
	 * 使用dom4j的观察者模式来解析XML，那么就可以选择自己关心的节点来解析XML<br />
	 * 在这个实例中，观察所有标签元素，过滤XML中所有&lt;student&gt;和&lt;teacher&gt;元素并解析。
	 * 
	 * @param document
	 */
	public static void parseByVisitor(Document document) {
		document.accept(new VisitorSupport() {
			@Override
			public void visit(Attribute node) {
				super.visit(node);
			}

			public void visit(org.dom4j.Namespace namespace) {
			};

			public void visit(org.dom4j.Text node) {
			};

			@Override
			public void visit(Element node) {
				super.visit(node);

				// 因为只需要解析&lt;student&gt;和&lt;teacher&gt;元素
				if (node.getName().equals(TAG_TEACHER)) {
					Element teacher = (Element) node;
					String name = teacher.elementText(TAG_NAME);
					name = name == null ? teacher.attributeValue(ATTR_NAME)
							: name;
					String subject = teacher.elementText(TAG_SUBJECT);
					subject = subject == null ? teacher
							.attributeValue(TAG_SUBJECT) : subject;
					if (name.equals("王海")) {
						assert subject.equals("语文");
					} else if (name.equals("刘文辉") || name.equals("陈红")) {
						assert subject.equals("数学");
					} else if (name.equals("李恢")) {
						assert subject.equals("英语");
					} else {
						assert false;
					}
				} else if (node.getName().equals(TAG_STUDENT)) {
					Element student = (Element) node;
					String name = student.elementText(TAG_NAME);
					name = name == null ? student.attributeValue(ATTR_NAME)
							: name;
					boolean onDuty = "true".equals(student
							.elementText(TAG_ONDUTY))
							|| "true".equals(student
									.attributeValue(ATTR_ONDUTY));
					if (name.equals("张三") || name.equals("吴广")
							|| name.equals("洪新") || name.equals("辰光")) {
						assert !onDuty;
					} else if (name.equals("李四") || name.equals("陈胜")
							|| name.equals("李渊") || name.equals("梁良")) {
						assert onDuty;
					} else {
						assert false;
					}
				}

			}
		});
	}

	/**
	 * 通过XPath来读取XML的数据。具体的XPath语法请参考 <a
	 * href="http://www.w3school.com.cn/xpath/index.asp">w3school的XPath教程</a>
	 * 
	 * @param document
	 */
	public static void parseByXPath(Document document) {
		// 读取所有<school>根节点下的所有<teacher>元素
		List<?> teachers = document.selectNodes("/school//teacher");
		for (Object node : teachers) {
			Element teacher = (Element) node;
			String name = teacher.elementText(TAG_NAME);
			name = name == null ? teacher.attributeValue(ATTR_NAME) : name;
			String subject = teacher.elementText(TAG_SUBJECT);
			subject = subject == null ? teacher.attributeValue(TAG_SUBJECT)
					: subject;
			if (name.equals("王海")) {
				assert subject.equals("语文");
			} else if (name.equals("刘文辉") || name.equals("陈红")) {
				assert subject.equals("数学");
			} else if (name.equals("李恢")) {
				assert subject.equals("英语");
			} else {
				assert false;
			}
		}

		// 读取根节点<school>
		Node school = document.selectSingleNode("/school");// 与document.selectSingleNode("school");一样
		assert school.getName().equals("school");

		// 读取文档中所有<class>元素
		List<?> classes = document.selectNodes("//class");
		for (Object node : classes) {
			Element clazz = (Element) node;
			assert clazz.attributeValue(ATTR_LEVEL).equals("1")
					|| clazz.attributeValue(ATTR_LEVEL).equals("2");
		}

		// 读取文档中所有<class>元素的level属性
		List<?> levels = document.selectNodes("//class/@level");
		for (Object node : levels) {
			Attribute level = (Attribute) node;
			assert level.getValue().equals("1") || level.getValue().equals("2");
		}

		// 注意XPATH的序号从1开始，所以这里找不到任何节点
		levels = document.selectNodes("//class[0]/@level");
		assert levels.size() == 0;

		// 读取文档中第一个<class>元素的level属性
		levels = document.selectNodes("//class[1]/@level");
		assert levels.size() == 1;
		for (Object node : levels) {
			Attribute level = (Attribute) node;
			assert level.getValue().equals("1");
		}

		// 读取文档中所有level属性等于‘1’的<class>元素下的所有<student>元素，并只返回<student>元素集的最后一个<student>元素
		Element student = (Element) document
				.selectSingleNode("//class[@level='1']//student[last()]");
		assert student.attributeValue("name").equals("吴广");

		// 读取文档中所有level属性等于‘1’的<class>元素下的所有<student>元素，并只返回<student>元素集中索引大于2的元素。
		List<?> students = document
				.selectNodes("//class[@level='2']//student[position()>2]");
		assert students.size() == 2;
		for (Object node : students) {
			student = (Element) node;
			String name = student.elementText(TAG_NAME);
			name = name == null ? student.attributeValue(ATTR_NAME) : name;
			assert name.equals("梁良") || name.equals("辰光");
		}

		// 读取文档中所有的<student>元素而且其子元素中有一个<name>元素，其值为’张三‘
		student = (Element) document.selectSingleNode("//student[name='张三']");
		assert student.elementText(TAG_NAME).equals("张三");

		List<?> studentsAndTeachers = document
				.selectNodes("/school/class/teachers/teacher | /school/class/students/student");
		assert studentsAndTeachers.size() == 12;

	}

	/**
	 * 该方法使用了dom4j的事件驱动方式来解析XML文档<br />
	 * <br />
	 * 事件驱动主要是使用两个dom4j的API来实现：<br />
	 * {@link SAXReader#addHandler(String, ElementHandler)}
	 * :最开始使用这个方法针对某个元素路径添加事件处理<br />
	 * <br />
	 * {@link ElementPath#addHandler(String, ElementHandler)}
	 * :在解析文档元素的过程中添加事件处理，一般在{@link ElementHandler#onStart(ElementPath)}中调用<br />
	 * <br />
	 * 这里的事件处理接口是{@link ElementHandler},它只有两个方法需要实现：<br />
	 * {@link ElementHandler#onStart(ElementPath)}:遇到元素开始标签时调用，如&lt;tag&gt;<br />
	 * <br />
	 * {@link ElementHandler#onEnd(ElementPath)}：遇到元素结束标签时调用，如&lt;tag/&gt;<br />
	 * <br />
	 * 
	 * @throws Exception
	 */
	public static void parseByEvent() throws Exception {
		SAXReader reader = new SAXReader();
		// 对<school>元素下的<class>元素添加事件处理
		reader.addHandler("/school/class", new ClassHandler());

		// 不要忘了解析文档
		reader.read(ReadDom.class.getClassLoader().getResourceAsStream(
				"documentForRead.xml"));
	}

	/**
	 * 针对&lt;class&gt;的事件处理器
	 * 
	 * @author tim
	 * 
	 */
	public static class ClassHandler implements ElementHandler {

		/**
		 * 在这个方法中，可以添加相对于&lt;class&gt;元素的其他子元素路径添加事件处理器
		 */
		public void onStart(ElementPath elementPath) {
			Element clazz = elementPath.getCurrent();
			assert clazz.getName().equals(TAG_CLASS);
			elementPath.addHandler("teachers/teacher",
					new TeacherHandler(clazz.attributeValue(ATTR_LEVEL)));
			elementPath.addHandler("students/student",
					new StudentHandler(clazz.attributeValue(ATTR_LEVEL)));
		}

		/**
		 * 应该在这个方法中清除在{@link this#onStart(ElementPath)}中添加的事件处理器
		 */
		public void onEnd(ElementPath elementPath) {
			elementPath.removeHandler("teachers/teacher");
			elementPath.removeHandler("students/student");
		}

	}

	/**
	 * &lt;student&gt;元素的事件处理器
	 * 
	 * @author tim
	 * 
	 */
	public static class StudentHandler implements ElementHandler {

		private String level;

		public StudentHandler(String level) {
			this.level = level;
		}

		public void onStart(ElementPath elementPath) {
			Element student = elementPath.getCurrent();
			assert student.getName().equals(TAG_STUDENT);
			assert student.getParent().getParent().attributeValue(ATTR_LEVEL)
					.equals(level);

		}

		public void onEnd(ElementPath elementPath) {
		}

	}

	/**
	 * &lt;teacher&gt;元素的事件处理器
	 * 
	 * @author tim
	 * 
	 */
	public static class TeacherHandler implements ElementHandler {

		private String level;

		public TeacherHandler(String level) {
			this.level = level;
		}

		public void onStart(ElementPath elementPath) {
			Element teacher = elementPath.getCurrent();
			assert teacher.getName().equals(TAG_TEACHER);
			assert level.equals(teacher.getParent().getParent()
					.attributeValue(ATTR_LEVEL));
		}

		public void onEnd(ElementPath elementPath) {

		}

	}

	/**
	 * 通过{@link org.dom4j.io.SAXReader}来读取并解析XML文件
	 * 
	 * @param xmlFile
	 * @return
	 * @throws Exception
	 */
	private static Document getDocumentBySAXReader(File xmlFile)
			throws Exception {
		SAXReader reader = new SAXReader();
		return reader.read(xmlFile);
	}

	/**
	 * 通过{@link Document#asXML()}可以以字符串形式返回整个Document的XML形式
	 * 
	 * @param document
	 * @throws Exception
	 */
	public static void domToString(Document document) throws Exception {
		System.out.println(document.asXML());
	}

}
