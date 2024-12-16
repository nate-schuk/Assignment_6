/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: Represents an alcohol drink
 * Due: 12/17/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Nathaniel Schuknecht
*/

public class Alcohol extends Beverage{

	private boolean isWeekend;
	
	public Alcohol(String bevName, Size size, boolean isWeekend) {
		
		super(bevName, Type.ALCOHOL, size);
		this.isWeekend = isWeekend;
	}
	
	//returns if it is the weekend
	public boolean isWeekend() {
		return isWeekend;
	}
	
	//compares two alcohol drinks
	public boolean equals(Object anotherBev) {
		
		if(anotherBev == null || !(anotherBev instanceof Alcohol))
			return false;
		
		Alcohol otherBev = (Alcohol) anotherBev;
		return super.equals(anotherBev) && isWeekend == otherBev.isWeekend();
	}
	
	//calculates price
	public double calcPrice() {
		double total = addSizePrice();
		
		if(isWeekend)
			total += .6;
		
		return total;
	}
	
	public String toString() {
		return super.toString() + "\nWeekend: " + isWeekend + "\nPrice: " + calcPrice();
	}
}
