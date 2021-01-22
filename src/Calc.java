import java.util.ArrayList;

abstract class Calc{
    protected String H1;
    private ArrayList<Student> students;

    protected ArrayList<String>  dataNamesTable = new ArrayList<>();
    protected ArrayList<Integer> dataFrequencyTable = new ArrayList<>();
    protected ArrayList<Integer> sumTable = new ArrayList<>();
    protected ArrayList<Integer> minTable = new ArrayList<>();
    protected ArrayList<Integer> maxTable = new ArrayList<>();
    protected ArrayList<Float> avgTable = new ArrayList<>();

    protected Calc(ArrayList<Student> students){
        setStudents(students);
    }
    /*
     * setters
     * */

    private void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    /*
     * Getters
     * */

    protected ArrayList<Student> getStudents() {
        return students;
    }

    /*
     * calc
     * */

    private int getIndex(String name){
        return dataNamesTable.indexOf(name);
    }

    protected void setSumTable(int grade, String name){
        int Index = getIndex(name);
        sumTable.set(Index,sumTable.get(Index) + grade);
    }

    protected void setMinTable(int grade, String name){
        int Index = getIndex(name);
        int min = minTable.get(Index);
        if(minTable.get(Index) == 0){
            minTable.set(Index,grade);
        }else if(grade < min && grade != 0){
            minTable.set(Index,grade);
        }
    }

    protected void setMaxTable(int grade, String name){
        int Index = getIndex(name);
        int max = maxTable.get(Index);
        if(grade > max){
            maxTable.set(Index,grade);
        }
    }

    protected void setFrequencyTable(String name){
        int Index = getIndex(name);
        dataFrequencyTable.set(Index,dataFrequencyTable.get(Index) + 1);
    }

    protected void setAvgTable(){
        for (int i = 0; i < dataNamesTable.size(); i++) {
            avgTable.add(Float.valueOf(sumTable.get(i)/dataFrequencyTable.get(i)));
        }
    }

    abstract protected String makeName(Student s, Year y, Semester sem, Unit u);

    protected void loopTable(){
        String name;
        for (Student s :
                this.getStudents()) {
            for (Year y :
                    s.getYear()) {
                for (Semester sem :
                        y.getSemesters()) {
                    for (Unit u :
                            sem.getUnits()) {
                        name = this.makeName(s,y,sem,u);
                        this.setTables(name,u.getGrade());
                    }

                }
            }
        }
        setAvgTable();
    }

    protected void setTables(String str, int grade){
        if(!dataNamesTable.contains(str)){
            dataNamesTable.add(str);
            this.sumTable.add(grade);
            this.dataFrequencyTable.add(1);
            this.minTable.add(grade);
            this.maxTable.add(grade);
        }else{
            this.setSumTable(grade, str);
            setFrequencyTable(str);
            setMinTable(grade, str);
            setMaxTable(grade, str);
        }
    }

    /*
    * Printers
    * */
    protected void setH1(String h1){
        this.H1 = h1;
    }

    private void printHeader(boolean big){
        System.out.printf("\n%s\n",H1);
        System.out.printf("%8s"," ");
        for (String s :
                dataNamesTable) {
            if(big == true ){
                System.out.printf("%20s",s);
            }else{
                System.out.printf("%10s",s);
            }
        }
        System.out.print("\n");
    }

    private void printRowData(boolean big,ArrayList table, String type){
        System.out.printf("%8s",type);
        for (Object typeData :
                table) {
            if(typeData instanceof Integer ){
                if(big == true ){
                    System.out.printf("%20d",typeData);
                }else{
                    System.out.printf("%10d",typeData);
                }
            }else{
                if(big == true ){
                    System.out.printf("%20.2f",typeData);
                }else{
                    System.out.printf("%10.2f",typeData);
                }
            }
        }
        System.out.print("\n");
    }

    public void printData(boolean big){
        printHeader(big);

        printRowData(big,minTable , "Min");
        printRowData(big,maxTable , "Max");
        printRowData(big,avgTable , "AVG");
    }
}