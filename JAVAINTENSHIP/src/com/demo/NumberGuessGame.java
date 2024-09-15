package com.demo;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  
        Random random = new Random();  
        
        int minRange = 1;  
        int maxRange = 100;
        int maxAttempts = 10;
        
        boolean playAgain = true;
        int roundsPlayed = 0;  
        int totalAttempts = 0; 
        
        while (playAgain) {  
            int targetNumber = random.nextInt(maxRange - minRange + 1) + minRange; 
            int attempts = 0; 
            roundsPlayed++; 
            
            System.out.println("Round " + roundsPlayed + ":");
            System.out.println("Guess the number between " + minRange + " and " + maxRange);
            
            while (attempts < maxAttempts) {  
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();  
                attempts++; 
                
                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    totalAttempts += attempts; 
                    break;  
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }
            
            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The number was: " + targetNumber);
            }
            
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.next();  
            playAgain = playAgainResponse.equalsIgnoreCase("yes"); 
        }
        
        double averageAttemptsPerRound = (double) totalAttempts / roundsPlayed;  
        System.out.println("Game over. Rounds played: " + roundsPlayed);
        System.out.println("Your average attempts per round: " + averageAttemptsPerRound);
        
        scanner.close();  
    }
}