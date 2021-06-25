package com.qa.collection_programs;

import java.util.LinkedHashMap;
import java.util.Map;

public class remove_space {

	public static void main(String[] args) {
		
		remove("b i kram");

	}
	
	public static void remove(String s) {
		
		char ch[]=s.toCharArray();
		LinkedHashMap<Character,Integer> map=new LinkedHashMap<Character,Integer>();
		for(char c:ch) {
			if(map.containsKey(c)) {
				map.put(c,map.get(c)+1);
			}
			else {
				map.put(c,1);
			}
		}
		char a=' ';
		map.remove(a);
		String name="";
	
		for(Map.Entry<Character,Integer> data:map.entrySet()) {			
			name=name+data.getKey();			
		}
		System.out.println(name);
		
//		String str=s.replaceAll("\\s", "");
//		System.out.println(str);
	}

}
