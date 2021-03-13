package com.epsilon.assignment12;


public class CreateCircles {

	public static void main(String[] args) {
		Circle[] circles = {
				new Cylinder(12.34),
				new Cylinder(12.34, 10.0),
				new Cylinder(12.34, 10.0, "blue")
			};	
		
System.out.println("Area of circle 1 :"+ circles[0].getArea());
System.out.println("Volume of cylinder 1 :"+ ((Cylinder) circles[0]).getVolume());
System.out.println("Area of circle 2 :"+ circles[1].getArea());
System.out.println("Volume of cylinder 2 :"+ ((Cylinder) circles[1]).getVolume());
System.out.println("Area of circle 2 :"+ circles[2].getArea());
System.out.println("Volume of cylinder 2 :"+ ((Cylinder) circles[2]).getVolume());
	}

}
