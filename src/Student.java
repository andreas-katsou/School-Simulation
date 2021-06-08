import java.util.ArrayList;

//Student subclass, graduates a student from a subject returns the Certificates ArrayList and checks whether the student has a certificate or not.
public class Student extends Person
{
    private ArrayList<Integer> certificates;
    private boolean enrolled;

    //Student constructor
    public Student(String name, char gender, int age)
    {
        super(name, gender, age);
        certificates = new ArrayList<>();
        enrolled = false;
    }

    //Adds a subject ID to the certificates ArrayList
    public void graduate(Subject subject)
    {
        certificates.add(subject.getID());
    }

    //Returns the certificates ArrayList
    public ArrayList<Integer> getCertificates()
    {
        return certificates;
    }

    //If the certificates ArrayList contains the subject ID it returns true, else it returns false
    public boolean hasCertificate(Subject subject)
    {
        return certificates.contains(subject.getID());
    }

    //Sets the boolean enrolled to true
	public void enroll()
    {
        enrolled = true;
    }

    //Returns if the Student is Enrolled
	public boolean isEnrolled()
    {
        return enrolled;
    }

}



