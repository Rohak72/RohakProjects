package com.pluralsight.getorganized;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Greeting the user with a greeting message.
        String greeting = greetUser();
        System.out.println(greeting);

        // Getting mathematical values from getValue method.
        int principal = (int) getValue("Principal: ", 100, 1_000_000);
        double interestRate = getValue("Enter the interest rate as a decimal: ", 0.05, 0.45);
        int numTimes = formatNumTimes();
        int time = (int) getValue("Enter time in years (e.g. 1, 3, or 5): ", 1, 20);

        // Deriving compound interest from a getter method which includes a formula.
        double compoundInterest = getCompoundInterest(principal, numTimes, interestRate, time);

        // Displaying all relevant values and final compound interest.
        finalDisplay(principal, numTimes, interestRate, time, compoundInterest);
    }

    public static String greetUser() {
        String userName = "";
        String greetingString = "";

        // Gets name and prints a matching string.
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        userName = scanner.nextLine();
        greetingString = "Hello! Welcome to the mortgage calculator, " + userName + "!";

        return greetingString;
    }

    public static double getValue(String prompt, double min, double max) {
        double value = 0;

        // Infinite Loop with a break statement used to provide validation and to generate user input.
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print(prompt);
            value = scanner.nextDouble();
            // Validation
            if (value < min || value > max) {
                System.out.println("Enter a number between " + min + " and " + max);
                continue;
            }
            return value;
        }

    }

    public static int formatNumTimes() {
        int numTimes = 0;

        // Input which gets the type of compound interest from the user.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you prefer: 'Monthly Interest', 'Weekly Interest', or 'Bi-annual Interest'? Enter in your preference. ");
        String compoundForm = scanner.nextLine();

        // If statements which evaluate user input and use string equality to assign a value to numTimes.
        if (compoundForm.equals("Monthly Interest"))
            numTimes = 12;
        else if (compoundForm.equals("Weekly Interest"))
            numTimes = 52;
        else if (compoundForm.equals("Bi-annual Interest"))
            numTimes = 2;
        else
            System.out.println("Invalid Input. Please enter one of the three options: 'Monthly Interest', 'Weekly Interest', 'Bi-annual Interest'.");
        return numTimes;
    }

    public static double getCompoundInterest(int principal, int numTimes, double interestRate, int time) {
        double compound = 0;
        double result = 0;
        int powerExponent = numTimes * time;

        // Computation using Compound Interest Formula.
        result = (1 + (interestRate / numTimes));
        compound = principal * (Math.pow(result, powerExponent));

        return compound;
    }

    public static void finalDisplay(int principal, int numTimes, double interestRate, int time, double compound) {
        // Formatting the interest rate into a percentage and the compound interest and principal into dollar amounts.
        NumberFormat percent = NumberFormat.getPercentInstance();
        String formattedInterest = percent.format(interestRate);
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String newCompound = currency.format((float) compound);
        NumberFormat currency2 = NumberFormat.getCurrencyInstance();
        String newPrincipal = currency.format(principal);

        // Display
        System.out.println("Final Display");
        System.out.println("----------------------");
        System.out.println("Principal: " + newPrincipal);
        System.out.println("Number of times you compound per year: " + numTimes);
        System.out.println("Interest Rate (as a percentage): " + formattedInterest);
        System.out.println("Time (in years): " + time);
        System.out.println("FINAL COMPOUND INTEREST: " + newCompound);
    }
}
