package fa.training.assignment2;

import java.util.Scanner;

public class Exercise4 {

	public static void main(String[] args) {
		double radius, height, volume, surfaceArea,baseArea;
        Scanner scanner;
        scanner = new Scanner(System.in);
      
        System.out.println("Enter Radius of Cylinder");
        radius = scanner.nextDouble();
        System.out.println("Enter Height of Cylinder");
        height = scanner.nextDouble();
 
        baseArea= Math.PI* radius* radius;
        surfaceArea = 2 * Math.PI * radius * (radius + height);
        volume = Math.PI * radius * radius * height;
 
        System.out.format("Surface Area  = %.3f\n", surfaceArea);
        System.out.format("Base Area  = %.3f\n", baseArea);
        System.out.format("Volume  = %.3f\n", volume);

	}

}
