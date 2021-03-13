package com.epsilon.assignment9;

import java.util.Scanner;

public class SumOfEvensAndOdds {
	public int[] sumOfEvensAndOdds(int []nums) { 
		int []a=new int[]{0,0};
		for(int i=0;i<nums.length;i++) {
			if(nums[i]%2==0) {
				a[0]+=nums[i];
			}else {
				a[1]+=nums[i];
			}
		}
		return a;
	}
	public static void main(String[] args) {
	SumOfEvensAndOdds s1=new SumOfEvensAndOdds();
	Scanner sc=new Scanner(System.in);
	String c="yes";
	while(c.equalsIgnoreCase("yes")) {
	System.out.print("Enter the number of elements:");
	int n=sc.nextInt();
	 int []arr=new int[n];
	 
	 System.out.println("Enter the elements of the array:");
	 for(int i=0;i<n;i++) {
		 arr[i]=sc.nextInt();
	 }
	 int val[]=s1.sumOfEvensAndOdds(arr);
	 System.out.println("Sum of Even numbers and Odd numbers: {"+val[0]+","+val[1]+"}");
	 System.out.print("Do you want to continue yes/no?:");
     c=sc.next();
	}
	 sc.close();
	}

}
