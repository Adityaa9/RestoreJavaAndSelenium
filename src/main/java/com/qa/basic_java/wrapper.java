package com.qa.basic_java;

public class wrapper extends abst {

	public static void main(String[] args) {
		String s="100";
		int x=Integer.parseInt(s);
		System.out.println(x);
		
		String str=String.valueOf(x);
		System.out.println(str+"200");
		
		String a="false";
		boolean b=Boolean.parseBoolean(a);
		System.out.println(b);
		

	}

	@Override
	public void test1() {
		
		
	}

	@Override
	public void test2() {
		// TODO Auto-generated method stub
		
	}

}
