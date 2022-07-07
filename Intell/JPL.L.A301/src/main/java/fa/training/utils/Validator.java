package fa.training.utils;

import fa.training.dao.CustomerDaoImpl;
import fa.training.entities.Customer;

import java.util.Scanner;

public class Validator {
    private final static Scanner scanner = new Scanner(System.in);

    //check user input number limit
    public static int inputInRange(int min, int max){
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(scanner.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    //check user input string
    public static String inputString() {
        //loop until user input correct
        while (true) {
            String result = scanner.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    //check user input yes/ no
    public static boolean isYesNoString() {
        //loop until user input correct
        while (true) {
            String result = inputString();
            //return true if user input y/Y
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            //return false if user input n/N
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }

    public static double isDouble() {
        //loop until user input correct
        while (true) {
            try {
                double result = Double.parseDouble(scanner.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Must be input double");
                System.out.print("Enter again: ");
            }

        }
    }
    public static int checkInputInt() {
        //loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(scanner.nextLine().trim());
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Must be input integer.");
                System.out.print("Enter again: ");
            }
        }
    }
    public static Customer checkExitsCustomer() {
        //loop until user input correct
        while (true) {
            try {
                int customerId = checkInputInt();
                if (new CustomerDaoImpl().getCustomerById(customerId) == null){
                    throw  new NullPointerException();
                }
                return new CustomerDaoImpl().getCustomerById(customerId);

            } catch (NullPointerException e) {
                System.err.println("Customer ID is not exits");
                System.out.print("Enter again: ");
            }
        }
    }



}
