package com.singletonpattern;

public class SingletonDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student student =  Student.getInatance();
		student.desplayDetails();
		
	}

}
