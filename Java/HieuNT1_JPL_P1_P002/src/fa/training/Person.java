package fa.training;
import java.util.Scanner;

public class Person {
	public static Scanner in = new Scanner(System.in);
	  public static int checkInputInt() {
	        while (true) {
	            try {
	                int result = Integer.parseInt(in.nextLine());
	                return result;
	            } catch (NumberFormatException e) {
	                System.err.println("Please input a number.");
	                System.out.print("Enter again: ");
	            }
	        }
	    }
public static int[] input() {
	 System.out.println("======= Shopping program =======");
	 System.out.print("Input number of bill: ");
     int size = checkInputInt();
     int[] bills = new int[size];
     for (int i = 0; i < bills.length; i++) {
         System.out.print("Input value of bill " + (i + 1) + ": ");
         bills[i] = checkInputInt();
     }
     return bills;
}
public static int inputWallet() {
    System.out.print("Input value of wallet: ");
    int wallet = checkInputInt();
    return wallet;
}
public static int calcTotal(int[] bills) {
    int total = 0;
    for (int i = 0; i < bills.length; i++) {
        total += bills[i];
    }
    return total;
}
public static boolean payMoney(int total, int wallet) {
    if (total > wallet) {
        return false;
    } else {
        return true;
    }
}
public static void printTotalAndResult(int[] bills, int wallet) {
    int total = calcTotal(bills);
    System.out.println("This is total of bill: " + total);
    if (payMoney(total, wallet)) {
        System.err.println("You can buy it");
    } else {
        System.err.println("You can't buy it.");
    }
}
public static void main(String[] args) {
	int[] bills = input();
    int wallet = inputWallet();
    printTotalAndResult(bills, wallet);
}
}
