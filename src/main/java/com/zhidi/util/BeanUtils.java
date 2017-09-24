package com.zhidi.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class BeanUtils {

	// 从一个对象设置非空属性导另一个对象
	public static <T> void copyNotNullField(T source, T target) {
		try {
			for (Field f : source.getClass().getDeclaredFields()) {
				f.setAccessible(true);
				for(Field t : target.getClass().getDeclaredFields()){
					t.setAccessible(true);
					if (!"id".equals(f.getName())&&f.getName().equals(t.getName())&& f.get(source) != null) { // 判断字段是否为空，并且对象属性中的基本都会转为对象类型来判断
						Method m = target.getClass().getMethod(
								"set"
										+ f.getName().substring(0, 1).toUpperCase()
										+ f.getName().substring(1,
												f.getName().length()), f.getType());
						m.invoke(target, f.get(source));
					}
				}
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	// 对象非空字段设置到map
	public static <T> Map<String, Object> notNullFieldToMap(T source) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			for (Field f : source.getClass().getDeclaredFields()) {
				f.setAccessible(true);
				if (!"id".equals(f.getName()) && f.get(source) != null&&StringUtils.isNotBlank(f.get(source).toString())) { // 判断字段是否为空，并且对象属性中的基本都会转为对象类型来判断
					map.put(f.getName(), f.get(source));
				}
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return map;
	}
	
	public static void main(String[] args) {
		System.out.println(Timestamp.valueOf("2016-05-06 00:00:00"));
		
		
	}
	
}
