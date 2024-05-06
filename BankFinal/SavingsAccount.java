package BankFinal;

public class SavingsAccount extends BankAccount implements Transaction {
    private String name;
    
    public SavingsAccount(String name, double money) {
        super(money); // เรียก Constructor ของคลาสแม่
        this.name = name;
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount); // เรียกใช้เมธอด deposit() จากคลาสแม่
        System.out.println("ฝากเงินสำเร็จ");
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        super.withdraw(amount); // เรียกใช้เมธอด withdraw() จากคลาสแม่
        System.out.println("ถอนเงินสำเร็จ");
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return super.getMoney();
    }
}
