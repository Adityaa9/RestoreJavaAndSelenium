package com.qa.basic_java;

public class RunEncap {

	public static void main(String[] args) {
		
		EncapTest en=new EncapTest();
		en.setX(10);
		en.setY(20);
		en.setZ(30);
		
		System.out.println(en.getX()+" "+en.getY()+" "+en.getZ());

	}

}
