package fa.training.sms;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
public static void main(String[] args) {
	ArrayList<Student> students = new ArrayList();
	ArrayList<Course> course = new ArrayList();
	ArrayList<Enroll> enrols = new ArrayList();
	ArrayList<Book> books = new ArrayList();
	ArrayList<BookAdoption> bookAdp = new ArrayList();
	Student st1 = new Student(01, "Hieu", "SE", "04/06/2001");
	Student st2 = new Student(02, "Vu", "SE", "05/06/2001");
	Student st3= new Student(03, "Dat", "SE", "06/06/2001");
	Student st4 = new Student(04, "Tuan", "SE", "07/06/2001");
	Student st5 = new Student(05, "Duc", "SE", "08/06/2001");
	//
	students.add(st1);
	students.add(st2);
	students.add(st3);
	students.add(st4);
	students.add(st5);
	
	Course co1= new Course("c01", "Java", "Software");
	Course co2= new Course("c02", ".Net", "Software");
	Course co3= new Course("c03", "Python", "Software");
	Course co4= new Course("c04", "C++", "Software");
	Course co5= new Course("c05", "C", "Software");
	//
	course.add(co1);
	course.add(co2);
	course.add(co3);
	course.add(co4);
	course.add(co5);
	
	Enroll er1 = new Enroll("05/01/2022", 2, st1, co1);
	Enroll er2 = new Enroll("05/01/2022", 2, st2, co2);
	Enroll er3 = new Enroll("05/01/2022", 2, st3, co3);
	Enroll er4 = new Enroll("05/01/2022", 2, st4, co4);
	Enroll er5 = new Enroll("05/01/2022", 2, st5, co5);
	Enroll er6 = new Enroll("05/01/2022", 2, st1, co5);
	enrols.add(er1);
	enrols.add(er2);
	enrols.add(er3);
	enrols.add(er4);
	enrols.add(er5);
	enrols.add(er6);

//
	Book bk1= new Book(1, "Ahihi", "VietNam", "Trung Hieu");
	Book bk2= new Book(2, "Ahoho", "VietNam", "Trung Hieu");
	Book bk3= new Book(3, "Ahehe", "VietNam", "Trung Hieu");
	Book bk4= new Book(4, "Ahuhu", "VietNam", "Trung Hieu");
	Book bk5= new Book(5, "Ahaha", "VietNam", "Trung Hieu");
	
	books.add(bk5);
	books.add(bk1);
	books.add(bk2);
	books.add(bk3);
	books.add(bk4);
	//
	BookAdoption ba1= new BookAdoption("02/03/2022", co1, bk1);
	BookAdoption ba2= new BookAdoption("02/03/2022", co2, bk2);
	BookAdoption ba3= new BookAdoption("02/03/2022", co3, bk3);
	BookAdoption ba4= new BookAdoption("02/03/2022", co4, bk4);
	BookAdoption ba5= new BookAdoption("02/03/2022", co5, bk5);
    //
	bookAdp.add(ba5);
	bookAdp.add(ba1);
	bookAdp.add(ba2);
	bookAdp.add(ba3);
	bookAdp.add(ba4);
	
	System.out.println(st1);
	System.out.println(st2);
	System.out.println(st3);
	System.out.println(st4);
	System.out.println(st5);
	
	System.out.println(co1);
	System.out.println(co2);
	System.out.println(co3);
	System.out.println(co4);
	System.out.println(co5);
	
	System.out.println(er1);
	System.out.println(er2);
	System.out.println(er3);
	System.out.println(er4);
	System.out.println(er5);
	
	
	System.out.println(ba1);
	System.out.println(ba2);
	System.out.println(ba3);
	System.out.println(ba4);
	System.out.println(ba5);
	
	Scanner sc = new Scanner(System.in);
	System.out.print("Enter SSN: ");
	int ssn = sc.nextInt();
	for (Enroll ero : enrols) {
		if(ssn == ero.getStudent().getSsn()) {
			System.out.println("All Course :"+ ero.getCourse());
		}		
		}
	System.out.println("Enter ISBN:");
	int isbn = sc.nextInt();
	for (BookAdoption bookAdoption : bookAdp) {
		if (isbn == bookAdoption.getBk().getISBN() ) {
			System.out.println("All Book : " + bookAdoption.getBk());
		}
	}
	}


}

