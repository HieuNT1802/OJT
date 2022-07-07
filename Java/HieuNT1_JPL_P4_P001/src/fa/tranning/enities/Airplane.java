package fa.tranning.enities;

public class Airplane {
 private String id;
 private String model;
 private double cruiseSpeed;
 private double emptyWeight;
 private double maxTakeoffWeight;
 private int seats;
 
public Airplane() {

	// TODO Auto-generated constructor stub
}

public Airplane(String id, String model, double cruiseSpeed, double emptyWeight, double maxTakeoffWeight, int seats) {
	
	this.id = id;
	this.model = model;
	this.cruiseSpeed = cruiseSpeed;
	this.emptyWeight = emptyWeight;
	this.maxTakeoffWeight = maxTakeoffWeight;
	this.seats = seats;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getModel() {
	return model;
}

public void setModel(String model) {
	this.model = model;
}

public double getCruiseSpeed() {
	return cruiseSpeed;
}

public void setCruiseSpeed(double cruiseSpeed) {
	this.cruiseSpeed = cruiseSpeed;
}

public double getEmptyWeight() {
	return emptyWeight;
}

public void setEmptyWeight(double emptyWeight) {
	this.emptyWeight = emptyWeight;
}

public double getMaxTakeoffWeight() {
	return maxTakeoffWeight;
}

public void setMaxTakeoffWeight(double maxTakeoffWeight) {
	this.maxTakeoffWeight = maxTakeoffWeight;
}

public int getSeats() {
	return seats;
}

public void setSeats(int seats) {
	this.seats = seats;
}

}
