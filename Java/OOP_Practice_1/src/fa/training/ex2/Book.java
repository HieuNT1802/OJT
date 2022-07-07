package fa.training.ex2;

import java.util.List;

public class Book {
    /*
    Implement a class for a “Book”.
    Book contains a title (a String), a list of authors (array of authors),
    number of pages (an integer), price (floating point number), publisher (a String) etc.
    Write suitable constructor and accessor/modifier methods. Implement a class for “Library”.
    A library contains a list of books (array of Book). Write add (to add a book) and remove (to delete a book) methods for library.
    Write a main() function to create a “Library” and add five “Book” to library. Print the total price of all books.
    */

    private String title;

    private List<String> authors;

    private String publisher;

    private int numOfPages;

    private double price;

    public Book(String title, List<String> authors, String publisher, int numOfPages, double price) {
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
        this.numOfPages = numOfPages;
        this.price = price;
    }

    public Book(){};

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", authors=" + authors +
                ", publisher='" + publisher + '\'' +
                ", numOfPages=" + numOfPages +
                ", price=" + price +
                '}';
    }
}
