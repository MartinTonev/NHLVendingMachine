package com.it2b.nhlvendingmachine;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MainTest {
	
	private Main mainC;

	@BeforeEach
	void setUp() throws Exception {
		
		mainC = new Main();
		
		/*
		 * Adding cash to the machine -> Numbers = cents -> in total adding 68.27 Euro
		 * Use the following to fill up the machine with sample data
		
		machineMoney.changeCash("2", true);
		machineMoney.changeCash("5", true);
		machineMoney.changeCash("5", true);
		machineMoney.changeCash("5", true);
		machineMoney.changeCash("10", true);
		machineMoney.changeCash("10", true);
		machineMoney.changeCash("10", true);
		machineMoney.changeCash("20", true);
		machineMoney.changeCash("20", true);
		machineMoney.changeCash("20", true);
		machineMoney.changeCash("20", true);
		machineMoney.changeCash("50", true);
		machineMoney.changeCash("50", true);
		machineMoney.changeCash("50", true);
		machineMoney.changeCash("50", true);
		machineMoney.changeCash("100", true);
		machineMoney.changeCash("100", true);
		machineMoney.changeCash("100", true);
		machineMoney.changeCash("100", true);
		machineMoney.changeCash("100", true);
		machineMoney.changeCash("200", true);
		machineMoney.changeCash("200", true);
		machineMoney.changeCash("200", true);
		machineMoney.changeCash("200", true);
		machineMoney.changeCash("200", true);
		machineMoney.changeCash("500", true);
		machineMoney.changeCash("500", true);
		machineMoney.changeCash("500", true);
		machineMoney.changeCash("500", true);
		machineMoney.changeCash("1000", true);
		machineMoney.changeCash("2000", true);
		
		*/
	}

	/**
	 * Inserting a 2 Euro coin.
	 */
	@Test
	void testInsertMoney() {
		mainC.insertMoney("200");
		Assertions.assertEquals(2f, mainC.showMoney());
	}
	
	
	/**
	 * Buying two items: Balpen and the Fine liner
	 * Balpen: 0.25 Euro
	 * Fine liner: 0.50 Euro
	 */
	@Test
	void testBuyItem() {
		mainC.buy(0);
		mainC.buy(5);
		Assertions.assertEquals(1.25f, mainC.showMoney());
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
		mainC.returnMoney();
		
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
		int oldStock = mainC.increaseStock(0, 0);
		int newStock = mainC.increaseStock(0, 10);
		
		Assertions.assertEquals(oldStock, 12);
		Assertions.assertEquals(newStock, 13);
	}
}
