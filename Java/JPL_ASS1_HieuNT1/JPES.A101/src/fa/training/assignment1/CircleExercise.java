package fa.training.assignment1;

import java.util.Scanner;

public class CircleExercise {
public static void main(String[] args) {
	double r;
    Scanner sc = new Scanner(System.in);
    System.out.println("Radius: ");
    r = sc.nextDouble();
    System.out.println("Perimeter is =" + (r*2*3.1415926535));
    System.out.println("Area is =" + (r*r*3.1415926535));
}
}
