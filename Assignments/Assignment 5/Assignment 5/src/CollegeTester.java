import java.util.InputMismatchException;
import java.util.Scanner;

/**
 ** Program Name: College Tester
 ** Author: Hossein Toutounchi
 ** Date: Jan 19th, 2023
 ** Course: CPSC 1180
 ** Compiler: JDK 20.0.2
 */
public class CollegeTester {
    public static void main(String[] args) {

        //Creating college langara to store various students inside.
        College langara = new College();
        Scanner input = new Scanner(System.in);
        int repeat = 1, menu ;
        do {
            try {
                menu();
                menu = input.nextInt();
                input.nextLine();

                //Switch navigates the user through various menu functions.
                switch (menu) {
                    case 1:
                        addNewStudent(langara, input);
                        break;
                    case 2:
                        studentSearch(langara, input);
                        break;
                    case 3:
                        deleteStudent(langara, input);
                        break;
                    case 4:
                        addGradePoint(langara, input);
                        break;
                    case 5:
                        retrieveLogin(langara, input);
                        break;
                    case 6:
                        System.out.println("**Finding a student with the college’s highest GPA**");
                        System.out.println("The information for student with highest grade is as follows");
                        System.out.println("Name: " + langara.highestGPA().getName() + "\tGPA: " + langara.highestGPA().calculateGPA());
                        break;
                    case 7:
                        seeTotalTuition(langara,input);
                    case 8:
                        studentType(langara,input);
                        break;
                    default:

                        //Default class to find out if any illegal argument was passed through the switch.
                        throw new IllegalArgumentException();
                }
            }

            //catching exceptions related to college, students, and scanner class.
            catch (IllegalArgumentException exception)
            {
                System.out.println("\nInvalid entry for the menu");
            }
            catch (InputMismatchException exception)
            {
                input.nextLine();
                System.out.println("\nInvalid entry make sure  you enter the proper digit entry");
            }
            catch (CollegeExceptions exception)
            {
                System.out.println(exception.getMessage());
            }
            catch (NullPointerException exception)
            {
                System.out.println("Field can not be empty, you must type your entry");
            }
                System.out.println("\n\nWould you like to repeat the program?");
                System.out.println("[1] YES \t\t[2] NO");
                try {
                    repeat = input.nextInt();
                    input.nextLine();
                }
                catch (InputMismatchException exception)
                {
                    input.nextLine();
                    System.out.println("\nInvalid entry make sure  you enter the proper digit entry");
                }

        //Repeating the program while digit 1 is entered.
        }while (repeat == 1) ;
        System.out.println("Langara college student are:" + langara);
        System.out.println("End of program");

    }
    public static void menu()
    {
        // we prompt the user to select between the various selection which helps the user to test different functions of the classes.
        System.out.println("*** Welcome to Langara College ***");
        System.out.println("Please enter one of the following from the menu");
        System.out.println("\n[1] Adding a new student to the college.\n[2] Looking up an existing student based on the student number.");
        System.out.println("[3] Deleting a student from the college using the student number.");
        System.out.println("[4] Adding the grade point value and credit units earned for a course taken by an existing student.");
        System.out.println("[5] Retrieving the login id for an existing student (using the student number to look up the student).");
        System.out.println("[6] Finding a student with the college’s highest GPA.");
        System.out.println("[7] See the total outstanding tuition amount for the student.");
        System.out.println("[8] To find out the student type");
    }

    public static void addNewStudent (College langara, Scanner input)
    {
        //Helps the user to create a new student.
        int selection;
        String name , address, countryOrigin, researchTopic, supervisor;
        Student temp;
        System.out.println("**Adding a new student to the college**");
        System.out.println("\nplease enter the first name and the last name of the student with one space in the middle");
        name = input.nextLine();
        System.out.println("\nplease enter your address (Free format)");
        address = input.nextLine();
        System.out.println("What kind of student would you like to create?");
        System.out.println("[1] Regular student\n[2] International Student\n[3] Graduate Student");
        selection = input.nextInt();
        input.nextLine();
        switch (selection)
        {
            //New regular student only need name and address as parameter.
            case 1:
                System.out.println("** Regular Student **");
                temp = new Student(name,address);
                langara.addStudent(temp);
                System.out.println(temp);
                break;

            //International students also need country of origin in their profile.
            case 2:
                System.out.println("** International Student **");
                System.out.println("Please enter the country of origin of the international student");
                countryOrigin = input.nextLine();
                temp = new InternationalStudent(name ,address ,countryOrigin);
                langara.addStudent(temp);
                System.out.println(temp);
                break;

            //Graduate students need a research topic and supervisor name in their profile.
            case 3:
                System.out.println("** Graduate Student **");
                System.out.println("Please enter the research topic");
                researchTopic = input.nextLine();
                System.out.println("What is the name of the supervisor?");
                supervisor = input.nextLine();
                temp = new GraduateStudent(name,address,researchTopic,supervisor);
                langara.addStudent(temp);
                System.out.println(temp);
                break;
            default:
                //Default class to find out if any illegal argument was passed through the switch.
                throw new IllegalArgumentException();
        }
        System.out.println("\nStudent Added successfully");
    }
    public static void studentSearch(College langara, Scanner input)
    {
        //Searching for specific student and printing the information on the student.
        Student found;
        System.out.println("**Looking up an existing student based on the student number**");
        found = searchForStudent(langara, input);
        System.out.println(found);
    }
    public static void deleteStudent (College langra, Scanner input)
    {
        //deleting a student from the college.
        Student found;
        System.out.println("**Deleting a student from the college using the student number.**");
        found = searchForStudent(langra, input);
        langra.deleteStudent(found);
    }

    public static void addGradePoint (College langara, Scanner input)
    {
        //Adding the grade point and the corresponding credits for each student.
        double gradePoint;
        int totalCredits;
        Student found;
        System.out.println("**Adding the grade point value and credit units earned for a course taken by an existing student**");
        found = searchForStudent(langara, input);
        System.out.println("How many credits would you like to add?");
        totalCredits = input.nextInt();
        System.out.println("What is the corresponding grade point for those credits?");
        gradePoint = input.nextDouble();
        found.addCourse(gradePoint, totalCredits);
    }

    public static void retrieveLogin (College langara, Scanner input)
    {
        //Getting the login information on student.
        int option;
        Student found;
        System.out.println("**Retrieving the login id for an existing student (using the student number to look up the student)**");
        found = searchForStudent(langara, input);
        System.out.println("The student login ID is: " + found.getStudentLogin());
        System.out.println("\nwould you like to see the complete information about this student?" );
        System.out.println("[1] YES\t[2] NO");
        option = input.nextInt();
        input.nextLine();
        if (option == 1)
            System.out.println(found);
    }
    public static void seeTotalTuition(College langara, Scanner input)
    {
        //The total tuition fees associated with each student depending on their type.
        Student found;
        System.out.println("**total outstanding tuition amount for the student**");
        found = searchForStudent(langara, input);
        found.getTuitionFees();
    }
    public static void studentType (College langara, Scanner input)
    {
        //Finding out a student type based on student ID.
        Student found;
        found = searchForStudent(langara, input);
        System.out.println("Student entered is: " + found.getClass().getName());
    }
    public static Student searchForStudent (College langara,Scanner input)
    {
        //Searching for students inside the college, returning the corresponding student.
        int studentNumber;
        System.out.println("\nPlease enter the student number in integer format");
        studentNumber = input.nextInt();
        input.nextLine();
        if (langara.searchStudentByNumber(studentNumber) == null)
            throw new CollegeExceptions ("The Student you are looking for does not exist!");
        return langara.searchStudentByNumber(studentNumber);
    }

}
