

public abstract class Leg {
	
	private Location origin;
	private Location destination;
	private String daysAvailable;
	private int distance;
	private double costPerKm;
	
	public Leg(Location origin, Location destination, int distanceInKm, String days, double costPerKm) {
		this.origin = origin;
		this.destination = destination;
		this.daysAvailable = days;
		this.costPerKm = costPerKm;
		this.distance = distanceInKm;
	}

	public abstract boolean isLegValid();
	
	public Location getOrigin() {
		return origin;
	}
	
	public Location getDestination() {
		return destination;
	}
	public String daysAvailable() {
		return daysAvailable;
	}
	public int getDistance() {
		return distance;
	}
	public double getCostPerKm() {
		return costPerKm;
	}
	
	public String toString() {
		
		return "Origin: " + origin + " Destination: " + destination + "\n";
	}
	

}
