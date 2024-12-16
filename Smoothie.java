/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: represents a smoothie drink
 * Due: 12/17/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Nathaniel Schuknecht
*/

public class Smoothie extends Beverage {

	private int numOfFruits;
	private boolean addProtein;
	
	public Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein) {
		
		super(bevName, Type.SMOOTHIE, size);
		this.numOfFruits = numOfFruits;
		this.addProtein= addProtein;
	}
	
	//returns num of fruit
	public int getNumOfFruits() {
		return numOfFruits;
	}
	
	//returns if protein added
	public boolean getAddProtein() {
		return addProtein;
	}
	
	//calculates price
	public double calcPrice() {
		
		double price = addSizePrice() + (numOfFruits * 0.5);
		
		if(addProtein)
			price += 1.5;
		
		return price;
	}
	
	//compares two smoothies
	public boolean equals(Object anotherBev) {
		
		if(anotherBev == null || !(anotherBev instanceof Smoothie))
			return false;
		
		Smoothie otherBev = (Smoothie) anotherBev;
		return super.equals(anotherBev) && this.getBasePrice() == (otherBev.getBasePrice()) && numOfFruits == otherBev.getNumOfFruits() && addProtein == otherBev.getAddProtein();
	}
	
	public String toString() {
		return super.toString() + "\nProtein: " + addProtein + "\nNumber of Fruits: " + numOfFruits + "\nPrice: " + calcPrice();
	}
}
