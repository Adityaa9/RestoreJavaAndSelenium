package com.qa.numericals;

public class primeNumber {

	public static void main(String[] args) {
		prime(2);
	}
	
	public static void prime(int x) {
		int n=x/2;
		int flag=0;
		if(x<=1) {
			System.out.println("Its not a prime number");
			
		}
		else {
			for(int i=2;i<=n;i++) {
				if(x%i==0) {
					System.out.println("Its not a prime number");
					flag=1;
					break;
				}				
			}
			if(flag==0) {
				System.out.println("Its a prime number");
		}
					
		}		
		
	}
	

}
