import java.util.ArrayList;

public class CalcStudents extends Calc{
    private final String H1 = "Students Grades!";

    public CalcStudents(ArrayList<Student> students){
        super(students);
        this.setH1(H1);
        loopTable();
        printData(false);
    }

    protected String makeName(Student s, Year y, Semester sem, Unit u){
        return s.getName();
    }
}
