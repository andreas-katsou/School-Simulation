import java.util.ArrayList;

/*Course class, returns the status of the course, advances the course by one day, enrolls students,
assigns the instructor to a course and cancels the course.*/
public class Course
{
    private Subject subject;
    private int daysUntilStarts;
    private int daysToRun;
    private ArrayList<Student> enrolledStudents;
    private Instructor instructor;
    private boolean isFinished;
    private boolean cancelled;

    //Course constructor
    public Course(Subject subject, int daysUntilStarts)
    {
		this.subject = subject;
        this.daysUntilStarts = daysUntilStarts;
        daysToRun = subject.getDuration();
        enrolledStudents = new ArrayList<>();
        cancelled = false;
        instructor = null;
    }

    //Returns the subject
    public Subject getSubject()
    {
        return subject;
    }

    //Checks the status of the course
    public int getStatus()
    {	
		//If the daysUntilStarts is positive and returns the negative number of days until the course starts
		if (daysUntilStarts > 0)
        {
            return -daysUntilStarts;
        }
        
		//Else if the daysToRun is positive and returns the number of days left until the course ends
		else if (daysToRun > 0)
        {
            return daysToRun;
        }

		//Else the course has ended, returns 0
		else
        {
            return 0;
        }
    }

    //Advances one day of the course, issues certificates and cancels the course
    public void aDayPasses()
    {
        //If the days until the course starts is positive advances one day of the course by subtracting 1 from the daysUntilStarts
		if (daysUntilStarts > 0)
        {
            daysUntilStarts = daysUntilStarts - 1;
        }
		
		//Else advances one day of the course by subtracting 1 from the daysToRun
        else 
		{
            daysToRun = daysToRun - 1;
        }

		//If it is the last day of the course, it issues certificates and releases the instructor
        if(daysToRun==0)
		{
			for(Student student: enrolledStudents)
			{
				student.graduate(getSubject());
			}

			instructor.unassignCourse();
            isFinished=true;
		}
		
		//If at the day the course starts there is no instructor or there are no students, it cancels the course
		if(daysUntilStarts==0 && ((instructor==null) || (enrolledStudents.size()==0)))
		{
			cancelled=true;
		}
    }

    /*Enrolls students if the size is less than 3 or the course hasn't started yet
    or the student isn't already enrolled, returns a boolean whether the enrollment was successful*/
	public boolean enrolStudent(Student student)
    {
		boolean successful;

        if(enrolledStudents.size()>=3 || daysUntilStarts<=0 || student.isEnrolled())
        {
            successful=false;
        }

        else
		{
			enrolledStudents.add(student);
			student.enroll();
			successful=true;
        }

        return successful;
    }

	//Returns the number of the enrolled students
    public int getSize()
    {
      return enrolledStudents.size();
    }

	//Returns an Array of the enrolled students by converting the ArrayList to an Array
	public Student[] getStudents()
	{
        return enrolledStudents.toArray(new Student[0]);
	}

	//Sets an instructor to the course if can teach the subject and returns true, else returns false
	public boolean setInstructor(Instructor instructor)
    {	
		if(instructor.canTeach(getSubject()))
		{
			this.instructor=instructor;
			return true;
		}
      
		else
		{
			return false;
		}
	}

	//If the course has an instructor returns true, else returns false
	public boolean hasInstructor()
    {
        return instructor != null;
    }

	//If the course is cancelled releases the instructor and the students and returns true, else returns false
    public boolean isCancelled()
    {
        if(cancelled)
        {
            instructor=null;
            enrolledStudents.clear();
            return true;
        }

        else
        {
            return false;
        }
	}

	//If the days left in the course are less than or equal to 0 returns true, else return false
	public boolean isFinished()
	{
        return isFinished;
    }

    //Returns the Subject ID
    public int getSubjectID()
    {
        return subject.getID();
    }

    //Returns the Subject Specialism
    public int getSubjectSpecialism()
    {
        return subject.getSpecialism();
    }

    //Return the Subject Description
    public String getSubjectDescription()
    {
        return subject.getDescription();
    }

    //Adds every student from the enrolledStudents ArrayList to the studentName ArrayList, and returns the studentName ArrayList
    public ArrayList<String> getStudentName()
    {
        ArrayList<String> studentName =  new ArrayList<>();
        for (Student student : enrolledStudents) 
        {
            studentName.add(student.getName());
        }

        return studentName;
    }

}





