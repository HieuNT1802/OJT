package fa.training.assignment_802.validate;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class InputValidate {
	static final Scanner sc = new Scanner(System.in);

	public String inputString() {
		while(true) {
			try {
				String input =  sc.nextLine();
				if(input == null || input.replaceAll("[ ]+", "").equals("")) {
					System.out.println("Can not input blank value");
					continue;
				} return input;
			}
			catch(Exception e) {
				continue;
			}
		}
	}

	public int inputPublicationYear() {
		while(true) {
			try {
				int year = Integer.parseInt(sc.nextLine());
				if(year < 1900 || year > 2300) {
					System.err.println("Year must larger than 1900 and smaller than 2300");
					continue;
				}
				return year;
			}catch(NumberFormatException e) {
				System.err.println("Invalid data");
				continue;
			}
		}
	}
	
	public Date inputPublicationDate(int year) {
		while(true) {
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	        sdf.setLenient(false);
	        String inputDate = sc.nextLine();
	        try{
	        	java.util.Date parsed = sdf.parse(inputDate); // parse to format MM/dd/yyyy
	            java.sql.Date dateConvert = new java.sql.Date(parsed.getTime()); //try to convert to sql Date
	            if(dateConvert.toLocalDate().getYear() != year) {
	            	System.err.println("Date must have same year with publication year");
	            	continue;
	            }
	            return dateConvert;
	        }
	        catch(Exception e)
	        {
	            System.err.println(inputDate+" is not a valid Date");
	            continue;
	        }
		}
	}
	
	
	public char inputYesNo() {
		while(true) {
			char choice = sc.next(".").toLowerCase().charAt(0);
			if(choice == 'y' || choice == 'n') {
				sc.nextLine();
				return choice;
			}
			System.err.println("Y/y or N/n only"); 
		}
	}
	
	public int inputInt() {
		while(true) {
			try {
				int choice = Integer.parseInt(sc.nextLine());
				return choice;
			}catch(NumberFormatException e) {
				System.err.println("Invalid data");
				continue;
			}
		}
	}
}
