public class Student{
    private Year[] year;
    private String name;


    public Student(String name){
        setName(name);
        setYear();
    }

    /*
    * calc data
    * */


    /*
    * setters
    * */
    private void setYear() {
        this.year = new Year[3];
        for (int i = 0; i < 3; i++) {
            year[i] = new Year();
        }
    }

    public void setName(String name) { this.name = name; }

    /*
    * getters
    * */
    public Year[] getYear() { return year; }

    public String getName() {
        return name;
    }


}
