import org.example.Bank;
import org.example.BankAccount;
import org.example.InsufficientFundsException;
import org.example.NegativeAmountException;
import org.junit.Test;

import javax.security.auth.login.AccountNotFoundException;

import static org.junit.Assert.*;

public class BankTest {

    @Test
    public void testCreateAccount() throws AccountNotFoundException {
        Bank bank = new Bank();
        bank.createAccount("Alice", 1000);
        assertNotNull(bank.findAccount(1));
    }

    @Test
    public void testDeposit() throws AccountNotFoundException {
        Bank bank = new Bank();
        bank.createAccount("Alice", 1000);
        BankAccount account = bank.findAccount(1);
        account.deposit(500);
        assertEquals(1500, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdraw() throws AccountNotFoundException, InsufficientFundsException, NegativeAmountException {
        Bank bank = new Bank();
        bank.createAccount("Alice", 1000);
        BankAccount account = bank.findAccount(1);
        account.withdraw(500);
        assertEquals(500, account.getBalance(), 0.001);
    }

    @Test(expected = InsufficientFundsException.class)
    public void testWithdrawInsufficientFunds() throws AccountNotFoundException, InsufficientFundsException, NegativeAmountException {
        Bank bank = new Bank();
        bank.createAccount("Alice", 100);
        BankAccount account = bank.findAccount(1);
        account.withdraw(500);
    }


    @Test(expected = NegativeAmountException.class)
    public void testWithdrawNegativeAmount() throws InsufficientFundsException, NegativeAmountException, AccountNotFoundException {
        Bank bank = new Bank();
        bank.createAccount("Alice", 1500);

        BankAccount account = bank.findAccount(1);
        account.withdraw(-100);
    }



    @Test
    public void testTransferMoney() throws AccountNotFoundException, InsufficientFundsException, NegativeAmountException {
        Bank bank = new Bank();
        bank.createAccount("Alice", 1000);
        bank.createAccount("Bob", 500);
        bank.transferMoney(1, 2, 300);
        assertEquals(700, bank.findAccount(1).getBalance(), 0.001);
        assertEquals(800, bank.findAccount(2).getBalance(), 0.001);
    }

    @Test(expected = AccountNotFoundException.class)
    public void testTransferMoneyAccountNotFound() throws AccountNotFoundException, InsufficientFundsException, NegativeAmountException {
        Bank bank = new Bank();
        bank.createAccount("Alice", 1000);
        bank.transferMoney(1, 2, 300);
    }
}
