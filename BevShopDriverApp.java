import java.util.*;

public class BevShopDriverApp {

	public static void main(String[] args) {
		
		BevShop bevShop = new BevShop();
		
		System.out.println("The current order in process can have at most " + bevShop.getMaxOrderForAlcohol() +" alcoholic beverages.");
		System.out.println("The minimum age to order alcohol drink is " + bevShop.getMinAgeForAlcohol());
		System.out.println("Start please a new order:");
		
		System.out.println("Your Total Order for now is 0.0");
		System.out.print("Would you please enter your name: ");
		
		Scanner keyboard = new Scanner(System.in);
		String name = keyboard.nextLine();
			
		System.out.print("Would you please enter your age: ");
		int age = keyboard.nextInt();
		keyboard.nextLine();
		
		bevShop.startNewOrder(12, Day.TUESDAY, name, age);
		
		if(bevShop.isValidAge(age))
			System.out.println("Your age is above " + bevShop.getMinAgeForAlcohol() + " and you are eligible to order alcohol");
		else
			System.out.println("Your age is not appropriate for alcohol drink!!");
		
		System.out.println("Would you please add an alcohol drink");
		bevShop.processAlcoholOrder("Mohito", Size.SMALL);
		
		System.out.println("The current order of drinks is " + bevShop.getNumOfAlcoholDrink());
		System.out.println("The total price on the Order is " + bevShop.totalOrderPrice(0));
		System.out.println("Your current alcohol drink order is less than " + bevShop.getMaxOrderForAlcohol());
		System.out.println("Would you please add a second alcohol drink");
		
		bevShop.processAlcoholOrder("Manhattan", Size.LARGE);
		System.out.println("The current order of drinks is " + bevShop.getNumOfAlcoholDrink());
		System.out.println("The total price on the Order is " + bevShop.totalOrderPrice(0));
		System.out.println("Your current alcohol drink order is less than " + bevShop.getMaxOrderForAlcohol());
		
		System.out.println("Add a third alcohol drink");
		
		bevShop.processAlcoholOrder("Margarita", Size.LARGE);
		System.out.println("The current order of drinks is " + bevShop.getNumOfAlcoholDrink());
		System.out.println("The total price on the Order is " + bevShop.totalOrderPrice(0));
		
		System.out.println("You have maximum alcohol drinks for this order");
		System.out.println("Would you please add a COFFEE to your order");
		
		bevShop.processCoffeeOrder("Black Coffee", Size.LARGE, false, false);
		System.out.println("The current order of drinks is " + bevShop.getNumOfAlcoholDrink());
		System.out.println("The total price on the Order is " + bevShop.totalOrderPrice(0));
		
		
		System.out.println("#------------------------------------#");
		System.out.println("Would you please start a new order");
		
		System.out.print("Would you please enter your name: ");
		
		String custName = keyboard.nextLine();
	
		
		System.out.print("Would you please enter your age: ");
		int custAge = keyboard.nextInt();
		bevShop.startNewOrder(1, Day.FRIDAY, custName, custAge);
		System.out.println("The total price on the Order is " + bevShop.totalOrderPrice(1));
		
		System.out.println("Would you please add a SMOOTHIE to order");
		bevShop.processSmoothieOrder("Chocolate Smoothie", Size.LARGE, 4, true);
		System.out.println("The total price on the Order is " + bevShop.totalOrderPrice(1));
	
		System.out.println("Would you please add a SMOOTHIE to order");
		bevShop.processSmoothieOrder("Strawberry Smoothie", Size.SMALL, 0, false);
		
		System.out.println("Would you please add a COFFEE to order");
		bevShop.processCoffeeOrder("Black Coffee", Size.SMALL, false, false);
		System.out.println("The total price on the Order is " + bevShop.totalOrderPrice(1));
		
		System.out.println("Would you please add a alcohol drink");
	
		if(bevShop.isValidAge(custAge))
			System.out.println("Your age is above " + bevShop.getMinAgeForAlcohol() + " and you are eligible to order alcohol");
		else
			System.out.println("Your age is not appropriate for alcohol drink!!");
		
		System.out.println("The current order of drinks is " + bevShop.getCurrentOrder().getTotalItems());
		System.out.println("The total price on the Order is " + bevShop.totalOrderPrice(1));
		
		System.out.println("Would you please add a SMOOTHIE to order");
		bevShop.processSmoothieOrder("Protein Smoothie", Size.LARGE, 5, false);
		System.out.println("The total number of fruits is " + bevShop.getMaxNumOfFruits());
		
		if(bevShop.isMaxFruit(5))
			System.out.println("You reached a Maximum number of fruits");
		
		System.out.println("\nTotal price on the second Order: " + bevShop.totalOrderPrice(1));
		System.out.println("Tota amount for all Orders: " + bevShop.totalMonthlySale());
	}
	
}
