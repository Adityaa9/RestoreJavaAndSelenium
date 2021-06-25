package com.qa.hackerrank;

import java.util.Scanner;

public class Number_Line_Jump {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int x1=sc.nextInt();
		int v1=sc.nextInt();
		int x2=sc.nextInt();
		int v2=sc.nextInt();		
		
		if(x1>x2 && v1>v2) {
			System.out.println("NO");
		}
		if(x2>x1 && v2>v1) {
			System.out.println("NO");
		}
		
		for(int n=1;n<=100;n++) {
			if(x1>x2) {
				if(x1+(n*v1)==x2+(n*v2)) {
					System.out.println("YES");
					break;
				}				
			}
			if(x2>x1) {
				if(x1+(n*v1)==x2+(n*v2)) {
					System.out.println("YES");
					break;
				}	
				
			}
			
		}
		
				
	}
}
