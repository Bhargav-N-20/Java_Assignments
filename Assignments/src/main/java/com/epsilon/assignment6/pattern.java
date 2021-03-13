package com.epsilon.assignment6;

import java.util.Scanner;

public class pattern {

	public static void main(String[] args) {
		String c="yes";
		Scanner sc=new Scanner(System.in);
		while(c.equalsIgnoreCase("yes")) {

		System.out.print("Enter a number:");
		
		int n=sc.nextInt();
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		 System.out.print("Do you want to continue yes/no?:");
	        c=sc.next();
		}
		sc.close();
	}

}
