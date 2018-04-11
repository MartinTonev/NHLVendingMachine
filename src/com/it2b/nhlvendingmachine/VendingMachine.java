package com.it2b.nhlvendingmachine;

public class VendingMachine {

	public Money machineMoney = new Money();
	private Money customerMoney = new Money();
	public Item[] item = new Item [8];
	
	/**
	 * Create items and init machine money here
	 */
	public VendingMachine() {
		
	}
	
	/**
	 * @param index		- index of specific item
	 * @param amount	- amount which should be increased
	 * @return	new stock capacity for this item | -1 = wrong item index
	 */
	public int increaseStock(int index, int amount) {
		
		if(item[index].getQuantity() + amount <= 13) {
			item[index].add(amount);
		} 
		else {
			return -1;
		}
		
		return item[index].getQuantity();
	}
	
	/**
	 * @return	int array of cash
	 */
	public int[] getMachineMoney() {
		return machineMoney.getMoney();
	}
	
	/**
	 * @param index	- index of specific item
	 * @return	(float) stored price
	 */
	public float getPrice(int index) {
		float price = item[index].getPrice();
		return price;
	}
	
	/**
	 * @param index	- index of specific item
	 */
	public void buy(int index) {
		item[index].remove();
		customerMoney.pay(item[index].getPrice());
		returnMoney(item[index].getPrice());
	}
	
	/**
	 * @param money	- cash: (0.05, 0.1, 0.2, 0.5, 1, 2, 5, 10) are allowed
	 */
	public void insertMoney(String money) {
		customerMoney.changeCash(money, true);
	}
	
	/**
	 * TODO: this method will not work in the current state!
	 * @param itemPrice	- not neccessary param | TODO: delete parameter
	 */
	public void returnMoney(float itemPrice) {
		
		float moneyCustomer = customerMoney.getMoneySum();
		float difference = moneyCustomer - itemPrice;
		
		if(difference >= 0.0) {
			System.out.println("Enough money!");
		} 
		else {
			System.out.println("Not enough money");
		}
	}
	
	/**
	 * @return	customer money cash (int array)
	 */
	public int[] showMoney() {
		return customerMoney.getMoney();
	}
	
	/**
	 * @return	customer money
	 */
	public float showMoneySum() {
		return customerMoney.getMoneySum();
	}

}
