package homework;

/**
 * subclasa <i>School</i> a clasei <i>Location</i>, adauga numar de studenti
 */
public class School extends Location {
    int numberOfStudents;

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public int getNumberOfPumps() {
        return numberOfStudents;
    }


    public School(String name, Double x, Double y) {
        super(name, x, y);
    }
}
