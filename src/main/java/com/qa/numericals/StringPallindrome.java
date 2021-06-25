package com.qa.numericals;

public class StringPallindrome {

	public static void main(String[] args) {
		
		pallindrome("abcba");
	}
	
	public static void pallindrome(String s) {
		String rev="";
		int x=s.length();
		for(int i=x-1;i>=0;i--) {
			rev=rev+s.charAt(i);
		}
		if(s.equalsIgnoreCase(rev)) {
			System.out.println("Given stirng is pallindrome");
		}
		else {
			System.out.println("Given string is not a pallindrome");
		}
	}

}
