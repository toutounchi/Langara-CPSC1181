/**
 ** Program Name: College Tester
 ** Author: Hossein Toutounchi
 ** Date: Jan 19th, 2023
 ** Course: CPSC 1180
 ** Compiler: JDK 20.0.2
 */
import java.util.Scanner;

/**
 * This Class is built to test different functions of the College class.
 */
public class CollegeTest {
    public static void main(String[] args) {
        //First we create the purse object to use it in our College class.
        int sNum, resume;
        boolean flagEntry, flagContinue;
        int entry = 0;
        String sName, sAddress, selection, continueOrNot, stringSnum;
        Student found, created;
        Scanner input = new Scanner(System.in);
        System.out.println("TEST FOR COLLEGE CLASS");
        College langaraCollege = new College();

        do {
            do {
                //Then we prompt the user to select between the various selection which helps the user
                //test different functions in College clas.
                System.out.println("Please enter one of the following from the menu");
                System.out.println("\n1- Adding a new student to the college.\n2- Looking up an existing student based on the student number.");
                System.out.println("3- Deleting a student from the college using the student number.");
                System.out.println("4- Adding the grade point value and credit units earned for a course taken by an existing student.");
                System.out.println("5- Retrieving the login id for an existing student (using the student number to look up the student).");
                System.out.println("6- Finding a student with the college’s highest GPA.");
                selection = input.nextLine();
                flagEntry = verifyInput(selection);
                if (flagEntry)
                    entry = Integer.parseInt(selection);
            } while (!flagEntry);

            switch (entry) {
                case 1:

                    //Fist option will help the user add individual student objects to the college class.
                    System.out.println("**Adding a new student to the college**");
                    System.out.println("\nplease enter the first name and the last name of the student with one space in the middle");
                    sName = input.nextLine();
                    if (verifyName(sName))
                    {
                        System.out.println("\nplease enter your address (Free format)");
                        sAddress = input.nextLine();
                        created = new Student(sName, sAddress);
                        langaraCollege.addStudent(created);
                        System.out.println("Student was recorded\n" + created + "\n\n");
                    }
                    break;

                case 2:

                    //Second option will help the user to find the existing user based on their student number.
                    System.out.println("**Looking up an existing student based on the student number**");
                    System.out.println("\nPlease enter the student number in integer format");
                    stringSnum = input.nextLine();
                    if (verifySnum(stringSnum))
                    {
                        stringSnum = stringSnum.trim();
                        sNum = Integer.parseInt(stringSnum);
                        found = langaraCollege.searchStudentByNumber(sNum);
                        if (found == null)
                            System.out.println("Student ID entered does not exist");
                        else
                            System.out.println(found.getName() + " address on record : " + found.getAddress());
                    }
                    break;

                case 3:

                    //Third option will find the user based on the student ID and delete it.
                    System.out.println("**Deleting a student from the college using the student number.**");
                    System.out.println("\nPlease enter the student number in integer format");
                    stringSnum = input.nextLine();
                    if (verifySnum(stringSnum)) {
                        stringSnum = stringSnum.trim();
                        sNum = Integer.parseInt(stringSnum);
                        found = langaraCollege.searchStudentByNumber(sNum);
                        if (found == null)
                            System.out.println("Student ID entered does not exist");
                        else {
                            langaraCollege.deleteStudent(found);
                            System.out.println("student was removed successfully");
                        }
                    }
                    break;

                case 4:

                    //Fourth option will add grade point and credits based on the student ID entered.
                    System.out.println("**Adding the grade point value and credit units earned for a course taken by an existing student**");
                    System.out.println("\nPlease enter the student number in integer format");
                    stringSnum = input.nextLine();
                    if (verifySnum(stringSnum)) {
                        stringSnum = stringSnum.trim();
                        sNum = Integer.parseInt(stringSnum);
                        found = langaraCollege.searchStudentByNumber(sNum);
                        if (found == null)
                            System.out.println("Student ID entered does not exist");
                        else {
                            System.out.println("Please enter the grade point you want to add:");
                            double gPoint = input.nextDouble();
                            input.nextLine();
                            System.out.println("Please enter the co responding credits for the grade point entered:");
                            int numCredits = input.nextInt();
                            input.nextLine();
                            found.addCourse(gPoint, numCredits);
                            System.out.println("student information was added successfully");
                        }
                    }
                    break;

                case 5:

                    //Fifth option will return the Login ID corresponding to the student ID entered.
                    System.out.println("**Retrieving the login id for an existing student (using the student number to look up the student)**");
                    System.out.println("\nPlease enter the student number in integer format");
                    stringSnum = input.nextLine();
                    if (verifySnum(stringSnum)) {
                        stringSnum = stringSnum.trim();
                        sNum = Integer.parseInt(stringSnum);
                        found = langaraCollege.searchStudentByNumber(sNum);
                        if (found == null)
                            System.out.println("Student ID entered does not exist");
                        else
                            System.out.println("Login ID for the student entered is: " + found.getStudentLogin());
                    }
                        break;


                case 6:

                    //last option returns the student with the highest GPA.
                    System.out.println("**Finding a student with the college’s highest GPA**");
                    if (langaraCollege.highestGPA() == null)
                        System.out.println("No records are available in this college");
                    else
                        System.out.println("Student with highest grade is: " + langaraCollege.highestGPA().getName());
                    break;

            }
            //Program will continue until the user enters 1 and terminate if the entry is 2.
            do {
                System.out.println("\nWould you like to continue the program?");
                System.out.println("1- yes\t\t 2- no");
                resume = 1;
                continueOrNot = input.nextLine();
                flagContinue = verifyInputContinue(continueOrNot);

                if (flagContinue)
                    resume = Integer.parseInt(continueOrNot);
            } while (!flagContinue);
        } while (resume == 1);
        System.out.println("Information recorded on the college was: \n" + langaraCollege);
    }
            public static boolean verifyInput (String str)
            {
                //This method will verify the menu bar entry to be between 0 and 9.
                if (str.length() == 1 && str.charAt(0) > '0' && str.charAt(0) < '7')
                    return true;
                System.out.println("Your entry must be only one number between 1 and 6\n");
                return false;
            }

            public static boolean verifyInputContinue (String str)
            {
                //This method will verify the continue entry to be either 0 or 1
                if (str.length() == 1 && str.charAt(0) > '0' && str.charAt(0) < '3')
                    return true;
                System.out.println("Your entry must be only one number 1 for continue and 2 to cancel\n");
                return false;
            }

            public static boolean verifyName (String str)
            {
                //This method will check the student name to be in proper format: "FirstName LastName" Only one space
                str = str.trim();
                return str.split(" ").length == 2;
            }

            public static boolean verifySnum (String str)
            {
                //This method will verify the student number and the entry from the student to make sure the student number entered in properly formatted.
                int temp;
                str = str.trim();
                if (str.length() != 8) {
                    System.out.println("Wrong Entry");
                    System.out.println("Your student number must be 8 digits");
                    return false;
                }
                for (int i = 0; i < 8; i++) {
                    if (str.charAt(i) > '9' || str.charAt(i) < '0') {
                        System.out.println("Your student number must be 8 digits");
                        System.out.println("Your entry must be all digits between 0 and 9");
                        return false;
                    }
                }
                temp = Integer.parseInt(str);
                if (temp < 10000001)
                {
                    System.out.println("your student number cant be smaller than 10000001");
                    return false;
                }
                return true;
            }
    }