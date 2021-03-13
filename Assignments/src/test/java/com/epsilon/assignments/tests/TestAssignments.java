package com.epsilon.assignments.tests;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.epsilon.assignment2.Prime;
public class TestAssignments {
	Prime p1;
	@BeforeEach
	void setup() {
	System.out.println("Setting up.....");
	}
	
	@AfterEach
	void tearDown() {
		System.out.println("Executing tearDown()...\n");
	}
	@BeforeAll
	static void init() {
		System.out.println("Executing init()...\n");
	}

	@AfterAll
	static void destroy() {
		System.out.println("Executing destroy()...");
	}
@Test
void primeOf3() {
	System.out.println("Checking for 3");
	boolean actual=Prime.isPrimeNumber(3);
	boolean expected=true;
	Assertions.assertEquals(expected,actual);
}

@Test
void primeOf1() {
	System.out.println("Checking for 1");
	boolean actual=Prime.isPrimeNumber(1);
	boolean expected=false;
	Assertions.assertEquals(expected,actual);
}
}
