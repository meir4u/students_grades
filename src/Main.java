import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Student> students;

        System.out.println("program started!");

        Generator g = new Generator();
        students = g.getStudents();
        new CalcStudents(students);
        new CalcTeacher(students);
        new CalcUnit(students);
        new CalcCourse(students);
        new CalcTotalGrades(students);
    }


}
