/**
 ** Program Name: Student Tester
 ** Author: Hossein Toutounchi
 ** Date: Jan 18th, 2023
 ** Course: CPSC 1180
 ** Compiler: JDK 20.0.2
 */
import java.util.Scanner;
/**
 * This class tests variety of functions from the student class.
 * Creates the object and test the getter and setter functions also
 * checks on different parameters of the object like name and address too.
 */
public class StudentTester {
    public static void main(String[] args)
    {
        Student num1;
        String name, address;
        double gPoints;
        int numCredits, option, repeat;
        Scanner input = new Scanner(System.in);

        //Prompting the user to enter name and address in proper format to create the student object.
        System.out.println("** TESTING THE STUDENT CLASS **");
        System.out.println("Please enter your first and last name: ");
        name = input.nextLine();
        System.out.println("Please enter your Address: ");
        address = input.nextLine();
        num1 = new Student(name,address);

        do{
            //Menu to choose different functions of the student class to test is provided.
            System.out.println("What function would you like to test?");
            System.out.println("1- getName and getAddress\n2- addCourse\t3- calculateGPA\n4- getStudentNum\t5- getLoginId");
            option = input.nextInt();

            switch (option)
            {
                //Switch directs different function of the student class based on the user entry.
                case 1:
                    System.out.println("Expected name = " + name + "\tExpected address = " + address);
                    System.out.println("Stored name = " + num1.getName() + "\tStored address = " + num1.getAddress());
                    break;
                case 2:
                    System.out.println("Please add credits you would like to add");
                    numCredits = input.nextInt();
                    System.out.println("What is the grade point for the credits?");
                    gPoints = input.nextDouble();
                    num1.addCourse(gPoints,numCredits);
                    break;
                case 3:
                    System.out.println("Your GPA is = " +num1.calculateGPA());
                    break;
                case 4:
                    System.out.println("Your student number is " + num1.getStudentNum());
                    break;
                case 5:
                    System.out.println("Your login ID is " + num1.getStudentLogin());
                    break;
            }
            //Program will continue as long as the user desire and type number 1.
            input.nextLine();
            System.out.println("Would you like to repeat the program?");
            System.out.println("1 =yes\t2 no");
            repeat = input.nextInt();
        }while(repeat==1);

    }

}