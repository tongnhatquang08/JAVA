package Synchronized;
import java.util.Scanner;

class BankAccount_1 {
    private int balance;

    public BankAccount_1(int initialBalance) {
        this.balance = initialBalance;
    }
    public synchronized void deposit(int amount) {
        balance += amount;
        notify();
    }
    public synchronized void withdraw(int amount) {
        while (balance < amount) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        balance -= amount;
        System.out.println("Withdrawal successful: " + amount + ". Remaining balance: " + balance);
    }
}
public class Bai_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the initial balance: ");
        int initialBalance = scanner.nextInt();
        System.out.print("Enter the withdrawal amount for husband: ");
        int amountA = scanner.nextInt();
        System.out.print("Enter the withdrawal amount for wife: ");
        int amountB = scanner.nextInt();

        BankAccount_1 husbandAccount = new BankAccount_1(initialBalance);
        Thread wifeThread = new Thread(() -> {
            husbandAccount.withdraw(amountA);
        });
        wifeThread.start();
        Thread husbandThread = new Thread(() -> {
            husbandAccount.deposit(amountB);
        });

        husbandThread.start();
    }
}

