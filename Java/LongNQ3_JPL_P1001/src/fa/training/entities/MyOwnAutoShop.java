package fa.training.entities;

import java.util.Scanner;

public class MyOwnAutoShop {
	public static void main(String[] args) {
		Ford ford1 = new Ford(40, 2000f, "Red", 2005, 10);
		Ford ford2 = new Ford(40, 2000f, "Red", 2004, 5);

		Sedan sedan1 = new Sedan(60, 2150, "Black", 1400);
		Sedan sedan2 = new Sedan(50, 1800f, "Blue", 2000);

		Scanner sc = new Scanner(System.in);

		Truck truck1 = inputTruck(sc);
		Truck truck2 = inputTruck(sc);

		sc.close();
		System.out.println("All sale price: ");
		Car[] cars = {ford1,ford2,sedan1,sedan2,truck1,truck2};
		for(Car car: cars) {
			System.out.println(car.getSalePrice());
		}
	}

	public static Truck inputTruck(Scanner sc){
		System.out.println("Enter truck info!");
		Truck truck = new Truck();
		System.out.print("Speed:");
		truck.setSpeed(sc.nextInt());
		System.out.print("Regular price:");
		truck.setRegularPrice(sc.nextDouble());
		System.out.print("Color:");
		truck.setColor(sc.next());
		System.out.print("Weight: ");
		truck.setWeight(sc.nextInt());
		System.out.println(truck);
		return truck;
	}
}
