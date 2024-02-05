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
    private final double eachCredit = 107.62;
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
     * @return the number of credits corresponding to the student.
     */
    public int getNumCredits()
    {
        return numCredits;
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
     * Will calculate the tuition fee for regular students.
     * @return the value for total tuition fees based on the credits.
     */
    public double getTuitionFees ()
    {
        return numCredits * eachCredit;
    }


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
        if (temp.split(" ").length != 2)
            throw new CollegeExceptions("The name you entered must be consist of 2 words");
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

    /**
     * Overrides the object equals object and checks if the students are the same.
     * @param otherObject is an object passed into the method
     * @return boolean indicating whether the students are the same or not.
     */
    @Override
    public boolean equals (Object otherObject)
    {
        if (otherObject == null)
            return false;
        if (getClass() != otherObject.getClass())
            return false;
        Student other = (Student) otherObject;
        return studentNum == other.getStudentNum();
    }

    /**
     * Overrides the toString method of Object class.
     * @return string with all the attributes of student.
     */
    @Override
    public String toString()
    {
        return "[" + getClass().getName() + "]" + "\n[" + "Name: " + getName() + ",\taddress: " + getAddress() + ",\tStudent number: " + getStudentNum()
                + ",\nLogin ID: " + getStudentLogin() + ",\tThe GPA for the student is: " + calculateGPA() + ",\tThe total tuition fee is: " + getTuitionFees() +"]";
    }
}
