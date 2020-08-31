package com.pluralsight.getorganized;

import java.text.NumberFormat;
import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {
    }

    // Instance Variables and Initialization
    public long cash = 0;
    public int num_withdrawals = 0;
    public int num_deposits = 0;
    public long withdrawAmount = 0;
    public long loan = 0;
    public double interestRate = 0;
    public String transferName = "";
    public long transferAmount = 0;
    public String name = "";
    public int ID = 0;
    public String insurer = "";
    public long policyNumber = 0;
    public long premiumAmount = 0;
    public boolean cashTransferred = false;
    public boolean madeDeposit = false;
    public boolean madeWithdrawal = false;
    public boolean madeLoan = false;
    public boolean madePremium = false;
    int minWithdrawal = 100;
    int maxWithdrawal = 2_000_000;
    int minDeposit = 100;
    int maxDeposit = 50_000_000;
    int minLoan = 100;
    int maxLoan = 100_000;
    double minInterest = 0.05;
    double maxInterest = 0.65;
    NumberFormat currency = NumberFormat.getCurrencyInstance();
    NumberFormat percentage = NumberFormat.getPercentInstance();
    Scanner scanner = new Scanner(System.in);

    // Greeting message for the user, reliant on the entered ID and username.
    public void GreetUser() throws Exception {
        // Messages, concatenated with the parameters given.
        System.out.println("Welcome to your very own ATM! This automated teller machine will let you deposit and " +
                "withdraw funds and will give you access to a variety of other features.");

        System.out.println("Enter your name: ");
        name = scanner.nextLine();
        System.out.println("Enter your ID: ");
        ID = Integer.parseInt(scanner.nextLine());

        System.out.println("So, " + name + ", your ID or identification pin is " + ID + ".");
        System.out.println("You're all set! Follow the ATM's built-in interface and get started!");
        System.out.println("-----------------------------------------------------------------------");
        publicInterface();
    }

    public void publicInterface() throws Exception {
        // Options are provided and user is given input as to where he/she wants to go.
        System.out.println("Welcome to the ATM, " + name + ". Your options are listed below.");
        System.out.println("NOTE: THE NUMBER NEXT TO EACH ACTION IS THE NUMBER YOU MUST ENTER TO GO THERE.");
        System.out.println("1: Make a deposit.");
        System.out.println("2: Make a withdrawal.");
        System.out.println("3: Apply for a personal loan.");
        System.out.println("4: Get your current balance or funds.");
        System.out.println("5: Transfer cash to someone else.");
        System.out.println("6: Pay insurance premium.");
        System.out.println("7: Exit.");

        try {
            String preferenceTest = scanner.nextLine();
            int preference = Integer.parseInt(preferenceTest);
            // Switch statement for navigation to withdrawal and deposit interfaces.
            switch (preference) {
                case 1:
                    // Input for desired deposit, makes string into an integer, and calls makeDeposit method.
                    System.out.println("Enter your desired deposit amount (do not enter a deposit greater than 50 million): ");
                    long depAmount = Long.parseLong(scanner.nextLine());
                    madeDeposit = true;
                    while (depAmount < minDeposit || depAmount > maxDeposit) {
                        madeDeposit = false;
                        System.out.println("Invalid Input! You cannot deposit this much money.");
                        System.out.println("Enter your desired deposit amount: ");
                        depAmount = Long.parseLong(scanner.nextLine());
                        if (depAmount > minDeposit && depAmount < maxDeposit) {
                            madeDeposit = true;
                            break;
                        }
                    }
                    makeDeposit(depAmount);
                    break;
                case 2:
                    // Input for desired withdrawal, makes string into an integer, and calls makeWithdrawal method.
                    System.out.println("Enter your desired withdrawal amount (do not enter a withdrawal greater than 2 million): ");
                    withdrawAmount = Long.parseLong(scanner.nextLine());
                    while (withdrawAmount < minWithdrawal || withdrawAmount > maxWithdrawal) {
                        System.out.println("Invalid Input! You cannot withdraw this much money.");
                        System.out.println("Enter your desired withdrawal amount: ");

                        withdrawAmount = Long.parseLong(scanner.nextLine());

                        if (withdrawAmount > minWithdrawal && withdrawAmount < maxWithdrawal) {
                            madeWithdrawal = true;
                            break;
                        }
                    }
                    makeWithdrawal();
                    break;
                case 3:
                    personalLoanApplication();
                    break;
                case 4:
                    getBalance();
                    break;
                case 5:
                    cashTransfer();
                    break;
                case 6:
                    payInsurancePremium();
                    break;
                case 7:
                    finalDisplay();
                    break;
            }
        }
        // Exception Handling
        catch(NumberFormatException e ){
            throw new Exception("You have entered an invalid value, please try again.");
        }
        catch(Exception e ){
            throw new Exception("Error. Please re-run and try again.");
        }
    }

    // Method for making a deposit into funds.
    public void makeDeposit(long depositAmount) throws Exception {
        // Entrance into menu and updating of variables.
        System.out.println("You have made a deposit of " + depositAmount + " into your funds.");

        cash += depositAmount;
        System.out.println("Your cash now sits at " + currency.format(cash));
        num_deposits += 1;
        System.out.println("Number of deposits: " + num_deposits);
        System.out.println("-------------------------------------------");
        publicInterface();
    }

    // Method for making a withdrawal from funds.
    public void makeWithdrawal() throws Exception {
        // Entrance into menu and updating of variables.
        while (true) {
            if (withdrawAmount > cash) {
                System.out.println("This is an invalid Input. Your withdrawal makes your total funds negative.");
                System.out.println("Please try again.");
                withdrawAmount = Long.parseLong(scanner.nextLine());
            }

            if (withdrawAmount < cash) {
                madeWithdrawal = true;
                cash -= withdrawAmount;
                System.out.println("You have made a withdrawal of " + withdrawAmount + " from your funds.");
                break;
            }
        }

        System.out.println("Your cash now sits at " + currency.format(cash));
        num_withdrawals += 1;
        System.out.println("Number of withdrawals: " + num_withdrawals);
        System.out.println("-------------------------------------------");
        publicInterface();
    }

    public void getBalance() throws Exception {
        System.out.println("You currently have " + currency.format(cash) + " in your funds.");
        System.out.println("--------------------------------");
        publicInterface();
    }

    public void personalLoanApplication() throws Exception {
        System.out.println("Welcome to the personal loan application menu, " + name + ".");
        System.out.println("Enter your preferred loan amount (this should be between 100 and 100,000).");
        try {
            loan = Long.parseLong(scanner.nextLine());
            madeLoan = true;
            while (loan < minLoan || loan > maxLoan) {
                madeLoan = false;
                System.out.println("Invalid Input! You cannot apply for a loan with this amount.");
                System.out.println("Enter your loan amount: ");

                loan = Long.parseLong(scanner.nextLine());

                if (loan > minLoan && loan < maxLoan) {
                    madeLoan = true;
                    break;
                }
            }
            System.out.println("Great! Now enter your interest rate as a decimal (this should be between 0.05 and 0.65).");
            String intAmt = scanner.nextLine();
            interestRate = Double.parseDouble(intAmt);
            while (interestRate < minInterest || interestRate > maxInterest) {
                System.out.println("Invalid Input! You cannot enter in this interest rate.");
                System.out.println("Enter your interest rate as a decimal: ");

                interestRate = Long.parseLong(scanner.nextLine());

                if (interestRate > minInterest && interestRate < maxInterest) {
                    break;
                }
            }
        }
        catch (NumberFormatException e) {
            throw new Exception ("You have entered an invalid value. Please try again and re-enter.");
        }

        System.out.println("Well done! You have submitted your application for a personal loan.");
        System.out.println("SUMMARY");
        System.out.println("-----------------------------");
        System.out.println("LOAN AMOUNT: " + currency.format(loan));
        System.out.println("INTEREST RATE: " + percentage.format(interestRate));
        System.out.println("-----------------------------");
        publicInterface();
    }

    public void cashTransfer() throws Exception {
        System.out.println("Welcome to the cash transfer menu, " + name + "!");
        System.out.println("Enter the name of who you want to transfer cash to: ");
        transferName = scanner.nextLine();
        System.out.println("Enter the amount of cash you would like to transfer (cannot be greater than " + currency.format(cash) + "): ");
        transferAmount = Long.parseLong(scanner.nextLine());
        cashTransferred = true;
        while (true) {
            if (transferAmount < cash) {
                cashTransferred = true;
                break;
            }
            while (transferAmount > cash || transferAmount < 0) {
                if (transferAmount < 0) {
                    System.out.println("Invalid Input! Your transfer amount is negative.");
                    System.out.println("Enter the amount of cash you would like to transfer (cannot be greater than " + currency.format(cash) + "): ");
                    transferAmount = Long.parseLong(scanner.nextLine());
                    if (transferAmount > cash) {
                        System.out.println("Invalid Input! Your transfer amount is greater than your current funds.");
                        System.out.println("Enter the amount of cash you would like to transfer (cannot be greater than " + currency.format(cash) + "): ");
                        transferAmount = Long.parseLong(scanner.nextLine());
                    }
                }
                if (transferAmount > cash) {
                    System.out.println("Invalid Input! Your transfer amount is greater than your current funds.");
                    System.out.println("Enter the amount of cash you would like to transfer (cannot be greater than " + currency.format(cash) + "): ");
                    transferAmount = Long.parseLong(scanner.nextLine());
                    if (transferAmount < 0) {
                        System.out.println("Invalid Input! Your transfer amount is negative.");
                        System.out.println("Enter the amount of cash you would like to transfer (cannot be greater than " + currency.format(cash) + "): ");
                        transferAmount = Long.parseLong(scanner.nextLine());
                    }
                }
            }
        }
        System.out.println("Thank you for your input! We will transfer " + currency.format(transferAmount) + " to " + transferName + ".");
        publicInterface();
    }

    public void payInsurancePremium() throws Exception {
        String L = "LIC";
        System.out.println("Welcome to the insurance menu, " + name + "! Here, you can pay insurance premiums easily and quickly!");
        System.out.println("Who is your insurer?");
        System.out.println("Enter 'L' for LIC.");
        System.out.println("Enter 'H' for HDFC.");
        System.out.println("Enter 'S' for SBI Life.");
        insurer = scanner.nextLine();
        madePremium = true;

        while (!insurer.equals("L") || !insurer.equals("H") || !insurer.equals("S")) {
            if (insurer.equals("L") || insurer.equals("H") || insurer.equals("S")) {
                madePremium = true;
                break;
            }
            madePremium = false;
            System.out.println("Invalid Input! Please try again and re-enter.");
            System.out.println("Who is your insurer?");
            System.out.println("Enter 'L' for LIC.");
            System.out.println("Enter 'H' for HDFC.");
            System.out.println("Enter 'S' for SBI Life.");
            insurer = scanner.nextLine();
        }

        try {
            System.out.println("Great! Now enter your policy number (this should be less than $5000): ");
            policyNumber = Long.parseLong(scanner.nextLine());
            while (true) {
                if (policyNumber < 5000) {
                    madePremium = true;
                    break;
                }
                while (policyNumber > 5000 || policyNumber < 0) {
                    madePremium = false;
                    if (policyNumber < 0) {
                        System.out.println("Invalid Input! Your policy number is negative.");
                        System.out.println("Now enter your policy number (this should be less than $5000): ");
                        policyNumber = Long.parseLong(scanner.nextLine());
                        if (policyNumber > 5000) {
                            System.out.println("Invalid Input! Your policy number is greater than $5000!");
                            System.out.println("Now enter your policy number (this should be less than $5000): ");
                            policyNumber = Long.parseLong(scanner.nextLine());
                        }
                    }

                    if (policyNumber > 5000) {
                        System.out.println("Invalid Input! Your policy number is greater than $5000!");
                        System.out.println("Now enter your policy number (this should be less than $5000): ");
                        policyNumber = Long.parseLong(scanner.nextLine());
                        if (policyNumber < 0) {
                            System.out.println("Invalid Input! Your policy number is negative.");
                            System.out.println("Now enter your policy number (this should be less than $5000): ");
                            policyNumber = Long.parseLong(scanner.nextLine());
                        }
                    }
                }
            }
            System.out.println("Awesome! Now enter your premium amount (this should be less than $1000): ");
            premiumAmount = Long.parseLong(scanner.nextLine());
            while (true) {
                if (premiumAmount < 1000) {
                    madePremium = true;
                    break;
                }
                while (premiumAmount > 1000 || premiumAmount < 0) {
                    madePremium = false;
                    if (premiumAmount < 0) {
                        System.out.println("Invalid Input! Your premium amount is negative.");
                        System.out.println("Now enter your premium amount (this should be less than $1000): ");
                        premiumAmount = Long.parseLong(scanner.nextLine());
                        if (premiumAmount > 1000) {
                            System.out.println("Invalid Input! Your premium amount is greater than $1000!");
                            System.out.println("Now enter your premium amount (this should be less than $1000): ");
                            premiumAmount = Long.parseLong(scanner.nextLine());
                        }
                    }

                    if (premiumAmount > 1000) {
                        System.out.println("Invalid Input! Your premium amount is greater than $1000!");
                        System.out.println("Now enter your premium amount (this should be less than $1000): ");
                        premiumAmount = Long.parseLong(scanner.nextLine());
                        if (premiumAmount < 0) {
                            System.out.println("Invalid Input! Your premium amount is negative.");
                            System.out.println("Now enter your premium amount (this should be less than $1000): ");
                            premiumAmount = Long.parseLong(scanner.nextLine());
                        }
                    }
                }
            }

                System.out.println("FINAL TRANSACTION: ");
                System.out.println("----------------------");
                switch (insurer) {
                    case "L":
                        System.out.println("You have payed your insurance for LIC with a premium of " + currency.format(premiumAmount) + ".");
                        System.out.println("Just as a friendly reminder, your policy number was " + policyNumber + ".");
                        System.out.println("--------------------------------------------------------------------------");
                        break;
                    case "H":
                        System.out.println("You have payed your insurance for HDFC with a premium of " + currency.format(premiumAmount) + ".");
                        System.out.println("Just as a friendly reminder, your policy number was " + policyNumber + ".");
                        System.out.println("--------------------------------------------------------------------------");
                        break;
                    case "S":
                        System.out.println("You have payed your insurance for SBI Life with a premium of " + currency.format(premiumAmount) + ".");
                        System.out.println("Just as a friendly reminder, your policy number was " + policyNumber + ".");
                        System.out.println("--------------------------------------------------------------------------");
                        break;
                }


            } catch (NumberFormatException e) {
            throw new Exception("Invalid Input. Please try again and re-enter.");
        }
        publicInterface();
    }

    
    public void finalDisplay () {
        System.out.println("Thanks for using the ATM, " + name);
        System.out.println("We greatly appreciate your time and hope to see you soon!");
        System.out.println("SUMMARY: ");
        System.out.println("-----------------------------");
        System.out.println("Name: " + name);
        System.out.println("ID: " + ID);
        System.out.println("Cash (Funds): " + currency.format(cash));
        if (madeLoan) {
            System.out.println("Loan Amount: " + currency.format(loan));
            System.out.println("Interest Rate (of loan): " + percentage.format(interestRate));
        }
        if (madeWithdrawal) {
            System.out.println("Number of Withdrawals: " + num_withdrawals);
        }
        if (madeDeposit) {
            System.out.println("Number of Deposits: " + num_deposits);
        }
        if (cashTransferred) {
            System.out.println(currency.format(transferAmount) + " has been transferred to " + transferName + ".");
        }
        if (madePremium) {
            System.out.println("Payed for an insurance premium with a premium amount of " + currency.format(premiumAmount) + " with a policy number of " + policyNumber + ".");
        }
    }
}