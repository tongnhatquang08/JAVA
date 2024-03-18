package OOP.Btap.Btap_ke_thua;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Animal {
    String ten;
    int age;
    String describe;

    public Animal() {
    }

    public Animal(String ten) {
        this.ten = ten;
    }

    public Animal(String ten, int age) {
        this.ten = ten;
        this.age = age;
    }

    public Animal(String ten, int age, String describe) {
        this.ten = ten;
        this.age = age;
        this.describe = describe;
    }

    public void viewThongTin() {
        System.out.println("Ten: " + ten);
        System.out.println("Tuoi: " + age);
        System.out.println("Mo Ta: " + describe);
    }

    public abstract void sound();
}

class Tiger extends Animal {
    public Tiger() {
        super();
    }

    public Tiger(String ten) {
        super(ten);
    }

    public Tiger(String ten, int age) {
        super(ten, age);
    }

    public Tiger(String ten, int age, String describe) {
        super(ten, age, describe);
    }

    @Override
    public void sound() {
        System.out.println("Tiger sound: Roar");
    }
}

class Dog extends Animal {
    public Dog() {
        super();
    }

    public Dog(String ten) {
        super(ten);
    }

    public Dog(String ten, int age) {
        super(ten, age);
    }

    public Dog(String ten, int age, String describe) {
        super(ten, age, describe);
    }

    @Override
    public void sound() {
        System.out.println("Dog sound: Woof");
    }
}

class Cat extends Animal {
    public Cat() {
        super();
    }

    public Cat(String ten) {
        super(ten);
    }

    public Cat(String ten, int age) {
        super(ten, age);
    }

    public Cat(String ten, int age, String describe) {
        super(ten, age, describe);
    }

    @Override
    public void sound() {
        System.out.println("Cat sound: Meow");
    }
}

class Chuong {
    int maChuong;
    ArrayList<Animal> animalList;

    public Chuong(int maChuong) {
        this.maChuong = maChuong;
        this.animalList = new ArrayList<>();
    }

    public void themConVat(Animal a) {
        animalList.add(a);
    }

    public void deleteConVat(String name) {
        for (Animal a : animalList) {
            if (a.ten.equals(name)) {
                animalList.remove(a);
                break;
            }
        }
    }

    public void viewAllAnimals() {
        for (Animal a : animalList) {
            a.viewThongTin();
            a.sound();
        }
    }

    public int getMaChuong() {
        return maChuong;
    }
}

class Zoo {
    ArrayList<Chuong> listChuong;
    int currentBarnCode;
    Chuong currentBarn;

    public Zoo() {
        this.listChuong = new ArrayList<>();
    }

    public void addChuong(Chuong c) {
        listChuong.add(c);
    }

    public void removeChuong(int maChuong) {
        for (Chuong c : listChuong)
            if (c.maChuong == maChuong) {
                listChuong.remove(c);
                break;
            }
    }
    public Chuong getChuong(int code) {
        for (Chuong c : listChuong) {
            if (c.getMaChuong() == code) {
                currentBarnCode = code;
                currentBarn = c;
                return c;
            }
        }
        return null;
    }
}

class TestZoo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Zoo zoo = new Zoo();
        int choice;

        do {
            System.out.println("1. Add a barn");
            System.out.println("2. Delete the barn");
            System.out.println("3. Add animals");
            System.out.println("4. Delete the animal");
            System.out.println("5. See all the animals");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the barn code: ");
                    int addCode = scanner.nextInt();
                    zoo.addChuong(new Chuong(addCode));
                    System.out.println("Barn with code " + addCode + " has been added");

                    break;
                case 2:
                    System.out.print("Enter the barn code to delete: ");
                    int deleteBarnCode = scanner.nextInt();
                    zoo.removeChuong(deleteBarnCode);
                    System.out.println("Barn with code " + deleteBarnCode + " has been deleted");
                    break;
                case 3:
                    Chuong currentBarn = zoo.getChuong(zoo.currentBarnCode);
                    if (currentBarn == null) {
                        System.out.println("Please select a barn first.");
                        break;
                    }
                    System.out.println("Enter the type of animal to add: Tiger, Dog, Cat");
                    String animalType = scanner.next();

                    System.out.print("Enter the animal's name: ");
                    String animalName = scanner.next();

                    System.out.print("Enter the animal's age: ");
                    int animalAge = scanner.nextInt();

                    String animalMoTa = "";
                    if (animalType.equalsIgnoreCase("Tiger")) {
                        Tiger tiger = new Tiger(animalName, animalAge, animalMoTa);
                        currentBarn.themConVat(tiger);
                    } else if (animalType.equalsIgnoreCase("Dog")) {
                        Dog dog = new Dog(animalName, animalAge, animalMoTa);
                        currentBarn.themConVat(dog);
                    } else if (animalType.equalsIgnoreCase("Cat")) {
                        Cat cat = new Cat(animalName, animalAge, animalMoTa);
                        currentBarn.themConVat(cat);
                    }
                    break;
                case 4:
                    currentBarn = zoo.getChuong(zoo.currentBarnCode);
                    if (currentBarn == null) {
                        System.out.println("Please select a barn first.");
                        break;
                    }
                    System.out.print("Enter the animal's name to delete: ");
                    String deleteAnimalName = scanner.next();
                    currentBarn.deleteConVat(deleteAnimalName);
                    break;
                case 5:
                    currentBarn = zoo.getChuong(zoo.currentBarnCode);
                    if (currentBarn == null) {
                        System.out.println("Please select a barn first.");
                        break;
                    }
                    currentBarn.viewAllAnimals();
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

