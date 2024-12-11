package ExpenseTracker;

import java.util.Scanner;

public class Confirmation {
    private final Scanner scanner = new Scanner(System.in);

    public boolean confirmAction(String message) {
        while (true) {
            System.out.print(message);
            String confirmation = scanner.nextLine().trim().toLowerCase();
            switch (confirmation) {
                case "y":
                case "yes":
                    return true;
                case "n":
                case "no":
                    return false;
                default:
                    System.out.println("Invalid input. Please enter 'y' or 'n'.");
                    break;
            }
        }
    }
}