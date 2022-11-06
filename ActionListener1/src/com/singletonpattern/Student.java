package com.singletonpattern;

public class Student {
	
	//instance to sent to outside
	private static final Student instance = new Student();
	private String name;
	
	//Private constructor
	private Student() {
		this.name = "Jhon";
	}
	
	//method to sent the student instance to the outside
	public static Student getInatance() {
		return instance;
	}
	
	public void desplayDetails() {
		System.out.println("Name of the student is :" + this.name);
	}
	
}
