package OOP.Btap.Abstract_class;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface IStudent {
    void display();
}

class Student implements IStudent {
    private static int nextId = 1;
    private int id;
    private String fullName;
    private LocalDate dateOfBirth;
    private String nativePlace;
    private String className;
    private String phoneNo;
    private String mobile;

    public Student() {
        this.id = nextId++;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.dateOfBirth = LocalDate.parse(dateOfBirth, formatter);
    }

    public String getDateOfBirth() {
        return dateOfBirth.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }

    @Override
    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Full Name: " + fullName);
        System.out.println("Date of Birth: " + getDateOfBirth());
        System.out.println("Native Place: " + nativePlace);
        System.out.println("Class: " + className);
        System.out.println("Phone Number: " + phoneNo);
        System.out.println("Mobile: " + mobile);
        System.out.println();
    }
}

public class Bai_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> studentList = new ArrayList<>();
        int selection;

        do {
            System.out.println("1. Insert new student");
            System.out.println("2. View list of students");
            System.out.println("3. Search students");
            System.out.println("4. Exit");
            System.out.print("Enter your selection: ");
            selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    Student student = new Student();
                    scanner.nextLine();
                    System.out.print("Enter full name: ");
                    student.setFullName(scanner.nextLine());
                    System.out.print("Enter date of birth (dd/MM/yyyy): ");
                    student.setDateOfBirth(scanner.nextLine());
                    System.out.print("Enter native place: ");
                    student.setNativePlace(scanner.nextLine());
                    System.out.print("Enter class: ");
                    student.setClassName(scanner.nextLine());
                    System.out.print("Enter phone number: ");
                    student.setPhoneNo(scanner.nextLine());
                    System.out.print("Enter mobile: ");
                    student.setMobile(scanner.nextLine());
                    studentList.add(student);
                    break;
                case 2:
                    System.out.println("ID\tFull Name\tDate of Birth\tNative Place\tClass\tPhone Number\tMobile");
                    System.out.println("---------------------------------------------------------------------------------------------------");
                    for (Student s : studentList) {
                        s.display();
                    }
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.print("Enter class to search: ");
                    String searchClass = scanner.nextLine();
                    System.out.println("ID\tFull Name\tDate of Birth\tNative Place\tClass\tPhone Number\tMobile");
                    System.out.println("---------------------------------------------------------------------------------------------------");
                    for (Student s : studentList) {
                        if (s.getClassName().equals(searchClass)) {
                            s.display();
                        }
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid selection.");
            }
        } while (selection != 4);

        scanner.close();
    }
}