/*
 * Class: CMSC203 
 * Instructor: Khandan Monshi
 * Description: Represents an entire beverage shop that has multiple orders in a list. Keeps track of all order, 
 * customer, and beverage information for each order.
 * Due: 12/17/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Nathaniel Schuknecht
*/

import java.util.*;

public class BevShop implements BevShopInterface {

	private int alcoholOrdered;
	private ArrayList<Order> orders;
	
	public BevShop() {
		orders = new ArrayList<Order>();
	}
	
	//returns if valid time
	public boolean isValidTime(int time) {
		return time > MIN_TIME && time < MAX_TIME;
	}
	
	//returns max fruits
	public int getMaxNumOfFruits() {
		return MAX_FRUIT;
	}
	
	//returns min age for alcohol
	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}
	
	//returns if numOfFruits is over the max
	public boolean isMaxFruit(int numOfFruits) {
		return numOfFruits > MAX_FRUIT;
	}
	
	//returns the most you can order alcohol
	public int getMaxOrderForAlcohol() {
		return MAX_ORDER_FOR_ALCOHOL;
	}
	
	//returns if order is eligible for more alcohol
	public boolean isEligibleForMore() {
		return alcoholOrdered < MAX_ORDER_FOR_ALCOHOL;
	}
	
	//returns current order number of alcohol
	public int getNumOfAlcoholDrink() {
		return alcoholOrdered;
	}
	
	//returns if age is old enough
	public boolean isValidAge(int age) {
		return age >= MIN_AGE_FOR_ALCOHOL;
	}
	
	//starts a new order
	public void startNewOrder(int time, Day day, String customerName, int customerAge) {
		orders.add(new Order(time, day, new Customer(customerName, customerAge)));
		alcoholOrdered = 0;
	}
	
	//adds a coffee beverage to order
	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		getCurrentOrder().addNewBeverage(bevName, size, extraShot, extraSyrup);
	}
	
	//adds alcohol to order
	public void processAlcoholOrder(String bevName, Size size) {
		alcoholOrdered++;
		getCurrentOrder().addNewBeverage(bevName, size);
	}
	
	//adds a smoothie to order
	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
		getCurrentOrder().addNewBeverage(bevName, size, numOfFruits, addProtein);
	}
	
	//finds an order based on orderNo
	public int findOrder(int orderNo) {
		int index = -1;
		
		for(int i = 0; i < orders.size(); i++) {
			
			if(orders.get(i).getOrderNo() == orderNo)
				index = i;
		}
		
		return index;
	}
	
	//returns the total price of an order
	public double totalOrderPrice(int orderNo) {
		
		int index = findOrder(orders.get(orderNo).getOrderNo());
		
		if(index == -1)
			return 0.0;
		
		return orders.get(index).calcOrderTotal();
	}
	
	//returns the total price of all orders
	public double totalMonthlySale() {
		
		double total = 0;
		
		for(Order order: orders)
			total += order.calcOrderTotal();
		
		return total;
	}
	
	//returns total number of orders 
	public int totalNumOfMonthlyOrders() {
		return orders.size();
	}
	
	//returns the current order
	public Order getCurrentOrder() {
		return orders.get(orders.size() - 1);
	}
	
	//returns the order at index
	public Order getOrderAtIndex(int index) {
		
		if(index < 0 || index > orders.size() - 1)
			return null;
		
		return orders.get(index);
	}
	
	//sorts orders using insertion sort
	public void sortOrders() {
		
		int n = orders.size();
		for(int i = 0; i < n - 1; i++) {
			
			int minIndex = i;
			
			for(int j = i + 1; j < n; j++) 
				if(orders.get(j).compareTo(orders.get(minIndex)) < 0)
					minIndex = j;
			
			Order temp = orders.get(minIndex);
			orders.set(minIndex, orders.get(i));
			orders.set(i, temp);
		}
	}
	
	public String toString() {
		
		String toRet = "";
		
		for(Order order: orders)
			toRet += order.toString();
		
		return toRet;
	}
}
