//Demonstrator subclass of Instructor
public class Demonstrator extends Instructor
{
	//Demonstrator Constructor
	public Demonstrator(String name, char gender, int age)
    {
		super(name, gender, age);
    }

	//If the subject can be taught by a Demonstrator returns true, else returns false
    public boolean canTeach(Subject subject) 
	{
		return subject.getSpecialism() == 2;
    }

}
