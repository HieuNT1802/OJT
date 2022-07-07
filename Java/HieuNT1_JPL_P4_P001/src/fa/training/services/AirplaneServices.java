package fa.training.services;

import java.util.LinkedList;
import java.util.List;

import fa.tranning.enities.Airplane;
import fa.tranning.enities.Fixedwings;
import fa.tranning.enities.Helicopters;



public class AirplaneServices {
	 private static List<Airplane> airplane = new LinkedList<>();

	public AirplaneServices() {
		airplane.add(new Fixedwings("", null, 0, 0, 0, 0, null));
		airplane.add(new Helicopters("", null, 0, 0, 0, 0, null));
	}
		public  List<Airplane> getAirplanes(){
			return airplane;
	 			}
	 public boolean addAirport(Airplane airports) {
		return airplane.add(airports); 
	 }
	
	 
}
