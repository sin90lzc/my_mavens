package com.sin90lzc.test.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassInfo {
	public static void printClassInfo(Class<?> clazz) {
		print("------------------------" + clazz.getSimpleName()
				+ "'s Class Info-----------------------");
		print("Class's Name:" + clazz.getName());
		print("Class's Fields:");
		for (Field field : clazz.getDeclaredFields()) {
			print(field.toGenericString());
		}
		for (Method method : clazz.getDeclaredMethods()) {
			print(method.toGenericString());
		}
		print("------------------------"+"End"+"-----------------------");
	}

	private static void print(String message) {
		System.out.println(message);
	}
}
