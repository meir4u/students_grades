import java.util.ArrayList;

public class CalcUnit extends Calc{
    private final String H1 = "Unit Grades!";

    public CalcUnit(ArrayList<Student> students){
        super(students);
        this.setH1(H1);
        loopTable();
        printData(false);
    }


    protected String makeName(Student s, Year y, Semester sem, Unit u){
        return u.getName();
    }



}