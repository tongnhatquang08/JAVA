package LOOP.LT;

public class WhileLoop{
    public static void main(String[] args) {
        int x = 0;
        int [] numbers = {10, 20, 30, 40, 50};
        while (x<5){
            System.out.print("value of item : " + numbers[x] );
            x++;
            System.out.print("\n");
        }
    }
}