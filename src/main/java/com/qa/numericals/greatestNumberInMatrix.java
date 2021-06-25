package com.qa.numericals;

import java.util.Scanner;

public class greatestNumberInMatrix {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int x=sc.nextInt();
		int y=sc.nextInt();
		int[][] matrix=new int[x][y]; 
		for(int i=0;i<x;i++) {
			for(int j=0;j<y;j++) {
				matrix[i][j]=sc.nextInt();
			}
		}
		
		greatestNumber(matrix);
	}
	
	public static void greatestNumber(int[][] data) {
		
		int y=data[0].length;
		int x=data.length;
		int lowest=data[0][0];
		int max=0;
		for(int i=0;i<x;i++) {
			for(int j=0;j<y;j++) {
				if(data[i][j]>max) {
					max=data[i][j];
				}
				if(data[i][j]<lowest) {
					lowest=data[i][j];
				}
			}
		}
		System.out.println("The greatest integer is: " +max);
		System.out.println("The lowest integer is: " +lowest);
		
	}

}
