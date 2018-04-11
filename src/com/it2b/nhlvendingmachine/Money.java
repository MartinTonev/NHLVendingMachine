package com.it2b.nhlvendingmachine;

public class Money {

	float amount = 0;
	int[] cash = new int[8];

	/**
	 * @return	int array of cash
	 */
	public int[] getMoney() {
		return cash;
	}
	
	/**
	 * @param price	- substract by specified amount
	 */
	public void pay(float price) {
		amount -= price;
	}
	
	/**
	 * @return	Sum of money
	 */
	public float getMoneySum() {
		return amount;
	}
	
	/**
	 * @param money		- coin wich should be inserted
	 * @param increase	- true = increasing, false = decreasing
	 */
	public void changeCash(String money, boolean increase) {
		if (increase) {
			switch(money) {
				case "0.05": 
					cash[0] += 1;
					amount += 0.05;
					break;
				case "0.1": 
					cash[1] += 1;
					amount += 0.1;
					break;
				case "0.2": 
					cash[2] += 1;
					amount += 0.2;
					break;
				case "0.5" : 
					cash[3] += 1;
					amount += 0.5;
					break;
				case "1": 
					cash[4] += 1;
					amount += 1;
					break;
				case "2" : 
					cash[5] += 1;
					amount += 2;
					break;
				case "5" : 
					cash[6] += 1;
					amount += 5;
					break;
				case "10" : 
					cash[7] += 1;
					amount += 10;
					break;
			}
		}
		
		else {
			switch(money) {
				case "0.05": 
					cash[0] -= 1;
					amount -= 0.05;
					break;
				case "0.1": 
					cash[1] -= 1;
					amount -= 0.1;
					break;
				case "0.2": 
					cash[2] -= 1;
					amount -= 0.2;
					break;
				case "0.5" : 
					cash[3] -= 1;
					amount -= 0.5;
					break;
				case "1": 
					cash[4] -= 1;
					amount -= 1;
					break;
				case "2" : 
					cash[5] -= 1;
					amount -= 2;
					break;
				case "5" : 
					cash[6] -= 1;
					amount -= 5;
					break;
				case "10" : 
					cash[7] -= 1;
					amount -= 10;
					break;
			}
		}	
	}
}
