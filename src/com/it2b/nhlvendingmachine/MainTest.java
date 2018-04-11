package com.it2b.nhlvendingmachine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MainTest {
	
	private VendingMachine mainC;

	@BeforeEach
	void setUp() throws Exception {
		
		//Instance of VendingMachine to test methods
		mainC = new VendingMachine();
		
		//Creating neccessary items
		mainC.item[0] = new Item("Balpen",13, 0.25f);
		mainC.item[1] = new Item("Notebook with Stenden logo",13, 2.45f);
		mainC.item[2] = new Item("Whiteboard markers",13, 3.65f);
		mainC.item[3] = new Item("Pencil",13, 0.1f);
		mainC.item[4] = new Item("Key cord with NHL Stenden Logo",13, 0.25f);
		mainC.item[5] = new Item("Fine liner",13, 0.5f);
		mainC.item[6] = new Item("USB stick 16GB",13, 6.95f);
		mainC.item[7] = new Item("Bambook reusable Notebook", 13, 18.45f);
		
		//Init machine money
		mainC.machineMoney.changeCash("0.05", true);
		mainC.machineMoney.changeCash("0.05", true);
		mainC.machineMoney.changeCash("0.05", true);
		mainC.machineMoney.changeCash("0.05", true);
		mainC.machineMoney.changeCash("0.1", true);
		mainC.machineMoney.changeCash("0.1", true);
		mainC.machineMoney.changeCash("0.1", true);
		mainC.machineMoney.changeCash("0.2", true);
		mainC.machineMoney.changeCash("0.2", true);
		mainC.machineMoney.changeCash("0.2", true);
		mainC.machineMoney.changeCash("0.2", true);
		mainC.machineMoney.changeCash("0.5", true);
		mainC.machineMoney.changeCash("0.5", true);
		mainC.machineMoney.changeCash("0.5", true);
		mainC.machineMoney.changeCash("0.5", true);
		mainC.machineMoney.changeCash("1", true);
		mainC.machineMoney.changeCash("1", true);
		mainC.machineMoney.changeCash("1", true);
		mainC.machineMoney.changeCash("1", true);
		mainC.machineMoney.changeCash("1", true);
		mainC.machineMoney.changeCash("2", true);
		mainC.machineMoney.changeCash("2", true);
		mainC.machineMoney.changeCash("2", true);
		mainC.machineMoney.changeCash("2", true);
		mainC.machineMoney.changeCash("2", true);
		mainC.machineMoney.changeCash("5", true);
		mainC.machineMoney.changeCash("5", true);
		mainC.machineMoney.changeCash("5", true);
		mainC.machineMoney.changeCash("5", true);
		mainC.machineMoney.changeCash("10", true);
		mainC.machineMoney.changeCash("10", true);
	}

	/**
	 * Inserting a 2 Euro coin.
	 */
	@Test
	void testInsertMoney() {
		mainC.insertMoney("2");
		Assertions.assertEquals(2f, mainC.showMoneySum());
	}
	
	
	/**
	 * Buying two items: Balpen and the Fine liner
	 * Balpen: 0.25 Euro
	 * Fine liner: 0.50 Euro
	 */
	@Test
	void testBuyItem() {
		mainC.insertMoney("2");
		
		mainC.buy(0);
		mainC.buy(5);
		
		Assertions.assertEquals(1.25f, mainC.showMoneySum());
	}
	
	/**
	 * Checking remaining coins
	 * The following coins will decrease by one:
	 * 5c --> Position 1
	 * 20c --> Position 3
	 * 1 Euro --> Position 5
	 */
	@Test
	void testReturnMoney() {
		
		mainC.insertMoney("2");
		mainC.buy(0);
		mainC.buy(5);
		
		int[] mMoney = mainC.getMachineMoney();
		
		Assertions.assertEquals(4, mMoney[5]);
		Assertions.assertEquals(3, mMoney[3]);
		Assertions.assertEquals(2, mMoney[1]);
	}
	
	
	/**
	 * Getting price of the fifth item
	 * this should be 0.5f which represents 0.50 Euro.
	 */
	
	@Test
	void testGetPrice() {
		Assertions.assertEquals(0.5f, mainC.getPrice(5));
	}
	
	/**
	 * Testing stock of the first Item
	 * It was decreased by one of a previous test which should now be 12.
	 * Increasing the item by an amount which is bigger than "oldAmount + x = 13" will just fill it up until 13
	 */
	@Test
	void testStock() {
		
		mainC.buy(0);
		
		int oldStock = mainC.item[0].getQuantity();
		int newStock = mainC.increaseStock(0, 1);
		
		Assertions.assertEquals(12, oldStock);
		Assertions.assertEquals(13, newStock);
	}
	
}
