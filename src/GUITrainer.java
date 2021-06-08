//GUITrainer subclass of Teacher
public class GUITrainer extends Teacher
{
   //GUITrainer Constructor
   public GUITrainer(String name, char gender, int age)
    {
        super(name, gender, age);
    }
    
	//If the subject can be taught by a GUITrainer returns true, else returns false
	public boolean canTeach(Subject subject)
    {
        return subject.getSpecialism() == 1 || subject.getSpecialism() == 2 || subject.getSpecialism() == 4;
    }

}
