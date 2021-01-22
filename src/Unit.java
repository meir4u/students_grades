public class Unit {
    private int grade;
    private String name;
    private String teacherName;

    public Unit(){
        this.grade = 0;
    }

    public void setGrade(int dueA, int dueB ) {
        if(dueB > 0){
            this.grade = dueB;
        }else{
            this.grade = dueA;
        }

    }

    public void setTeacherName(String teacherName) { this.teacherName = teacherName; }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public String getTeacherName() { return teacherName; }

    public String getName() {
        return name;
    }
}

