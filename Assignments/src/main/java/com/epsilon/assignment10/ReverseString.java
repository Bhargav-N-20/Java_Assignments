package com.epsilon.assignment10;

import java.util.Scanner;

public class ReverseString {
	public static String reverseByWords(String sentence) { 
		String words[]=sentence.split("\\s");
		String reverse="";
		
		for(int i=0;i<words.length;i++) {
			if(i==words.length-1) {
				reverse=words[i]+reverse;
			}else {
				reverse=" "+words[i]+reverse;
			}
		}
		return reverse; 
	}
	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	String c="yes";
	while(c.equalsIgnoreCase("yes")) {
		System.out.print("Enter a Line:");
		String original=sc.nextLine();
		String rev=reverseByWords(original);
		System.out.println("Reversed string by words is:"+rev);
		
		 System.out.print("Do you want to continue yes/no?:");
	     c=sc.nextLine();
	
	}
sc.close();
	}

}
