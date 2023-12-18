package org.example;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a word to check if it's a palindrome: ");
        String input = scanner.nextLine();

        if (PalindromeChecker.isPalindrome(input)) {
            System.out.println("The word is a palindrome!");
        } else {
            System.out.println("The word is not a palindrome.");
        }

        scanner.close();
    }
}
