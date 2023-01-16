package app;

import java.util.Scanner;

public class MakeChange {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double itemPrice = 0;
		double amtTender = 0;
		double amtRemaining = 0;
//		User Story #1
//		The user is prompted asking for the price of the item.
		System.out.print("What is the price of the item?: ");
		itemPrice = sc.nextDouble();

//		User Story #2
//		The user is then prompted asking how much money was tendered by the customer.
		System.out.print("How much did the customer give?: ");
		amtTender = sc.nextDouble();
		sc.close();
//		User Story #3
//		Display an appropriate message if the customer provided too little money or the exact amount.
		if (amtTender < itemPrice) {
			amtRemaining = amtTender - itemPrice;

			System.err.print("The item is: " + Math.round(itemPrice) 
							+ " Please pay the remaining amount: " 
							+ Math.round(amtRemaining));
		} else if (amtTender == itemPrice) {
			System.out.print("Thank you come again! ");
//    	User Story #4
//    	If the amount tendered is more than the cost of the item, display the number of bills and coins 
//    	that should be given to the customer.
		} else {
			changeBreakdown(amtTender, itemPrice);
		}
	}// Main Bracket

	private static void changeBreakdown(double amtTender, double itemPrice) {

		double change = amtTender - itemPrice;
		System.out.println("Your change is: $" + change);
		System.out.println("\nChange Breakdown:");

		int twentyDollars = (int) change / 20;
		if (twentyDollars > 0) {
			change -= twentyDollars * 20;
			System.out.println(twentyDollars + " twenty dollar bill(s)");
		}
		int tenDollars = (int) change / 10;
		if (tenDollars > 0) {
			change -= tenDollars * 10;
			System.out.println(tenDollars + " ten dollar bill(s)");
		}
		int fiveDollars = (int) change / 5;
		if (fiveDollars > 0) {
			change -= fiveDollars * 5;
			System.out.println(fiveDollars + " five dollar bill(s)");
		}
		int oneDollar = (int) change / 1;
		if (oneDollar > 0) {
			change -= oneDollar;
			System.out.println(oneDollar + " one dollar bill(s)");
		}
		int quarter = (int) (change / .25);
		if (quarter > 0) {
			change -= quarter * .25;
			System.out.println(quarter + " quarter(s)");
		}
		int dime = (int) (change / .10);
		if (dime > 0) {
			change -= dime * .10;
			System.out.println(dime + " dime(s)");
		}
		int nickel = (int) (change / .05);
		if (nickel > 0) {
			change -= nickel * .05;
			System.out.println(nickel + " nickel(s)");
		}
		int penny = (int) (change / .01);
		if (penny > 0) {
			change -= penny * .01;
			System.out.println(penny + " penny(s)");
		}

	}// changeBreakDown Bracket
}// Class Bracket