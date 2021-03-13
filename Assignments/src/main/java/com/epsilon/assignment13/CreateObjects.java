package com.epsilon.assignment13;

public class CreateObjects {

	public static void main(String[] args) {
		Person[] people = {
				new Student("Shyam", "Bangalore, Karnataka", "Java fundamentals", 2010, 4500.0),
				new Staff("Anand", "Bangalore, Karnataka", "Delhi Public school", 35000.0), 
				new Staff("Umesh", "Bangalore, Karnataka", "National Public school", 42000.0), 
				new Student("Suresh", "Hassan, Karnataka", "Java fundamentals", 2012, 4750.0),
				new Student("Kiran", "Vasco, Goa", "Reactjs", 2017, 12500.0)
			};
System.out.println("Details of person 1:"+people[0].toString());
System.out.println("---------------------");
System.out.println("Details of person 2:"+people[1].toString());
System.out.println("---------------------");
System.out.println("Details of person 3:"+people[2].toString());
System.out.println("---------------------");
System.out.println("Details of person 4:"+people[3].toString());
System.out.println("---------------------");
System.out.println("Details of person 5:"+people[4].toString());
System.out.println("---------------------");
	}

}
