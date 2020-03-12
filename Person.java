package com.gmail.docfordja;

import java.io.Serializable;

public class Person implements Serializable {
	private String lastName;
	private int age;
	private boolean sex;
	private String name;

	public Person() {

	}

	public Person(String lastName, String name, int age, boolean sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}

	public void sayInfo() throws IllegalAccessException {
		String gender = "";
		if (sex) {
			gender = "man";
		} else {
			gender = "woman";
		}
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.println("Sex: " + gender);
	}

	@Override
	public String toString() {
		return "Person [lastName=" + lastName + ", age=" + age + ", sex=" + sex + ", name=" + name + "]";
	}

}
