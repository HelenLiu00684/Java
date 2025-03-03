package assignment1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * CET - CS Academic Level 3 This class contains Assignment 1 Student Name:
 * QianJun Liu Student Number: 041150452 Course: CST8130 - Data Structures
 * 
 * @author/Professor: James Mwangi PhD.
 * 
 */

public class Inventory {

	protected static FoodItem[] arrayFoods = new FoodItem[20];// Create a array to save each items.
	// protected FoodItem[] arrayFoods;// Create a array to save each items.

	protected int numberItems = 0;// The size of real item saving in the arrayFoods.

	// Scanner keyboard = new Scanner(System.in); // Create a Scanner object to read
	// input.;

	protected FoodItem item;

////	protected static int[] FoodItemCodes = new int[20];
//	static List<Integer> FoodItemCodeslist = new ArrayList<>(); // Create this list to save the codeNumber of the item
//																// from array, to meet the requirement when just input
//																// an invalid code for add or update, the code will
//																// return the main menu promptly.

	public Inventory() {
	};

	protected boolean addItem(Scanner keyboard) {
		boolean itemAddedBoolean;// To check a new object has been created
		int itemAlreadyCheck;// To ehceck this new object has benn created before.
		// FoodItem[] arrayFoods = new FoodItem[20];

		boolean flag = false; // to record the result of this add action is success (true)or not(false)........
		while (!flag) {
			System.out.print("Do you wish to add a fruit(f),vegetable(v),preserve(p),or a seafood(s)?");
			try {
				Pattern pattern = Pattern.compile("[f,v,p,s,F,V,P,S]");
				char lowerCaseCharVal = Character.toLowerCase(keyboard.next().charAt(0));

				if (pattern.matcher(String.valueOf(lowerCaseCharVal)).matches()) {

					switch (lowerCaseCharVal) {
					case 'f':
						item = new Fruit();
						itemAddedBoolean = item.addItem(keyboard); // invoke object method to collect each item and
																	// create
																	// an Object to add in the arrayFoods......
						//System.out.println(item.toString());
						itemAlreadyCheck = alreadyExists(item);// to invoke already Exist to check any item existing or
																// not.....return n:finding existing item, return -1 :not finding existing item.
					if(itemAlreadyCheck!=-1) {
						System.out.println("The Item index "+itemAlreadyCheck+" is existing..... Item will not be created. ");
						flag = true;
						break;
					}

						if (itemAddedBoolean && (itemAlreadyCheck == -1)) {// all data is valid and the item has never
																			// been created.....
							arrayFoods[numberItems++] = item;
							flag = true;
						}
						// System.out.println(item.toString());
						break; // to loop.....

					case 'v':
						item = new Vegetable();
						itemAddedBoolean = item.addItem(keyboard); // invoke object method to collect each item and
																	// create
																	// an Object to add in the arrayFoods......
						itemAlreadyCheck = alreadyExists(item);// to invoke already Exist to check any item existing or
																// not.....
						if(itemAlreadyCheck!=-1) {
							System.out.println("The  Item  index "+itemAlreadyCheck+" is existing..... Item will not be created. ");
							flag = true;
							break;
						}

						if (itemAddedBoolean && (itemAlreadyCheck == -1)) {// all data is valid and the item has never
																			// been created.....
							arrayFoods[numberItems++] = item;
							flag = true;
						}
						break; // to loop.....

					case 'p':
						item = new Preserve();
						itemAddedBoolean = item.addItem(keyboard); // invoke object method to collect each item and
																	// create
																	// an Object to add in the arrayFoods......
						itemAlreadyCheck = alreadyExists(item);// to invoke already Exist to check any item existing or
																// not.....
						if(itemAlreadyCheck!=-1) {
							System.out.println("The  Item  index "+itemAlreadyCheck+" is existing..... Item will not be created. ");
							flag = true;
							break;
						}
						if (itemAddedBoolean && (itemAlreadyCheck == -1)) {// all data is valid and the item has never
																			// been created.....
							// if (itemAddedBoolean) {
							// System.out.println(item);
							arrayFoods[numberItems++] = item;
							flag = true;
						}
						break; // to loop.....

					case 's':
						item = new Seafood();
						itemAddedBoolean = item.addItem(keyboard); // invoke object method to collect each item and
																	// create
																	// an Object to add in the arrayFoods......
						itemAlreadyCheck = alreadyExists(item);// to invoke already Exist to check any item existing or
																// not.....
						if(itemAlreadyCheck!=-1) {
							System.out.println("The  Item  index "+itemAlreadyCheck+" is existing..... Item will not be created. ");
							flag = true;
							break;
						}
						if (itemAddedBoolean && (itemAlreadyCheck == -1)) {// all data is valid and the item has never
																			// been created.....
							// if (itemAddedBoolean) {
							// System.out.println(item);
							arrayFoods[numberItems++] = item;
							flag = true;
						}
						break; // to loop.....
					}

				} else {
					System.out.println(" ...invalid input...try again..."); // Only 4 types of food is
																			// permitted:fruit(f),vegetable(v),preserve(p),or
																			// sea food.
				}


			} catch (InputMismatchException e) { // This catches the mismatchFormatted that occurs when you don't input
													// a
													// char.
				System.err.println("Error: You did not input an valid value to reprsent food. Try again.\n"); //
				keyboard.next();
			}
		}



		return flag;// This return is not working in Sample demo!!!!!!
	};

	private int alreadyExists(FoodItem fooditemNew) {// return n:finding existing item, return -1:not finding existing item.
		// int itemCode=fooditem.getItemCode();
		FoodItem fd=fooditemNew;
		try {
			for (FoodItem foodItem : arrayFoods) {
			if (foodItem.getItemCode()==fd.getItemCode()) {
//				if (fd==foodItem) {
					return foodItem.getItemCode();
				}
			}
			return -1;
		} catch (NullPointerException e) {
			return -1;
		}
		

	}

	@SuppressWarnings("null")
	protected boolean updateQuantity(Scanner keyboard, boolean bsflag) {// This function is integration add or reduce
																		// method together.
		boolean flag = false; // to check input value is an valid number....
		boolean result = true; // Return result of update is working or not....
		int inputcode = -1; // save the input item code....
		int inputQuantity = -1; // save the input item quantity....

		if (arrayFoods == null) {
			// System.err.println("FoodItemCodeslist need initialize......");
			return false;
		}
		boolean hasElements = false;

		for (FoodItem item : arrayFoods) {
		    if (item != null) {
		        hasElements = true;
		        break; 
		    }
		}

		if (!hasElements) { 
		    return false;
		}
		while (!flag) { // 循环直到输入有效
			System.out.print("Enter the code for the item:");
			if (keyboard.hasNextInt()) {
				try {
					inputcode = Integer.parseInt(keyboard.next());
					flag = true; // quit the input while
				} catch (NumberFormatException e) {
					System.err.println("Error: Invalid input. Please enter an integer.");
				}
			} else {
				System.out.println("Error: Invalid input. Please enter an integer.");
				keyboard.next(); // clear input buffer
			}
		}


//		
//		try {
//			for(FoodItem fd:Inventory.arrayFoods) {
//				if(fd.getItemCode()!=inputcode) {
//					//System.out.println(icode+"is duplicated...Return to main menu:" );
//					return false;	//arrayFoods don't have the item and return false to return the main menu
//				}
//			}
//	} catch (NullPointerException e) {
//		//System.out.println("FoodItems are empty or don't have duplicated number......");
//	}
		
		

		flag = false;
		while (!flag) {
			System.out.print("Enter the valid quantity to buy (positive integer): ");
			if (keyboard.hasNextInt()) {
				inputQuantity = keyboard.nextInt();
				if (inputQuantity >= 0) {// the inputQuantity is position integer
					flag = true;// quit the input while
				} else {
					System.out.println("Error: Quantity must be non-negative integer.");
				}
			} else {
				System.out.println("Error: Invalid input. Please enter an integer.");
				keyboard.next(); // clear input buffer
			}
		}

		//System.out.println("The item code is: " + inputcode + " the quantity is: " + inputQuantity); // To recode the
																										// valid item
																										// code and
																										// quantity

		item = null;
		for (FoodItem fd : arrayFoods) { // To recode the valid item code and quantity
			if (fd != null && fd.getItemCode() == inputcode) {
				item = fd;
			}
		}
		
		//System.out.println(item.toString());

		if (alreadyExists(item) == -1) { // Find duplicated item in a arrayList
			//System.out.println("Find a existing item...... "+alreadyExists(item));
			return false;
		}

		if (bsflag == true) {
			item.updateitem(inputQuantity); // This function is add the input quantity to the existing quantity amounts
			//System.out.println("The final quantity after buying is " + item.itemQuantityinStock);
		} else if (bsflag == false) { // This function is reducethe input quantity to the existing quantity amounts
			if (item.itemQuantityinStock >= inputQuantity) {
				item.updateitem(0 - inputQuantity);
			} else {
				System.out.println("Insufficient stock in inventory...... " + item.itemQuantityinStock);
				return false; // if the amount is insufficient, reduction is begin roll back and produce a
								// warning.
			}
		}
		return result;
	}

	protected void displayInventory() { // display all items of arraylist.....
		// TODO Auto-generated method stub


		try {
			for (FoodItem fd : arrayFoods) {
				if (fd != null)
					System.out.println(fd.toString());
			}
		} catch (NullPointerException e) {
			// System.err.println("FoodItemArray need initialize......");
			System.out.println("");
		}
	}



}
