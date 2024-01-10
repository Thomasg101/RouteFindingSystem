public class TestDriver {

	public static void main(String[] args) {
		SystemManager sm = new SystemManager();
		
		Location b1 = new BikeDeliveryLocation("BikeDepot1");
	    Location b2 = new BikeDeliveryLocation("BikeDepot2");
	    Location b3 = new BikeDeliveryLocation("BikeDepot3");
	    Location b4 = new BikeDeliveryLocation("BikeDepot4");

	    Location t1 = new TruckDepot("TRUCK001");
	    Location t2 = new TruckDepot("TRUCK002");
	    Location t3 = new TruckDepot("TRUCK003");
	    Location t4 = new TruckDepot("TRUCK004");
	    Location t5 = new TruckDepot("TRUCK005");
	    Location t6 = new TruckDepot("TRUCK006");
	    Location t7 = new TruckDepot("TRUCK007");
	    
	    Location a1 = new Airport("AAA");
	    Location a2 = new Airport("BBB");
	    
	    sm.addLocation(b1);
	    sm.addLocation(b2);
	    sm.addLocation(b3);
	    sm.addLocation(b4);
	    sm.addLocation(t1);
	    sm.addLocation(t2);
	    sm.addLocation(t3);
	    sm.addLocation(t4);
	    sm.addLocation(t5);
	    sm.addLocation(t6);
	    sm.addLocation(t7);
	    sm.addLocation(a1);
	    sm.addLocation(a2);
	    
	    sm.addLeg(new BikeLeg(t2, b1, 3, "MTWRFSU"));
	    sm.addLeg(new BikeLeg(b1, t3, 3, "MTWRFSU"));
	    sm.addLeg(new BikeLeg(t4, b2, 7, "MTWRFSU"));
	    sm.addLeg(new BikeLeg(t5, b3, 17, "MTWRFSU"));
	    sm.addLeg(new BikeLeg(b3, b4, 10, "MTWRFSU"));
	    sm.addLeg(new BikeLeg(b2, t7, 80, "MTWRU"));
	    sm.addLeg(new BikeLeg(t6, b4, 18, "MTWRFSU"));
	    
	    sm.addLeg(new TruckLeg(t1, t2, 15, "MTWRFSU"));
	    sm.addLeg(new TruckLeg(t1, t4, 112, "MTWRFSU"));
	    sm.addLeg(new TruckLeg(t2, a1, 8, "MTWRFSU"));
	    sm.addLeg(new TruckLeg(t2, t3, 7, "MTWRFSU"));
	    sm.addLeg(new TruckLeg(t3, a1, 2, "MTWRFSU"));
	    sm.addLeg(new TruckLeg(t3, a2, 231, "MTWRFSU"));
	    sm.addLeg(new TruckLeg(t1, a1, 20, "WRFSU"));
	    sm.addLeg(new TruckLeg(t4, a2, 80, "TWRSU"));
	    sm.addLeg(new TruckLeg(t7, a2, 11, "MTWRFSU"));
	    sm.addLeg(new TruckLeg(a2, t5, 3, "MTWRFSU"));
	    sm.addLeg(new TruckLeg(a2, t6, 40, "MTWRFSU"));
	    sm.addLeg(new TruckLeg(t7, t6, 30, "MTWRFSU"));

	    sm.addLeg(new Flight(a1, a2, 206, "MTWFSU"));

	    
	    // TruckDepot t1 to BikeDepot b4
	    Route rA = sm.findCheapestRoute(sm.findLocation("TRUCK001"), sm.findLocation("BikeDepot4"), "M");
	    System.out.println("\n\nA:\n" + rA);
	    
	    Route rB = sm.findCheapestRoute(sm.findLocation("TRUCK001"), sm.findLocation("BikeDepot4"), "W");
	    System.out.println("\n\nB:\n" + rB);
	    
	    // TruckDepot t1 to TruckDepot t6
	    Route rC = sm.findShortestKmRoute(sm.findLocation("TRUCK001"), sm.findLocation("TRUCK006"), "F");
	    System.out.println("\n\nC:\n" + rC);
	    
	    Route rD = sm.findShortestKmRoute(sm.findLocation("TRUCK001"), sm.findLocation("TRUCK006"), "T");
	    System.out.println("\n\nD:\n" + rD);
	    
	    Route rE = sm.findShortestKmRoute(sm.findLocation("TRUCK001"), sm.findLocation("TRUCK006"), "S");
	    System.out.println("\n\nE:\n" + rE);
	    
	    // BikeDepot b1 to BikeDepot b2
	    Route rF = sm.findMinStepsRoute(sm.findLocation("BikeDepot1"), sm.findLocation("BikeDepot2"), "W");
	    System.out.println("\n\nF:\n" + rF);
	    
	    // TruckDepot t4 to BikeDepot b4
	    Route rG = sm.findMinStepsRoute(sm.findLocation("TRUCK004"), sm.findLocation("BikeDepot4"), "W");
	    System.out.println("\n\nG:\n" + rG);
	    
	    Route rH = sm.findMinStepsRoute(sm.findLocation("TRUCK004"), sm.findLocation("BikeDepot4"), "F");
	    System.out.println("\n\nH:\n" + rH);
	    
	    // TruckDepot t4 to BikeDepot b3
	    Route rI = sm.findCheapestRoute(sm.findLocation("TRUCK004"), sm.findLocation("BikeDepot3"), "M");
	    System.out.println("\n\nI:\n" + rI);
	}

}

/** Routes
A:
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
Steps: 6 Distance: 259 Cost: 89.46
Route Start:
Origin: TRUCK001 Destination: TRUCK002
Origin: TRUCK002 Destination: AAA
Origin: AAA Destination: BBB
Origin: BBB Destination: TRUCK005
Origin: TRUCK005 Destination: BikeDepot3
Origin: BikeDepot3 Destination: BikeDepot4
Route End.
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

B:
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
Steps: 5 Distance: 256 Cost: 87.72
Route Start:
Origin: TRUCK001 Destination: AAA
Origin: AAA Destination: BBB
Origin: BBB Destination: TRUCK005
Origin: TRUCK005 Destination: BikeDepot3
Origin: BikeDepot3 Destination: BikeDepot4
Route End.
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

C:
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
Steps: 3 Distance: 266 Cost: 82.18
Route Start:
Origin: TRUCK001 Destination: AAA
Origin: AAA Destination: BBB
Origin: BBB Destination: TRUCK006
Route End.
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

D:
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
Steps: 4 Distance: 229 Cost: 169.36
Route Start:
Origin: TRUCK001 Destination: TRUCK004
Origin: TRUCK004 Destination: BikeDepot2
Origin: BikeDepot2 Destination: TRUCK007
Origin: TRUCK007 Destination: TRUCK006
Route End.
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

E:
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
Steps: 3 Distance: 232 Cost: 134.56
Route Start:
Origin: TRUCK001 Destination: TRUCK004
Origin: TRUCK004 Destination: BBB
Origin: BBB Destination: TRUCK006
Route End.
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

F:
Impossible

G:
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
Steps: 3 Distance: 138 Cost: 87.6
Route Start:
Origin: TRUCK004 Destination: BBB
Origin: BBB Destination: TRUCK006
Origin: TRUCK006 Destination: BikeDepot4
Route End.
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

H:
Impossible

I:
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
Steps: 5 Distance: 118 Cost: 112.12
Route Start:
Origin: TRUCK004 Destination: BikeDepot2
Origin: BikeDepot2 Destination: TRUCK007
Origin: TRUCK007 Destination: BBB
Origin: BBB Destination: TRUCK005
Origin: TRUCK005 Destination: BikeDepot3
Route End.
>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
 */