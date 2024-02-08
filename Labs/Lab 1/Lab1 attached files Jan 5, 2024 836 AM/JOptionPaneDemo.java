
import javax.swing.JOptionPane;

public class JOptionPaneDemo
{
   public static void main(String[] args)
   {
	String[] levels = {"Yes", "No"};
      
       int option = JOptionPane.showOptionDialog( null, "Would you like to continue?", "Continue?",
                                                                       JOptionPane.DEFAULT_OPTION,
                                                                       JOptionPane.QUESTION_MESSAGE,
                                                                        null,
                                                                       levels,
								      levels[1]); // use No as the default
      

	  if(option == 0)
		  System.out.println("Continue....");
	  else
		  System.out.println("Terminate the program....");
   }
   
  
}

