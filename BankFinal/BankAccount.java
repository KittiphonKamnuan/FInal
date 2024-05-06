package BankFinal;

public class BankAccount {
    private double money;
    private boolean accountcheck;
    public static final double BONUS = 5.0; 
    
    public BankAccount() {
        money = 0;
        accountcheck = false;
    }
    
    public BankAccount(double money) {
        this.money = money;
        accountcheck = false;
    }
    
    public void deposit(double amount) {
        money += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= money) {
            money -= amount;
        } else {
            throw new InsufficientFundsException("Insufficient funds!");
        }
    }
    
    public double calculateInterest() {
        return BONUS * money;
    }

    public double getMoney() {
        return money;
    }
}
