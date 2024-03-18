package FileHandling;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Bai_1 {
    public static void main(String[] args) {
        String fileName = "numbers.txt";
        double sum = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                sum += Double.parseDouble(line.trim());
            }
            System.out.println("Tổng các số trong file là: " + sum);
        } catch (IOException e) {
            System.err.println("Đã xảy ra lỗi khi đọc file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Định dạng không hợp lệ: " + e.getMessage());
        }
    }
}
