package fa.tranning.enities;

public class Fixedwings extends Airplane {
private String flyMethod;

public Fixedwings(String id, String model, double cruiseSpeed, double emptyWeight, double maxTakeoffWeight, int seats,
		String flyMethod) {
	super(id, model, cruiseSpeed, emptyWeight, maxTakeoffWeight, seats);
	this.flyMethod = flyMethod;
}

public Fixedwings() {
	super();
}

public String getFlyMethod() {
	return flyMethod;
}

public void setFlyMethod(String flyMethod) {
	this.flyMethod = flyMethod;
}

@Override
public String toString() {
	return "Fixedwings [flyMethod=" + flyMethod + "]";
}

}
