package com.epsilon.assignment14;

public class Rectangle extends Shape {
private double width=1.0;
private double length=1.0;

public Rectangle() {
	
}

public Rectangle(double width, double length) {
	super();
	this.width = width;
	this.length = length;
}

public Rectangle(String color, boolean filled, double width, double length) {
	super(color, filled);
	this.width = width;
	this.length = length;
}

public double getWidth() {
	return width;
}

public void setWidth(double width) {
	this.width = width;
}

public double getLength() {
	return length;
}

public void setLength(double length) {
	this.length = length;
}

@Override
public String toString() {
	return "Rectangle [width=" + width + ", length=" + length +",Shape=[" + super.toString() + "]]";
}
public double getPerimeter() {
	return 2*(this.getLength()+this.getWidth());
}

public double getArea() {
	return this.getLength()*this.getWidth();
}
}
