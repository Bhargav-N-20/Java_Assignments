package com.epsilon.assignment1;

import java.util.Scanner;

public class DateValidation {

	static boolean isValidDate(int year, int month, int day) { 
		
		if(month<=12 && month>=1) {
		if(month==2) {
			if(((year%4==0) &&(year%100!=0))|| (year%400==0)) {
				if(day>=1 && day<=29) {
					return true;
				}else {
					return false;  //February in a leap year
				}
			}
			if(day>=1 && day<=28) {
				return true;
			}						//February in a non leap year
			else {
				return false;
			}
			
		}
		else{
			switch(month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				if(day>=1 && day <=31) {
					return true;
				}
			case 4:
			case 6:
			case 9:
			case 11:
				if(day>=1 && day <=30) {
					return true;
				}
				break;
			}
		}
		}
			
		return false; 
	}
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		String c="yes";
		while(c.equalsIgnoreCase("yes"))
		{
		System.out.print("Enter Year,Month,Day:");
		int year=sc.nextInt();
		int month=sc.nextInt();
		int day=sc.nextInt();
       boolean date=isValidDate(year,month,day);
       if(date) {
    	   System.out.println("Valid");
       }else {
    	   System.out.println("Invalid");
       }
       System.out.print("Do you want to continue yes/no?:");
        c=sc.next();
		}
		sc.close();
	}

}
