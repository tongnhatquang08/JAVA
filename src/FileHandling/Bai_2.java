package FileHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Bai_2 {
    public static void main(String[] args) {
        String fileName = "numbers.txt";
        Double maxNumber = null;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                double number = Double.parseDouble(line.trim());
                if (maxNumber == null || number > maxNumber) {
                    maxNumber = number;
                }
            }
            if (maxNumber != null) {
                System.out.println("Số lớn nhất trong file là: " + maxNumber);
            } else {
                System.out.println("File không chứa số nào.");
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Đã xảy ra lỗi: " + e.getMessage());
        }
    }
}
