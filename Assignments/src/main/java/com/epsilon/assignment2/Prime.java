package com.epsilon.assignment2;

import java.util.Scanner;

public class Prime {

	public static boolean isPrimeNumber(int num) { 
		if(num<2) {
			return false;
		}
		for(int i=2;i<=num/2;i++) {
			if(num%i==0) {
				return false;
			}
		}
		return true; 
	}
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		String c="yes";
		while(c.equalsIgnoreCase("yes"))
		{
		System.out.print("Enter a number: ");
		int num=sc.nextInt();
       boolean prime=isPrimeNumber(num);
       if(prime) {
    	   System.out.println("The entered number "+num+" is a Prime Number");
       }else {
    	   System.out.println("The entered number "+num+" is not a Prime Number");
       }
       System.out.print("Do you want to continue yes/no?:");
        c=sc.next();
		}
		sc.close();
	}

}
