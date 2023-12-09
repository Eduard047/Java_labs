package org.example;

import javax.security.auth.login.AccountNotFoundException;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        bank.createAccount("Margaret", 1500);
        bank.createAccount("Andrew", 2000);

        try {
            BankAccount MargaretAccount = bank.findAccount(1);
            BankAccount AndrewAccount = bank.findAccount(2);

            bank.transferMoney(1, 2, 300);
            System.out.println("Transfer successful.");
            System.out.println("Margaret's balance: " + MargaretAccount.getBalance());
            System.out.println("Andrew's balance: " + AndrewAccount.getBalance());
        } catch (InsufficientFundsException | NegativeAmountException | AccountNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
