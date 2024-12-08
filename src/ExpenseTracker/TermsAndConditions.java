package ExpenseTracker;

import java.util.Scanner;

public class TermsAndConditions extends menu {
    public void display() {
        Scanner s = new Scanner(System.in);
        System.out.println("╔══════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                                                                                                              ║");
        System.out.println("║\tTERMS AND CONDITIONS                                                                                   ║");
        System.out.println("║                                                                                                              ║");
        System.out.println("║\t\tPlease read the following terms and conditions                                                 ║");
        System.out.println("║\t\tcarefully before registering and using our system.                                             ║");
        System.out.println("║                                                                                                              ║");
        System.out.println("║\t\t\t1. ACCEPTANCE OF TERMS                                                                 ║");       
        System.out.println("║\t\t\tBy registering and using our system, you confirm that you have read,                   ║");
        System.out.println("║\t\t\tunderstood, and agree to be bound by the terms and conditions of this                  ║");
        System.out.println("║\t\t\tagreement. If you do not agree to the terms, you may not use the system.               ║");
        System.out.println("║                                                                                                              ║");
        System.out.println("║\t\t\t2. USER INFORMATION                                                                    ║");
        System.out.println("║\t\t\tTo provide a personalized experience, we collect the following information             ║");
        System.out.println("║\t\t\tduring registration and usage:                                                         ║");
        System.out.println("║                                                                                                              ║");
        System.out.println("║\t\t\tPersonal Details: Email address (Gmail only).                                          ║");
        System.out.println("║\t\t\tFinancial Data: Monthly income, expenses, and categories.                              ║");
        System.out.println("║\t\t\tWe ensure that your information is securely stored and used solely for improving       ║");
        System.out.println("║\t\t\tyour experience within the system.                                                     ║");
        System.out.println("║                                                                                                              ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
        System.out.println("\tPress Enter to continue...");
        s.nextLine(); 
    }
}