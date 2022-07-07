package fa.training.exercise3;

public class MyOwnAutoShop {
public static void main(String[] args) {
	Sedan sed = new Sedan(100, 10000.0, "red", 30);
	Ford fod = new Ford(150, 300, "black", 2020, 20);
	Ford fod2 = new Ford(180, 30000, "white", 2021, 30);
	Car cr = new Car(140, 100, "yellow");
	System.out.println("Sedan:" + sed.getSalePrice());
	System.out.println("Ford:" + fod.getSalePrice());
	System.out.println("Car:" + cr.getSalePrice());
}
}
