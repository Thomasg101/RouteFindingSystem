
import java.util.ArrayList;

public class Route {

	private ArrayList<Leg> L;
	private boolean isValid = true;
	

	public Route(){
		L = new ArrayList<Leg>();
	}
	
	public Route(Route minRoute) {
		L = new ArrayList<Leg>(minRoute.L);
	}

	public Location getLastLocation() {
		return L.get(L.size() - 1).getDestination();
	}
	
	public double totalCost(){
		
		double a = 0;
		for(int i = 0; i < L.size(); i++) {
			a += L.get(i).getCostPerKm() * L.get(i).getDistance();
		}
		return a;
		
	}
	public int totalDistance() {
		int a = 0;
		for(int i = 0; i < L.size(); i++) {
			a += L.get(i).getDistance();
		}
		return a;
	}
	public int totalSteps() {
		return L.size();
		
	}
	public void addLeg(Leg leg, String day) {
		
		//checks if we can add the leg
		for(int i = 0; i < L.size(); i++) {
			
			
			if(L.get(i).getDestination() == leg.getDestination() || L.get(i).getOrigin() == leg.getDestination()) {
				this.isValid = false;
			}
		} 
		
		if(!leg.daysAvailable().contains(day)) {
			this.isValid = false;
		}
		
		// if I can ship on the date
		
		
		L.add(leg);
	}
	
	public String toString() {
		
		
		
		String s = "";
		for(Leg l : L) {
			s += l.toString();
		}
		
		return ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n" + "Steps: " + totalSteps() + " Distance: " + totalDistance()
				+ " Cost: " + totalCost() + "\nRoute Start: \n" + s
				+ "Route End.\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>";
	}

	public boolean isValid() {
		
		return isValid;
	}
	
}
