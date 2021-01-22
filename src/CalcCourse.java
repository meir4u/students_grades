import java.util.ArrayList;

public class CalcCourse extends Calc{
    private final String H1 = "Courses Grades!";

    public CalcCourse(ArrayList<Student> students){
        super(students);
        this.setH1(H1);
        loopTable();
        printData(true);
    }

    protected String makeName(Student s, Year y, Semester sem, Unit u){
        return u.getName() + " " + y.getnYear() + " " + sem.getName();
    }
}
