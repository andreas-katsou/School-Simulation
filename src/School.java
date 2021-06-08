import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;

/*School class, returns a String, adds, removes and returns students, subjects and courses, creates courses, assigns instructors, enrolls students,
 ask the user whether to save current state of the simulation and either saves it or not.*/
public class School
{
    private String schoolname;
    private ArrayList<Student> Students;
    private ArrayList<Subject> Subjects;
    private ArrayList<Course> Courses;
    private ArrayList<Instructor> Instructors;
    private boolean  isSave;
    private PrintStream newPrintStream;

    //School Constructor
	public School(String schoolname)
    {
        this.schoolname = schoolname;
        Students = new ArrayList<>();
        Subjects = new ArrayList<>();
        Courses = new ArrayList<>();
        Instructors = new ArrayList<>();
      
		try
        {
            newPrintStream = new PrintStream("Saved_state.txt");
        }

        catch (FileNotFoundException e)
        {
            System.out.println("File not Found");
        }

        //Adds the schoolname to the PrintStream
		newPrintStream.append("school:" +schoolname+ "\n");
    }

    //Adds a student to the Student ArrayList
	public void add(Student student)
    {
        Students.add(student);
    }

    //Removes a student from the Students ArrayList
	public void remove(Student student)
    {
        Students.remove(student);
    }

    //Returns the Students ArrayList
	public ArrayList<Student> getStudents()
    {
        return Students;
    }

    //Adds a subject to the Subjects ArrayList
	public void add(Subject subject) 
	{
        Subjects.add(subject);
    }

    //Removes a subject from the Subjects ArrayList
	public void remove(Subject subject) 
	{
        Subjects.remove(subject);
    }

   //Returns the Subjects ArrayList
	public ArrayList<Subject> getSubjects() 
	{
        return Subjects;
    }

    //Adds a course to the Courses ArrayList
	public void add(Course course)
    {
        Courses.add(course);
    }

    //Removes a course from the Courses ArrayList
	public void remove(Course course)
    {
        Courses.remove(course);
    }

    //Returns the Course ArrayList
	public ArrayList<Course> getCourses()
    {
        return Courses;
    }

    //Adds a instructor to Instructors ArrayList
	public void add(Instructor instructor)
    {
        Instructors.add(instructor);
    }

    //Removes a instructor from the Instructors ArrayList
	public void remove(Instructor instructor)
    {
        Instructors.remove(instructor);
    }

    //Returns the Instructors ArrayList
	public ArrayList<Instructor> getInstructors()
    {
        return Instructors;
    }

    //Returns a String 
	public String toString() 
	{
        String output = "";

        //Adds the school name to the String
        output += " School Name: " + schoolname;
        output += "" + System.lineSeparator();
        output += "" + System.lineSeparator();

        output += " Courses: ";
        //Adds info about each course to the String
        for (Course course : Courses) 
		{
            output += "" + System.lineSeparator();
            output += " -Subject ID: " + course.getSubjectID();
            output += " -Subject Specialism: " + course.getSubjectSpecialism();
            output += " -Description: " + course.getSubjectDescription();
            output += " -Status: " + course.getStatus();
            output += " -Number of enrolled students: " + course.getSize();
            output += " -Students: " + course.getStudentName();
            output += "" + System.lineSeparator();
        }

        output += "" + System.lineSeparator();
        output += " Students Enrolled this day: ";
        //Checks if the Students ArrayList is empty, else adds info about each student to the String and writes info to the PrintStream
        if (Students.isEmpty()) 
		{
            output += "" + System.lineSeparator();
            output += " No Students";
            output += "" + System.lineSeparator();
        }

        else 
		{
            for (Student student : Students) 
			{
                output += "" + System.lineSeparator();
                output += " -Student Name: " + student.getName();
                output += " -Student Age: " + student.getAge();
                output += " -Student Gender: " + student.getGender();
                output += " -Certificates In: " + student.getCertificates();
                output += "" + System.lineSeparator();

                newPrintStream.append("student:" + student.getName() + "," + student.getGender() + "," + student.getAge() + "\n");
			}
        }

        output += "" + System.lineSeparator();
        output += " Instructors: ";
        /*Checks if the Instructors ArrayList is empty, else adds info about each instructor to the String and
         writes info to the PrintStream depending if it  is Teacher, Demonstrator, OOTrainer or GUITrainer.*/
        if (Instructors.isEmpty()) 
		{
            output += "" + System.lineSeparator();
            output += " No Instructors";
            output += "" + System.lineSeparator();
        }

        else 
		{
            for (Instructor instructor : Instructors) 
			{
                if (instructor.getAssignedSubject() == 0) 
				{
                    output += "" + System.lineSeparator();
                    output += " -Instructor Name: " + instructor.getName();
                    output += " Cant teach any of the current subjects ";
                    output += "" + System.lineSeparator();
                }

                else 
				{
                    output += "" + System.lineSeparator();
                    output += " -Instructor Name: " + instructor.getName();
                    output += " -Instructor Gender: " + instructor.getGender();
                    output += " -Instructor Age: " + instructor.getAge();
                    output += " -Assigned Course ID: " + instructor.getAssignedSubject();
                    output += "" + System.lineSeparator();

                    if (instructor instanceof Teacher) 
					{
						if (instructor instanceof OOTrainer) 
						{
                            newPrintStream.append("OOTrainer:" + instructor.getName() + "," + instructor.getGender() + "," + instructor.getAge() + "\n");
                        }

                        else if (instructor instanceof GUITrainer) 
						{
                            newPrintStream.append("GUITrainer:" + instructor.getName() + "," + instructor.getGender() + "," + instructor.getAge() + "\n");
                        }

                        else 
						{
							newPrintStream.append("Teacher:" + instructor.getName() + "," + instructor.getGender() + "," + instructor.getAge() + "\n");
                        }
                    }

                    else if (instructor instanceof Demonstrator) 
					{
                        newPrintStream.append("Demonstrator:" + instructor.getName() + "," + instructor.getGender() + "," + instructor.getAge() + "\n");
                    }
                }
            }
        }
        return output;
	}

    /*Creates new Courses, assigns instructors, enrolls students calls aDayPasses to each course and removes the course if it is either cancelled or finished
    and writes info about the subjects to the PrintStream*/
    public void adayAtSchool()
    {
        /*For every subject, checks if a subject doesnt have course, or the the status of the course is a positive number meaning the course has already started
        or the course is cancelled or the course is finished or the course size is 3 meaning is full, then creates a course for that subject.*/
        for (Subject subject : Subjects)
        {
            if (subject.getCourse() == null || subject.getCourse().getStatus()>0|| subject.getCourse().isCancelled() || subject.getCourse().isFinished() || subject.getCourse().getSize()==3)
            {
                Course myCourse = new Course(subject, 2);
                Courses.add(myCourse);
            }

            newPrintStream.append("subject:" + subject.getDescription() + "," + subject.getID() + "," + subject.getSpecialism() + "," + subject.getDuration() +"\n");

        }

        //If course doesn't have an instructor adds one if the instructor isn't assigned to any course and can teach the subject
        for (Course course : Courses)
        {
            if (!course.hasInstructor())
            {
                for (Instructor instructor : Instructors)
                {
                    if ((instructor.getAssignedCourse() == null) && (instructor.canTeach(course.getSubject())))
                    {
                        instructor.assignCourse(course);
                        course.setInstructor(instructor);
                        break;
                    }
                }
            }
        }

        //Enrolls each student to a course if the the size of the course is less than 3 and the student doesn't have a certificate for that course.
		for (Student student : Students)
        {
            for (Course course : Courses)
            {
                if(course.getSize()<3 && !student.getCertificates().contains(course.getSubjectID()))
                {
                    course.enrolStudent(student);
                }
            }
        }

        //Calls aDayPasses for each course
		for (Course course : Courses)
        {
            course.aDayPasses();
        }

		//Removes the course if it is cancelled or it is finished
		{
			Iterator iterator = Courses.iterator();
			while (iterator.hasNext())
            {
                Course course = (Course) iterator.next();
                if (course.isCancelled() || course.isFinished())
                {
                    iterator.remove();
                }
            }
        }
	}

}

