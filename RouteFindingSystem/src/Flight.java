

public class Flight extends Leg{

	public Flight(Location origin, Location destination, int distanceInKm, String days) {
		super(origin, destination, distanceInKm, days, 0.23);
	}
	
	public boolean isLegValid() {
		if ((this.getOrigin() instanceof Airport) && (this.getDestination() instanceof Airport)) {
			return true;
		} 
		System.out.println("Error: cannot create Flight between: " + this.getOrigin() + " and " + this.getDestination());
		return false;
	}
}
