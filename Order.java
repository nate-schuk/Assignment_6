/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: represents an order that can be made from the client. Each order has a customer and a list of beverages
 * Due: 12/17/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Nathaniel Schuknecht
*/
import java.util.*;

public class Order implements OrderInterface, Comparable<Order>{

	private int orderNumber;
	private int time;
	private Day day;
	private Customer customer;
	private ArrayList<Beverage> beverages;

	public Order(int orderTime, Day orderDay, Customer cust) {
		
		time = orderTime;
		day = orderDay;
		customer = new Customer(cust);
		orderNumber = generateOrder();
		beverages = new ArrayList<Beverage>();
	}
	
	//generates an order number
	public int generateOrder() {
		return 10000 + (int)(Math.random() * 80001);
	}
	
	//returns order number
	public int getOrderNo() {
		return orderNumber;
	}
	
	//returns order time
	public int getOrderTime() {
		return time;
	}
	
	//returns order day
	public Day getOrderDay() {
		return day;
	}
	
	//returns order customer
	public Customer getCustomer() {
		return new Customer(customer);
	}
	
	//returns if it is the weekend
	public boolean isWeekend() {
		return day == Day.SATURDAY || day == Day.SUNDAY;
	}
	
	//returns a beverage from its number
	public Beverage getBeverage(int itemNo) {
		
		if(itemNo < 0 || itemNo > beverages.size() - 1)
			return null;
		
		return beverages.get(itemNo);
	}
	
	//returns number of beverages
	public int getTotalItems() {
		return beverages.size();
	}
	
	//adds a coffee to order
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		beverages.add(new Coffee(bevName, size, extraShot, extraSyrup));
	}
	
	//adds alcohol to order
	public void addNewBeverage(String bevName, Size size) {
		beverages.add(new Alcohol(bevName, size, isWeekend()));
	}
	
	//adds a smoothie to order
	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
		beverages.add(new Smoothie(bevName, size, numOfFruits, addProtein));
	}
	
	//calculates the order total
	public double calcOrderTotal() {
		
		double total = 0;
		
		for(Beverage bev: beverages)
			total += bev.calcPrice();
	
		return total;
	}
	
	//finds the total number of beverages with type
	public int findNumOfBeveType(Type type) {
		
		int total = 0;
		
		for(Beverage bev: beverages) {
			
			if(bev.getType() == type)
				total++;
		}
			
		return total;
	}
	
	//compares two orders with eachother
	public int compareTo(Order anotherOrder) {
		
		
		if(orderNumber > anotherOrder.orderNumber)
			return 1;
		
		if(orderNumber < anotherOrder.orderNumber)
			return -1;
		
		return 0;
	}
	
	public String toString() {
		String toRet = "Order Number: " + orderNumber + "\nTime: " + time + "\nDay: " + day + customer.toString();
		
		for(Beverage bev: beverages)
			toRet += bev.toString();
		
		return toRet;
	}
}
