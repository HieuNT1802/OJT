package fa.training.assignment_802.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import fa.training.assignment_802.entities.Book;

public class BookService {
	List<Book> books;

	public BookService() {
		books = new ArrayList<Book>();
	}

	
	public List<Book> getBooks() {
		return books;
	}


	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public void display() {
		for (Book book : books) {
			book.display();
		}
	}
	
	public void displaySpecificList(List<Book>  specificBookList) {
		for (Book book : specificBookList) {
			book.display();
		}
	}
	public boolean addBook(Book newBook) {
		if (!books.contains(newBook)) {
			books.add(newBook);
			return true;
		}
		return false;
	}

	public boolean addAuthor(Book selectedBook, String author) {
		Set<String> authors = selectedBook.getAuthor();
		boolean checkAdd = authors.add(author);
		if (checkAdd) {
			books.get(books.indexOf(selectedBook)).setAuthor(authors); // get index of selected book then get book and
																		// set author
			return true;
		}
		return false;
	}


	public void sortList(List<Book> bookList) {
		// sort by publication date then isbn using comparator lambda
		Comparator<Book> sortByPublicationDate = (b1, b2) -> b1.getPublicationDate().compareTo(b2.getPublicationDate());
		Comparator<Book> sortByIsbn = (b1, b2) -> b1.getIsbn().compareTo(b2.getIsbn());
		Collections.sort(bookList, sortByPublicationDate.thenComparing(sortByIsbn));
	}

	public Book getBookByIsbn(String isbn) {
		for (Book book : books) {
			if(book.getIsbn().equals(isbn)) {
				return book;
			}
		}
		return null;
	}
	public List<Book> getBookByAuthor(String author) {
		List<Book> findBooks = new ArrayList<>();
		for (Book book : books) {
			Set<String> authors = book.getAuthor();
			if (authors.contains(author)) {
				findBooks.add(book);
			}
		}
		sortList(findBooks);
		return findBooks;
	}

	public List<Book> getBookByPublisher(String publisher) {
		List<Book> findBooks = new ArrayList<>();
		for (Book book : books) {
			if (book.getPublisher().equals(publisher)) {
				findBooks.add(book);
			}
		}
		return findBooks;
	}
}
