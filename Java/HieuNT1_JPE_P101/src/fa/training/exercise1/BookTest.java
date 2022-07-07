package fa.training.exercise1;

import java.util.Scanner;

public class BookTest {
public static void main(String[] args) {
String name;
int ISBN_number; 
String author; 
String publisher;
 Scanner sc = new Scanner(System.in);
 Book [] book =new Book [30];
 System.out.println("Enter data:");
 for(int i=0; i<30; i++){
     System.out.printf("Book %d\n", (i+1));
     System.out.printf("Enter the book name\n");
     name = sc.next();
     
     System.out.printf("Enter the book ISBN Number\n");
     ISBN_number = sc.nextInt();
     
     System.out.printf("Enter the book Author\n");
     author = sc.next();
     
     System.out.printf("Enter the book Publisher\n");
     publisher = sc.next();
     
     book[i] = new Book(name,ISBN_number,author,publisher );  
 }
 for(int i=0; i<30; i++){
     System.out.printf("\n\nBook %d\n", (i+1));
     System.out.printf("%s\n", book[i].getBookInfo());
 }
 }
}
