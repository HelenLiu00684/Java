package assignment1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * CET - CS Academic Level 3 This class contains Assignment 1 Student Name:
 * QianJun Liu Student Number: 041150452 Course: CST8130 - Data Structures
 * 
 * @author/Professor: James Mwangi PhD.
 * 
 */

public class Fruit extends FoodItem {
	protected String orchardName = "NONONO";

	protected boolean addItem(Scanner keyboard) {
		if (super.addItem(keyboard)) {
			System.out.print("Enter the name of the orchard supplier:");
			//keyboard.nextLine();
			this.orchardName = keyboard.nextLine();
			return true;
		}
		return false;
	}

	protected Fruit() {
		super();
	}

	@Override
	public String toString() {
		return super.toString() + " orchard name:" + orchardName;
	};

}