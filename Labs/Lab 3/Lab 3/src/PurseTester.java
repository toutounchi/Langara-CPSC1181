/**
  * This class tests the Purse class from the Programming Exercise P7.5
  * Big Java, 4th Edition, Cay Horstmann
  *
*/
public class PurseTester
{
	   /**
	   * Creates a few purses and test the various methods of the class.
	   * All the parameters are 'hardwired' here ... there is no  input from a user.
	   * @param args not used
	   */
	   public static void main(String[] args)
	   {
		      Purse a = new Purse();
			  Coin nickel = new Coin("Dime",10);
		      a.addCoin(new Coin("quarter", 25));
		      a.addCoin(new Coin("Dime", 10));
		      a.addCoin(new Coin("Nickel", 5));
		      a.addCoin(new Coin("Dime", 10));     
		      System.out.println("a = " + a);   
		      
		      Purse b = new Purse();    
		      b.addCoin(new Coin("nickel", 5));
		      b.addCoin(new Coin("dime", 10));   
		      b.addCoin(new Coin("dime", 10));      
		      b.addCoin(new Coin("quarter", 25));
		      System.out.println("b = " + b);
		      
		      // at this point we expect a and be to be equal
		      testHasSameCoins(a, b, "a","b", true);
		  
		      Purse c = new Purse();
		      c.addCoin(new Coin("quarter", 25));
		      c.addCoin(new Coin("penny", 1));
		      c.addCoin(new Coin("Nickel", 5));
		      c.addCoin(new Coin("dime", 10));    
		      System.out.println("c = " + c);      
		      
		      Purse d = new Purse();    
		      d.addCoin(new Coin("NICKEL", 5));
		      d.addCoin(new Coin("DIME", 10));   
		      d.addCoin(new Coin("DIME", 10));         
		      d.addCoin(new Coin("QUARTER", 25));       
		      d.addCoin(new Coin("quarter", 25));
		      System.out.println("d = " + d);
		      
		      // c and d are different so we expect as output false
		      testHasSameCoins(c, d, "c", "d", false);
		   
		      
		      // d and d are the same so we expect as output true
		      testHasSameCoins(d, d, "d", "d", true);
		      
		 
		      Purse e = new Purse();
		      System.out.println("e = " + e);
		      
		      // the empty purse and any other purse with coins are different, so expecting false
		      testHasSameCoins(e, d, "e", "d", false);
		      
		      Purse f = null;
		      System.out.println("f = " + f + "\n");

		      // the empty purse and the null reference are not the same
		      System.out.print("Do e and f have the same coins? ");
		      System.out.println(e.hasSameCoins(f) + " and " + "Expected: false \n");
		   
		      // testing the remove coin function in purse.
		      System.out.println("Testing to remove coin Expected: true");
			  System.out.println("Result : " + a.removeCoin(nickel));

		      // testing the highest coin function of the purse.
		      System.out.println("\n\nTesting the highest coin function of the purse Expected: 25");
			  System.out.println("Result : " + a.highestCoin());

			  // testing the count function in purse.
		      System.out.println("\n\nTesting the count function in purse Expected: 1 ");
		      System.out.println("Result : " + a.countCoin(nickel));
	   }
	   
	   /**
	   * Take two purses and their names and report whether they are the same.
	   * Use the method hasSameCoins when comparing.
	   * @param x purse against which y is compared, x != null
	   * @param y purse against which x is compared, y != null
	   * @param xName name that will be printed for the first parameter
	   * @param yName name that will be printed for the second parameter
	   * @param expectedValue what the result of the comparison should be
	   */
	   public static void testHasSameCoins(Purse x, Purse y, String xName, String yName, boolean expectedValue)
	   {
		      System.out.println();
		      System.out.print("Do " + xName + " and " + yName + " have the same coins? ");
		      System.out.println(x.hasSameCoins(y) + " and " + y.hasSameCoins(x));
		      System.out.println("Expected: " + expectedValue + " and " + expectedValue + "\n");
	   }
}
