import java.util.ArrayList;

public class CalcTotalGrades extends Calc {
    private final String H1 = "Total Grades!";

    public CalcTotalGrades(ArrayList<Student> students){
        super(students);
        this.setH1(H1);
        loopTable();
        printData(true);
    }

    protected String makeName(Student s, Year y, Semester sem, Unit u){
        return "Total";
    }
}
