package Btap_them;

import java.util.Scanner;

public class SNT {
    private static boolean isPrime(int n){
        if (n<2){
            return false;
        }
        for (int i = 2 ; i*i <= n; i++){
            if (n%i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        for (int i = n1; i<= n2; i++){
            if (isPrime(i)){
                System.out.println(i);
            }
        }
    }
}
