//Subject class contains getters and setters for the subject.
public class Subject
{
    private int id;
    private int specialism;
    private int duration;
    private String description;
    private Course course;

	//Subject constructor
    public Subject(int id, int specialism, int duration)
    {
        this.id = id;
        this.specialism = specialism;
        this.duration = duration;
    }

	//Returns the ID
    public int getID()
    {
        return id;
    }

    //Returns the specialism
    public int getSpecialism()
    {
        return specialism;
    }

    //Returns the duration
    public int getDuration()
    {
        return duration;
    }

	//Returns description
    public String getDescription()
    {
        return description;
    }

	//Sets description
    public void setDescription(String description)
    {
        this.description = description;
    }

    //Return thee course
    public Course getCourse()
    {
        return course;
    }

    //Sets the course
    public void setCourse(Course course)
    {
        this.course = course;
    }

}


