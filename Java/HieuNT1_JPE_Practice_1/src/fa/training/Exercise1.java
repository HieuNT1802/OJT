package fa.training;

import java.util.Scanner;

public class Exercise1 {
	
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an integer:  ");
		int k = input.nextInt();
		System.out.print("Enter a integer:  ");
		int j = input.nextInt();
		// int n=0;	
		if ( k % 2 != 0){
		   ++k;
		}
		while(k < j) {
		  System.out.println("" + k);
		  k += 2;
	  }
	

}}
