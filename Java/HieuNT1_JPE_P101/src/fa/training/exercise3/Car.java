package fa.training.exercise3;

public class Car {
private int speed;
private double regularPrice;
private String color;
//private double getSalePrice();
public Car(int speed, double regularPrice, String color) {
	super();
	this.speed = speed;
	this.regularPrice = regularPrice;
	this.color = color;
}
public Car() {
	super();
	// TODO Auto-generated constructor stub
}
public double getSalePrice() {
    return regularPrice;
}


}
