package OOP.Btap.Huong_doi_tuong;

import java.util.*;

class Student {
    private int id;
    private String name;
    private int age;
    private String address;
    private double gpa;

    public Student(int id, String name, int age, String address, double gpa) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public double getGpa() {
        return gpa;
    }
}

class StudentManager {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void editStudentById(int id, Student newStudent) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.set(i, newStudent);
                break;
            }
        }
    }

    public void deleteStudentById(int id) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getId() == id) {
                iterator.remove();
                break;
            }
        }
    }

    public void sortStudentsByGpa() {
        Collections.sort(students, Comparator.comparingDouble(Student::getGpa));
    }

    public void sortStudentsByName() {
        Collections.sort(students, Comparator.comparing(Student::getName));
    }

    public void showStudents() {
        for (Student student : students) {
            System.out.println(student.getId() + " " + student.getName() + " " + student.getAge() + " " + student.getAddress() + " " + student.getGpa());
        }
    }
}

public class StudentManagement {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Student Management System");
            System.out.println("1. Add a student");
            System.out.println("2. Edit student by id");
            System.out.println("3. Delete student by id");
            System.out.println("4. Sort students by GPA");
            System.out.println("5. Sort students by name");
            System.out.println("6. Show students");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 0 and 6.");
                continue;
            }

            if (choice == 0) {
                break;
            }

            switch (choice) {
                case 1:
                    addStudent(manager, scanner);
                    break;
                case 2:
                    editStudent(manager, scanner);
                    break;
                case 3:
                    deleteStudent(manager, scanner);
                    break;
                case 4:
                    manager.sortStudentsByGpa();
                    break;
                case 5:
                    manager.sortStudentsByName();
                    break;
                case 6:
                    manager.showStudents();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 0 and 6.");
                    break;
            }
        }

        scanner.close();
    }

    private static void addStudent(StudentManager manager, Scanner scanner) {
        System.out.print("Enter id: ");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input for ID. Please enter a valid integer.");
            return;
        }
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age;
        try {
            age = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input for age. Please enter a valid integer.");
            return;
        }
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        System.out.print("Enter GPA: ");
        double gpa;
        try {
            gpa = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input for GPA. Please enter a valid floating-point number.");
            return;
        }
        manager.addStudent(new Student(id, name, age, address, gpa));
    }

    private static void editStudent(StudentManager manager, Scanner scanner) {
        System.out.print("Enter id of student to edit: ");
        int editId;
        try {
            editId = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input for ID. Please enter a valid integer.");
            return;
        }
        System.out.print("Enter new name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter new age: ");
        int newAge;
        try {
            newAge = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input for age. Please enter a valid integer.");
            return;
        }
        System.out.print("Enter new address: ");
        String newAddress = scanner.nextLine();
        System.out.print("Enter new GPA: ");
        double newGpa;
        try {
            newGpa = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input for GPA. Please enter a valid floating-point number.");
            return;
        }
        manager.editStudentById(editId, new Student(editId, newName, newAge, newAddress, newGpa));
    }

    private static void deleteStudent(StudentManager manager, Scanner scanner) {
        System.out.print("Enter id of student to delete: ");
        int deleteId;
        try {
            deleteId = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input for ID. Please enter a valid integer.");
            return;
        }
        manager.deleteStudentById(deleteId);
    }
}
