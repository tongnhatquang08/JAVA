package OOP.Btap.Abstract_class;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface IStudentMark {
    void display();
    void calculateAverageMark();
}

class StudentMark implements IStudentMark {
    private static int nextId = 1;
    private int id;
    private String fullName;
    private String className;
    private int semester;
    private float[] subjectMarkList = new float[5];
    private int subjectMarkCount = 0;
    private float averageMark;

    public StudentMark() {
        this.id = nextId++;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getSemester() {
        return semester;
    }

    public void addSubjectMark(float mark) {
        if (subjectMarkCount < 5) {
            subjectMarkList[subjectMarkCount] = mark;
            subjectMarkCount++;
        } else {
            System.out.println("Subject mark list is full.");
        }
    }

    @Override
    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Full Name: " + fullName);
        System.out.println("Class: " + className);
        System.out.println("Semester: " + semester);
        System.out.println("Average Mark: " + averageMark);
    }

    @Override
    public void calculateAverageMark() {
        float sum = 0;
        for (int i = 0; i < subjectMarkCount; i++) {
            sum += subjectMarkList[i];
        }
        averageMark = sum / subjectMarkCount;
    }
}

public class Bai_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<StudentMark> studentMarkList = new ArrayList<>();
        int selection;

        do {
            System.out.println("1. Insert new student mark");
            System.out.println("2. View list of student marks");
            System.out.println("3. Average Mark");
            System.out.println("4. Exit");
            System.out.print("Enter your selection: ");
            selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    StudentMark studentMark = new StudentMark();
                    scanner.nextLine();
                    System.out.print("Enter full name: ");
                    studentMark.setFullName(scanner.nextLine());
                    System.out.print("Enter class: ");
                    studentMark.setClassName(scanner.nextLine());
                    System.out.print("Enter semester: ");
                    studentMark.setSemester(scanner.nextInt());
                    System.out.println("Enter 5 subject marks:");
                    for (int i = 0; i < 5; i++) {
                        System.out.print("Subject mark " + (i + 1) + ": ");
                        studentMark.addSubjectMark(scanner.nextFloat());
                    }
                    studentMarkList.add(studentMark);
                    break;
                case 2:
                    for (StudentMark sm : studentMarkList) {
                        sm.display();
                    }
                    break;
                case 3:
                    for (StudentMark sm : studentMarkList) {
                        sm.calculateAverageMark();
                        sm.display();
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