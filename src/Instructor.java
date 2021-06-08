//Instructor subclass of Person assigns/unassigns and gets the assign course and subject.
public abstract class Instructor extends Person
{
    private Course assignedCourse;

    //Instructor Constructor
	public Instructor(String name, char gender, int age)
    {
        super(name, gender, age);
    }
	
	//Assigns a course to the Instructor
    public void assignCourse(Course course)
    {
        assignedCourse = course;
    }

	//Unassigns a course from the Instructor
    public void unassignCourse()
    {
        assignedCourse = null;
    }

	//Returns the assigned course
    public Course getAssignedCourse()
    {
        return assignedCourse;
    }

    //If there isn't a assigned course returns a zero, else it returns the subject ID of the assigned course
    public int getAssignedSubject()
    {
        if(getAssignedCourse() == null)
        {
            return 0;
        }

        else
        {
            return assignedCourse.getSubjectID();
        }
    }

    //Declaring an abstract method canTeach
    public abstract boolean canTeach(Subject subject);

}
