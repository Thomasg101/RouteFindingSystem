
import java.util.ArrayList;

public abstract class Location {

	protected ArrayList<Leg> connectingLegs = new ArrayList<Leg>();
	protected String name;
	
	public Location(String a) {
		name = a;
	}
	
	public void addConnection(Leg l) {
		connectingLegs.add(l);
	}
	
	public ArrayList<Leg> getNeighbours() {
		return connectingLegs;
	}
	
	public void cheapestRouteTo(Location Loc, String day) {
		
	}
	public void minStepsRouteTo(Location Loc, String day) {
		
	}
	public void shortestKmRouteTo(Location Loc, String day) {

	}

	public String getName() {
		return this.name;
	};
	
	public String toString() {
		return this.name;
	}

	public String getLocation() {
		return name;
	}
	
}
