import java.util.ArrayList;

/**
 * class College is used to construct and create the College object.
 */
public class College
{
    private final ArrayList<Student> students;

    /**
     * Constructor will create the College object which is one ArrayList.
     */
    public College()
    {
        students = new ArrayList<>();
    }

    /**
     * Void addStudent method will add each student object to the College object.
     * @param student has to be student created and passed through the method.
     */
    public void addStudent(Student student)
    {
        students.add(student);
    }

    /**
     * This function will find the student based on their student number.
     * @param sNum has to be in int format.
     * @return the student which has the corresponding student number.
     */
    public Student searchStudentByNumber(int sNum)
    {
        for(Student student:students)
        {
        if(student.getStudentNum() == sNum)
            return student;
        }
        return null;
    }

    /**
     * This method will delete the student from College based on their student number.
     * @param temp has to be student.
     */
    public void deleteStudent(Student temp)
    {
        students.remove(temp);
    }

    /**
     * It will calculate the highest GPA.
     * @return the student with highest GPA.
     */
    public Student highestGPA ()
    {
        double highest = 0;
        Student highestStudent = null;
        for (Student student:students)
        {
            double GPA = student.calculateGPA();
            if(GPA > highest)
            {
                highest = GPA;
                highestStudent = student;
            }
        }
        return highestStudent;
    }
    public String toString ()
    {
        String temp = "";
        for (Student student: students)
            temp += student.toString() + "\n\n";
        return temp;
    }
}
