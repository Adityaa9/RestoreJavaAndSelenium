package com.qa.collection_programs;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatedCharacter {

	public static void main(String[] args) {
		
		nonRepeatCharacter("structured_query_language");

	}
	
	public static void nonRepeatCharacter(String s) {
		
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
		
		for(Map.Entry<Character,Integer> data:map.entrySet()) {
			if(data.getValue()==1) {
				System.out.println("The first non repeating character is: " +data.getKey());
				break;
			}
		}
		
	}

}
