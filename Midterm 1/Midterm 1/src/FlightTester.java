public class FlightTester
{
     public static void main( String[] args )
     {
          Flight flightAC = new Flight("AC8050");  

          // add names some with blanks before, some with blanks after, some with upper case letters
          String person = "Manpreet";
          if (!flightAC.add(person,  false)) 
              System.out.println("failed to add properly");
          if (!flightAC.add(" MING ", false)) 
              System.out.println("failed to add properly");
          if (!flightAC.add("anniE",  true))
              System.out.println("failed to add properly");
          if (!flightAC.add("bOBBy  ", true)) 
              System.out.println("failed to add properly");
          if (!flightAC.add("        jiMMy", false)) 
              System.out.println("failed to add properly");
      
         System.out.println(flightAC);
         //Expected output: AC8050 {passengers:5 adults:2 [manpreet ,ming ,annie ,bobby ,jimmy]}
      
         System.out.println("There are " + flightAC.getNumOfChildren() + " children in the flight");
         // Expected output:  There are 3 children in the flight
      
         System.out.println();
      
         // create a flight without passengers
         Flight flightLH = new Flight("LH492");
      
         System.out.println(flightLH);
         //expected output: LH492 {Passengers: 0 adults: 0 [ ] }
      
         System.out.println("number of children = " + flightLH.getNumOfChildren() + " -- expecting 0");
      
         System.out.println();
      
         if (!flightLH.add(" gretzky ", true)) 
              System.out.println("failed to add properly");
         if (!flightLH.add(" McDavid", false)) 
              System.out.println("failed to add properly");
         if (!flightLH.add("Bobby",  true)) 
             System.out.println("failed to add properly");
         if (!flightLH.add("Lafleur ", true)) 
             System.out.println("failed to add properly");
      
         System.out.println(flightLH);
         //Expected output: LH492 {Passengers: 4 adults: 3 [gretzky ,mcdavid ,bobby ,lafleur ] }
      
         System.out.println("number of children = " + flightLH.getNumOfChildren() + " -- expecting 1");
      
         System.out.println();
            
	 System.out.print("LH492.totalNoDups(AC8050) = " + flightLH.totalNoDups(flightAC));
         System.out.println(" -- expecting 8");
      
         System.out.print("AC8050.totalNoDups(AC8050) = " + flightAC.totalNoDups(flightAC));
         System.out.println(" -- expecting 5");
      
         System.out.print("AC8050.totalNoDups(null) = " + flightAC.totalNoDups(null));
         System.out.println(" -- expecting 5");
      
         System.out.println();
      
         Flight flightBA = new Flight("BA84");
         if (!flightBA.add("Gretzky ", true)) 
             System.out.println("failed to add properly");
         if (!flightBA.add(" McDavid", false)) 
             System.out.println("failed to add properly");
         if (!flightBA.add("Crosby",  false)) 
             System.out.println("failed to add properly");
         if (!flightBA.add("Lafleur ", true)) 
            System.out.println("failed to add properly");
      
         System.out.println(flightBA);
         //Expected output: BA84 {Passengers: 4 adults: 2 [gretzky ,mcdavid ,crosby ,lafleur ] }
      
         System.out.println();
      
         System.out.print("BA84.totalNoDups(LH492) = " + flightBA.totalNoDups(flightLH));
         System.out.println(" -- expecting 5");
      
         System.out.print("BA84.totalNoDups(null) = " + flightBA.totalNoDups(null));
         System.out.println(" -- expecting 4");
         System.out.println();
      
         System.out.print("instances of Flights = " + Flight.getNumberOfFlights());
         System.out.println(" -- expecting 3");
      
         System.out.println();

         if (flightLH.hasMoreAdults(flightAC))
               System.out.println("LH492 has more adults than AC8050 -- as expected");
         else
             System.out.println("---> ERROR: LH492 reports not having more adults than AC8050\n");

         if (flightBA.hasMoreAdults(flightAC))
              System.out.println("---> ERROR: BA84 and AC8050 do have the same number of adults\n");
         else
             System.out.println("BA84 does not have more adults than AC8050 because they are equal -- as expected");
      
         if (flightAC.hasMoreAdults(null))
             System.out.println("AC8050 has more adults whereas null doesn't -- as expected");
         else
            System.out.println("---> ERROR: AC8050 reports not having more adults than null\n"); 

         System.out.println();      
     }
}
