public class GraduateStudent extends Student{
    private String researchTopic;
    private String studentSupervisor;

    public GraduateStudent(String name, String address, String researchTopic, String studentSupervisor)
    {
        super(name, address);
        this.researchTopic = researchTopic;
        this.studentSupervisor = studentSupervisor;
    }

    /**
     * @return String research topic of the graduate student.
     */
    public String getResearchTopic() {
        return researchTopic;
    }

    /**
     * @return String student supervisor name of the graduate student.
     */
    public String getStudentSupervisor() {
        return studentSupervisor;
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
        Student other = (GraduateStudent) otherObject;
        return getStudentNum() == other.getStudentNum();
    }

    /**
     * Overrides the toString method of Object class.
     * @return string with all the attributes of graduate Student.
     */
    @Override
    public String toString()
    {
        return  super.toString() + " [research topic: " +  researchTopic + ",\tstudent supervisor: " + studentSupervisor + "]";
    }

}
