package com.epsilon.assignment3;

import java.util.Scanner;

public class Ascending {
	public void sortThreeNumbers(int a, int b, int c) { 
		int large=a;
		int small=a;
		int mid=a+b+c;
		if(b>large && b>c) {
			large=b;
		}else if(c>large && c>b){
			large=c;
		}
		if(b<small && b<c) {
			small=b;
		}else if(c<small && c<b) {
			small=c;
		}
		mid=mid-large-small;
		System.out.println("Ascending order:"+small+","+mid+","+large);
		
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter three numbers:");
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=sc.nextInt();
		Ascending a1=new Ascending();
     a1.sortThreeNumbers(a,b,c);
		sc.close();

	}

}
