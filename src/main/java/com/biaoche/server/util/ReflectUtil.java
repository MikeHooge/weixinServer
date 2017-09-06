package com.biaoche.server.util;

import java.lang.reflect.Field;

/**
 * 反射工具类
 * 
 * @author Administrator
 *
 */
public class ReflectUtil {

	/**
	 * 反射获取指定对象的指定属性
	 * 
	 * @param obj
	 * @param fileName
	 * @return
	 */
	public static Object getFieldValue(Object obj, String fileName) {
		Object result = null;
		Field field = ReflectUtil.getField(obj, fileName);
		if (field != null) {
			field.setAccessible(true);
			try {
				result = field.get(obj);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 获取指定对象的所有属性(包括父类继承的属性)
	 * 
	 * @param obj
	 * @param fieldName
	 * @return
	 */
	private static Field getField(Object obj, String fieldName) {
		Field field = null;
		for (Class<?> clazz = obj.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
			try {
				field = clazz.getDeclaredField(fieldName);
				break;
			} catch (NoSuchFieldException e) {

			}
		}
		return field;
	}

	/**
	 * 为指定对象的指定属性赋值
	 * 
	 * @param obj
	 *            指定的对象
	 * @param fieldName
	 *            指定的属性
	 * @param fieldValue
	 *            指定的值
	 */
	public static void setFieldValue(Object obj, String fieldName, Object fieldValue) {
		Field field = ReflectUtil.getField(obj, fieldName);
		if (field != null) {
			try {
				field.setAccessible(true);
				field.set(obj, fieldValue);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

}
