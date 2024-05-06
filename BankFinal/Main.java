package BankFinal;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<SavingsAccount> accounts = new ArrayList<>();

        int choice = -1;
        while (choice != 4) {
            System.out.println("โปรดเลือกรายการ:");
            System.out.println("0. เปิดบัญชี");
            System.out.println("1. ดูบัญชี");
            System.out.println("2. ฝากเงิน");
            System.out.println("3. ถอนเงิน");
            System.out.println("4. ปิดโปรแกรม");
            System.out.print("เลือก: ");

            String input = scanner.nextLine();

            if (input.matches("\\d+")) {
                choice = Integer.parseInt(input);

                switch (choice) {
                    case 0:
                        System.out.print("ป้อนชื่อผู้ใช้: ");
                        String name = scanner.nextLine();
                        System.out.print("ป้อนยอดเงิน: ");
                        double money = scanner.nextDouble();
                        SavingsAccount savingsAccount = new SavingsAccount(name, money);
                        accounts.add(savingsAccount);
                        System.out.println("บัญชีออมทรัพย์ของ " + savingsAccount.getName() + " มีเงิน " + savingsAccount.getMoney() + " บาท");
                        break;
                    case 1:
                        if (!accounts.isEmpty()) {
                            for (SavingsAccount account : accounts) {
                                System.out.println("บัญชีออมทรัพย์ของ " + account.getName() + " มีเงิน " + account.getMoney() + " บาท");
                            }
                        } else {
                            System.out.println("ไม่พบบัญชี");
                        }
                        break;
                    case 2:
                        if (!accounts.isEmpty()) {
                            System.out.print("ป้อนชื่อผู้ใช้: ");
                            scanner.nextLine();
                            String depositorName = scanner.nextLine();
                            System.out.print("ป้อนจำนวนเงินที่ต้องการฝาก: ");
                            double depositAmount = scanner.nextDouble();
                            for (SavingsAccount account : accounts) {
                                if (account.getName().equals(depositorName)) {
                                    try {
                                        account.deposit(depositAmount);
                                        System.out.println("ฝากเงิน " + depositAmount + " บาท");
                                    } catch (IllegalArgumentException e) {
                                        System.out.println("ไม่สามารถทำรายการได้: " + e.getMessage());
                                    }
                                    break;
                                }
                            }
                        } else {
                            System.out.println("ไม่พบบัญชี");
                        }
                        break;
                    case 3:
                        if (!accounts.isEmpty()) {
                            System.out.print("ป้อนชื่อผู้ใช้: ");
                            scanner.nextLine();
                            String withdrawerName = scanner.nextLine();
                            System.out.print("ป้อนจำนวนเงินที่ต้องการถอน: ");
                            double withdrawAmount = scanner.nextDouble();
                            for (SavingsAccount account : accounts) {
                                if (account.getName().equals(withdrawerName)) {
                                    try {
                                        account.withdraw(withdrawAmount);
                                        System.out.println("ถอนเงิน " + withdrawAmount + " บาท");
                                    } catch (InsufficientFundsException e) {
                                        System.out.println("ไม่สามารถทำรายการได้: " + e.getMessage());
                                    }
                                    break;
                                }
                            }
                        } else {
                            System.out.println("ไม่พบบัญชี");
                        }
                        break;
                    case 4:
                        System.out.println("ปิดโปรแกรม");
                        break;
                    default:
                        System.out.println("กรุณาเลือกใหม่");
                }
            } else {
                System.out.println("กรุณาป้อนตัวเลขเท่านั้น");
            }
        }

        scanner.close();
    }
}
