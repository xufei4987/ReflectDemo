package com.youxu.reflect;

public class Person {
	private int age;
	private String name;
	public final String birth = "1991-09-29";
		
	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
		System.out.println("person is created,name="+name+" and age="+age);
	}
	
	public Person() {
		super();
		System.out.println("person is created");
	}
	
	public void method1() {
		System.out.println("public method");
	}
	
	@SuppressWarnings("unused")
	private void method2() {
		System.out.println("private method");
	}
	
	protected void method3() {
		System.out.println("protected method");
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}
	
	
}
