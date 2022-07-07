package fa.training.assignment_802.entities;

import java.sql.Date;
import java.util.*;

public class Book extends Publication {
	private String isbn;
	private Set<String> author;
	private String publicationPlace;

	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(int publicationYear, String publisher, Date publicationDate, String isbn, Set<String> author,
			String publicationPlace) {
		super(publicationYear, publisher, publicationDate);
		this.isbn = isbn;
		this.author = author;
		this.publicationPlace = publicationPlace;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Set<String> getAuthor() {
		return author;
	}

	public void setAuthor(Set<String> author) {
		this.author = author;
	}

	public String getPublicationPlace() {
		return publicationPlace;
	}

	public void setPublicationPlace(String publicationPlace) {
		this.publicationPlace = publicationPlace;
	}

	@Override
    public boolean equals(Object other) {
        return (other instanceof Book) && (isbn != null) ? isbn.equals(((Book) other).isbn) : (other == this);
    }
	@Override
	public void display() {
		System.out.println(String.format("%d\t%s\t%s\t%s\t%s\t%s", super.getPublicationYear(), super.getPublisher(),
				super.getPublicationDate(), isbn, author.toString(), publicationPlace));
	}
	
}
