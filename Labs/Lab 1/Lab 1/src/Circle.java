import javax.swing.JOptionPane;

/**
 ** Program Name: area and circumference calculator
 ** Author: Hossein Toutounchi
 ** Date: Nov 17th, 2023
 ** Course: CPSC 1180
 ** Compiler: JDK 20.0.2
 */

public class Circle {
    public static void main(String[] args)
    {
        double radius;
        String area, circum;
        int option;
        do {

            String radiuS = JOptionPane.showInputDialog("Please enter your radius");
            radius = Double.parseDouble(radiuS);
            area = String.format("%.2f", areacalc(radius));
            circum = String.format("%.2f", circumcalc(radius));
            JOptionPane.showMessageDialog(null, "The area is: " + area + "\nThe circumference of the circle is " + circum);


            String[] levels = {"Yes", "No"};

            option = JOptionPane.showOptionDialog(null, "Would you like to continue?", "Continue?",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    levels,
                    levels[1]); // use No as the default

        }while(!(option==1));
    }

    public static double areacalc(double rad)
    {
        double area;
        area = Math.PI * Math.pow(rad,2);

        return area;
    }

    public static double circumcalc(double rad)
    {
        double circum;
        circum = 2 * Math.PI * rad;
        return circum;
    }
}