package com.biaoche.server.util;

import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import com.biaoche.server.pojo.resp.BaseMessage;

/**
 * 消息处理工具类
 * 
 * @author Administrator
 *
 */
public class MsgUtil {
	public static String convertToXml(BaseMessage obj, String encoding){
		Document document = DocumentHelper.createDocument();
        //创建root
        Element root = document.addElement("xml");
        try {
            Class<? extends BaseMessage> aClass = obj.getClass();
            List<Field> fields = getDeclaredFields(aClass);
            System.out.println(fields.size());
            for (Field field : fields) {
                Element element = root.addElement(field.getName());
                if (field.getType().getName().equals("java.lang.String")) {
                    Method method = aClass.getMethod("get" + field.getName());
                    element.addCDATA((String) method.invoke(obj));
                } else {
                    Method method = aClass.getMethod("get" + field.getName());
                    element.addText(method.invoke(obj).toString());
                }
            }
            OutputFormat outputFormat = OutputFormat.createPrettyPrint();
            StringWriter stringWriter = new StringWriter();
            XMLWriter writer = new XMLWriter(stringWriter, outputFormat);
            writer.write(document.getRootElement());
            writer.close();
            System.out.println(stringWriter.toString().trim());
            return stringWriter.toString().trim();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	
	private static List<Field> getDeclaredFields(Class<?> clazz){	
		List<Field> list = new ArrayList<Field>();
		for(Class<?> clazzObj =clazz; clazzObj!=Object.class; clazzObj = clazzObj.getSuperclass()){
			Field[] declaredFields = clazzObj.getDeclaredFields();
			for (Field field : declaredFields) {
				list.add(field);
			}
		}
		return list;
	}
}
