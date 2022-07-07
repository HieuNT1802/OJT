package fa.training.services;

import java.util.LinkedList;
import java.util.List;
import fa.tranning.enities.Airports;

public class AirportService {
	 private static List<Airports> airport = new LinkedList<>();
	 
	 public AirportService() {	
		 airport.add(new Airports("AP1", "Noi Bai", "Ha Noi", 1000, 2000,null,500, null));
	}

	public  List<Airports> getAirport(){
			return airport;
	 			}
	 public boolean addAirport(Airports airports) {
		return airport.add(airports); 
	 }
	 
	 
	 }
