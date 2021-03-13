package com.epsilon.assignment11;

import java.util.Scanner;

public class NumberNames {
static String one[]= {"","one ","two ","three ","four ",
		"five ","six ","seven ","eight ","nine ","ten ",
		"eleven ","twelve ","thirteen ","fourteen ","fifteen ",
		"sixteen ","seventeen ","eighteen ","nineteen "};
static String ten[]= {"","","twenty ","thirty ","forty ",
		"fifty ","sixty ","seventy ","eighty ","ninty "};

public static String inWords(int num,String s) { 
	String str=" ";
	if(num>19) {
		str+=ten[num/10]+one[num%10];
	}else {
		str+=one[num];
	}
	if(num!=0) {
		str+=s;
	}
	return str; 
}
public static String splitDigit(int n) {
	String out="";
	out+=inWords((n/10000000),"crore ");
	out+=inWords((n/100000)%100,"lakh ");
	out+=inWords((n/1000)%100,"thousand") ;
	out+=inWords((n/100)%10,"hundred");
	out+=inWords(n%100,"");
	return out;
}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String c="yes";
		while(c.equalsIgnoreCase("yes")) {
			System.out.print("Enter a number:");
			int num=sc.nextInt();
			String rev=splitDigit(num);
			System.out.println("Value of "+num+" is:"+rev);
			
			 System.out.print("Do you want to continue yes/no?:");
		     c=sc.next();
		
		}
	sc.close();


	}

}
