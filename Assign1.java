package assignment1;

import java.util.Scanner;

import labWeek3.Lab3;

/**
 * CET - CS Academic Level 3 This class contains Assignment 1 Student Name:
 * QianJun Liu Student Number: 041150452 Course: CST8130 - Data Structures
 * 
 * @author/Professor: James Mwangi PhD.
 * 
 */

public class Assign1 {

	Scanner keyboard = new Scanner(System.in); // Create a Scanner object to read input

//	public FoodItem[] arrayFoods = new FoodItem[20];
//	public int numberItems = 0;

	public static void main(String[] args) {

		Assign1 assign = new Assign1(); // Create a object of class Assign1.
		Inventory invent = new Inventory(); // Create a object of class invent.
		int stringintVal = -1; // Create a variable in capture option 1-5.
		boolean updateFlag;

//		while (true) {
		while (true) { // Use true as the loop condition for continuous execution

			dispalyMean();
			System.out.print("> ");
			// System.out.print(String.format("\033[%d;%dH", 6, 2));
			try {
				stringintVal = Integer.parseInt(assign.keyboard.next());
				if (stringintVal >= 1 && stringintVal <= 5) {
					switch (stringintVal) {
					case 1 -> {
						if (invent.addItem(assign.keyboard)) {
//							System.out.println("The add action has been finished ....");
						}
//						else {
//							System.err.println("The addItem is failed....");
//						}
					} // Add eachItem to Inventory
					case 2 -> invent.displayInventory();// Display each Item of Inventory
					case 3 -> {                                                    //updateFlag = true success......= false failed.
						updateFlag = invent.updateQuantity(assign.keyboard, true);// Buy some Items and increase the
																					// quantity of this item.....
						if (!updateFlag) {
							System.out.println("Error....could not buy item......");// This item is not exist. 
						} else {
							System.out.println("The buying is success....");
						}
					}
					case 4 -> {
						updateFlag = invent.updateQuantity(assign.keyboard, false);// sell some Items and decrease the
																					// quantity of this item.....
						if (!updateFlag) {
							System.out.println("Error...could not sell item...");// This item is not exist.
						} else {
							System.out.println("The selling is success....");
						}
					}
					case 5 -> { // Exit the loop after calling toExit()
						String quitBlock = """
								Exiting ...
								""";

						System.out.println(quitBlock);
						assign.keyboard.close();
						System.exit(0);
						break;
					}
					}
				} else {
					System.out.println(" ...invalid input...try again...\n"); // only accept the input value between 1-
																				// 5

				}
			} catch (NumberFormatException e) {// The input value can not transfer into a Integer......
				System.out.println("...invalid input...try again...\n");// This handles of NumberFormatException to
																		// print a error message.

			}
		}

//		}

	};

	/**
	 * The sub function is for invoking Object functions to display values, minimum
	 * value, maximum value, max mod min, factorialMax ......
	 *
	 * @param null.
	 * 
	 * @return null.
	 */

	public static void dispalyMean() {

		String mainMenuItemBlock = """
				Please select one of the following:
				1: Add Item to Invertory
				2: Display Current Invertory
				3: Buy Item(s)
				4: Sell Item(s)
				5: To Exit
						""";
		System.out.print(mainMenuItemBlock + "");

	}

}
