import java.util.Scanner;

public class MakeChange {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // *User Story #1
        // *The user is prompted asking for the price of the item.
        System.out.println("What is the price of the item? ");
        double itemPrice = sc.nextDouble();

        // *User Story #2
        // *The user is then prompted asking how much money was tendered by the
        // customer.
        System.out.println("How much did the customer give? ");
        double amtTender = sc.nextDouble();
        sc.close();

        // *User Story #3
        // *Display an appropriate message if the customer provided too little money or
        // *the exact amount.
        double amtRemaining = amtTender - itemPrice;

        if (amtRemaining < 0) {
            System.err.print("The item is: " + Math.round(itemPrice)
                    + " Please pay the remaining amount: "
                    + Math.round(-amtRemaining));
        } else if (amtRemaining == 0) {
            System.out.print("Thank you come again! ");
        } else {
            changeBreakdown(amtRemaining);
        }
    }

    // *User Story #4
    // *If the amount tendered is more than the cost of the item, display the number
    // *of bills and coins that should be given to the customer.
    private static void changeBreakdown(double change) {
        System.out.println("Your change is: $" + change);
        System.out.println("\nChange Breakdown: ");

        int[] values = { 2000, 1000, 500, 100, 25, 10, 5, 1 };
        String[] labels = { "twenty dollar bill(s)", "ten dollar bill(s)", "five dollar bill(s)", "one dollar bill(s)",
                "quarter(s)", "dime(s)", "nickel(s)", "penny(s)" };

        for (int i = 0; i < values.length; i++) {
            int quantity = (int) (change / values[i]);
            change -= quantity * values[i];
            change = Math.round(change * 100.0) / 100.0; // Avoid rounding errors

            if (quantity > 0) {
                System.out.println(quantity + " " + labels[i]);
            }
        }
    }
}
