package com.qa.collection_programs;

public class AnagramString {

	public static void main(String[] args) {
		
		anagram("mary","army");		

	}
	
	public static void anagram(String s1,String s2) {
		
		int x=s1.length();
		int y=s2.length();
		boolean flag=true;
		if(x==y) {
			for(int i=0;i<x;i++) {
				for(int j=0;j<y;j++) {
					if(s1.charAt(i)==s2.charAt(j)) {
						flag=true;
						break;
					}
					else {
						flag=false;
					}
				}
			}
			if(flag) {
				System.out.println("Given strings are anagram");
			}
			else {
				System.out.println("Given Strings are not anagram");
			}
		}
		
	}

}
