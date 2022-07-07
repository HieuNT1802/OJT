package fa.training.assignment2;

import java.util.Scanner;

public class Exercise3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		 System.out.print("Input first number: ");
        int number1 = in.nextInt();
        System.out.print("Input second number: ");
        int number2 = in.nextInt();
		 System.out.print("Input third number: ");
        int number3 = in.nextInt();
        System.out.print("Input fourth number: ");
        int number4 = in.nextInt();	
        System.out.print("Input five number: ");
        int number5 = in.nextInt();	

        
        System.out.println("The sum is: "+ (number1+number2+number3+number4+number5));
	}

}
