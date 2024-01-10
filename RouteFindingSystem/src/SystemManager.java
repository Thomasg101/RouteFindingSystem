
import java.util.ArrayList;

public class SystemManager {

	private ArrayList<Location> locations = new ArrayList<Location>();
	private ArrayList<Leg> legs = new ArrayList<Leg>();
	
	public SystemManager(){
	}
	
	public void addLocation(Location l){
		locations.add(l);
	}
	
	public void addLeg(Leg leg) {
		
		boolean valid = true;
		
		for(int i = 0; i < legs.size(); i++) {
			if(legs.get(i).getDestination().equals(leg.getDestination()) && legs.get(i).getOrigin().equals(leg.getOrigin())) {
				valid = false;
			}
		}
		
		if(leg.getDistance() < 0) {
			valid = false;
		}
		
		if(!leg.daysAvailable().contains("M") && !leg.daysAvailable().contains("T") && !leg.daysAvailable().contains("W") && !leg.daysAvailable().contains("R") && !leg.daysAvailable().contains("F") && !leg.daysAvailable().contains("S") && !leg.daysAvailable().contains("U")) {
			valid = false;
		}
		
		if(!leg.isLegValid()) {
			valid = false;
		}
		
		
		
	
		if(valid) {
			legs.add(leg);
			leg.getOrigin().addConnection(leg);
//			leg.getDestination().addConnection(new Leg(leg.getDestination(), leg.getOrigin(), leg.getDistance(), leg.daysAvailable(), leg.getCostPerKm()));
		} else {
//			System.out.println("Error add leg: " + leg);
		}
		
		
	}
	public void displaySystemDetails() {
		
	}
	public Location findLocation(String a) {
		for(int i = 0; i < locations.size(); i++) {
			if(locations.get(i).getName().equals(a)) {
				return locations.get(i);
			}
		}
		return null;
	}
	
	
	public Route findCheapestRoute(Location origin, Location destination, String day) {
		
		
		if(origin.getName().equals(destination.getName())) {
			return null;
		}
		
		Route result = null;
		ArrayList<Route> allRoutes = new ArrayList<Route>();
		
		for(int i = 0 ; i < origin.getNeighbours().size(); i++) {
			Route testRoute = new Route();
		
			testRoute.addLeg(origin.getNeighbours().get(i), day);
			if(testRoute.isValid()) {
				allRoutes.add(testRoute);
			}
		}
		
		while(!allRoutes.isEmpty()) {
			
			int minIndex = getMinRouteCostIndex(allRoutes);
			Route minRoute = allRoutes.get(minIndex);
			allRoutes.remove(minIndex);
			Location nextHub = minRoute.getLastLocation();	
			
			if(nextHub.getName().equals(destination.getName())) {
				if (result == null || result.totalCost() > minRoute.totalCost()) {
					result = minRoute;
				}
			}
			
			for(int i = 0; i < nextHub.getNeighbours().size(); i++) {
				Route testRoute = new Route(minRoute);
				
				testRoute.addLeg(nextHub.getNeighbours().get(i), day);
				if(testRoute.isValid()) {
					allRoutes.add(testRoute);
				}
				
			}
			
		}
		return result;
		
	}
	
	
	public int getMinRouteCostIndex(ArrayList<Route> allRoutes) {
		double num = Integer.MAX_VALUE;
		int index = 0;
		
		for(int i = 0; i < allRoutes.size(); i++) {
			if(num > allRoutes.get(i).totalCost()) {
				num = allRoutes.get(i).totalCost();
				index = i;
			}
			
		}
		return index;
		
	}
	
	
	public Route findMinStepsRoute(Location origin, Location destination, String day) {
			
		if(origin == null || destination == null || origin.getName().equals(destination.getName())) {
			return null;
		}
		
		Route result = null;
		ArrayList<Route> allRoutes = new ArrayList<Route>();
		
		for(int i = 0 ; i < origin.getNeighbours().size(); i++) {
			Route testRoute = new Route();
			testRoute.addLeg(origin.getNeighbours().get(i), day);
			if(testRoute.isValid()) {
				allRoutes.add(testRoute);
			}
			
		}
		
		while(!allRoutes.isEmpty()) {
			
			int minIndex = getMinRouteStepIndex(allRoutes);
			Route minRoute = allRoutes.get(minIndex);
			allRoutes.remove(minIndex);
			Location nextHub = minRoute.getLastLocation();
			
			if(nextHub.getName().equals(destination.getName())) {
				if (result == null || result.totalSteps() > minRoute.totalSteps()) {
					result = minRoute;
				}
			}
			
			for(int i = 0; i < nextHub.getNeighbours().size(); i++) {
				Route testRoute = new Route(minRoute);
				testRoute.addLeg(nextHub.getNeighbours().get(i), day);
				if(testRoute.isValid()) {
					allRoutes.add(testRoute);
				}
			}
		}
		return result;
		
		
	}
	public int getMinRouteStepIndex(ArrayList<Route> allRoutes) {
		double num = Integer.MAX_VALUE;
		int index = 0;
		
		for(int i = 0; i < allRoutes.size(); i++) {
			if(num > allRoutes.get(i).totalSteps()) {
				num = allRoutes.get(i).totalSteps();
				index = i;
			}
			
		}
		return index;
		
	}
	public Route findShortestKmRoute(Location origin, Location destination, String day ){
		
		
		if(origin.getName().equals(destination.getName())) {
			return null;
		}
		
		Route result = null;
		ArrayList<Route> allRoutes = new ArrayList<Route>();
		
		for(int i = 0 ; i < origin.getNeighbours().size(); i++) {
			Route testRoute = new Route();
			testRoute.addLeg(origin.getNeighbours().get(i), day);
			if(testRoute.isValid()) {
				allRoutes.add(testRoute);
			}
		}
		
		while(!allRoutes.isEmpty()) {
			
			int minIndex = getMinRouteKmIndex(allRoutes);
			Route minRoute = allRoutes.get(minIndex);
			allRoutes.remove(minIndex);
			Location nextHub = minRoute.getLastLocation();
			
			if(nextHub.getName().equals(destination.getName())) {
				if (result == null || result.totalDistance() > minRoute.totalDistance()) {
					result = minRoute;
				}
			}
			
			for(int i = 0; i < nextHub.getNeighbours().size(); i++) {
				Route testRoute = new Route(minRoute);
				testRoute.addLeg(nextHub.getNeighbours().get(i), day);
				if(testRoute.isValid()) {
					allRoutes.add(testRoute);
				}
			}
		}
		return result;
		
		
	}
	public int getMinRouteKmIndex(ArrayList<Route> allRoutes) {
		double num = Integer.MAX_VALUE;
		int index = 0;
		
		for(int i = 0; i < allRoutes.size(); i++) {
			if(num > allRoutes.get(i).totalDistance()) {
				num = allRoutes.get(i).totalDistance();
				index = i;
			}
			
		}
		return index;
		
	}

}
