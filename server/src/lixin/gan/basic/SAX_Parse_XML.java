package lixin.gan.basic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAX_Parse_XML {
	public static void main(String[] args) {
		// 获得工厂
		SAXParserFactory factory = SAXParserFactory.newInstance();
		
		// 获取解析器
		SAXParser parser = null;
		try {
			parser = factory.newSAXParser();
		} catch (ParserConfigurationException | SAXException e) {
			e.printStackTrace();
		}
		
		// 编写处理器
		MyXMLHandler handler = new MyXMLHandler();
		
		// 解析
		try {
			parser.parse(Thread.currentThread().getContextClassLoader().getResourceAsStream("lixin/gan/basic/data.xml"), handler);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		List<Person> list = handler.getPersons();
		
		System.out.println(list);
	}
}

class MyXMLHandler extends DefaultHandler {
	
	private List<Person> persons;
	private Person person;
	private String tag; // 解析的标签
	
	@Override
	public void startDocument() throws SAXException {
		persons = new ArrayList<>();
		System.out.println("开始解析");
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.println(qName + "-->开始解析");
		tag = qName;
		if (tag.equals("person")) {
			person = new Person();
		}
	}
	
	@Override
	public void characters(char[] ch,int start, int length) throws SAXException {
		String content = new String(ch, start, length);
		//System.out.println("内容为-->" + content);
		
		if (tag != null) {
			if (tag.equals("name")) {
				person.setName(content);
			} else if (tag.equals("id")) {
				if(content.length() > 0) {
					person.setId(Integer.valueOf(content));
				}
			}
		}
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println(qName + "-->解析结束");
		if (qName != null) {
			if (qName.equals("person")) {
				persons.add(person);
			}
		}
		
		tag = null;
	}
	
	@Override
	public void endDocument() throws SAXException {
		System.out.println("解析完毕");
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
}
