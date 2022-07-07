package exercise3;

import java.util.Scanner;

public class FrequentNumber {

	public static void main(String[] args) {
		int n;
		 Scanner scanner = new Scanner(System.in);
		 
		 do {
		        System.out.println("Nhập vào số phần tử của mảng: ");
		        n = scanner.nextInt();
		    } while (n < 0);
		 int intArray [] = new int[n];
		 System.out.println("Nhập các phần tử cho mảng: ");
		    for (int len = 0; len < n; len++) {
		        System.out.print("Nhập phần tử thứ " + len + ": ");
		        intArray[len] = scanner.nextInt();
		    }
		    int value = 5;   
		    int d,c,l,index=0;
		    d = 0;
		    c = n - 1;
		    while (d <= c) {
		        l = (d + c) / 2;
	     
		    if (intArray[l] == value) {
		    	index=index+1;
	            System.out.println("Indexs:" + l);
	            return; 
	        } else if (intArray[l] < value) {
	            
	            d = l + 1;
	        } else {    
	            c = l - 1;
	        }
		    System.out.println("Amount of frequence:" + index);
	    }
	}
}
