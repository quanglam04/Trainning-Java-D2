package BT_11;

import java.util.Scanner;

public class News implements INews {
	private int ID;
	private String title;
	private String publishDate;
	private String author;
	private String content;
	private float averageRate;
	private int[] Rates = new int[3];
	
	public News(int ID, String Title, String PublishDate, String Author, String Content) {
        this.ID = ID;
        this.title = Title;
        this.publishDate = PublishDate;
        this.author = Author;
        this.content = Content;
    }
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public float getAverageRate() {
		return averageRate;
	}
	
	@Override
	public void Display() {
	        System.out.println("Title: " + title);
	        System.out.println("Publish Date: " + publishDate);
	        System.out.println("Author: " + author);
	        System.out.println("Content: " + content);
	        System.out.println("Average Rate: " + averageRate);
		
	}
	
	public void getRates() {
		Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 3 ratings for this news:");
		for (int i = 0; i < Rates.length; i++) {
            System.out.print("Enter rating " + (i + 1) + ": ");
            Rates[i] = scanner.nextInt();
        }
	}
	@Override
	public float Calculate() {
        averageRate = (Rates[0] + Rates[1] + Rates[2]) / 3.0f;
        return averageRate;
		
	}
	
	
	
	

	
	
}
