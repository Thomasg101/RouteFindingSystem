public class testDriver2 {

	public static void main(String[] args) {
		SystemManager sm = new SystemManager();

		Location b1 = new BikeDeliveryLocation("BikeDepot1");
		Location b2 = new BikeDeliveryLocation("BikeDepot2");
		Location b3 = new BikeDeliveryLocation("BikeDepot3");
		Location b4 = new BikeDeliveryLocation("BikeDepot4");
		Location b5 = new BikeDeliveryLocation("BikeDepot5");
		Location b6 = new BikeDeliveryLocation("BikeDepot6");
		Location b7 = new BikeDeliveryLocation("BikeDepot7");
		Location b8 = new BikeDeliveryLocation("BikeDepot8");

		Location t1 = new TruckDepot("TRUCK001");
		Location t2 = new TruckDepot("TRUCK002");
		Location t3 = new TruckDepot("TRUCK003");
		Location t4 = new TruckDepot("TRUCK004");
		Location t5 = new TruckDepot("TRUCK005");
		Location t6 = new TruckDepot("TRUCK006");
		Location t7 = new TruckDepot("TRUCK007");
		Location t8 = new TruckDepot("TRUCK008");
		Location t9 = new TruckDepot("TRUCK009");
		Location t10 = new TruckDepot("TRUCK010");
		Location t11 = new TruckDepot("TRUCK011");

		Location a = new Airport("AAA");
		Location b = new Airport("BBB");
		Location c = new Airport("CCC");
		Location d = new Airport("DDD");
		Location e = new Airport("EEE");
		Location f = new Airport("FFF");
		Location x = new Airport("XXX");

		sm.addLocation(b1);
		sm.addLocation(b2);
		sm.addLocation(b3);
		sm.addLocation(b4);
		sm.addLocation(b5);
		sm.addLocation(b6);
		sm.addLocation(b7);
		sm.addLocation(b8);
		sm.addLocation(t1);
		sm.addLocation(t2);
		sm.addLocation(t3);
		sm.addLocation(t4);
		sm.addLocation(t5);
		sm.addLocation(t6);
		sm.addLocation(t7);
		sm.addLocation(t8);
		sm.addLocation(t9);
		sm.addLocation(t10);
		sm.addLocation(t11);
		sm.addLocation(a);
		sm.addLocation(b);
		sm.addLocation(c);
		sm.addLocation(d);
		sm.addLocation(e);
		sm.addLocation(f);
		sm.addLocation(x);

		try {
			sm.addLeg(new Flight(a, b, 200, "MTWRFSU"));
			sm.addLeg(new Flight(b, c, 200, "MTWRFSU"));
			sm.addLeg(new Flight(c, d, 200, "MTWRFSU"));
			sm.addLeg(new Flight(d, e, 200, "MTWRFSU"));
			sm.addLeg(new Flight(e, f, 200, "MTWRFSU"));
			sm.addLeg(new Flight(d, x, 900, "MTWRFSU"));
			
			sm.addLeg(new TruckLeg(x, t8, 10, "MTW"));
			sm.addLeg(new TruckLeg(x, t10, 10, "MTWRFSU"));
			sm.addLeg(new TruckLeg(x, t11, 10, "MTWR"));
			sm.addLeg(new TruckLeg(x, t9, 10, "MT"));		
			sm.addLeg(new TruckLeg(t10, t11, 6, "MTWRFSU"));
			sm.addLeg(new TruckLeg(t11, t8, 14, "MTWRFSU"));
			sm.addLeg(new TruckLeg(t8, t9, 11, "MTWRFSU"));
			sm.addLeg(new TruckLeg(f, t7, 11, "MTWRU"));
			sm.addLeg(new TruckLeg(a, t5, 6, "MTRFSU"));
			sm.addLeg(new TruckLeg(t6, d, 12, "MTWRSU"));
			sm.addLeg(new TruckLeg(f, t1, 80, "MWRFSU"));
			sm.addLeg(new TruckLeg(a, t4, 100, "MTWRFS"));
			sm.addLeg(new TruckLeg(t1, t2, 10, "MTWRFSU"));
			sm.addLeg(new TruckLeg(t2, t4, 19, "MTWRFSU"));
			sm.addLeg(new TruckLeg(t2, t3, 10, "MTWRFSU"));
			
			sm.addLeg(new BikeLeg(t3, b2, 5, "MTWRFSU"));
			sm.addLeg(new BikeLeg(b2, b3, 5, "MTWRFSU"));
			sm.addLeg(new BikeLeg(b3, b4, 5, "MTWRFSU"));
			sm.addLeg(new BikeLeg(b5, t4, 5, "MTWRFSU"));
			sm.addLeg(new BikeLeg(t4, b4, 5, "SU"));
			sm.addLeg(new BikeLeg(b1, t5, 5, "MTWRFSU"));
			sm.addLeg(new BikeLeg(b1, t6, 9, "MTSU"));
			sm.addLeg(new BikeLeg(t10, b7, 9, "MTSU"));
			sm.addLeg(new BikeLeg(t9, b8, 7, "MTWRFSU"));
			
		} catch (Exception E) {
			System.out.println("Exception Thrown. Leg cannot be added.");
		}

		// AAA to b4
		Route rA1 = sm.findCheapestRoute(sm.findLocation("AAA"), sm.findLocation("BikeDepot4"), "M");
		System.out.println("\n\nA1:\n" + rA1);

		Route rA2 = sm.findCheapestRoute(sm.findLocation("AAA"), sm.findLocation("BikeDepot4"), "U");
		System.out.println("\n\nA2:\n" + rA2);
		
		Route rA3 = sm.findCheapestRoute(sm.findLocation("AAA"), sm.findLocation("BikeDepot4"), "S");
		System.out.println("\n\nA3:\n" + rA3);

		// B1 to B4
		Route rB1 = sm.findShortestKmRoute(sm.findLocation("BikeDepot1"), sm.findLocation("BikeDepot4"), "M");
		System.out.println("\n\nB1:\n" + rB1);

		Route rB2 = sm.findShortestKmRoute(sm.findLocation("BikeDepot1"), sm.findLocation("BikeDepot4"), "S");
		System.out.println("\n\nB2:\n" + rB2);
		
		Route rB3 = sm.findShortestKmRoute(sm.findLocation("BikeDepot1"), sm.findLocation("BikeDepot4"), "T");
		System.out.println("\n\nB3:\n" + rB3);

		// BBB to t5
		Route rC = sm.findMinStepsRoute(sm.findLocation("BBB"), sm.findLocation("TruckDepot5"), "M");
		System.out.println("\n\nC:\n" + rC);

		// T6 to b8
		Route rD1 = sm.findMinStepsRoute(sm.findLocation("TRUCK006"), sm.findLocation("BikeDepot8"), "M");
		System.out.println("\n\nD1:\n" + rD1);

		Route rD2 = sm.findMinStepsRoute(sm.findLocation("TRUCK006"), sm.findLocation("BikeDepot8"), "W");
		System.out.println("\n\nD2:\n" + rD2);

		Route rD3 = sm.findMinStepsRoute(sm.findLocation("TRUCK006"), sm.findLocation("BikeDepot8"), "R");
		System.out.println("\n\nD3:\n" + rD3);
		
		Route rD4 = sm.findMinStepsRoute(sm.findLocation("TRUCK006"), sm.findLocation("BikeDepot8"), "S");
		System.out.println("\n\nD4:\n" + rD4);
		
		Route rD5 = sm.findMinStepsRoute(sm.findLocation("TRUCK006"), sm.findLocation("BikeDepot8"), "F");
		System.out.println("\n\nD5:\n" + rD5);
	}
	
	/* EXPECTED OUTPUT
	 * 
		A1:
		>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		Steps: 11 Distance: 1115.0 Cost: 303.0
		 Route Start:
		 Origin: AAA Destination: BBB
		 Origin: BBB Destination: CCC
		 Origin: CCC Destination: DDD
		 Origin: DDD Destination: EEE
		 Origin: EEE Destination: FFF
		 Origin: FFF Destination: TRUCK001
		 Origin: TRUCK001 Destination: TRUCK002
		 Origin: TRUCK002 Destination: TRUCK003
		 Origin: TRUCK003 Destination: BikeDepot2
		 Origin: BikeDepot2 Destination: BikeDepot3
		 Origin: BikeDepot3 Destination: BikeDepot4
		 Route End. 
		>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		
		
		A2:
		>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		Steps: 9 Distance: 1114.0 Cost: 298.21999999999997
		 Route Start:
		 Origin: AAA Destination: BBB
		 Origin: BBB Destination: CCC
		 Origin: CCC Destination: DDD
		 Origin: DDD Destination: EEE
		 Origin: EEE Destination: FFF
		 Origin: FFF Destination: TRUCK001
		 Origin: TRUCK001 Destination: TRUCK002
		 Origin: TRUCK002 Destination: TRUCK004
		 Origin: TRUCK004 Destination: BikeDepot4
		 Route End. 
		>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		
		
		A3:
		>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		Steps: 2 Distance: 105.0 Cost: 62.99999999999999
		 Route Start:
		 Origin: AAA Destination: TRUCK004
		 Origin: TRUCK004 Destination: BikeDepot4
		 Route End. 
		>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		
		
		B1:
		>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		Steps: 10 Distance: 536.0 Cost: 180.96000000000004
		 Route Start:
		 Origin: BikeDepot1 Destination: TRUCK006
		 Origin: TRUCK006 Destination: DDD
		 Origin: DDD Destination: EEE
		 Origin: EEE Destination: FFF
		 Origin: FFF Destination: TRUCK001
		 Origin: TRUCK001 Destination: TRUCK002
		 Origin: TRUCK002 Destination: TRUCK003
		 Origin: TRUCK003 Destination: BikeDepot2
		 Origin: BikeDepot2 Destination: BikeDepot3
		 Origin: BikeDepot3 Destination: BikeDepot4
		 Route End. 
		>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		
		
		B2:
		>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		Steps: 8 Distance: 535.0 Cost: 176.18000000000004
		 Route Start:
		 Origin: BikeDepot1 Destination: TRUCK006
		 Origin: TRUCK006 Destination: DDD
		 Origin: DDD Destination: EEE
		 Origin: EEE Destination: FFF
		 Origin: FFF Destination: TRUCK001
		 Origin: TRUCK001 Destination: TRUCK002
		 Origin: TRUCK002 Destination: TRUCK004
		 Origin: TRUCK004 Destination: BikeDepot4
		 Route End. 
		>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		
		
		B3:
		null
		
		
		C:
		null
		
		
		D1:
		>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		Steps: 4 Distance: 929.0 Cost: 226.76000000000002
		 Route Start:
		 Origin: TRUCK006 Destination: DDD
		 Origin: DDD Destination: XXX
		 Origin: XXX Destination: TRUCK009
		 Origin: TRUCK009 Destination: BikeDepot8
		 Route End. 
		>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		
		
		D2:
		>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		Steps: 5 Distance: 940.0 Cost: 233.14000000000001
		 Route Start:
		 Origin: TRUCK006 Destination: DDD
		 Origin: DDD Destination: XXX
		 Origin: XXX Destination: TRUCK008
		 Origin: TRUCK008 Destination: TRUCK009
		 Origin: TRUCK009 Destination: BikeDepot8
		 Route End. 
		>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		
		
		D3:
		>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		Steps: 6 Distance: 954.0 Cost: 241.26000000000002
		 Route Start:
		 Origin: TRUCK006 Destination: DDD
		 Origin: DDD Destination: XXX
		 Origin: XXX Destination: TRUCK011
		 Origin: TRUCK011 Destination: TRUCK008
		 Origin: TRUCK008 Destination: TRUCK009
		 Origin: TRUCK009 Destination: BikeDepot8
		 Route End. 
		>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		
		
		D4:
		>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		Steps: 7 Distance: 960.0 Cost: 244.74
		 Route Start:
		 Origin: TRUCK006 Destination: DDD
		 Origin: DDD Destination: XXX
		 Origin: XXX Destination: TRUCK010
		 Origin: TRUCK010 Destination: TRUCK011
		 Origin: TRUCK011 Destination: TRUCK008
		 Origin: TRUCK008 Destination: TRUCK009
		 Origin: TRUCK009 Destination: BikeDepot8
		 Route End. 
		>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
		
		
		D5:
		null

	 */

}