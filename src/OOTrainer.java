//OOTrainer subclass of Teacher
public class OOTrainer extends Teacher
{
	//OOTrainer Constructor
	public OOTrainer(String name, char gender, int age)
    {
		super(name, gender, age);
    }

	//If the subject can be taught by a OOTrainer returns true, else returns false
    public boolean canTeach(Subject subject) 
	{
        return subject.getSpecialism() == 1 || subject.getSpecialism() == 2 || subject.getSpecialism() == 3;
    }

}
