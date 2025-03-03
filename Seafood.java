package assignment1;

import java.util.Scanner;

/**
 * CET - CS Academic Level 3 This class contains Assignment 1 Student Name:
 * QianJun Liu Student Number: 041150452 Course: CST8130 - Data Structures
 * 
 * @author/Professor: James Mwangi PhD.
 * 
 */

public class Seafood extends FoodItem {
	private String SeafoodSupplierName;

	protected boolean addItem(Scanner keyboard) {
		if (super.addItem(keyboard)) {
			System.out.print("Enter the name of the seafood supplier:");
			//keyboard.nextLine();
			this.SeafoodSupplierName = keyboard.nextLine();
		}
		return true;
	}

	protected Seafood() {
		super();
	}

	@Override
	public String toString() {
		return super.toString() + " Seafood supplier:" + SeafoodSupplierName;
	};

}