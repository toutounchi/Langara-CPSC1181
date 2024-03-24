/**
 * A coin with a monetary value, taken from textbook
 * by C. Horstmann, chapter 8
 */
public class Coin
{
      private int value;
      private String name;

      /**
           Constructs a coin and gives it the name with lower case 
           letters with the passed monetary value.
          @param aName the name of the coin
         @param aValue the monetary value of the coin.
      */
      public Coin(String aName, int aValue) 
      { 
            value = aValue; 
            name = aName.toLowerCase();
      }

      /**
           Retrieves the coin value.
          @return the value
       */
      public int getValue() 
      {
           return value;
      }
 
      /**
           Retrieves the coin name.
          @return the name
       */
      public String getName() 
      {
            return name;
      }
      
      /**
           Makes a string of the form (value,name)
          @return the string 
       */
      public String toString()
      {
            return "(" + name + "," + value + ")";
      }
      
      /**
           Determines if two Coins are equal.
           @return true if the monetary value in pennies and the names are the same.
       */
      public boolean equals(Object otherObject)
      {
             if (otherObject == null) 
                  return false;
             if (getClass() != otherObject.getClass()) 
                 return false;
            Coin other = (Coin) otherObject;
                 return value == other.value && name.equalsIgnoreCase(other.name);
      }
   
      
}
