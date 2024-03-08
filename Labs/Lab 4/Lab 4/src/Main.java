/**
 ** Program Name: Mathematical Calculations
 ** Author: Hossein Toutounchi
 ** Date: Jan 26th, 2023
 ** Course: CPSC 1180
 ** Compiler: JDK 20.0.2
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        String operator = "";
        System.out.println("Welcome to Mathematical Calculator ");

        do {
            try {
                Scanner input = new Scanner(System.in);
                int firstNum, secNum;
                System.out.println("Please enter your mathematical expression");
                firstNum = input.nextInt();
                operator = input.next();
                secNum = input.nextInt();

                switch (operator) {
                    case "+":
                        System.out.println(firstNum + " + " + secNum + " = " + (firstNum + secNum));
                        break;

                    case "-":
                        System.out.println(firstNum + " - " + secNum + " = " + (firstNum - secNum));
                        break;

                    case "*":
                        System.out.println(firstNum + " * " + secNum + " = " + (firstNum * secNum));
                        break;

                    case "/":
                        System.out.println(firstNum + " / " + secNum + " = " + (firstNum / secNum));
                        break;

                    case "%":
                        System.out.println(firstNum + " % " + secNum + " = " + (firstNum % secNum));
                        break;

                    case "q":
                        break;

                    default:
                        throw new IllegalAccessException("Invalid Operator");
                }
            } catch (IllegalAccessException exception) {
                System.out.println("the operator is none of (+, -, *, /, or %)");
            } catch (InputMismatchException exception) {
                System.out.println("The Input must be an integer number");
            } catch (ArithmeticException exception) {
                System.out.println("you can not divide a number by 0, in the / and % operations");
            }

        }while(!operator.equalsIgnoreCase("q"));
    }
}
