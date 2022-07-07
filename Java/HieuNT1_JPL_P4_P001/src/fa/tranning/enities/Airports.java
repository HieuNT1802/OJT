package fa.tranning.enities;

import java.util.ArrayList;
import java.util.List;

public class Airports {
 private String id;
 private String name;
 private String address;
 private double runwaySize;
 private double maxFixedWingPark;
 private  List<Airplane> aid = new ArrayList<>();
 private double maxRotatedWingPark;
 private List<Helicopters> heli = new ArrayList<>();
public Airports(String id, String name, String address, double runwaySize, double maxFixedWingPark, List<Airplane> aid,
		double maxRotatedWingPark, List<Helicopters> heli) {
	super();
	this.id = id;
	this.name = name;
	this.address = address;
	this.runwaySize = runwaySize;
	this.maxFixedWingPark = maxFixedWingPark;
	this.aid = aid;
	this.maxRotatedWingPark = maxRotatedWingPark;
	this.heli = heli;
}
public Airports() {
	
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public double getRunwaySize() {
	return runwaySize;
}
public void setRunwaySize(double runwaySize) {
	this.runwaySize = runwaySize;
}
public double getMaxFixedWingPark() {
	return maxFixedWingPark;
}
public void setMaxFixedWingPark(double maxFixedWingPark) {
	this.maxFixedWingPark = maxFixedWingPark;
}
public List<Airplane> getAid() {
	return aid;
}
public void setAid(List<Airplane> aid) {
	this.aid = aid;
}
public double getMaxRotatedWingPark() {
	return maxRotatedWingPark;
}
public void setMaxRotatedWingPark(double maxRotatedWingPark) {
	this.maxRotatedWingPark = maxRotatedWingPark;
}
public List<Helicopters> getHeli() {
	return heli;
}
public void setHeli(List<Helicopters> heli) {
	this.heli = heli;
}

 
}
