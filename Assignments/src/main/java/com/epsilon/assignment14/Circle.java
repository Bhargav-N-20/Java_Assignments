package com.epsilon.assignment14;

public class Circle extends Shape {
private double radius=1.0;

public Circle() {
	
}

public Circle(double radius) {
	super();
	this.radius = radius;
}

public Circle(String color, boolean filled, double radius) {
	super(color, filled);
	this.radius = radius;
}

public double getRadius() {
	return radius;
}

public void setRadius(double radius) {
	this.radius = radius;
}

@Override
public String toString() {
	return "Circle [radius=" + radius + ","+" Shape=["+ super.toString() +  "]]";
}
public double getPerimeter() {
	return 2*3.14156*this.getRadius();
}

public double getArea() {
	return 3.14156*this.getRadius()*this.getRadius();
}
}
