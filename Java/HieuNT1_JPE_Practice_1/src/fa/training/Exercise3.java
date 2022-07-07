package fa.training;

import java.util.Scanner;

public class Exercise3 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n;
		do {
		    System.out.println("Please enter number the interval [1...20] :  ");
		    while (!input.hasNextInt()) {		        
		        input.next();
		    }
		    n = input.nextInt();
		} while (n <= 22 && n>20);
		int i, j;   
		for(i=1; i<=n; i++)   
		{   
		for(j=1; j<=i; j++)   
		{  
		System.out.print(i+" ");   
		}   
		System.out.println();   
		}   
		}
	}
