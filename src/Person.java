//Person Superclass
public class Person
{
    private String name;
    private char gender;
    private int age;

	//Person constructor
    public Person(String name, char gender, int age)
    {
        this.name = name;
        this.gender = gender;
        this.age = age;
	}

	//Returns the name of the Person
    public String getName()
    {
        return name;
    }
	
	//Returns the gender of the Person
    public char getGender()
    {
        return gender;
    }
	
	//Sets the age of the Person
    public void setAge(int age)
    {
        this.age = age;
    }
	
	//Returns the age of the Person
    public int getAge()
    {
        return age;
    }

}

