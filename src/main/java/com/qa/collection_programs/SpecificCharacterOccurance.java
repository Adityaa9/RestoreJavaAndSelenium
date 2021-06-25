package com.qa.collection_programs;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class SpecificCharacterOccurance {

	public static void main(String[] args) {
		
		CharacterOccurence("god_bless_spiderman");		

	}
	
	public static void CharacterOccurence(String s) {
		
		Scanner sc=new Scanner(System.in);
		char a=sc.next().charAt(0);
		char[] ch=s.toCharArray();
		LinkedHashMap<Character,Integer> map= new LinkedHashMap<Character,Integer>();
		for(char c:ch) {
			if(map.containsKey(c)) {
				map.put(c,map.get(c)+1);
			}
			else {
				map.put(c,1);
			}
		}
		
		System.out.println("The number of occurance for the given character is: " +map.get(a)); 
	}

}
