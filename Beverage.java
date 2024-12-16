/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: represents a beverage that can either be coffee, alcohol, or a smoothie
 * Due: 12/17/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Nathaniel Schuknecht
*/

public abstract class Beverage {

	private final double BASE_PRICE = 2;
	private final double SIZE_PRICE = .5;
	
	private String name;
	private Type type;
	private Size size;
	
	public Beverage(String bevName, Type type, Size size) {
		
		name = bevName;
		this.type = type;
		this.size = size;
	}
	
	//returns the base price
	public double getBasePrice() {
		return BASE_PRICE;
	}
	
	//returns type of beverage
	public Type getType() {
		return type;
	}
	
	//returns beverage name
	public String getBevName() {
		return name;
	}
	
	//returns beverage size
	public Size getSize() {
		return size;
	}
	
	//returns the price of size added to base 
	public double addSizePrice() {
		
		if(size == Size.SMALL)
			return BASE_PRICE;
		else if(size == Size.MEDIUM)
			return BASE_PRICE + SIZE_PRICE;
		
		return BASE_PRICE + (2*SIZE_PRICE);
	}
	
	//comapres two beverages
	public boolean equals(Object anotherBev) {
		
		if(anotherBev == null || !(anotherBev instanceof Beverage))
			return false;
		
		Beverage otherBev = (Beverage) anotherBev;
		return this.name.equals(otherBev.getBevName()) && this.type.equals(otherBev.getType()) && this.size.equals(otherBev.getSize());
	}
	
	public String toString() {
		return "\nName: " + name + "\nSize: " + size;
	}
	
	public abstract double calcPrice();
}
