

public class Test {
	
	public static void main (String [] args) {
	    SystemManager sm = new SystemManager();
	    Location b1 = new BikeDeliveryLocation("BikeDepot1");
	    Location b2 = new BikeDeliveryLocation("BikeDepot2");
	    Location b3 = new BikeDeliveryLocation("BikeDepot3");

	    Location t1 = new TruckDepot("TRUCK001");
	    Location t2 = new TruckDepot("TRUCK002");
	    Location t3 = new TruckDepot("TRUCK003");
	    Location t4 = new TruckDepot("TRUCK004");
	    
	    Location a1 = new Airport("AAA");
	    Location a2 = new Airport("BBB");
	 

	    sm.addLocation(b1);
	    sm.addLocation(b2);
	    sm.addLocation(b3);
	    sm.addLocation(t1);
	    sm.addLocation(t2);
	    sm.addLocation(t3);
	    sm.addLocation(t4);
	    sm.addLocation(a1);
	    sm.addLocation(a2);
	   

	    sm.addLeg(new BikeLeg(b1, a1, 1, "MTWRFSU"));
	    sm.addLeg(new BikeLeg(t1, b2, 8, "MTWRFSU"));
	    sm.addLeg(new BikeLeg(b2, t2, 2, "MTWRFSU"));
	    sm.addLeg(new BikeLeg(t4, b3, 2, "MTWRFSU"));
	    
	    sm.addLeg(new TruckLeg(t1, t2, 11, "MTWRFSU"));
	    sm.addLeg(new TruckLeg(t2, a2, 36, "MTWRFSU"));
	    sm.addLeg(new TruckLeg(a2, t4, 42, "MTWRFSU"));
	    sm.addLeg(new TruckLeg(t2, t4, 120, "MTWRFSU")); 
	    sm.addLeg(new TruckLeg(t3, a1, 19, "MTWRFSU"));
	    
	    sm.addLeg(new Flight(a1, a2, 221, "MTWRFSU"));
	   
	    
	    // TruckDepot t1 to TruckDepot t4
	    System.out.println("------- t1 to t4 ----------");
	    Route rA = sm.findCheapestRoute(sm.findLocation("TRUCK001"), sm.findLocation("TRUCK004"), "M");
	    System.out.println("\n\nCheapest Route: ");
	    System.out.println(rA);

	    Route rB = sm.findShortestKmRoute(sm.findLocation("TRUCK001"), sm.findLocation("TRUCK004"), "M");
	    System.out.println("\n\nShortest Route:\n " + rB);

	    System.out.println("");

	    // BikeDepot 1 to BikeDepot 3
	    System.out.println("------- b1 to b3 ----------");
	    Route r1 = sm.findCheapestRoute(sm.findLocation("BikeDepot1"), sm.findLocation("BikeDepot3"),"M");
	    System.out.println("Cheapest: " + r1);
	    Route r2 = sm.findShortestKmRoute(sm.findLocation("BikeDepot1"), sm.findLocation("BikeDepot3"), "M");
	    System.out.println("\n\nShortest Route:\n " + r2);

	   

	    // TruckDepot 4 to BikeDepot 1  NOT POSSIBLE
	    System.out.println("------- 4 to 5 ----------");
	    r1 = sm.findCheapestRoute(sm.findLocation("TRUCK004"), sm.findLocation("BikeDepot1"),"M");
	    System.out.println("\n\nCheapest: ");
	    System.out.println(r1);
	    r2 = sm.findShortestKmRoute(sm.findLocation("TRUCK004"), sm.findLocation("BikeDepot1"), "M");
	    System.out.println("\n\nShortest Route:\n " + r2); 

	  } // main
	
//	public static void main (String args[]) {
//	
//	SystemManager sm = new SystemManager();
//    Location loc1 = new Airport("YYJ");
//    Location loc2 = new TruckDepot("PURVIC01");
//    Location loc3 = new BikeDeliveryLocation("Empress Hotel, Victoria BC");
//    Location loc4 = new Airport("YVR");
//    Location loc5 = new BikeDeliveryLocation("Ogden Point");
//    Location loc6 = new Airport("INH");
//    Location loc7 = new TruckDepot("PURLAURE");
//    sm.addLocation(loc1);
//    sm.addLocation(loc2);
//    sm.addLocation(loc3);
//    sm.addLocation(loc4);
//    sm.addLocation(loc5);
//    sm.addLocation(loc6);
//    sm.addLocation(loc7);
//
//    sm.addLeg(new TruckLeg(loc1, loc3, 25, "MW"));
//    sm.addLeg(new BikeLeg(loc2, loc3, 10, "MTWRFSU"));
//    sm.addLeg(new BikeLeg(loc3, loc5, 10, "MFS"));
//    sm.addLeg(new TruckLeg(loc6, loc7, 1, "M"));
//    sm.addLeg(new Flight(loc1,loc6, 30, "MTWRFSU"));
//    sm.addLeg(new BikeLeg(loc7, loc5, 2, "MFS"));
//    sm.addLeg(new Flight(loc7, loc5, 2, "MFS"));  // error
//    sm.addLeg(new BikeLeg(loc7, loc3, 2, "Z"));  // error
//    sm.addLeg(new BikeLeg(loc7, loc3, -1, "T")); // error
//
//    Route r1 = sm.findCheapestRoute(sm.findLocation("YYJ"), sm.findLocation("Ogden Point"), "M");
//    System.out.println(r1);
//    Route r2 = sm.findShortestKmRoute(sm.findLocation("YYJ"), sm.findLocation("Empress Hotel, Victoria BC"), "M");
//    System.out.println(r2);
//    Route r3 = sm.findMinStepsRoute(sm.findLocation("YYJ"), sm.findLocation("Empress Hotel, Victoria BC"), "M");
//    System.out.println(r3);

	}


