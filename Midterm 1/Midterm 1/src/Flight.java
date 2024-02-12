import java.util.ArrayList;
/** 
The Flight class has a flight number, keeps a list of the names of the passengers that are on the Flight,
and keeps track of the number of passengers that are adults. 
Every passenger is either an adult or a child.
A passenger who is not an adult is a child.

Once a passenger name has been added to the  Flight,  it is no longer  possible to determine whether 
the passenger name corresponded to an adult or not. 
It is  not  possible to retrieve the passenger names that are adults but it is possible to ask how many  
passengers are adults. 

Each passenger has a single name (a single word). 
The name of the passenger is stored in lower case letters.

It is possible to obtain the number of flights that have been created.

*/

public class Flight
{
    private int adults;
    private int kids;
    private int totalPassengers;
    public static int flightsCreated = 0;
    public ArrayList<String> plane;
    private String flightNumber;
    /**
        * Constructs a Flight that has a flightNum and no passengers.
        * @param flightNum the flight number which could include the airline code. 
        * Precondition: flightNum is well formed  and is not null.
        */
    public Flight(String flightNum)
    {
        flightNumber = flightNum;
        adults = 0;
        kids = 0;
        totalPassengers = 0;
        plane = new ArrayList<String>();
        flightsCreated++;
    }
   
    /**
         * Adds a passenger name to the  Flight only if the name
         * is not in the Flight passenger list already.
         * When deciding whether a name is a passenger already or
         * not, the  name  is matched against the passenger list names
         * regardless of (upper/lower) case and regardless of leading and trailing blanks. 
         *  
         * If the  name is added to the  Flight , and if  isAdult  is true ,
         * the number of adults goes up by one. 
         *  isAdult  is not used in determining whether to add a  name  or not.
         *  
         * @param name a single word  with possible leading and trailing blanks. Precondition: name is not null.
         * @param isAdult determines if the name is an adult
         * @return true if the name was added to the list of passengers,  false otherwise
         */
    public boolean add(String name, boolean isAdult)
    {
        name = name.trim();
      for (String passenger: plane)
      {
          if (passenger.toLowerCase().equals(name.toLowerCase()))
          {
              return false;
          }
      }
      plane.add(name.toLowerCase());
      if (isAdult)
          adults++;
      else
          kids++;
      totalPassengers++;
      return true;
   }
   
     /**
         * @return a string in the format 
         * 
         *    flightNumber  {passengers: n  adults: m  
         *          name 0  ,
         *           name 1 ,
         *           name 2   ... 
         *           name n-1  ]}
         *  
         * where  n >= 0   and  m >= 0 
        */
    public String toString()
    {
        String planeInformation = "";
        for (String passenger : plane)
        {
            planeInformation += "\t\t" + passenger + plane.indexOf(passenger) + "  ,\n";
        }
        return "\n\t"+ flightNumber +"{passengers: " + totalPassengers + "  adults: " + adults + " number of kids : " + kids+ "\n" + planeInformation;
    }
   
    /**
         * @return number of passengers that are children i.e. that are not adults
         */
    public int getNumOfChildren()
    {
        return kids;
    }
   
    /**
         * @param other the specified other Flight
         * @return true if there are more adults in this Flight than in the other Flight, false otherwise.
         */
    public boolean hasMoreAdults(Flight other)
    {
        if (other == null)
            return true;
        if(adults> other.adults)
            return true;
        else
            return false;
    }
   
    /**
          * @return the number of  Flight instances created, 
          * i.e. the number of objects of the class Flight that have been constructed.
         */   
    public static int getNumberOfFlights()
    {
        return flightsCreated;
    }
   
    /**
         * Returns the total  number of passengers that are in the  Flight  
         * added to the total  number  of passengers in the  other Flight ; 
         * however, if a passenger name is in both flights, then it is only counted once. 
         * Ignores whether the passengers are adults or not.
         *  
         * For example, if the string returned by a flight's  toString  method is 
         *  
         * CZ330 {passengers:5 adults:3 [ming, bobby, jimmy, annie, manpreet]}
         *  
         * and the string returned by the another flight's toString method is
         *  
         * LH492 {passengers:4 adults:3 [gretzky, mcdavid, bobby, lafleur]}
         *  
         * then  totalNoDups  returns 8  because "bobby" is a duplicate since it is in both flights.
         * @param other the specified other Flight
         * @return the cardinality of the union of the passengers in the Flight and  in the other Flight
         */
     public int totalNoDups(Flight other)  
     {
         if (other == null)
             return totalPassengers;
         int totalOnBoard;
         totalOnBoard = totalPassengers + other.totalPassengers;
         for (String passenger :plane)
         {
             for(String passengerOther : other.plane)
             {
                 if (passenger.equals(passengerOther))
                 {
                     totalOnBoard--;
                 }
             }
         }
         return totalOnBoard;
     }
}
