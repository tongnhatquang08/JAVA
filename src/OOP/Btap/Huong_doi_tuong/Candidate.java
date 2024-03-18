package OOP.Btap.Huong_doi_tuong;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Candidate {
    private int MSV;
    private String name;
    private LocalDate DOB;
    private double mathScore;
    private double literatureScore;
    private double englishScore;

    public Candidate(int MSV, String name, LocalDate DOB, double mathScore, double literatureScore, double englishScore) {
        this.MSV = MSV;
        this.name = name;
        this.DOB = DOB;
        this.mathScore = mathScore;
        this.literatureScore = literatureScore;
        this.englishScore = englishScore;
    }

    public int getMSV() {
        return MSV;
    }

    public void setMSV(int MSV) {
        this.MSV = MSV;
    }

    public String getName() {
        return name;
    }

    public void setName(int MSV) {
        this.name = name;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public double getMathScore() {
        return mathScore;
    }

    public void setMathScore(int mathScore) {
        this.mathScore = mathScore;
    }

    public double getLiteratureScore() {
        return literatureScore;
    }

    public void setLiteratureScore(int literatureScore) {
        this.literatureScore = literatureScore;
    }

    public double getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(int englishScore) {
        this.englishScore = englishScore;
    }

    public double getSum() {
        return mathScore + literatureScore + englishScore;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "MSV=" + MSV + '\'' +
                ", ten='" + name + '\'' +
                ", ngaySinh=" + DOB +
                ", diemToan=" + mathScore +
                ", diemVan=" + literatureScore +
                ", diemAnh=" + englishScore +
                "}";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng thí sinh: ");
        int n = scanner.nextInt();

        List<Candidate> candidates = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            scanner.nextLine();
            System.out.println("Nhập thông tin thí sinh thứ " + (i + 1));
            System.out.print("Mã: ");
            String MSV = scanner.nextLine();
            System.out.print("Tên: ");
            String name = scanner.nextLine();
            System.out.print("Ngày sinh: ");
            LocalDate DOB = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            System.out.print("Điểm Toán: ");
            double mathScore = scanner.nextDouble();
            System.out.print("Điểm Văn: " );
            double literatureScore = scanner.nextDouble();
            System.out.print("Điểm Anh: " );
            double englishScore = scanner.nextDouble();
        }
    }
}
