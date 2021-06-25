package com.qa.collection_programs;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class RemoveSpecificCharacter {

	public static void main(String[] args) {
		
		removeCharacter("bisskram");

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
		map.remove(a);
		String name="";
		for(Map.Entry<Character,Integer> data:map.entrySet()) {
			name=name+data.getKey();
		}
		System.out.println(name);
		
	}

}
