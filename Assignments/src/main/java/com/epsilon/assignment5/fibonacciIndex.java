package com.epsilon.assignment5;

import java.util.Scanner;

public class fibonacciIndex {
	public int fibonacci(int index) { 
		int a=0;
		int b=1;
		if(index<2) {
			return index;
		}
		int c=0;
		for(int i=2;i<=index;i++) {
		c=a+b;
		a=b;
		b=c;
		}
		return c; 
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String c="yes";
		fibonacciIndex f1=new fibonacciIndex();
		while(c.equalsIgnoreCase("yes"))
		{
		System.out.print("Enter a index(starting from 0) : ");
		int num=sc.nextInt();
       int index=f1.fibonacci(num);
      
   System.out.println("Fibonacci number at  index "+num+" is:"+index);
      
       System.out.print("Do you want to continue yes/no?:");
        c=sc.next();
		}
		sc.close();

	}

}
