package fa.training.entities;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
public class LibraryManagement {
	private List<Book> list;
	private List<Magazine> list1;
	
	public LibraryManagement(List<Book> list,List<Magazine> list1) {
		super();
		this.list = list;
		this.list1 = list1;
	}
	
	
	public LibraryManagement() {
	}

	 Scanner sc = new Scanner(System.in);
	 
	//List<Book> list;
	public void addBook(Book book) {
		ArrayList<Book> books = new ArrayList<>();		
		int numberOfAuthor = 0;
		Set<String> authors = new HashSet<String>();		
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	     df.setLenient(false);
		while(true) {
			
			System.out.print("Enter publication year: ");
			book.setPubicationYear(sc.nextInt());
			System.out.print("Enter publisher: ");
			book.setPublisher(sc.next());
			System.out.print("Enter publication date: ");
			while(true) {
				try {
					book.setPublicationDate(df.parse(sc.next()));
					break;
				} catch (ParseException e) {
					System.out.print("Can't parse to date format, please enter again!");
				}
			}
			System.out.print("Enter ISBN: ");
			book.setIsbn(sc.next());
			System.out.print("Enter number of author you want to add: ");
			numberOfAuthor = sc.nextInt();
			for (int i = 0; i < numberOfAuthor; i++) {				
		 
				System.out.print("Enter author :");
				authors.add(sc.next());
				book.setAuthor(authors);				
				if(numberOfAuthor>authors.size()) {
					break;
				}
					
				}
			
			System.out.print("Enter publication place: ");
			book.setPublicationPlace(sc.next());
			books.add(book);
			System.out.println("Add book sucessfully!");
//			for (Book bk : books) {
//				System.out.println(bk);
//			}
			break;
		}		
	}
	public void addMagazine(Magazine maga) {
		ArrayList<Magazine> magas = new ArrayList<>();		
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
	    df.setLenient(false);
		while(true) {
			System.out.print("Enter publication year: ");
			maga.setPubicationYear(sc.nextInt());
			System.out.print("Enter publisher: ");
			maga.setPublisher(sc.next());
			System.out.print("Enter publication date: ");
			while(true) {
				try {
					maga.setPublicationDate(df.parse(sc.next()));
					break;
				} catch (ParseException e) {
					System.out.print("Can't parse to date format, please enter again!");
				}
			}
			System.out.println("Enter author: ");
			maga.setAuthor(sc.next());
			System.out.println("Enter volumn: ");
			maga.setVolumn(sc.nextInt());
			System.out.println("Enter edition: ");
			maga.setEdition(sc.nextInt());
			magas.add(maga);
			System.out.println("Add magazine sucessfully!");
			break;
		}
		
	}
	public void sorttop10() {
		 Collections.sort(list1, new Comparator<Magazine>() {
	            @Override
	            public int compare(Magazine o1, Magazine o2) {
	                if (o1.getVolumn() < o2.getVolumn()) {
	                    return 1;
	                } else if (o1.getVolumn() > o2.getVolumn()) {
	                    return -1;
	                } else {
	                    return 0;
	                }
	            }
	        });  
		 for (int i = 1; i< 10 ; i++) {
			 System.out.println(list1);
			 break;
		}
		 
	}


	}
	

