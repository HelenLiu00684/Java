package assignment1;

import java.util.Scanner;

/**
 * CET - CS Academic Level 3 This class contains Assignment 1 Student Name:
 * QianJun Liu Student Number: 041150452 Course: CST8130 - Data Structures
 * 
 * @author/Professor: James Mwangi PhD.
 * 
 */

public class Preserve extends FoodItem {
	private int jarSize;

	protected boolean addItem(Scanner keyboard) {
		if (super.addItem(keyboard)) {
			System.out.print("Enter the name of the farm supplier:");
			while (true) {
				try {
					jarSize = Integer.parseInt(keyboard.next());
					if (jarSize <= 0)
						System.out.println("...must be a positive integer...\n");
					else
						break;
				} catch (NumberFormatException e) {// The input value can not transfer into a Integer......
					System.out.println("...must be a positive integer...\n");// This handles of NumberFormatException
				}
			}
		}
		return true;
	}

	protected Preserve() {
		super();
	}

	@Override
	public String toString() {
		return super.toString() + " size:" + jarSize + "mL";
	};

}
