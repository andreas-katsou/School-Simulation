import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main
{
    public static void main(String[] args)
    {
        Teacher myTeacher = new Teacher("Teacher",'F', 30);

        Demonstrator myDemonstrator = new Demonstrator("Demonstrator", 'M',25);

        OOTrainer myOOTrainer = new OOTrainer("OOTrainer", 'M', 20);

        GUITrainer myGUITrainer = new GUITrainer("GUITrainer",'F', 27);

        Student firstStudent = new Student("FirstStudent",'M', 18);

        Student secondStudent = new Student("SecondStudent",'M', 17);

        Student thirdStudent = new Student("ThirdStudent",'F', 19);

        Student fourthStudent = new Student("FourthStudent",'F', 20);

        School mySchool = new School("MySchool");

        Administrator myAdministrator = new Administrator(mySchool);

//        BufferedReader reader;
//
//        Toolbox myToolbox = new Toolbox();

        String filename;

        Subject Arrays = new Subject(3,1, 3);
        Arrays.setDescription("A lesson for Arrays");
        Course courseArrays= new Course(Arrays,3);
        Arrays.setCourse(courseArrays);
//        courseArrays.setInstructor(myOOTrainer);
//        myOOTrainer.assignCourse(courseArrays);
        //courseArrays.enrolStudent(firstStudent);
        //courseArrays.enrolStudent(secondStudent);
//        firstStudent.graduate(Arrays);
//        secondStudent.graduate(Arrays);
        //thirdStudent.graduate(Arrays);
        //courseArrays.setCancelled();

        Subject Algorithms = new Subject(4,1,1);
        Algorithms.setDescription("A lesson for Algorithms ");
        Course courseAlgorithms= new Course(Algorithms,4);
        Algorithms.setCourse(courseAlgorithms);
//        courseAlgorithms.setInstructor(myTeacher);
//        myTeacher.assignCourse(courseAlgorithms);
        //courseAlgorithms.enrolStudent(firstStudent);
        //courseAlgorithms.enrolStudent(secondStudent);
        //courseAlgorithms.enrolStudent(thirdStudent);
        //courseAlgorithms.enrolStudent(fourthStudent);
//        firstStudent.graduate(Algorithms);
//        secondStudent.graduate(Algorithms);
//        thirdStudent.graduate(Algorithms);


        Subject Graphics = new Subject(10,4,5);
        Graphics.setDescription("A lesson for Graphics");
//        Course courseGraphics =new Course(Graphics,5);
//        Graphics.setCourse(courseGraphics);
        //courseGraphics.enrolStudent(secondStudent);
        //thirdStudent.graduate(Graphics);

//        mySchool.add(myTeacher);
//        mySchool.add(myDemonstrator);
//        mySchool.add(myOOTrainer);
//        mySchool.add(myGUITrainer);
//        mySchool.add(firstStudent);
//        mySchool.add(secondStudent);
//        mySchool.add(thirdStudent);
//        mySchool.add(fourthStudent);
//        mySchool.add(Arrays);
//        mySchool.add(courseArrays);
//        mySchool.add(Algorithms);
//       mySchool.add(courseAlgorithms);
//       mySchool.add(Graphics);

       //myAdministrator.run();

//        myAdministrator.run(3);
        //mySchool.adayAtSchool();
        //System.out.println(mySchool.toString());

//        myAdministrator.addStudentList();
//        myAdministrator.admittedStudents();
//        myAdministrator.addInstructorList();
//        myAdministrator.probability();
//        myAdministrator.instructorJoining();
//        myAdministrator.endOfDay();
//        mySchool.adayAtSchool();
//        System.out.println(mySchool.toString());

        myAdministrator.run();


    }

}
