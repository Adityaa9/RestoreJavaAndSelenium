package com.qa.basic_java;

import java.util.Scanner;

public class FindCube {
	
	public static int cube(int a) {
		return a*a*a;
	}
	
	public static double mirror(double x) {
		if(1<=x && x<=11) {
			return 11.60-x;
		}
		else {
			return 23.60-x;
		}
	}

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int x=sc.nextInt();
		int y=cube(x);
		System.out.println(y);
		
		double z=mirror(12.35);
		System.out.println(z);	

	}

}
