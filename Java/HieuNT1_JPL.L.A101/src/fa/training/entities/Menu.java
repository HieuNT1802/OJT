package fa.training.entities;
import java.util.Scanner;
import java.lang.ref.Cleaner;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class Menu {
	 List<Book> list = new ArrayList<>();
	 List<Magazine> list2 = new ArrayList<>();
	 LibraryManagement lb = new LibraryManagement();
	 Scanner sc = new Scanner(System.in);
	 public int menu() {
	        System.out.println("1. Add a book ");
	        System.out.println("2. Add a magazine ");
	        System.out.println("3. Display books and magazines ");
	        System.out.println("4. Add author to book ");
	        System.out.println("5. Display top 10 of magazines by volume ");
	        System.out.println("6. Search book by (isbn,author,publisher) ");
	        
	        int choice = getChoice("Input choice: ",1,6);
	        return choice;
	    }
	 public int getChoice(String mess, int min, int max) {
	        int number = 0;
	        while (true) {
	            try {
	                System.out.print(mess);
	                number = Integer.parseInt(sc.nextLine());
	                if (number < min || number > max) {
	                    System.out.println("Choice within 1-6, please input again");
	                } else {
	                    break;
	                }
	            } catch (Exception e) {
	                System.out.println("Invalid number, please input again");
	            }
	        }
	        return number;
	    }
	 
	 public static void main(String[] args) {
		
		 List<Book> list = new ArrayList<>();
		 List<Magazine> list2 = new ArrayList<>();
		 LibraryManagement lb = new LibraryManagement();
		 Book books = new Book();
		 Magazine magas= new Magazine();
		 Menu m = new Menu();
		 SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		LibraryManagement lb2 = new LibraryManagement(list,list2);
		    df.setLenient(false);
		 try {
				list2.add(new Magazine(1, "abc",df.parse("20-02-2001"), "abcd", 11, 10));
				list2.add(new Magazine(2, "abcd",df.parse("20-02-2001"), "abcd", 12, 10));
				list2.add(new Magazine(3, "abce",df.parse("20-02-2001"), "abcd", 13, 10));
				list2.add(new Magazine(4, "abc",df.parse("20-02-2001"), "abcd", 14, 10));
				list2.add(new Magazine(5, "abc",df.parse("20-02-2001"), "abcd", 15, 10));
				list2.add(new Magazine(6, "abc",df.parse("20-02-2001"), "abcd", 16, 10));
				list2.add(new Magazine(7, "abc",df.parse("20-02-2001"), "abcd", 17, 10));
				list2.add(new Magazine(8, "abc",df.parse("20-02-2001"), "abcd", 18, 10));
				list2.add(new Magazine(9, "abc",df.parse("20-02-2001"), "abcd", 19, 10));
				list2.add(new Magazine(10, "abc",df.parse("20-02-2001"), "abcd", 20, 10));
				list2.add(new Magazine(11, "abc",df.parse("20-02-2001"), "abcd", 21, 10));
			} catch (Exception e) {
				// TODO: handle exception
			}
		 while (true) {
	            int choice = m.menu() ;
	            switch (choice) {
	                case 1:
	                	lb.addBook(books);  
	                	break;
	                case 2:
	                    lb.addMagazine(magas);
	                    break;
	                case 3:
	                	list2.add(magas);
	                	list.add(books);
	                    System.out.println("All of books:");
	                    books.display();
					
	                   
	                   System.out.println("All of magazines:");
	                   for (Magazine mg : list2) {
						System.out.println(mg);
					}
	                    break;
	                case 4:
	                    
	                    break;
	                case 5:
	                	lb2.sorttop10();
	                    break;
	                case 6:
	                	
	                    break;
	                case 7:
	                    System.exit(0);
	            }
	        }
	}
}
