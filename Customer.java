/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: represents a customer  
 * Due: 12/17/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Nathaniel Schuknecht
*/

public class Customer {

	private String name;
	private int age;
	
	public Customer(String name, int age) {
		
		this.name = name;
		this.age = age;
	}
	
	public Customer(Customer c) {
		
		name = c.name;
		age = c.age;
	}
	
	//returns age
	public int getAge() {
		return age;
	}
	
	//sets age
	public void setAge(int age) {
		this.age = age;
	}
	
	//returns name
	public String getName() {
		return name;
	}
	
	//sets name
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "Name: " + name + "\nAge: " + age;
	}
}
