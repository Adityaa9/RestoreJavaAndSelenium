package com.qa.numericals;

public class FactorialNumber {

	public static void main(String[] args) {
		factorial(6);

	}
	
	public static void factorial(int x) {
		int fact=1;
		for(int i=1;i<=x;i++) {
			fact=fact*i;
		}
		System.out.println(fact);
	}

}
