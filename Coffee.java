/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: represents a coffee drink
 * Due: 12/17/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Nathaniel Schuknecht
*/

public class Coffee extends Beverage {

	private boolean extraShot; 
	private boolean extraSyrup;
	
	public Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		
		super(bevName, Type.COFFEE, size);
		this.extraShot = extraShot;
		this.extraSyrup = extraSyrup;
	}
	
	//returns if extra shot added
	public boolean getExtraShot() {
		return extraShot;
	}
	
	//returns if extra syrup added
	public boolean getExtraSyrup() {
		return extraSyrup;
	}
	
	//calculates price
	public double calcPrice() {
		
		double price = addSizePrice();
		
		if(extraShot)
			price += .5;
		
		if(extraSyrup)
			price += .5;
	
		return price;
	}
	
	//compares two coffee drinks
	public boolean equals(Object anotherBev) {
		
		if(anotherBev == null || !(anotherBev instanceof Coffee))
			return false;
	
		Coffee otherBev = (Coffee) anotherBev;
		return super.equals(anotherBev) && this.getBasePrice() == (otherBev.getBasePrice()) && extraShot == otherBev.getExtraShot() && extraSyrup == otherBev.getExtraSyrup();
	}
	
	public String toString() {
		return super.toString() + "\nExtra Shot: " + extraShot + "\nExtra Syrup: " + extraSyrup + "\nPrice: " + calcPrice();
	}
}
