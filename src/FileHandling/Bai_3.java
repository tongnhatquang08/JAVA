package FileHandling;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

class Student {
    private String studentID;
    private String fullName;
    private String hometown;
    public Student(String studentID, String fullName, String hometown) {
        this.studentID = studentID;
        this.fullName = fullName;
        this.hometown = hometown;
    }
    public String getStudentID() {
        return studentID;
    }
    public String getFullName() {
        return fullName;
    }
    public String getHometown() {
        return hometown;
    }
}

public class Bai_3 {
    public static void main(String[] args) {
        Student[] students = {
                new Student("AB1234", "Nguyen Van Anh", "Ha Noi"),
                new Student("AB5678", "Tran Thi Binh", "Ho Chi Minh"),
                new Student("AB1369", "Le Van Cuong", "Da Nang")
        };

        String fileName = "student.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Student student : students) {
                writer.write(student.getStudentID() + "," + student.getFullName() + "," + student.getHometown());
                writer.newLine();
            }
            System.out.println("Danh sách sinh viên đã được ghi vào file " + fileName);
        } catch (IOException e) {
            System.err.println("Đã xảy ra lỗi: " + e.getMessage());
        }
    }
}

