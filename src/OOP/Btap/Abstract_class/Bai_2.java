package OOP.Btap.Abstract_class;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface INews {
    void display();
    void calculateAverageRate();
}

class News implements INews {
    private static int nextId = 1;
    private int id;
    private String title;
    private String publishDate;
    private String author;
    private String content;
    private float averageRate;
    private int[] rateList = new int[3];
    private int rateCount = 0;

    public News() {
        this.id = nextId++;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
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

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void addRate(int rate) {
        if (rateCount < 3) {
            rateList[rateCount] = rate;
            rateCount++;
        } else {
            System.out.println("Rating limit reached.");
        }
    }

    @Override
    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Publish Date: " + publishDate);
        System.out.println("Author: " + author);
        System.out.println("Content: " + content);
        System.out.println("Average Rate: " + averageRate);
    }

    @Override
    public void calculateAverageRate() {
        int sum = 0;
        for (int i = 0; i < rateCount; i++) {
            sum += rateList[i];
        }
        averageRate = (float) sum / rateCount;
    }
}

public class Bai_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<News> newsList = new ArrayList<>();
        int selection;

        do {
            System.out.println("1. Insert news");
            System.out.println("2. View list news");
            System.out.println("3. Average rate");
            System.out.println("4. Exit");
            System.out.print("Enter your selection: ");
            selection = scanner.nextInt();

            switch (selection) {
                case 1:
                    News news = new News();
                    System.out.print("Enter title: ");
                    scanner.nextLine();
                    news.setTitle(scanner.nextLine());
                    System.out.print("Enter publish date: ");
                    news.setPublishDate(scanner.nextLine());
                    System.out.print("Enter author: ");
                    news.setAuthor(scanner.nextLine());
                    System.out.print("Enter content: ");
                    news.setContent(scanner.nextLine());
                    System.out.println("Enter 3 ratings:");
                    for (int i = 0; i < 3; i++) {
                        System.out.print("Rating " + (i + 1) + ": ");
                        news.addRate(scanner.nextInt());
                    }
                    newsList.add(news);
                    break;
                case 2:
                    for (News n : newsList) {
                        n.display();
                    }
                    break;
                case 3:
                    for (News n : newsList) {
                        n.calculateAverageRate();
                        n.display();
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