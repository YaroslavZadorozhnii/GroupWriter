package com.gmail.docfordja;

import java.io.Serializable;

public class Student extends Person implements Serializable {
	private int gradeBook;
	private int yearOfStudy;
	private int level;
	
	
	public Student() {
		super();
		
	}
	public Student(String lastName, String name, int age, boolean sex, int gradeBook, int yearOfStudy, int level) {
		super(lastName, name, age, sex);
		this.gradeBook = gradeBook;
		this.yearOfStudy = yearOfStudy;
		this.level = level; 
	}
	
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getGradeBook() {
		return gradeBook;
	}
	public void setGradeBook(int gradeBook) {
		this.gradeBook = gradeBook;
	}
	public int getYearOfStudy() {
		return yearOfStudy;
	}
	public void setYearOfStudy(int yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}
	
	@Override
	public void sayInfo()throws IllegalAccessException{
		String gender = "";
		if(isSex()){
			gender = "man";
		}else{
			gender = "woman";
		}
		System.out.println("Last Name: " + getLastName());
		System.out.println("Name: " + getName());
		System.out.println("Age: " + getAge());
		System.out.println("Sex: " + gender);
		System.out.println("Year of study: " + yearOfStudy);
		System.out.println("Gradebook number: " + gradeBook);
	}
	@Override
	public String toString() {
		return  "Student [lastName=" + super.getLastName() + ", name=" + super.getName() + ", age=" + super.getAge() + ", sex=" + super.isSex() + ", gradeBook=" + gradeBook + ", yearOfStudy=" + yearOfStudy + ", level=" + level + ",]";
	}
	


}
