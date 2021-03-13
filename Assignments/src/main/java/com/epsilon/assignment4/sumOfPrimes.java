package com.epsilon.assignment4;

import java.util.Scanner;

public class sumOfPrimes {
	public int sumOfPrime(int from, int to) { 
		if(from>to || to<2) {
			return 0;
		}
		int sum=0;
		
		for(int j=from;j<=to;j++) {
			boolean flag=true;
		for(int i=2;i<=j/2;i++) {
			if(j%i==0) {
				flag=false;
			}
		}
		if(flag && j>1) {
			
			sum+=j;
		}
		}
		return sum; 
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String c="yes";
		sumOfPrimes p1=new sumOfPrimes();
		while(c.equalsIgnoreCase("yes"))
		{
		System.out.print("Enter the start and end:");
		int start=sc.nextInt();
		int end=sc.nextInt();
       int sum=p1.sumOfPrime(start,end);
     System.out.println("Sum of all prime numbers between "+start+" and "+end+" is:"+sum);
       System.out.print("Do you want to continue yes/no?:");
        c=sc.next();
		}
		sc.close();

	}

}
