package com.epsilon.assignment7;

import java.util.Scanner;

public class sine {

	 static double Sin(double x,int n) {
		 double fact=1.0;
		 double s=1.0;
		 for(int i=1;i<=n;i++) {
			 fact=fact*i;
			 s=s*x;
		 }
		 return s/fact;
	 }
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		String c="yes";
		while(c.equalsIgnoreCase("yes")) {

		System.out.print("Enter a angle:");
		int x=sc.nextInt();
		double rad=x*3.14156/180;
		int n=50;
		double val=0.0;
		boolean flag=true;
		for(int i=1;i<=n;i=i+2) {
			if(flag) {
			val+=Sin(rad,i);
			flag=false;
			}else {
				val-=Sin(rad,i);
				flag=true;
			}
		}
		System.out.println("Sin("+x+")="+val);
	       System.out.print("Do you want to continue yes/no?:");
	        c=sc.next();
		}
sc.close();
	}

}
