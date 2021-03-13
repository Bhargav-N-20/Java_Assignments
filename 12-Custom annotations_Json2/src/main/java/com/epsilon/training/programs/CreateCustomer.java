package com.epsilon.training.programs;

import java.io.FileWriter;
import com.epsilon.training.annotations.processors.JsonSerializer;
import com.epsilon.training.entity.Address;
import com.epsilon.training.entity.Customer;

public class CreateCustomer {

	public static void main(String[] args) throws Exception {
	
		
		Address addr=new Address("1st main","Bengaluru","karnataka","India");
		Customer c1=new Customer("Bhargav N","abx@example.com","1234567890",addr);
		
		
		JsonSerializer js = new JsonSerializer();
		//String json = js.serialize(c1); // serialize p1 only it has @JsonSerializable
		//System.out.println(json);
		FileWriter file=new FileWriter("customer.json");
		 js.serialize(file,c1);
	
}
}

