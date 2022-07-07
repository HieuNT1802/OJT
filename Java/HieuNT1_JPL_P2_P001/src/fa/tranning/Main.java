package fa.tranning;

import java.util.Date;
import java.util.Scanner;

public class Main {
public static void main(String[] args) {
	String phone=null;
	String email=null;
	Date year=null;
	Validation va = new Validation();
	Scanner in = new Scanner(System.in);
	System.out.println("==== Validate Program ====" );	
	System.out.print("Phone number:");
	va.checkPhone(phone);
	System.out.print("Email:");
	va.checkInputEmail(email);
	System.out.print("Date: ");
	va.checkDate(year);
}
}
