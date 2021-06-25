package com.qa.collection_programs;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class RemoveDuplicateCharacters {

	public static void main(String[] args) {
		
		removeCharacter("biikkrraam");

	}
	
	public static void removeCharacter(String s) {
		Scanner sc=new Scanner(System.in);
		char a=sc.next().charAt(0);		
		char[] ch=s.toCharArray();
		LinkedHashMap<Character,Integer> map=new LinkedHashMap<Character,Integer>();
		for(char c:ch) {
			if(map.containsKey(c)) {
				map.put(c,map.get(c)+1);
			}
			else {
				map.put(c,1);
			}
		}
		String name="";
		for(Map.Entry<Character,Integer> data:map.entrySet()) {
			if(data.getValue()>1) {
				map.put(data.getKey(), 1);
			}
			name=name+data.getKey();
		}
		System.out.println(name);		
	}

}
