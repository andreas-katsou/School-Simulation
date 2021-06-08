import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/*Class Administrator, reads the data from the file, adds/removes students, instructors and subjects from the school,
runs the simulation for the specified number of days.*/
public class Administrator
{
    private static School school;
    private ArrayList<Student> admittedstudents;
    private Teacher teacher;
    private Demonstrator demonstrator;
    private OOTrainer ooTrainer;
    private GUITrainer guiTrainer;
    private ArrayList<Student> studentList;
    private BufferedReader reader;
    private static String filename;

    //Administrator Constructor
    public Administrator(School school)
    {
        this.school = school;
        admittedstudents = new ArrayList<>();
        studentList = new ArrayList<>();

        try
        {
            reader = new BufferedReader(new FileReader(filename));
        }

        catch (FileNotFoundException e)
        {
            System.err.println("File not found");
        }
    }

    //Runs the Simulation
    public void run()
	{
		readData();
        addStudentList();
        instructorList();
        admittedStudents();
        probability();
		school.adayAtSchool();
        endOfDay();
        System.out.println(school.toString());
    }

    //Adds Students to the student ArrayList
    public void addStudentList()
    {
        studentList.add(new Student("Student 1", 'M', 18));
        studentList.add(new Student("Student 2", 'F', 19));
        studentList.add(new Student("Student 3", 'M', 18));
        studentList.add(new Student("Student 4", 'F', 19));
        studentList.add(new Student("Student 5", 'M', 18));
        studentList.add(new Student("Student 6", 'F', 19));
        studentList.add(new Student("Student 7", 'M', 18));
        studentList.add(new Student("Student 8", 'F', 19));
        studentList.add(new Student("Student 9", 'M', 18));
        studentList.add(new Student("Student 10", 'F', 19));
    }

    //Creates new Instructors
    public void instructorList()
    {
        teacher = new Teacher("Teacher", 'F', 30);
        guiTrainer = new GUITrainer("GUITrainer", 'F', 27);
		ooTrainer = new OOTrainer("OOTrainer", 'M', 20);
		demonstrator = new Demonstrator("Demonstrator", 'M', 27);
    }

    //Admits a random number of students between 0 and 2
    public void admittedStudents()
    {
        Random rand = new Random();
        
		//Gets a random number between 0 and 2
		int studentNumber = rand.nextInt(3);
        
		//Sets the newStudentNumber to the number of students in the admitted student ArrayList plus the random number 
		int newStudentNumber = (admittedstudents.size() + studentNumber);

        for (Student student: studentList)
        {
			/*For every student in the studentList adds the student to the admittedStudents ArrayList and the School, 
			when the number of students in the admitted student ArrayList is less than newStudentNumber and the student isn't contained admittedStudents*/
			if ((admittedstudents.size() < newStudentNumber) && (!admittedstudents.contains(student))) 
			{
                school.add(student);
                admittedstudents.add(student);
            }

            //Stops the loop when the size of admitted students ArrayList is equals to the newStudentNumber
			if (admittedstudents.size() == newStudentNumber)
            {
                break;
            }
        }
    }

	//Adds a instructor to the School, according to the probabilities
    public void probability()
    {
        Random rand = new Random();
        
		//Gets a random number between 1 and 100
		int number = rand.nextInt(100) + 1 ;

        //If the number is between 1 and 20 adds a teacher, 20% probability
		if (number >= 1 && number <= 20)
        {
            school.add(teacher);
        }

        //If the number is between 21 and 30 adds a demonstrator, 10% probability
		if (number >= 21 && number <= 30)
        {
            school.add(demonstrator);
        }

        //If the number is between 31 and 35 adds a OOTrainer, 5% probability
		if (number >= 31 && number <= 35)
        {
            school.add(ooTrainer);
        }

        //If the number is between 36 and 40 adds a guiTrainer, 5% probability
		if (number >= 36 && number <= 40)
        {
            school.add(guiTrainer);
        }
    }

    public void endOfDay()
    {
        Random rand = new Random();

        //Gets a random number between 1 and 100
        int number = rand.nextInt(100) + 1;

        //Looks at each instructor who hasn't an assigned course and removes the instructor, according to the probability
        {
            Iterator iterator = school.getInstructors().iterator();
            while (iterator.hasNext())
            {
                Instructor instructor = (Instructor) iterator.next();

                //Removes the instructor if the number is between 1 and 20, 20% probability, and the Assigned Course is null
                if ((number >= 1 && number <= 20) && (instructor.getAssignedCourse() == null))
                {
                    iterator.remove();
                }
            }
        }

        //Looks at each student, if student has obtained the certificate for all subjects removes the student
        {
            for (Student student : school.getStudents())
            {
                int counter = 0;

                Iterator iterator = school.getSubjects().iterator();

                while (iterator.hasNext())
                {
                    Subject subject = (Subject) iterator.next();
                    {
                        //Adds one to the counter each time the student has a certificate for the subject
                        if (student.getCertificates().contains(subject.getID()))
                        {
                            counter++;
                        }

                        //Removes the student if counter is equals to the number of Subjects in the School, has certificate for every subject
                        if (counter == school.getSubjects().size())
                        {
                            iterator.remove();
                        }
                    }
                }
            }
        }

        //Looks at each student who isn't enrolled to any course and removes the student from School, according to the probability
        {
            Iterator iterator = school.getStudents().iterator();

            while (iterator.hasNext())
            {
                Student student = (Student) iterator.next();

                //Removes the student if it isn't enrolled to any of the course and the number is between 1 and 5, 5% probability
                if (!student.isEnrolled() && (number >= 1 && number <= 5))
                {
                    iterator.remove();
                }
            }
        }
    }

    //Runs the Simulation for a number of days given by the user and prints the Day number
    public void run(int numberOfDays)
    {
        for (int i = 1; i <= numberOfDays; i++)
        {
            System.out.println(" Day " + i + " ");
            this.run();
        }
    }

    //Returns a boolean whether the reader is ready, throws an exception if unable to provide data, catches the exception and prints a helpful error message
	public boolean fileIsReady()
    {
        boolean isReady = false;

        try
        {
            if (reader.ready())
            {
                isReady = true;
            }
        }

        catch (IOException e)
        {
            System.out.println("Stream  isn't ready to be used");
        }

        return isReady;
    }

    
	//Tries to read the reader's next line throws an exception if that fails, catches the exception and prints a helpful error message
	public String getLine()
    {
		try
        {
            return reader.readLine();
        }

        catch (IOException e)
        {
            return "No line found";
        }
    }

    //Reads the data from the File
	public void readData()
    {
        String newString;
        while (fileIsReady())
        {
            newString = this.getLine();

            //Splits the line in the ":" in two parts
            String[] string = newString.split(":");

            /*If the first part is equals to school, ignores cases, create a new school with name the second part
            and sets this school to the school equals to the school variable.*/
            if(string[0].equalsIgnoreCase("school"))
            {
                school= new School(string[1]);
            }

            /*Else if the first part is equals to subject, ignores cases, splits the second part in the "," in 4 parts,
            creates a new subject from the second split with parameters the second, third and fourth part, converted to integers
            sets the description equals to the  first part and adds the subject to the school.*/
            else if(string[0].equalsIgnoreCase("subject"))
            {
                String[] myString = string[1].split(",");
                Subject newSubject = new Subject(Integer.parseInt(myString[1]), Integer.parseInt(myString[2]), Integer.parseInt(myString[3]));
                newSubject.setDescription(myString[0]);
                school.add(newSubject);
            }

            /*Else if the first part is equals to student, ignores cases, splits the second part in the "," in 3 parts, creates a new student from the second split
            with first parameter the first part, the second parameter the second part converted to char,
            the third parameter the third part converted to int, and adds the student to the school.*/
            else if(string[0].equalsIgnoreCase("student"))
            {
                String[] myString = string[1].split(",");
                Student newStudent = new Student(myString[0], myString[1].charAt(0), Integer.parseInt(myString[2]));
                school.add(newStudent);
            }

            /*Else if the first part is equals to Teacher, ignores cases, splits the second part in the "," in 3 parts, creates a new teacher from the second split
            with first parameter the first part, the second parameter  the second part converted to char,
            the third parameter the third part converted to int, and adds the Teacher to the school.*/
            else if(string[0].equalsIgnoreCase("Teacher"))
            {
                String[] myString = string[1].split(",");
                Teacher newTeacher= new Teacher(myString[0], myString[1].charAt(0), Integer.parseInt(myString[2]));
                school.add(newTeacher);
            }

            /*Else if the first part is equals to Demonstrator, ignores cases, splits the second part in the "," in 3 parts,
            creates a new demonstrator from the second split with first parameter the first part, the second parameter the second part converted to char,
            the third parameter the third part converted to int, and adds the Demonstrator to the school.*/
            else if(string[0].equalsIgnoreCase("Demonstrator"))
            {
                String[] myString = string[1].split(",");
                Demonstrator newDemonstrator = (new Demonstrator(myString[0], myString[1].charAt(0), Integer.parseInt(myString[2])));
                school.add(newDemonstrator);
            }

            /*Else if the first part is equals to OOTrainer, ignores cases, splits the second part in the "," in 3 parts,
            creates a new OOTrainer from the second split with first parameter the first part, the second parameter the second part converted to char,
            the third parameter the third part converted to int, and adds the OOTrainer to the school.*/
            else if(string[0].equalsIgnoreCase("OOTrainer"))
            {
                String[] myString = string[1].split(",");
                OOTrainer newOOTrainer = new OOTrainer(myString[0], myString[1].charAt(0), Integer.parseInt(myString[2]));
                school.add(newOOTrainer);
            }

            /*Else if the first part is equals to GUITrainer, ignores cases, splits the second part in the "," in 3 parts,
            creates a new GUITrainer from the second split, with first parameter the first part, the second parameter the second part converted to char,
            the third parameter the third part converted to int, and adds the GUITrainer to the school.*/
            else if(string[0].equalsIgnoreCase("GUITrainer"))
            {
                String[] myString = string[1].split(",");
                GUITrainer newGUITrainer = new GUITrainer(myString[0], myString[1].charAt(0), Integer.parseInt(myString[2]));
                school.add(newGUITrainer);
            }

            //Else print a helpful error message
			else
            {
                System.out.println("Invalid Format");
            }
        }
    }

    /*Main method, creates a new Toolbox, sets the filename equal to the first argument, the days the simulation will run equals to the second argument,
    creates a new Administrator with school as a parameter.*/
	public static void main(String[] args)
    {
        filename = args[0];
        Administrator myAdministrator = new Administrator(school);
        int numberOfDays = Integer.parseInt(args[1]);
        myAdministrator.run(numberOfDays);
	}

}