package assignment1;

import java.util.List;
import java.util.Scanner;

/**
 * CET - CS Academic Level 3 This class contains Assignment 1 Student Name:
 * QianJun Liu Student Number: 041150452 Course: CST8130 - Data Structures
 * 
 * @author/Professor: James Mwangi PhD.
 * 
 */

public abstract class FoodItem {

	protected int itemCode; // Variable to save the scanner input.....
	protected String itemName;
	protected float itemPrice;
	protected int itemQuantityinStock;
	protected float itemCost;
	private boolean flag = true;



	protected FoodItem() {
	};

	boolean updateitem(int amount) {
		itemQuantityinStock = itemQuantityinStock + amount;
		return true;
	};

	protected boolean isEqual(FoodItem foodItem) {
		if(foodItem.getItemCode()==this.itemCode) {
			return true;
		}
		return false;
	};
	
	

	protected boolean addItem(Scanner keyboard) {
		flag = true;//each step the value is valid or not.....
		while (flag) {
//				System.out.print("Enter the code for the item:");
			if (inputCode(keyboard)) {
				flag = true;
				break;
			} else {
				flag = false;
				break;
			}

		}

		while (flag) {
			System.out.print("Enter the name for the item:");
			keyboard.nextLine();
			this.itemName = keyboard.nextLine();
			break;
		}
		;
		keyboard.nextLine();
		while (flag) {
			System.out.print("Enter the quantity for the item:");
			try {
				this.itemQuantityinStock = Integer.parseInt(keyboard.nextLine());
				if (itemQuantityinStock <= 0) {
					System.out.println("...must be a positive int...\n");
				} else
					break;
			} catch (NumberFormatException e) {// The input value can not transfer into a Integer......
				System.out.println("...must be a positive int...\n");// This handles of NumberFormatException
			}
		}
		;

		while (flag) {
			System.out.print("Enter the cost of the item:");
			try {
				this.itemCost = Float.parseFloat(keyboard.nextLine());
				if (itemCost <= 0) {
					System.out.println("...must be a positive ...\n");
				} else
					break;
			} catch (NumberFormatException e) {// The input value can not transfer into a Integer......
				System.out.println("...must be a positive number...\n");// This handles of NumberFormatException
			}
		}
		;

		while (flag) {
			System.out.print("Enter the sales price of the item:");
			try {
				this.itemPrice = Float.parseFloat(keyboard.nextLine());
				if (itemPrice <= 0) {
					System.out.println("...must be a positive number...\n");
				} else
					break;
			} catch (NumberFormatException e) {// The input value can not transfer into a Integer......
				System.out.println("...must be a positive number...\n");// This handles of NumberFormatException
			}
		}
		;
//		System.out.println("itemName: " + this.itemName);
		return flag; // This value to delivery to subclass to continue the final create the object.
	}

	@SuppressWarnings("unlikely-arg-type")
	protected boolean inputCode(Scanner keyboard) {
		int icode=-1;
		boolean flag = true; // check the input code is integer by while loop.....
		// System.out.println("Enter the code for the item:");
		boolean result = true; // result - 'true' valid codeNumber; result - 'false' invalid quit the program;
		while (flag) {
			System.out.print("Enter the code for the item:");
			if (keyboard.hasNextInt()) {
				// this.itemCode = Integer.parseInt(keyboard.next());
				this.itemCode = Integer.parseInt(keyboard.next());
				icode = this.itemCode;
				flag = false;
			} else {
				System.out.println("Error: Invalid input. Please enter an integer.");
				keyboard.next();
			}
		}

		
		try {
				for(FoodItem fd:Inventory.arrayFoods) {
					if(fd.getItemCode()==icode) {
						//System.out.println(icode+"is duplicated...Return to main menu:" );
						return false;	
					}
				}
		} catch (NullPointerException e) {
			//System.out.println("FoodItems are empty or don't have duplicated number......");
			result  = true;
		}



		return result;

	}

	public int getItemCode() {
		return itemCode;
	}

	@Override
	public String toString() {
		return "Item:" + itemCode + " " + itemName + " " + itemQuantityinStock + " price:" + "$" + itemPrice + " cost:"
				+ "$" + itemCost;
	};

}
