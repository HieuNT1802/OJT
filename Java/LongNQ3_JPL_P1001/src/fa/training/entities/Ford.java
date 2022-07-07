package fa.training.entities;

import fa.training.entities.Car;

public class Ford extends Car {
	private int year;
	private int manufacturerDiscount;
	
	
	public Ford() {
		super();
		
	}

	public Ford(int speed, double regularPrice, String color, int year, int manufacturerDiscount) {
		super(speed, regularPrice, color);
		this.manufacturerDiscount = manufacturerDiscount;
		this.year = year;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public int getManufacturerDiscount() {
		return manufacturerDiscount;
	}


	public void setManufacturerDiscount(int manufacturerDiscount) {
		this.manufacturerDiscount = manufacturerDiscount;
	}


	@Override
	public double getSalePrice() {
	
		return this.regularPrice * (100-this.manufacturerDiscount)/100 ;
	}

	@Override
	public String toString() {
		return "Ford [year=" + year + ", manufacturerDiscount=" + manufacturerDiscount + ", speed=" + speed
				+ ", regularPrice=" + regularPrice + ", color=" + color + "]";
	}
	
	
}
