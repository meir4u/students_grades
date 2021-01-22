import java.util.ArrayList;
import java.util.Random;

public class Generator{
    private ArrayList<Student> students = new ArrayList<>();

    public Generator (){
        setStudents(10);
        fillYears(2003,3);
        fillSemesters();
        fillUnits();
        fillGrades(15,100);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    protected void setStudents(int total) {
        for (int i = 0; i < total; i++) {
            this.students.add(new Student("name " + i));
        }
    }
    protected void fillYears(int startYear, int total){
        for (Student s :
                this.students) {
            for (int j = 0; j < total; j++) {
                s.getYear()[j].setnYear(startYear+j);
            }
        }
    }

    protected void fillSemesters(){
        String[] semester = new String[3];
        semester[0] = "SUMMER";
        semester[1] = "AUTUMN";
        semester[2] = "WINTER";
        for (Student s :
                this.students) {
            for (Year y :
                    s.getYear()) {
                for (int i = 0; i < 3; i++) {
                    y.getSemesters()[i].setName(semester[i]);
                }
            }
        }
    }

    protected  void fillUnits(){
        for (Student s :
                this.students) {
            for (Year y :
                    s.getYear()) {
                for (Semester sem :
                        y.getSemesters()) {
                    int i=0;
                    for (Unit u :
                            sem.getUnits()) {
                        u.setName("unit " + i++ );
                        u.setTeacherName("teacher " + i++ );
                    }

                }
            }
        }
    }

    private int getRandom(int max, int min){
        Random rand = new Random();
        int randomNum;

        if((rand.nextInt((2 - 0) + 1) + 0) == 0){
            randomNum = 0;
        }else if((rand.nextInt((10 - 1) + 1) + 1) > 4) {
            randomNum = rand.nextInt((max - 50) + 1) + 50;
        }else{
            randomNum = rand.nextInt((max - min) + 1) + min;
        }

        return randomNum;
    }

    protected void fillGrades(int min, int max){
        int randomNum1;
        int randomNum2;

        for (Student s :
                this.students) {
            for (Year y :
                    s.getYear()) {
                for (Semester sem :
                        y.getSemesters()) {
                    for (Unit u :
                            sem.getUnits()) {

                        /*to add more random zeros*/
                        randomNum1 = getRandom(max, min);
                        randomNum2 = getRandom(max, min);
                        u.setGrade(randomNum1,randomNum2);
                    }
                }
            }
        }
    }

}

