package com.qa.basic_java;

public class override1 extends override {
	
	public void method(double d) {
		System.out.println("inside child");
	}

	public static void main(String[] args) {
		new override1().method(10);

	}

}
