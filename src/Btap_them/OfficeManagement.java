package Btap_them;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee{
    protected String name;
    protected int age;
    protected String gender;
    protected String address;
    public Employee(String name, int age, String gender, String address){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }
    public String getName(){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getGender(){
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}

class Worker extends Employee{
    private int level;
    public Worker(String name, int age, String gender, String address, int level){
        super(name, age, gender, address);
        this.level = level;
    }
    public int getLevel() {
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString(){
        return "Worker{" +
                "level=" + level +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

class Engineer extends Employee{
    private String specialized;
    public Engineer (String name, int age, String gender, String address, String specialized){
        super(name, age, gender, address);
        this.specialized = specialized;
    }
    public String getSpecialized() {
        return specialized;
    }
    public void setSpecialized(String specialized) {
        this.specialized = specialized;
    }

    @Override
    public String toString(){
        return "Engineer{" +
                "branch='" + specialized + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

class Staff extends Employee{
    private String task;
    public Staff(String name, int age, String gender, String address, String task){
        super(name, age, gender, address);
        this.task = task;
    }
    public String getTask() {
        return task;
    }
    public void setTask(String task) {
        this.task = task;
    }

    @Override
    public String toString(){
        return "Staff{" +
                "task='" + task + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

class EmployeeManager {
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee (Employee employee){
        employees.add(employee);
    }
    public List<Employee> searchEmployeeByName(String name) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : this.employees) {
            if (employee.getName().contains(name)) {
                result.add(employee);
            }
            else{
                System.out.println("invalid");
            }
        }
        return result;
    }
    public void showEmployee() {
        for (Employee employee : employees) {
            System.out.println(employee.getName() + " " + employee.getAge() + " " + employee.getGender() + " " + employee.getAddress());
        }
    }
}

public class OfficeManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeManager manager = new EmployeeManager();
        while (true) {
            System.out.println("Office Management System");
            System.out.println("1. Add an employee");
            System.out.println("2. Search employee by name");
            System.out.println("3. Show employees");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            String line = scanner.nextLine();
            switch (line) {
                case "1": {
                    System.out.println("Enter a: to insert Engineer");
                    System.out.println("Enter b: to insert Worker");
                    System.out.println("Enter c: to insert Staff");
                    String type = scanner.nextLine();
                    switch (type) {
                        case "a": {
                            System.out.print("Enter name: ");
                            String name = scanner.nextLine();
                            System.out.print("Enter age: ");
                            int age = scanner.nextInt();
                            System.out.print("Enter gender: ");
                            scanner.nextLine();
                            String gender = scanner.nextLine();
                            System.out.print("Enter address: ");
                            String address = scanner.nextLine();
                            System.out.print("Enter branch: ");
                            String branch = scanner.nextLine();
                            Employee engineer = new Engineer(name, age, gender, address, branch);
                            manager.addEmployee(engineer);
                            System.out.println(engineer.toString());
                            break;

                        }
                        case "b": {
                            System.out.print("Enter name: ");
                            String name = scanner.nextLine();
                            System.out.print("Enter age: ");
                            int age = scanner.nextInt();
                            System.out.print("Enter gender: ");
                            scanner.nextLine();
                            String gender = scanner.nextLine();
                            System.out.print("Enter address: ");
                            String address = scanner.nextLine();
                            System.out.print("Enter level: ");
                            int level = scanner.nextInt();
                            Employee worker = new Worker(name, age, gender, address, level);
                            manager.addEmployee(worker);
                            System.out.println(worker.toString());
                            scanner.nextLine();
                            break;
                        }
                        case "c": {
                            System.out.print("Enter name: ");
                            String name = scanner.nextLine();
                            System.out.print("Enter age: ");
                            int age = scanner.nextInt();
                            System.out.print("Enter gender: ");
                            scanner.nextLine();
                            String gender = scanner.nextLine();
                            System.out.print("Enter address: ");
                            String address = scanner.nextLine();
                            System.out.print("Enter task: ");
                            String task = scanner.nextLine();
                            Employee staff = new Staff(name, age, gender, address, task);
                            manager.addEmployee(staff);
                            System.out.println(staff.toString());
                            break;
                        }
                        default:
                            System.out.println("Invalid");
                            break;
                    }
                    break;
                }
                case "2": {
                    System.out.print("Enter name to search: ");
                    String name = scanner.nextLine();
                    manager.searchEmployeeByName(name).forEach(employee -> {
                        System.out.println(employee.toString());
                    });
                    break;
                }
                case "3": {
                    manager.showEmployee();
                    break;
                }
                case "4": {
                    return;
                }
                default:
                    System.out.println("Invalid");
                    continue;
            }
        }
    }
}
