public class Fraction
{
    /**
     ** Program Name: Fraction and Fraction test class
     ** Author: Hossein Toutounchi
     ** Date: Jan 12th, 2023
     ** Course: CPSC 1181
     ** Compiler: JDK 20.0.2
     */
    int numerator;
    int denominator;
    public Fraction ()
    {
        numerator = 0;
        denominator =1;
    }

    public Fraction (int numerator, int denominator)
    {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator()
    {
        return numerator;
    }

    public int getDenominator()
    {
        return denominator;
    }

    public Fraction add (Fraction f)
    {
        int num = numerator * f.getDenominator() + denominator * f.getNumerator();
        int denom = denominator * f.getDenominator();
        return new Fraction(num, denom);
    }

    public Fraction multiply (Fraction f)
    {
        int num = numerator * f.getNumerator();
        int denom = denominator*f.getDenominator();
        return new Fraction(num, denom);
    }

    public Fraction subtract (Fraction f)
    {
        int num = numerator * f.getDenominator() - denominator * f.numerator;
        int denom = denominator * f.getDenominator();
        return new Fraction(num, denom);
    }

    public String toString ()
    {
        String result = (numerator + "/" + denominator);
        return result;
    }

}
