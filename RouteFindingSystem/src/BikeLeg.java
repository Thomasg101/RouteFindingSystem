

public class BikeLeg extends Leg{


	public BikeLeg(Location origin, Location destination, int distanceInKm, String days) {
		super(origin, destination, distanceInKm, days, 1);
	}

	public boolean isLegValid() {
		if (this.getOrigin() instanceof BikeDeliveryLocation) {
			if (this.getDestination() instanceof Airport) {
				
				System.out.println("Error: cannot create bike leg between: " + this.getOrigin() + " and " + this.getDestination());
				return false;
			}
			else {
				return true;
			}
		} 
		
		if (this.getDestination() instanceof BikeDeliveryLocation) {
			if (this.getOrigin() instanceof Airport) {
			
				System.out.println("Error: cannot create bike leg between: " + this.getOrigin() + " and " + this.getDestination());
					return false;
			}
			else {
				return true;
			}
		}
		System.out.println("Error: cannot create Bike leg between: " + this.getOrigin() + " and " + this.getDestination());
		return false;
	}
	
}
