package Btap_them;

import java.util.*;

class Doctor {
    protected String code;
    protected String name;
    protected String specialization;
    protected int availability;

    public Doctor(String code, String name, String specialization, int availability) {
        this.code = code;
        this.name = name;
        this.specialization = specialization;
        this.availability = availability;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSpecialization() {
        return specialization;
    }
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    public int getAvailability() {
        return availability;
    }
    public void setAvailability(int availability) {
        this.availability = availability;
    }
}

public class DoctorManagement {
    private HashMap<String, Doctor> doctors;

    public DoctorManagement() {
        doctors = new HashMap<>();
    }

    public void displayMenu() {
        System.out.println("DOCTOR MANAGEMENT");
        System.out.println("1. Add Doctor");
        System.out.println("2. Update Doctor");
        System.out.println("3. Delete Doctor");
        System.out.println("4. Search Doctor");
        System.out.println("5. Exit");
    }

    public void addDoctor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter code: ");
        String code = scanner.nextLine();
        if (doctors.containsKey(code)) {
            System.out.println("Doctor code already exists");
            return;
        }
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter specialization: ");
        String specialization = scanner.nextLine();
        System.out.print("Enter availability: ");
        int availability = scanner.nextInt();
        Doctor doctor = new Doctor(code, name, specialization, availability);
        doctors.put(code, doctor);
        System.out.println("Doctor added successfully");
    }

    public void updateDoctor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter code: ");
        String code = scanner.nextLine();
        if (!doctors.containsKey(code)) {
            System.out.println("Doctor code does not exist");
            return;
        }
        Doctor doctor = doctors.get(code);
        System.out.print("Enter new name (press enter to keep current): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) {
            doctor.name = name;
        }
        System.out.print("Enter new specialization (press enter to keep current): ");
        String specialization = scanner.nextLine();
        if (!specialization.isEmpty()) {
            doctor.specialization = specialization;
        }
        System.out.print("Enter new availability (press enter to keep current): ");
        if (scanner.hasNextInt()) {
            doctor.availability = scanner.nextInt();
        }
        System.out.println("Doctor updated successfully");
    }

    public void deleteDoctor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter code: ");
        String code = scanner.nextLine();
        if (!doctors.containsKey(code)) {
            System.out.println("Doctor code does not exist");
            return;
        }
        doctors.remove(code);
        System.out.println("Doctor deleted successfully");
    }

    public void searchDoctor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name or specialization: ");
        String searchString = scanner.nextLine();
        List<Doctor> foundDoctors = new ArrayList<>();
        for (Doctor doctor : doctors.values()) {
            if (doctor.name.contains(searchString) || doctor.specialization.contains(searchString)) {
                foundDoctors.add(doctor);
            }
        }
        if (foundDoctors.isEmpty()) {
            System.out.println("No doctors found");
        } else {
            for (Doctor doctor : foundDoctors) {
                System.out.println("Code: " + doctor.code + ", Name: " + doctor.name + ", Specialization: " + doctor.specialization + ", Availability: " + doctor.availability);
            }
        }
    }

    public static void main(String[] args) {
        DoctorManagement doctorManagement = new DoctorManagement();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            doctorManagement.displayMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    doctorManagement.addDoctor();
                    break;
                case 2:
                    doctorManagement.updateDoctor();
                    break;
                case 3:
                    doctorManagement.deleteDoctor();
                    break;
                case 4:
                    doctorManagement.searchDoctor();
                    break;
                case 5:
                    System.out.println("Exiting program");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}