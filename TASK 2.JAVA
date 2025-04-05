##"Build a program that generates a random number and challenges the user to guess it. The program should prompt the user to input their guess, compare it to the generated number

##Main code in java

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    private static final int DEFAULT_LOWER_BOUND = 1;
    private static final int DEFAULT_UPPER_BOUND = 100;
    private final int secretNumber;
    private final int lowerBound;
    private final int upperBound;
    private int attempts;

    public NumberGuessingGame() {
        this(DEFAULT_LOWER_BOUND, DEFAULT_UPPER_BOUND);
    }

    public NumberGuessingGame(int lowerBound, int upperBound) {
        if (lowerBound >= upperBound) {
            throw new IllegalArgumentException("Lower bound must be less than upper bound.");
        }
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.secretNumber = generateRandomNumber(lowerBound, upperBound);
        this.attempts = 0;
    }

    private int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public void playGame() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to the Number Guessing Game!");
            System.out.printf("I'm thinking of a number between %d and %d.%n", lowerBound, upperBound);

            while (true) {
                System.out.print("Enter your guess: ");
                try {
                    int guess = scanner.nextInt();
                    attempts++;

                    if (guess < lowerBound || guess > upperBound) {
                        System.out.printf("Your guess is outside the valid range (%d - %d). Please try again.%n", lowerBound, upperBound);
                    } else if (guess < secretNumber) {
                        System.out.println("Too low! Try again.");
                    } else if (guess > secretNumber) {
                        System.out.println("Too high! Try again.");
                    } else {
                        System.out.printf("Congratulations! You guessed the number %d in %d attempts.%n", secretNumber, attempts);
                        break;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a whole number.");
                    scanner.next(); // Consume the invalid input
                }
            }
        }
    }

    public static void main(String[] args) {
        NumberGuessingGame game = new NumberGuessingGame();
        game.playGame();
    }
}


Explanation and Advanced Java Concepts Used:

Class Structure: The code is organized within a class NumberGuessingGame, which is a fundamental concept of object-oriented programming.

Constructor Overloading: There are two constructors:

NumberGuessingGame(): Uses default lower (1) and upper (100) bounds for the random number.
NumberGuessingGame(int lowerBound, int upperBound): Allows the user to specify the range for the random number.
Encapsulation: The secretNumber, lowerBound, upperBound, and attempts are private instance variables. This protects the internal state of the NumberGuessingGame object. Access to these variables (if needed) would typically be provided through public getter methods (though not strictly necessary for this game).

IllegalArgumentException: The constructor with bounds checks if the lowerBound is greater than or equal to the upperBound. If so, it throws an IllegalArgumentException, which is a standard way to indicate that invalid arguments were provided to a method.

generateRandomNumber Method: This private helper method encapsulates the logic for generating a random number within the specified range. This makes the playGame method cleaner.

##playGame Method: This method contains the main game logic:

try-with-resources: The Scanner object is created within a try-with-resources block. This ensures that the Scanner is automatically closed after it's no longer needed, even if exceptions occur. This is a best practice for managing resources like input streams.
Clear Prompts: The user is given clear instructions and feedback.
Input Validation:
It checks if the user's guess is within the valid range.
try-catch Block for InputMismatchException: This handles the case where the user enters non-integer input. Instead of the program crashing, it catches the InputMismatchException, prints an informative error message, and uses scanner.next() to consume the invalid input so that the next iteration of the loop can process new input.
Game Logic: It compares the user's guess with the secretNumber and provides appropriate feedback (too low, too high, or correct).
Attempt Counter: It keeps track of the number of attempts the user has made.
main Method: This is the entry point of the program. It creates an instance of NumberGuessingGame and calls the playGame() method to start the game.

##How to Compile and Run:

Save: Save the code as NumberGuessingGame.java.
Compile: Open a terminal or command prompt, navigate to the directory where you saved the file, and compile the code using the Java compiler:
Bash

javac NumberGuessingGame.java
Run: After successful compilation, run the program:
Bash

java NumberGuessingGame
This program demonstrates a more robust and professionally structured approach to the number guessing game in Java, incorporating best practices for input handling, error management, and code organization.
