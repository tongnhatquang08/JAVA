package Synchronized;
import java.util.Scanner;

class BankAccount {
    private int balance;

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void withdraw(int amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: " + balance);
        }
        else {
            System.out.println("Insufficient balance for the requested withdrawal.");
        }
    }
    public synchronized int getBalance() {
        return balance;
    }
}
class WithdrawThread extends Thread {
    private BankAccount account;
    private int amount;
    public WithdrawThread(BankAccount account, int amount) {
        this.account = account;
        this.amount = amount;
    }
    public void run() {
        account.withdraw(amount);
    }
}
public class Bai_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the initial balance: ");
        int initialBalance = scanner.nextInt();
        System.out.print("Enter the withdrawal amount for person A: ");
        int amountA = scanner.nextInt();
        System.out.print("Enter the withdrawal amount for person B: ");
        int amountB = scanner.nextInt();

        BankAccount account = new BankAccount(initialBalance);
        WithdrawThread personA = new WithdrawThread(account, amountA);
        WithdrawThread personB = new WithdrawThread(account, amountB);

        personA.start();
        personB.start();

        try {
            personA.join();
            personB.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}