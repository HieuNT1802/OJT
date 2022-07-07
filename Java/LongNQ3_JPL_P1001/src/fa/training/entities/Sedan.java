package fa.training.entities;

public class Sedan extends Car {
	private int length;

	
	
	public Sedan() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Sedan(int speed, double regularPrice, String color, int length) {
		super(speed, regularPrice, color);
		this.length = length;
	}


	
	public int getLength() {
		return length;
	}



	public void setLength(int length) {
		this.length = length;
	}



	@Override
	public double getSalePrice() {
		if(this.length > 20) {
			return this.regularPrice * (100-5)/100;
		}
		return this.regularPrice * (100-10)/100;
	}



	@Override
	public String toString() {
		return "Sedan [length=" + length + ", speed=" + speed + ", regularPrice=" + regularPrice + ", color=" + color
				+ "]";
	}
	
	
	
}
