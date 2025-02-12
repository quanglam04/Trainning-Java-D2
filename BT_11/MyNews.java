package BT_11;

import java.util.ArrayList;
import java.util.Scanner;

public class MyNews {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<News> newsList = new ArrayList<>();
        int idCounter = 1;

        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Insert news");
            System.out.println("2. View list news");
            System.out.println("3. Average rate");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter publish date: ");
                    String publishDate = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter content: ");
                    String content = scanner.nextLine();

                    News news = new News(idCounter++, title, publishDate, author, content);
                    newsList.add(news);
                    news.getRates();
                    System.out.println("News added successfully!");
                    break;

                case 2:
                    if (newsList.isEmpty()) {
                        System.out.println("No news available.");
                    } else {
                        for (News news2 : newsList) {
                            news2.Display();
                            System.out.println();
                        }
                    }
                    break;

                case 3:
                    if (newsList.isEmpty()) {
                        System.out.println("No news available.");
                    } else {
                        for (News new3 : newsList) {
                            new3.Calculate();  
                            new3.Display();  
                            System.out.println();
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting program.");
                    return;

                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
