public class InternationalStudent extends Student{

    private String countryOrigin;
    private double eachCredit = 6377.91;
    public InternationalStudent(String name, String address, String countryOrigin)
    {
        super(name, address);
        this.countryOrigin = countryOrigin;
    }

    /**
     * @return The country origin of International student.
     */
    public String getCountryOrigin() {
        return countryOrigin;
    }

    /**
     * Will calculate the tuition fee for international students.
     * @return the value for total tuition fees based on the credits.
     */
    @Override
    public double getTuitionFees()
    {
        return  super.getNumCredits() * eachCredit;
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
        Student other = (InternationalStudent) otherObject;
        return getStudentNum() == other.getStudentNum();
    }

    /**
     * Overrides the toString method of Object class.
     * @return string with all the attributes of student.
     */
    @Override
    public String toString()
    {
        return super.toString() + "[Country of origin: " + countryOrigin + "]";
    }
}
