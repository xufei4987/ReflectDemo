package com.youxu.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo {

	public static void main(String[] args) throws Exception {
		getClassObject_1();
		getClassObject_2();
		getClassObject_3();
		createNewObj_1();
		createNewObj_2();
		getClassField_1();
		getClassField_2();
		getClassMethod_1();
		getClassMethod_2();
		getClassMethod_3();
	}
	//��ʽ1��ͨ�������ȡ
	public static void getClassObject_1() {
		Person person1 = new Person();
		Class clazz1 = person1.getClass();
		
		Person person2 = new Person();
		Class clazz2 = person2.getClass();
		
		System.out.println(clazz1 == clazz2);
		System.out.println("----------------");
	}
	//��ʽ2��ͨ����ľ�̬��Ա������ȡ
	public static void getClassObject_2() {
		Class clazz1 = Person.class;
		
		Class clazz2 = Person.class;
		
		System.out.println(clazz1 == clazz2);
		System.out.println("----------------");
	}
	
	//��ʽ3��ͨ��Class���forname������ȡ,��չ����ǿ
	public static void getClassObject_3() throws ClassNotFoundException {
		Class<?> clazz1 = Class.forName("com.youxu.reflect.Person");
		
		Class<?> clazz2 = Class.forName("com.youxu.reflect.Person");
		
		System.out.println(clazz1 == clazz2);
		System.out.println(clazz1);
		System.out.println("----------------");
	}
	
	//�ղι������
	public static void createNewObj_1() throws ClassNotFoundException {
		Class<?> clazz = Class.forName("com.youxu.reflect.Person");
		Person person = null;
		try {
			//���ÿղι��캯��
			person = (Person) clazz.newInstance();
			System.out.println(person);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		System.out.println("----------------");
	}
	//�������������
	public static void createNewObj_2() throws ClassNotFoundException {
		Class<?> clazz = Class.forName("com.youxu.reflect.Person");
		Person person = null;

		try {
			Constructor<?> constructor = clazz.getConstructor(int.class, String.class);
			person = (Person) constructor.newInstance(27,"youxu");
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(person);
		System.out.println("----------------");
	}
	
	public static void getClassField_1() throws Exception {
		Class<?> clazz = Class.forName("com.youxu.reflect.Person");
		Object obj = clazz.newInstance();
		Field field = clazz.getField("birth");
		Object object = field.get(obj);
		System.out.println(object);
		System.out.println("----------------");
	}
	
	public static void getClassField_2() throws Exception {
		Class<?> clazz = Class.forName("com.youxu.reflect.Person");
		Object obj = clazz.newInstance();
		Field field = clazz.getDeclaredField("age");
		//Ĭ�ϲ���ֱ�ӷ���˽�е��ֶΣ�ͨ������Accessible�����б������ʣ��ƻ��˷�װ�ԣ�
		field.setAccessible(true);
		Object object = field.get(obj);
		System.out.println(object);
		System.out.println("----------------");
	}
	//��ȡ���༰�丸������public����
	public static void getClassMethod_1() throws Exception {
		Class<?> clazz = Class.forName("com.youxu.reflect.Person");
		Method[] methods = clazz.getMethods();
		for(Method method : methods) {
			System.out.println(method);
		}
		System.out.println("----------------");
	}
	//��ȡ�������з�����public protected private
	public static void getClassMethod_2() throws Exception {
		Class<?> clazz = Class.forName("com.youxu.reflect.Person");
		Method[] methods = clazz.getDeclaredMethods();
		for(Method method : methods) {
			System.out.println(method);
		}
		System.out.println("----------------");
	}
	
	public static void getClassMethod_3() throws Exception {
		Class<?> clazz = Class.forName("com.youxu.reflect.Person");
		Object obj = clazz.newInstance();
		Method method = clazz.getMethod("toString", null);
		Object invoke = method.invoke(obj, null);
		System.out.println(invoke);
	}
}
