import java.util.Scanner;
public class FractionTest {
    /**
     ** Program Name: Fraction and Fraction test class
     ** Author: Hossein Toutounchi
     ** Date: Jan 12th, 2023
     ** Course: CPSC 1181
     ** Compiler: JDK 20.0.2
     */
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int num1, num2, den1, den2;
        String response;

        do {
            System.out.println("Testing the Fraction class");
            do {
                System.out.println("Please enter the numerator of your first fraction:");
                num1 = input.nextInt();
            } while(!testDigit(num1));

            do {
                System.out.println("Please enter the denominator of your first fraction:");
                den1 = input.nextInt();
            } while(!testDigit(den1));

            do {
                System.out.println("Please enter the numerator of your second fraction:");
                num2 = input.nextInt();
            } while(!testDigit(num2));

            do {
                System.out.println("Please enter the denominator of your second fraction:");
                den2 = input.nextInt();
            } while(!testDigit(den2));
                
            Fraction f1 = new Fraction(num1,den1);
            Fraction f2 = new Fraction(num2,den2);
            System.out.println("Stored value for first Fraction numerator is " + f1.numerator + " and denominator is " + f1.denominator);
            System.out.println("Stored value for second Fraction numerator is " + f2.numerator + " and denominator is " + f2.denominator);

            Fraction f3 = f1.add(f2);
            System.out.println("After adding Stored value for numerator is " + f3.numerator + " and denominator is " + f3.denominator);

            Fraction f4 = f1.multiply(f2);
            System.out.println(" After multiplication Stored value for numerator is " + f4.numerator + " and denominator is " + f4.denominator);

            Fraction f5 = f1.subtract(f2);
            System.out.println(" After subtraction Stored value for numerator is " + f5.numerator + " and denominator is " + f5.denominator);

            System.out.println("**Testing toString method**");
            System.out.println("First Fraction is " + f1.toString());
            System.out.println("Second Fraction is " + f2.toString());
            System.out.println("\n\nWould you like to continue the program");
            input.nextLine();
            response = input.nextLine();
        } while(response.equalsIgnoreCase("yes"));
    }

    public static boolean testDigit(int num)
    {
        if (num<0) {
            System.out.println("Your number can not be negative");
            return false;
        }
        return true;
    }
}