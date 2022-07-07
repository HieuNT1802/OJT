package fa.training.entities;

public class Truck extends Car {
	private int weight;

	
	public Truck() {
		super();
	}
	
	public Truck(int speed, double regularPrice, String color,int weight) {
		super(speed, regularPrice, color);
		this.weight = weight;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public double getSalePrice() {
		if(weight > 2000) {
			return this.regularPrice * (100-10) /100;  
		}
		return this.regularPrice * (100-20) /100;
	}

	@Override
	public String toString() {
		return "Truck [weight=" + weight + ", speed=" + speed + ", regularPrice=" + regularPrice + ", color=" + color
				+ "]";
	}
	
}
