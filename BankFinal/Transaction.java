package BankFinal;

public interface Transaction {
    void deposit(double amount);
    void withdraw(double amount) throws InsufficientFundsException;
}
