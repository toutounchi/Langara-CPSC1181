import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 ** Program Name: Mystery number Game
 ** Author: Hossein Toutounchi
 ** Date: Jan 8th, 2023
 ** Course: CPSC 1180
 ** Compiler: JDK 20.0.2
 */

public class MysteryGame
{
    /**
     * In this program we prompt the user to thunk of a number and keep it to Themselves, Then we ask them to do some operations
     *On the number based on their selection of difficulty. THen the program will again ask them to enter the number that they calculated
     * and finally the program will return the number they have guessed. Also there is a method to catch empty and character strings.
     */

    public static void main(String[] args)
    {
        //Main method will prompt the user to choose difficulty, enter their number and repeat their process if they want.
        int option;
        String[] levels = {"Yes", "No"};
        String[] responses = {"Easy", "Medium", "Hard"};
        do {
            JOptionPane.showMessageDialog(null, "Please Think of a number and keep it to yourself", "Mystery Game Number", JOptionPane.INFORMATION_MESSAGE);
            int diff = JOptionPane.showOptionDialog(null, "Please choose the level of difficulty",
                    "Mystery number Game", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null, responses, 0);

            //Method corresponding to their selection will be called and the value that they entered will be passed through
            if (diff == 0)
                easyMode();
            if (diff == 1)
                mediumMode();
            if (diff == 2)
                hardMode();
            option = JOptionPane.showOptionDialog(null, "Would you like to continue?", "Continue?",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, levels,
                    levels[1]);
        }while (!(option==1));

    }

    public static void easyMode() {

        //Easy mode will only take 100 our of the calculated number and make sure the entry is correct and return the value.
        int guess;
        String response;
        JOptionPane.showMessageDialog(null, "Please add 100 to your number");
        response = JOptionPane.showInputDialog("What is the result?");
        if (testString(response))
        {
            guess = (Integer.parseInt(response)) - 100;
            JOptionPane.showMessageDialog(null, "Your number was " + guess);
        }
    }

    public static void mediumMode()
    {
        //Medium mode subtract 100 and divide the number by 20 and return the value also check for the proper entry.
        int guess;
        String response;
        JOptionPane.showMessageDialog(null, "Please multiply your number by 20");
        JOptionPane.showMessageDialog(null, "Please add 100 to your number");
        response = JOptionPane.showInputDialog("What is the result?");
        if (testString(response))
        {
            guess = ((Integer.parseInt(response)) - 100) / 20;
            JOptionPane.showMessageDialog(null, "Your number was " + guess);
        }
    }

    public static void hardMode()
    {
        //Hard mode adds 20 then subtract 100 and finally divide by 100 to get the return value also checks for valid entry
        int guess;
        String response;
        JOptionPane.showMessageDialog(null, "Please multiply your number by 100");
        JOptionPane.showMessageDialog(null, "Please add 100 to your number");
        JOptionPane.showMessageDialog(null, "Final step: subtract 20");
        response = JOptionPane.showInputDialog("What is the result?");
        if (testString(response))
        {
            guess = ((((Integer.parseInt(response))+20) - 100)/100);
            JOptionPane.showMessageDialog(null, "Your number was " + guess);
        }

    }

    public static boolean testString (String respond)
    {
        //Validation method first checks to see if the entry is empty or not then it will find each character and checks for digit entry.
        //Returns true in case of correct entry and returns false with the message that the entry is wrong.
        boolean flag = true;
        if (respond == null)
        {
            JOptionPane.showMessageDialog(null, "The operation was canceled");
            return false;
        }

        if (respond.length() == 0)
            flag = false;
        for (int i = 0 ; i<respond.length(); i++)
        {
            char position = respond.charAt(i);
            if (position < '0' || position > '9')
                flag = false;
            if (respond.charAt(0) == '-' && i == 0)
                flag = true;
        }
        if (!flag)
            JOptionPane.showMessageDialog(null, "Your entry must be a number");
        return flag;
    }
}