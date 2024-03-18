package OOP.Btap.Abstract_class;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface IBook {
    void display();
    void calculateAveragePrice();
}

class Book implements IBook {
    private static int nextId = 1;
    private int id;
    private String name;
    private String publishDate;
    private String author;
    private String language;
    private float[] priceList = new float[5];
    private int priceCount = 0;
    private float averagePrice;

    public Book() {
        this.id = nextId++;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    public void addPrice(float price) {
        if (priceCount < 5) {
            priceList[priceCount] = price;
            priceCount++;
        } else {
            System.out.println("Price list is full.");
        }
    }

    @Override
    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Publish Date: " + publishDate);
        System.out.println("Author: " + author);
        System.out.println("Language: " + language);
        System.out.println("Average Price: " + averagePrice);
    }

    @Override
    public void calculateAveragePrice() {
        float sum = 0;
        for (int i = 0; i < priceCount; i++) {
            sum += priceList[i];
        }
        averagePrice = sum / priceCount;
    }
}

public class Bai_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Book> bookList = new ArrayList<>();
        int selection;

        do {
            System.out.println("1. Insert new book");
            System.out.println("2. View list of books");
            System.out.println("3. Average Price");
            System.out.println("4. Exit");
            System.out.print("Enter your selection: ");
            selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    Book book = new Book();
                    scanner.nextLine();
                    System.out.print("Enter name: ");
                    book.setName(scanner.nextLine());
                    System.out.print("Enter publish date: ");
                    book.setPublishDate(scanner.nextLine());
                    System.out.print("Enter author: ");
                    book.setAuthor(scanner.nextLine());
                    System.out.print("Enter language: ");
                    book.setLanguage(scanner.nextLine());
                    System.out.println("Enter 5 prices:");
                    for (int i = 0; i < 5; i++) {
                        System.out.print("Price " + (i + 1) + ": ");
                        book.addPrice(scanner.nextFloat());
                    }
                    bookList.add(book);
                    break;
                case 2:
                    for (Book b : bookList) {
                        b.display();
                    }
                    break;
                case 3:
                    for (Book b : bookList) {
                        b.calculateAveragePrice();
                        b.display();
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