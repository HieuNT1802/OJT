package fa.training.assignment_802.managements;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import fa.training.assignment_802.entities.Book;
import fa.training.assignment_802.entities.Magazine;
import fa.training.assignment_802.services.BookService;
import fa.training.assignment_802.services.MagazineService;
import fa.training.assignment_802.validate.InputValidate;

public class LibraryManagement {

	final static InputValidate iv = new InputValidate();
	BookService bookService;
	MagazineService magazineService;
	public LibraryManagement() {
		bookService = new BookService();
		magazineService = new MagazineService();
	}
	List<Book> initBookData() {
		List<Book> books = new ArrayList<Book>();
		books.add(new Book(2020, "GHTK", Date.valueOf("2020-06-23"), "978-3-16-148410-0",
				new HashSet<>(Arrays.asList("John", "Mike")), "US"));
		books.add(new Book(2021, "GHN", Date.valueOf("2021-07-11"), "978-3-16-148410-1",
				new HashSet<>(Arrays.asList("Josh", "Mike")), "US"));
		books.add(new Book(2022, "GHTK", Date.valueOf("2022-03-28"), "978-3-16-148410-2",
				new HashSet<>(Arrays.asList("Chris", "Lich")), "US"));
		books.add(new Book(2022, "GHTK", Date.valueOf("2022-09-15"), "978-3-16-148410-3",
				new HashSet<>(Arrays.asList("Hie", "Tom")), "US"));
		books.add(new Book(2021, "GHN", Date.valueOf("2021-12-12"), "978-3-16-148410-4",
				new HashSet<>(Arrays.asList("Dung", "Tran")), "US"));
		books.add(new Book(2022, "VNP", Date.valueOf("2022-07-01"), "978-3-16-148410-5",
				new HashSet<>(Arrays.asList("John", "Doom")), "US"));
		books.add(new Book(2020, "GHTK", Date.valueOf("2020-01-23"), "978-3-16-148410-6",
				new HashSet<>(Arrays.asList("Trick", "Pele")), "US"));
		return books;
	}

	List<Magazine> initMagazineData() {
		List<Magazine> magazines = new ArrayList<Magazine>();
		magazines.add(new Magazine(2021, "GHN", Date.valueOf("2021-04-30"), "Josh", 100, 1));
		magazines.add(new Magazine(2022, "GHN", Date.valueOf("2022-01-21"), "Mike", 132, 1));
		magazines.add(new Magazine(2021, "GHTK", Date.valueOf("2021-08-11"), "Josh", 99, 1));
		magazines.add(new Magazine(2020, "VNP", Date.valueOf("2020-01-05"), "Trick", 87, 1));
		magazines.add(new Magazine(2020, "GHTK", Date.valueOf("2020-03-24"), "Hoa", 100, 1));
		magazines.add(new Magazine(2021, "GHTK", Date.valueOf("2021-04-21"), "Josh", 321, 1));
		magazines.add(new Magazine(2022, "VNP", Date.valueOf("2022-04-21"), "Cam", 230, 1));
		magazines.add(new Magazine(2022, "VNP", Date.valueOf("2022-12-21"), "Shick", 47, 1));
		magazines.add(new Magazine(2020, "GHTK", Date.valueOf("2021-11-21"), "Minh", 102, 1));
		magazines.add(new Magazine(2021, "VNP", Date.valueOf("2021-11-21"), "Hoa", 89, 1));
		magazines.add(new Magazine(2020, "GHN", Date.valueOf("2020-11-21"), "Pellop", 313, 1));
		magazines.add(new Magazine(2022, "GHTK", Date.valueOf("2022-11-21"), "Yuri", 167, 1));
		return magazines;
	}

	Book inputBook() {
		System.out.println("--------Add new book---------");
		System.out.print("Input publication year: ");
		int publicationYear = iv.inputPublicationYear();
		System.out.print("Input publisher: ");
		String publisher = iv.inputString();
		System.out.print("Input publication date(MM/dd/YYYY): ");
		Date publicationDate = iv.inputPublicationDate(publicationYear);
		System.out.print("Input ISBN: ");
		String isbn = iv.inputString();
		Set<String> author = inputAuthors();
		System.out.print("Input publication place: ");
		String publicationPlace = iv.inputString();
		return new Book(publicationYear, publisher, publicationDate, isbn, author, publicationPlace);
	}

	Magazine inputMagazine() {
		System.out.println("--------Add new book---------");
		System.out.print("Input publication year: ");
		int publicationYear = iv.inputPublicationYear();
		System.out.print("Input publisher: ");
		String publisher = iv.inputString();
		System.out.print("Input publication date(MM/dd/YYYY): ");
		Date publicationDate = iv.inputPublicationDate(publicationYear);
		System.out.print("Input author: ");
		String author = iv.inputString();
		System.out.print("Input volume: ");
		int volume = iv.inputInt();
		System.out.print("Input edition: ");
		int edition = iv.inputInt();
		return new Magazine(publicationYear, publisher, publicationDate, author, volume, edition);
	}
	Set<String> inputAuthors() {
		Set<String> authors = new HashSet<String>();
		while (true) {
			System.out.print("Input author: ");
			String author = iv.inputString();
			if (!authors.add(author)) {
				System.out.println("Already have this author");
				if(!askContinue()) {
					break;
				}
			}
			if(!askContinue()) {
				break;
			}
		}
		return authors;
	}
	
	boolean askContinue() {
		System.out.print("Do you want to continue(y/n): ");
		char choice = iv.inputYesNo();
		if (choice == 'n') {
			return false;
		}
		return true;
	}
	void addAuthorToBook() {
		while(true) {
			bookService.display();
			System.out.print("Input isbn to add author: ");
			String isbnInput = iv.inputString();
			Book gettedBook = bookService.getBookByIsbn(isbnInput);
			if(gettedBook == null) {
				System.err.println("Can not find book have this isbn");
				if(!askContinue()) {
					break;
				}
			}
			System.out.print("Input author to add: ");
			String author = iv.inputString();
			boolean checkAdd = bookService.addAuthor(gettedBook, author);
			if(checkAdd) {
				System.out.println("Add successfully!!");
			}
			else {
				System.out.println("Author existed!");
			}
			if(!askContinue()) {
				break;
			}
		}
	}
	
	void chooseOptionToSearchBook() {
		while(true) {
			System.out.println("----Choose type you want to search-----");
			System.out.println("1. isbn");
			System.out.println("2. author");
			System.out.println("3. publisher");
			System.out.println("0. return");
			System.out.print("Your choice: ");
			int choice = iv.inputInt();
			if(choice == 0) {
				break;
			}
			switch (choice) {
			case 1:
				System.out.print("Input isbn: ");
				String isbn = iv.inputString();
				Book findedBook = bookService.getBookByIsbn(isbn);
				if(findedBook == null) {
					System.out.println("Book isn't exists!!");
				}
				else {
					findedBook.display();
				}
				break;
			case 2:
				System.out.print("Input author: ");
				String author = iv.inputString();
				List<Book> booksByAuthor = bookService.getBookByAuthor(author);
				if(booksByAuthor.size() == 0) {
					System.out.println("Dont' have any book have this author in data");
				}
				else {
					bookService.displaySpecificList(booksByAuthor);
				}
				break;
			case 3:
				System.out.print("Input publisher: ");
				String publisher = iv.inputString();
				List<Book> booksByPublisher = bookService.getBookByPublisher(publisher);
				if(booksByPublisher.size() == 0) {
					System.out.println("Dont' have any book have this publisher in data");
				}
				else {
					bookService.displaySpecificList(booksByPublisher);
				}
				break;
			case 0:
				break;
			default:
				System.out.println("Don't have this choice");
				break;
			}
			if(!askContinue()) {
				break;
			}
		}
	}
	void program() {
		while(true) {
			System.out.println("============LIBRARY MANAGEMENT SYSTEM================");
			System.out.println("1. Add a book");
			System.out.println("2. Add a magazine");
			System.out.println("3. Display book and magazine");
			System.out.println("4. Add author to book");
			System.out.println("5. Display top 10 of magazine by volume");
			System.out.println("6. Search book by (isbn, author, publisher)");
			System.out.print("Please choose function you'd would like to do: ");
			int choice = iv.inputInt();
			switch (choice) {
			case 1:
				boolean checkAdd = bookService.addBook(inputBook());
				if(!checkAdd) {
					System.err.println("ISBN is exists!!");
				}
				else {
					System.out.println("Add successfully!!");
				}
				break;
			case 2:
				magazineService.addMagazine(inputMagazine());
				System.out.println("Add successfully");
				break;
			case 3:
				magazineService.displayListSameProperty(bookService.getBooks());
				break;
			case 4: 
				addAuthorToBook();
				break;
			case 5:
				magazineService.displayTop10();
				break;
			case 6: 
				chooseOptionToSearchBook();
				break;
			default:
				System.out.println("Dont have this choice!");
				break;
			}
		}
	}
	
	void addData() {
		for (Book book : initBookData()) {
			if(bookService.addBook(book)) {
				System.out.println("add data successfully");
			}
			else {
				System.out.println("Duplicate isbn");
			}
		}
		for (Magazine magazine : initMagazineData()) {
			magazineService.addMagazine(magazine);
			System.out.println("add data successlly");
		}
	}
	public static void main(String[] args) {
		LibraryManagement lm = new LibraryManagement();
		//lm.addData();
		lm.program();
	}
}
