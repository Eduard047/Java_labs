package org.example;

import javax.security.auth.login.AccountNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<BankAccount> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

    public void createAccount(String accountName, double initialDeposit) {
        int newAccountNumber = accounts.size() + 1;
        BankAccount newAccount = new BankAccount(newAccountNumber, accountName, initialDeposit);
        accounts.add(newAccount);
    }

    public BankAccount findAccount(int accountNumber) throws AccountNotFoundException {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        throw new AccountNotFoundException("Account not found");
    }

    public void transferMoney(int fromAccountNumber, int toAccountNumber, double amount)
            throws InsufficientFundsException, NegativeAmountException, AccountNotFoundException {
        BankAccount fromAccount = findAccount(fromAccountNumber);
        BankAccount toAccount = findAccount(toAccountNumber);

        if (amount < 0) {
            throw new NegativeAmountException("Negative amount not allowed");
        }

        if (fromAccount.getBalance() < amount) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal");
        }

        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
    }
}

