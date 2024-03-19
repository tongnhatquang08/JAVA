package Multi_Threading;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame_2 {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào một số từ 1 đến 100: ");
        int userNumber = scanner.nextInt();

        Thread guesser1 = new Thread(new Guesser(userNumber));
        Thread guesser2 = new Thread(new Guesser(userNumber));

        guesser1.start();
        guesser2.start();

        try {
            guesser1.join();
            guesser2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Trò chơi kết thúc!");
    }

    static class Guesser implements Runnable {
        private final int userNumber;

        public Guesser(int userNumber) {
            this.userNumber = userNumber;
        }

        @Override
        public void run() {
            Random random = new Random();
            int guesses = 0;

            while (true) {
                int randomNumber = random.nextInt(MAX_NUMBER - MIN_NUMBER + 1) + MIN_NUMBER;
                System.out.println("Thread " + Thread.currentThread().getId() + ": " + randomNumber);
                guesses++;

                if (randomNumber == userNumber) {
                    System.out.println("Thread " + Thread.currentThread().getId() + " chiến thắng sau " + guesses + " lần đoán.");
                    break;
                }
            }
        }
    }
}

