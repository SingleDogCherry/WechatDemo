package com.wechat.global.util;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;


public class MessageUtil {

	/**
	 * 将xml格式转换为map
	 * @param request
	 * @return 
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public static Map<String , String > xmlToMap(HttpServletRequest request) throws IOException,DocumentException{
		Map<String, String > xmlMap = new HashMap<String, String>();
		SAXReader  saxReader=new SAXReader();
		try {
			InputStream ins=request.getInputStream();
			Document document=saxReader.read(ins);
			Element rootElement=document.getRootElement();
			List<Element> list=rootElement.elements();
			//System.out.println("2");
			for (Element e : list) {
				//System.out.println(e.getName());
				xmlMap.put(e.getName(), e.getText());
			}
			ins.close();
			
		} catch (DocumentException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		return xmlMap;
	}
	
/*	public  static void main(String[] args){
		MessageText mstMessageText=new MessageText();
		String nameString=
		System.out.println(nameString);
		
	}*/
	
	/**
	 * 将消息对象转化为xml
	 * @param 消息对象
	 * @return xmlString
	 * 
	 */
	public static String  beanToXml(Object object){
			
			XStream xStream=new XStream(new DomDriver("utf-8"));
			xStream.alias("xml", object.getClass());
			Class<?> tmpClass=object.getClass();
			Field[] fields=tmpClass.getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				String filedString=field.getName();
				String upString=filedString.substring(0,1).toUpperCase()+filedString.substring(1);
				xStream.aliasField(upString, object.getClass(), filedString);
			}
			if (tmpClass.getSuperclass()!=null) {
				Class< ?> superClass=tmpClass.getSuperclass();
				Field[] fields2=superClass.getDeclaredFields();
				for (Field field : fields2) {
					field.setAccessible(true);
					String filedString=field.getName();
					String upString=filedString.substring(0,1).toUpperCase()+filedString.substring(1);
					xStream.aliasField(upString, object.getClass(), filedString);
				}
			}
		return xStream.toXML(object);
	}
	/**
	 * 消息初始化
	 * @param 消息对象
	 * 
	 * */
	public static String init(Object object){
		
		
		
		return "su";
	}
	public boolean checkType(Object object){
		return false;
	}
	
}
