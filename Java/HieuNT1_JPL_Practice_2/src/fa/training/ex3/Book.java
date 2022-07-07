package fa.training.ex3;

import java.util.Arrays;
import java.util.List;

public class Book {
// String title,publisher;
// String Author[] = new String[5];
// float price;
// int pages,numAu;
//public Book(String title, String publisher, String[] author, float price, int pages, int numAu) {
//	super();
//	this.title = title;
//	this.publisher = publisher;
//	Author = author;
//	this.price = price;
//	this.pages = pages;
//	this.numAu = numAu;
//}
//public String getTitle() {
//	return title;
//}
//public void setTitle(String title) {
//	this.title = title;
//}
//public String getPublisher() {
//	return publisher;
//}
//public void setPublisher(String publisher) {
//	this.publisher = publisher;
//}
//public String[] getAuthor() {
//	return Author;
//}
//public void setAuthor(String[] author) {
//	Author = author;
//}
//public float getPrice() {
//	return price;
//}
//public void setPrice(float price) {
//	this.price = price;
//}
//public int getPages() {
//	return pages;
//}
//public void setPages(int pages) {
//	this.pages = pages;
//}
//public int getNumAu() {
//	return numAu;
//}
//public void setNumAu(int numAu) {
//	this.numAu = numAu;
//}
//public Book() {
//	super();
//	// TODO Auto-generated constructor stub
//}
//@Override
//public String toString() {
//	return "Book [title=" + title + ", publisher=" + publisher + ", Author=" + Arrays.toString(Author) + ", price="
//			+ price + ", pages=" + pages + ", numAu=" + numAu + "]";
//}
//void getAuthor( String a )
//{
//	Author[0] = a;
//	numAu = 1;
//}
//void getAuthor( String a, String b )
//{
//	Author[0] = a;
//	Author[1] = b;
//	numAu = 2;
//}
//void getAuthor( String a, String b, String c )
//{
//	Author[0] = a;
//	Author[1] = b;
//	Author[2] = c;
//	numAu = 3;
//}
//void getAuthor( String a, String b, String c,String d )
//{
//	Author[0] = a;
//	Author[1] = b;
//	Author[2] = c;
//	Author[3] = d;
//	numAu = 4;
//}void getAuthor( String a, String b, String c,String d, String e )
//{
//	Author[0] = a;
//	Author[1] = b;
//	Author[2] = c;
//	Author[3] = c;
//	Author[4] = c;
//	numAu = 5;
//}
//void create( String t, String ps, int pg, float pr )
//{
//	publisher = ps;
//	title = t;
//	price = pr;
//	pages = pg;
//}
//void Display()
//{
//	System.out.println("    Book Details ");
//	System.out.println("Title: "+title);
//	System.out.print("Authors: ");
//	for( int i=0; i<numAu; i++ )
//		System.out.println(Author[i]);
//	System.out.println("Pages - "+pages+"\nPrice - "+price);
//}
	
	private String title;
	private List<String> author;
	private double price;
	private String publisher;
	private int numOfPages;
	public Book(String title, List<String> author, double price, String publisher, int numOfPages) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
		this.publisher = publisher;
		this.numOfPages = numOfPages;
	}
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<String> getAuthor() {
		return author;
	}
	public void setAuthor(List<String> author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getNumOfPages() {
		return numOfPages;
	}
	public void setNumOfPages(int numOfPages) {
		this.numOfPages = numOfPages;
	}
	
}

