package com.qa.numericals;

public class getPrimeNumbers {

	public static void main(String[] args) {
		
		getPrimeNumber(17);

	}
	public static boolean isPrimeNumber(int a) {
		if(a<=1) {
			return false;
		}
		else {
			for(int i=2;i<=a/2;i++) {
				if(a%i==0) {
					return false;
				} 
			}
		}
		return true;
	}
	public static void getPrimeNumber(int b) {
		for(int i=0;i<=b;i++) {
			if(isPrimeNumber(i)) {
				System.out.println(i+" ");
			}
		}
	}

}
