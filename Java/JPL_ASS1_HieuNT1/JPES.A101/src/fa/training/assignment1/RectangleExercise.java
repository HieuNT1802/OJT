package fa.training.assignment1;

import java.util.Scanner;

public class RectangleExercise {
public static void main(String[] args) {
	double w,h;
    Scanner sc = new Scanner(System.in);
    System.out.print("Width = ");
    w = sc.nextDouble();
    System.out.print("Height  = ");
    h = sc.nextDouble();
    System.out.println("Area is "+w+"*"+h+"="+ (w*h));
    System.out.println("Perimeter is 2*("+w+"+"+h+")="+ (2*(w+h)));
}
}
