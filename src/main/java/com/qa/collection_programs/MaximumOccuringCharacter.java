package com.qa.collection_programs;

import java.util.LinkedHashMap;
import java.util.Map;

public class MaximumOccuringCharacter {

	public static void main(String[] args) {
		
		maxOccurance("god_bless_spiderman");

	}
	
	public static void maxOccurance(String s) {
		
		int maxVal=0;
		char maxKey=' ';
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
			if(data.getValue()>maxVal) {
				maxKey=data.getKey();
				maxVal=data.getValue();
			}
		}
		System.out.println("The maximum occuring character is: "+maxKey+", " +maxVal+ " times" );
	}

}
