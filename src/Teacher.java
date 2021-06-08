//Teacher subclass of Instructor
public class Teacher extends Instructor
{
    //Teacher constructor
	public Teacher(String name, char gender, int age)
    {
        super(name, gender, age);
    }

	//If the subject can be taught by a Teacher returns true, else returns false
    public boolean canTeach(Subject subject)
    {
        return subject.getSpecialism() == 1 || subject.getSpecialism() == 2;
    }

}
