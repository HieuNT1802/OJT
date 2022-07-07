package fa.training.assignment1;

import java.util.Scanner;

public class LogicalExercise {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n1,n2;
	
	System.out.print( "Input first integer: " );       
	n1 = sc.nextInt();
    System.out.print( "Input second integer: " );       
    n2 = sc.nextInt();  
	if ( n1 == n2 )           
        System.out.printf( "%d == %d\n", n1, n2 );  
    if ( n1 != n2 )          
        System.out.printf( "%d != %d\n", n1, n2 );  
    if ( n1 < n2 )          
        System.out.printf( "%d < %d\n", n1, n2 );  
    if ( n1 > n2 )          
        System.out.printf( "%d > %d\n", n1, n2 );  
    if ( n1 <= n2 )          
        System.out.printf( "%d <= %d\n", n1, n2 );  
    if ( n1 >= n2 )          
        System.out.printf( "%d >= %d\n", n1, n2 );  
}
}
