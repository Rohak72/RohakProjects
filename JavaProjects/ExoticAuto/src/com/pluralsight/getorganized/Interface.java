package com.pluralsight.getorganized;

import java.text.NumberFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class Interface {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    NumberFormat currency = NumberFormat.getCurrencyInstance();
    final int UPPERBOUND = 25000;
    final int LOWERBOUND = 15000;

    public List<String> introMessage() throws InterruptedException {
        System.out.println("Hey there!");
        System.out.println("Welcome to EXOTIC AUTO, the home of legendary automobiles.");
        System.out.print("Enter your name here: ");
        String name = scanner.nextLine();
        while (true) {
            try {
                Integer.parseInt(name);
                System.out.println(name + " is an integer. Please re-enter.");
                System.out.print("Enter your name here: ");
                name = scanner.nextLine();
            } catch (NumberFormatException e) {
                System.out.println("Great! Your name, '" + name + "' is valid.");
                break;
            }
        }

        System.out.println("Awesome!");
        System.out.println("Creating your personalized ID...");
        TimeUnit.SECONDS.sleep(1);
        int chosen_ID = 1000 + random.nextInt(1000);
        System.out.println("Chosen ID: " + chosen_ID);
        TimeUnit.SECONDS.sleep(1);

        List<String> returnValues = new ArrayList<>();
        returnValues.add(0, name);
        returnValues.add(1, Integer.toString(chosen_ID));

        return returnValues;

    }

    public int introMessage(boolean is_transaction) throws InterruptedException {
        System.out.println();
        System.out.println("Welcome to the Transactions Menu!");
        System.out.println("Here, your starting monetary amount will be computed.");
        System.out.println("Computing...");
        TimeUnit.SECONDS.sleep(2);

        int userMoney = random.nextInt(UPPERBOUND - LOWERBOUND) + LOWERBOUND;
        System.out.println("You now have: " + currency.format(userMoney) + " in savings!");
        TimeUnit.SECONDS.sleep(2);
        System.out.println();
        System.out.println("Now, in order to gain money, you will be placed into a Hangman game.");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Depending on your performance, a monetary amount will be added to your financial savings.");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Only enter CHARACTERS (SINGLE LETTERS) as input, or else the game will crash.");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Have fun and make some money!");
        TimeUnit.SECONDS.sleep(2);

        return userMoney;
    }

    public void carDisplay() throws InterruptedException {
        List<String> carList = new ArrayList<>();
        carList.add(0, "Mclaren 600LT");
        carList.add(1, "Lamborghini Urus");
        carList.add(2, "Ferrari 250 GTO");
        carList.add(3, "Bentley Bentayga");

        List<String> carPrices = new ArrayList<>();
        carPrices.add(0, "$50,000");
        carPrices.add(1, "$150,000");
        carPrices.add(2, "$200,000");
        carPrices.add(3, "$250,000");

        Hashtable<String, String> carDict = new Hashtable<>();
        carDict.put(carPrices.get(0), carList.get(0));
        carDict.put(carPrices.get(1), carList.get(1));
        carDict.put(carPrices.get(2), carList.get(2));
        carDict.put(carPrices.get(3), carList.get(3));

        System.out.println("Here are all the possible vehicles that YOU can purchase!\n");
        for (String key : carDict.keySet()) {
            System.out.println("Car Name: " + carDict.get(key) + "\nPrice: " + key + "\n");
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println("-----------------------------------------------------");
    }



}


