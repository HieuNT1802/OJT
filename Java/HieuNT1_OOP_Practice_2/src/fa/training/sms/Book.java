package fa.training.sms;

public class Book {
	private int ISBN;
	private String title;
	private String publisher;
	private String author;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(int iSBN, String title, String publisher, String author) {
		super();
		ISBN = iSBN;
		this.title = title;
		this.publisher = publisher;
		this.author = author;
	}
	public int getISBN() {
		return ISBN;
	}
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "Book [ISBN=" + ISBN + ", title=" + title + ", publisher=" + publisher + ", author=" + author + "]";
	}
	
}
