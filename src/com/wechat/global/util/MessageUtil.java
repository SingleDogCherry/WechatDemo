package com.wechat.global.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.wechat.global.servlet.WechatTokenServlet;

/**
 * 
 * 消息处理类
 * */
public class MessageUtil {
	static Logger logger = LogManager.getLogger(MessageUtil.class.getName());

	/**
	 * 将xml格式转换为map
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> xmlToMap(HttpServletRequest request)
			throws IOException, DocumentException {
		Map<String, String> xmlMap = new HashMap<String, String>();
		SAXReader saxReader = new SAXReader();
		try {
			InputStream ins = request.getInputStream();
			Document document = saxReader.read(ins);
			Element rootElement = document.getRootElement();
			List<Element> list = rootElement.elements();
			for (Element e : list) {
				xmlMap.put(e.getName(), e.getText());
			}
			ins.close();
			ins = null;
		} catch (DocumentException e) {
			logger.info(e.getMessage());
		}
		return xmlMap;
	}

	/**
	 * 将消息对象转化为xml
	 * 
	 * @param 消息对象
	 * @return xmlString
	 * 
	 */
	public static String beanToXml(Object object) {

		//XStream xStream = new XStream(new DomDriver("utf-8"));
		xstream.alias("xml", object.getClass());
		Class<?> tmpClass = object.getClass();
		Field[] fields = tmpClass.getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true);
			String filedString = field.getName();
			String upString = filedString.substring(0, 1).toUpperCase()
					+ filedString.substring(1);
			xstream.aliasField(upString, object.getClass(), filedString);
		}
		if (tmpClass.getSuperclass() != null) {
			Class<?> superClass = tmpClass.getSuperclass();
			Field[] fields2 = superClass.getDeclaredFields();
			for (Field field : fields2) {
				field.setAccessible(true);
				String filedString = field.getName();
				String upString = filedString.substring(0, 1).toUpperCase()
						+ filedString.substring(1);
				xstream.aliasField(upString, object.getClass(), filedString);
			}
		}
		return xstream.toXML(object);
	}

	/**
	 * 扩展xstream，使其支持CDATA块
	 * 
	 * @date 2017-08-22
	 */
	private static XStream xstream = new XStream(new XppDriver() {
		public HierarchicalStreamWriter createWriter(Writer out) {
			return new PrettyPrintWriter(out) {
				// 对所有xml节点的转换都增加CDATA标记
				boolean cdata = true;

				@SuppressWarnings("rawtypes")
				public void startNode(String name, Class clazz) {
					super.startNode(name, clazz);
				}

				protected void writeText(QuickWriter writer, String text) {
					if (cdata) {
						writer.write("<![CDATA[");
						writer.write(text);
						writer.write("]]>");
					} else {
						writer.write(text);
					}
				}
			};
		}
	});

	/**
	 * 消息初始化
	 * 
	 * @param 消息对象
	 * 
	 * */
	public static String init(Object object) {
		return "su";
	}

	public boolean checkType(Object object) {
		return false;
	}

	public static XStream getXstream() {
		return xstream;
	}

	public static void setXstream(XStream xstream) {
		MessageUtil.xstream = xstream;
	}

}
