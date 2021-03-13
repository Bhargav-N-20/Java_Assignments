package com.epsilon.assignment15;

import java.util.Scanner;

public class Inputs {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String c = "yes";
		int integer = 0;
		int nonint = 0;
		String nums="";
		String str ="";
		int sum = 0;
		while (c.equalsIgnoreCase("yes")) {
			System.out.println("Enter a Input:");
			String input = sc.nextLine();
			try {
				int num = Integer.parseInt(input);
				nums+=num+",";
				integer++;
				sum += num;
			} catch (Exception e) {
				str+= input+",";
				nonint++;
			}
			System.out.println("Do you want to continue:yes/no?");
			c = sc.nextLine();
		}
		System.out.println("Number of inputs=" + (integer + nonint));
		System.out.println("Number of integer inputs=" + integer);
		System.out.println("Number of no-integer inputs=" + nonint);
		System.out.println("Sum of all integer inputs=" + sum);
		System.out.println("The integer inputs= "+nums);
	
		System.out.println("The non-integer inputs= "+str);
	

		sc.close();

	}

}
