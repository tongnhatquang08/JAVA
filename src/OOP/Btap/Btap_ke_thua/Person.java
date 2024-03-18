package OOP.Btap.Btap_ke_thua;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

    class Person {
    String name;
    String gender;
    LocalDate DOB;
    String address;

    public Person(String name, String gender, LocalDate DOB, String address) {
        this.name = name;
        this.gender = gender;
        this.DOB = DOB;
        this.address = address;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void inputInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập thông tin cá nhân: ");
        System.out.print("Nhập tên: ");
        name = scanner.nextLine();
        System.out.print("Nhập giới tính: ");
        gender = scanner.nextLine();
        System.out.print("Nhập ngày sinh: ");
        DOB = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.print("Nhập địa chỉ: ");
        address = scanner.nextLine();
    }

    public void showInfo() {
        System.out.println("Thông tin cá nhân: ");
        System.out.println("Tên: " + name);
        System.out.println("Giới tính: " + gender);
        System.out.println("Ngày sinh: " + DOB);
        System.out.println("Địa chỉ: " + address);
    }

    static class Student extends Person {
        int MSV;
        double averageScore;
        String email;

        public Student(int MSV, double averageScore, String email) {
            super("", "", null, "");
            this.MSV = MSV;
            this.averageScore = averageScore;
            this.email = email;
        }

        public Student() {
        }

        public int getMSV() {
            return MSV;
        }

        public void setMSV(int MSV) {
            this.MSV = MSV;
        }

        public double getAverageScore() {
            return averageScore;
        }

        public void setAverageScore(double averageScore) {
            this.averageScore = averageScore;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @Override
        public void inputInfo() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập thông tin cá nhân: ");
            System.out.print("Nhập email: \n");
            email = scanner.nextLine();
            System.out.print("Nhập MSV: ");
            MSV = scanner.nextInt();
            System.out.println("Nhập điểm trung bình: ");
            averageScore = scanner.nextDouble();
        }

        public void showInfo() {
            System.out.println("Thông tin cá nhân: ");
            System.out.println("Email: " + email);
            System.out.println("Mã sinh viêm: " + MSV);
            System.out.println("Điểm trung bình: " + averageScore);
        }
        boolean is_eligible_for_scholarship(){
            return averageScore > 8.0;

        }
            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                Person person = new Person();
                person.inputInfo();
                person.showInfo();

                Student student = new Student();
                student.inputInfo();
                student.showInfo();

                System.out.println("Is eligible for scholarship: " + student.is_eligible_for_scholarship());
            }
        }
    }
