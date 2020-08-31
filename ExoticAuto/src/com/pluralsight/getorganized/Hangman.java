package com.pluralsight.getorganized;

// Imports!
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
A Game of Hangman that is incorporated into the ExoticAuto journey. With 10 Lives, the player must guess the name of
an unknown car brand that is chosen randomly. A fun, interactive mini-game that is used for monetary gain and game
progression. Enjoy!
 */

// Object-Oriented Structure
public class Hangman {

    // Comprehensive Method which runs the Hangman Game! (called from Main Method)
    public List<Object> playHangman(Hangman hangman) {
        System.out.println();
        System.out.println("Welcome to Hangman! Let's begin.");
        System.out.println();
        String chosenWord = hangman.chooseWord();
        String dashed_string = hangman.printDashes(chosenWord);
        List<Object> resultList = hangman.userGuess(dashed_string, chosenWord);

        return resultList;
    }

    // A list of random car brands, some essential objects, and variables for randomizing and scoring.
    String[] words = {"Volvo", "Ferrari", "Maserati", "Lamborghini", "Pagani", "Bentley", "Buick", "Cadillac",
            "Chevrolet", "Acura", "Mclaren", "Chrysler", "Mitsubishi"};
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    int upperbound = words.length;
    int lives = 10;
    boolean userWin = false;

    // Chooses a random word from the array of car brands.
    private String chooseWord() {
        // Uses previously defined upper-bound to choose word.
        int chosen_index = random.nextInt(upperbound);

        return words[chosen_index];
    }

    // Prints dashes based on the length of the word chosen.
    private String printDashes(String chosenWord) {
        return "_ ".repeat(chosenWord.length());
    }

    // The Interface which handles guessing, dash display, and scoring.
    private List<Object> userGuess(String dashes, String chosenWord) {
        // Establishes a StringBuilder object and creates array lists for later storage.
        StringBuilder userGuess = new StringBuilder();
        String new_dashes = dashes.replace(" ", "");
        List<Integer> indexList = new ArrayList<>();
        List<Object> finalList = new ArrayList<>();

        // Gets all the indices of the chosen word by an iterative approach.
        for (int i = 0; i < chosenWord.length(); i++) {
            indexList.add(i);
        }

        // Infinite loop with break strategy implemented.
        while (true) {
            // Gets user input.
            System.out.print("Enter your guess here (needs to be a single letter): ");
            String input = scanner.next();

            // Checks to see if word contains character.
            if (chosenWord.toLowerCase().contains(input)) {

                // Gets the number of times the character appears in the word.
                char ch = input.charAt(0);
                int count = countChar(chosenWord.toLowerCase(), ch);

                // Displays some metrics.
                System.out.println(count + " occurrences of '" + ch + "' found.");
                System.out.println(lives + " lives left.");

                // Calls getIndices to retrieve all the matching indexes of the character.
                List<Integer> indices = getIndices(chosenWord, indexList, ch, count);

                // Modifies dashes to contain the character.
                dashes = dashDisplay(dashes, ch, indices);

                System.out.println(dashes);
                System.out.println();

                // Checks if the dashes are all filled up with proper characters.
                boolean allLetters = dashes.replaceAll(" ", "").chars().allMatch(Character::isLetter);

                // If so, terminates the program with a victory message.
                if (allLetters) {
                    System.out.println("Mission accomplished!");
                    System.out.println("You have won the game of Hangman by correctly guessing the car brand, " + chosenWord + ".");

                    // Adds return values to the final array list.
                    userWin = true;
                    finalList.add(userWin);
                    finalList.add(lives);

                    return finalList;
                }

            }

            // If the character entered is NOT within the chosen word.
            else {
                // Decreases lives.
                System.out.println("Incorrect! 1 life lost.");
                lives -= 1;
                System.out.println(lives + " lives remaining.");
                System.out.println();

                // Ends game if there are no lives remaining.
                if (lives == 0) {
                    System.out.println("GAME OVER. You lost!");
                    System.out.println("Thanks for playing!");
                    System.out.println();

                    // Adds to final return list (with the result of the game).
                    userWin = false;
                    finalList.add(userWin);

                    return finalList;
                }
            }
        }
    }

    // Gets the indices of the entered character.
    private List<Integer> getIndices(String chosenWord, List<Integer> indexList, char ch, int count) {
        // Creates a list that will be used for the storage of indexes.
        List<Integer> indices = new ArrayList<>();
        for (int index : indexList) {
            // If the user entered character is inside the chosen word...
            if (chosenWord.toLowerCase().charAt(index) == ch) {
                // Checks to see if there are more than one occurrences of the character.
                if (count > 1) {
                    // Scans through all indices.
                    for (int index1 : indexList) {
                        if (chosenWord.toLowerCase().charAt(index1) == ch) {
                            indices.add(index1); // Finds a match and adds index to indices.
                        }
                    }
                }
                else {
                    for (int index1 : indexList) {
                        if (chosenWord.toLowerCase().charAt(index1) == ch) {
                            indices.add(index1);
                        }
                    }
                }
            }
        }
        // Removes all duplicate values and returns the formatted list.
        List<Integer> listWithoutDuplicates = indices.stream().distinct().collect(Collectors.toList());
        return listWithoutDuplicates;
    }

    // Displays dashes based on user input.
    private String dashDisplay(String dashes, char ch, List<Integer> indices) {
        // Checks to see if list of indices is multi-formatted.
        if (indices.size() > 1) {
            for (int index : indices) {
                // Removes whitespace from dash and replaces the underscore with the user input.
                dashes = dashes.replaceAll(" ", "");
                dashes = replaceStr(dashes, index, ch);
            }
        }

        else {
            // Does the same as the upper if clause, but instead, gets the first element.
            dashes = dashes.replaceAll(" ", "");
            dashes = replaceStr(dashes, indices.get(0), ch);
        }

        // Adds whitespace between the underscores to add an element of professionalism.
        dashes = dashes.replace("", " ").trim();
        return dashes;
    }

    // Method used for replacing the dashes with the user-entered character.
    private String replaceStr(String str, int index, char replace) {
        if (str == null) {
            return str;
        } else if (index < 0 || index >= str.length()) {
            return str;
        }
        char[] chars = str.toCharArray();
        chars[index] = replace;
        return String.valueOf(chars);
    }

    // Method used to find the total occurrences of the user-entered character in the chosen word.
    private int countChar(String str, char c) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c)
                count++;
        }

        return count;
    }
}