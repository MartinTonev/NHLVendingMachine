package com.it2b.nhlvendingmachine;

public class Item {
	
	private float price = 0;
	private int quantity = 0;
	private String name;
	
	/**
	 * Create Item
	 * @param name		- name of the item
	 * @param quantity	- amount of the item (stock)
	 * @param price		- price of the item
	 */
	public Item(String name, int quantity, float price) {
		
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	
	/**
	 * Decrease stock by one
	 * @return	if item 0 -> false will be returned | otherwise true
	 */
	public boolean remove() {
		if(quantity > 0) {
			quantity --;
			return true;
		}
		else 
			return false;
	}
	
	/**
	 * @param amount	- amount that should be increased
	 */
	public void add(int amount) {
		
		if((quantity + amount) < 13)
			quantity += amount;
		else if ((quantity + amount) > 13) {
			quantity = 13;
		}
	}
	
	/**
	 * @return	price of item
	 */
	public float getPrice() {
		return price;
	}
	
	/**
	 * @return	name of item
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return	amount in stock
	 */
	public int getQuantity() {
		return quantity;
	}
}
