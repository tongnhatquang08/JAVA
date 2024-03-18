package OOP.Btap.Abstract_class;

import java.util.ArrayList;
import java.util.Scanner;
public abstract class Phone {
    public abstract void insertPhone(String name, String phone);

    public abstract void removePhone(String name);

    public abstract void updatePhone(String name, String newPhone);

    public abstract void searchPhone(String name);

    public abstract void sort();
}

class PhoneBook extends Phone {
    private ArrayList<String> phoneList;

    public PhoneBook() {
        phoneList = new ArrayList<>();
    }

    @Override
    public void insertPhone(String name, String phone) {
        if (!phoneList.contains(name)) {
            phoneList.add(name + ": " + phone);
        } else {
            for (int i = 0; i < phoneList.size(); i++) {
                if (phoneList.get(i).startsWith(name + ":")) {
                    phoneList.set(i, phoneList.get(i).replaceFirst(name + ": \\d+", name + ": " + phone));
                    break;
                }
            }
        }
    }

    @Override
    public void removePhone(String name) {
        for (int i = 0; i < phoneList.size(); i++) {
            if (phoneList.get(i).startsWith(name + ":")) {
                phoneList.remove(i);
                break;
            }
        }
    }

    @Override
    public void updatePhone(String name, String newPhone) {
        for (int i = 0; i < phoneList.size(); i++) {
            if (phoneList.get(i).startsWith(name + ":")) {
                phoneList.set(i, name + ": " + newPhone);
                break;
            }
        }
    }

    @Override
    public void searchPhone(String name) {
        for (String phone : phoneList) {
            if (phone.startsWith(name + ":")) {
                System.out.println(phone);
            }
        }
    }

    @Override
    public void sort() {
        phoneList.sort((o1, o2) -> o1.compareTo(o2));
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("PHONEBOOK MANAGEMENT SYSTEM");
            System.out.println("1. Insert Phone");
            System.out.println("2. Remove Phone");
            System.out.println("3. Update Phone");
            System.out.println("4. Search Phone");
            System.out.println("5. Sort");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            scanner.nextLine(); // consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name1 = scanner.nextLine();
                    System.out.print("Enter phone: ");
                    String phone1 = scanner.nextLine();
                    phoneBook.insertPhone(name1, phone1);
                    break;
                case 2:
                    System.out.print("Enter name: ");
                    String name2 = scanner.nextLine();
                    phoneBook.removePhone(name2);
                    break;
                case 3:
                    System.out.print("Enter name: ");
                    String name3 = scanner.nextLine();
                    System.out.print("Enter new phone: ");
                    String phone3 = scanner.nextLine();
                    phoneBook.updatePhone(name3, phone3);
                    break;
                case 4:
                    System.out.print("Enter name: ");
                    String name4 = scanner.nextLine();
                    phoneBook.searchPhone(name4);
                    break;
                case 5:
                    phoneBook.sort();
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}