package com.epsilon.training.methodreferences;

import java.util.Arrays;
import java.util.List;

public class MethodReferences {

	public static void main(String[] args) {
		List<String> names=Arrays.asList("Vinod","Vinay","Apple","Bhargav");
for (String name : names) {
	System.out.println(name);
}
System.out.println();

names
.stream()
.forEach(name->System.out.println(name));

System.out.println();


names
.stream()
.forEach(System.out::println);

System.out.println();

names
.stream()
.map(name->name.toUpperCase())
.forEach(System.out::println);

System.out.println();

names
.stream()
.map(String::toUpperCase)
.forEach(System.out::println);

System.out.println();

names
.stream()
.filter(name->name.startsWith("Vi"))
.map(String::toUpperCase)
.forEach(System.out::println);
	}

}
