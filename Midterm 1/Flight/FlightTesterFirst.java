public class FlightTesterFirst
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
      
         System.out.println(flightAC.toString());
         //Expected output: AC8050 {passengers:5 adults:2 [annie, bobby, jimmy, manpreet, ming]}
         //Note that the order of the names is not important
      
         System.out.println("There are " + flightAC.getNumOfChildren() + " children in the flight");
         // expected output:  There are 3 children in the flight
       
      }
}
