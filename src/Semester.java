public class Semester{
    private static final int NUMBER_OF_UNITS = 5;
    private Unit[] units;
    private String name;

    public Semester(){
        setUnits();
    }

    public String getName() {
        return name;
    }

    private void setUnits() {
        this.units = new Unit[NUMBER_OF_UNITS];
        for (int i = 0; i < NUMBER_OF_UNITS; i++) {
            this.units[i] = new Unit();
        }
    }

    public Unit[] getUnits() {
        return units;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getNumberOfUnits() {
        return NUMBER_OF_UNITS;
    }



}
