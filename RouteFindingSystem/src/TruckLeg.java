

public class TruckLeg extends Leg{

	
	public TruckLeg(Location origin, Location destination, int distanceInKm, String days) {
		super(origin, destination, distanceInKm, days, 0.58);
	}

	public boolean isLegValid() {
		if (this.getOrigin() instanceof TruckDepot) {
			if (this.getDestination() instanceof BikeDeliveryLocation) {
				
				System.out.println("Error: cannot create Truck leg between: " + this.getOrigin() + " and " + this.getDestination());
				return false;
			} else {
				return true;
			}
		} 
		
		if (this.getDestination() instanceof TruckDepot) {
			if (this.getOrigin() instanceof BikeDeliveryLocation) {
			
				System.out.println("Error: cannot create Truck leg between: " + this.getOrigin() + " and " + this.getDestination());
					return false;
			} else {
				return true;
			}
		}		
		System.out.println("Error: cannot create Truck leg between: " + this.getOrigin() + " and " + this.getDestination());
		return false;
	}
}
