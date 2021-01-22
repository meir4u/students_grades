public class Year{
    private static final int NUMBER_OF_SEMESTERS = 3;
    private Semester[] semesters;
    private int nYear;

    public Year(){
        setSemesters();
    }

    public void setnYear(int nYear) {
        this.nYear = nYear;
    }

    private void setSemesters() {
        this.semesters = new Semester[NUMBER_OF_SEMESTERS];
        for (int i = 0; i < NUMBER_OF_SEMESTERS; i++) {
            semesters[i] = new Semester();
        }
    }

    public Semester[] getSemesters() {
        return semesters;
    }

    public int getnYear() {
        return nYear;
    }

}
