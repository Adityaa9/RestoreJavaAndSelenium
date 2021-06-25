package com.qa.basic_java;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regexDemo {

	public static void main(String[] args) {
		
		Pattern pattern=Pattern.compile("Bikram is a software Engineer",Pattern.CASE_INSENSITIVE);
		Matcher matcher=pattern.matcher("software");
		boolean matchfound=matcher.find();
		if(matchfound) {
			System.out.println("Match found");
		}
		else {
			System.out.println("Match not found");
		}

	}

}
