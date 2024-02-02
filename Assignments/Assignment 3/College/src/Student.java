/**
 * class student is used to construct and create the student object.
 */
public class Student
{
    private String name;
    private String address;
    private String loginId;
    private int studentNum;
    private double gPoint;
    private int numCredits;

    private static int lastStudentNum = 10000001;
    /**
     * Student constructor creates and makes the student object.
     @param name should be in first name and last name format seperated by space.
     @param address is free format.
     */
    public Student (String name, String address)
    {
        this.name = verifyName(name);
        this.address = address.trim();
        studentNum = lastStudentNum;
        lastStudentNum++;
        loginId = loginID();
        gPoint = 0;
        numCredits = 0;
    }

    /**
     * @return the name stored for each student first name and last name.
     */
    public String getName ()
    {
        return name;
    }

    /**
    * @return the address stored for each student.
    */
    public String getAddress()
    {
        return address;
    }

     /**
     * @return the Student number stored for each student.
     */
    public int getStudentNum() {return studentNum;}

     /**
     * @return LoginID stored for each student.
     */
    public String getStudentLogin() {return loginId;}

    /**
     * This method is to add number of credits and grade points earned by student.
     * @param gPoint needs to be in double or int format.
     * @param numCredits has to be int format.
     */
    public void addCourse (double gPoint, int numCredits)
    {
        this.gPoint += (gPoint * numCredits);
        this.numCredits += numCredits;
    }

    /**
     * This method calculates the GPA of each student.
     * @return the value that represent the GPA of corresponding student
     */
    public double calculateGPA()
    {
        double gpa;
        gpa = gPoint/numCredits;
        return gpa;
    }

    /**
     * This method verify the name and remove any extra spaces in the middle or before and after.
     * @param tempName is the one passed through the constructor only 2 names.
     * @return first name and last name in proper format with one space in the middle.
     */
    public String verifyName(String tempName)
    {
        String temp = tempName.trim();
        String firstName = temp.substring(0,tempName.indexOf(" "));
        temp = temp.substring(temp.indexOf(" "));
        String lastName = temp.trim();
        temp = firstName + " " + lastName;
        return temp;

    }

    /**
     * This method will create the LoginID of each student from first name and last name and
     * also 2 digits from the student number and create the unique login ID for each student.
     * @return the login ID for constructor to create student.
     */
    private String loginID()
    {
        String temp = name.toLowerCase();
        String login;
        String last3 = "";
        String twoDigits = String.format("%02d",(studentNum%100000));

        for(int i = temp.indexOf(" ") + 1; i< temp.length() && i<= temp.indexOf(" ") +3 ; i++ )
            last3 += temp.charAt(i);

        login = temp.charAt(0) + last3 + twoDigits;
        return login;
    }

    public String toString()
    {
        return "Name: " + getName() + "\taddress: " + getAddress() + "\nStudent number: " + getStudentNum()
                + " Login ID: " + getStudentLogin() + " The GPA for the student is: " + calculateGPA();
    }

}
