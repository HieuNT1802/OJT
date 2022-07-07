package fa.tranning;

import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
public class Validation {
	 Scanner in = new Scanner(System.in);
	 String PHONE_VALID = "^\\d{10}\\d*$";
	 String EMAIL_VALID
     = "^[A-Za-z0-9.+-_%]+@[A-Za-z.-]+\\.[A-Za-z]{2,4}$";
	 public String checkInputString() {
	        while (true) {
	            String result = in.nextLine().trim();
	            if (result.isEmpty()) {
	                System.err.println("Not empty");
	                System.out.print("Enter again: ");
	            } else {
	                return result;
	            }
	        }
	    }
	 public String checkPhone(String phone) {
	        while (true) {
	        	String result = checkInputString();
	            if (result.matches(PHONE_VALID)) {
	                return result;
	            } else {
	                System.err.println("Phone number must be 10 digits");
	                System.out.print("Phone number: ");
	            }
	        }
	    }
	  public String checkInputEmail(String email) {      
	        while (true) {
	            String result = checkInputString();
	          
	            if (result.matches(EMAIL_VALID)) {
	                return result;
	            } else {
	                System.err.println("Email must is correct format");
	                System.out.print("Email: ");
	            }
	        }
	    }
	  public Date checkDate(Date year) {
		  while(true) {
				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		        sdf.setLenient(false);
		        String inputDate = in.nextLine();
		        try{
		        	java.util.Date parsed = sdf.parse(inputDate); // parse to format MM/dd/yyy		           	           
		        	continue;
		           		           
		        }
		        catch(Exception e)
		        {
		            System.err.println("Date to correct format(dd/mm/yyyy)");
		            continue;
		        }
			}
			
		}
}
