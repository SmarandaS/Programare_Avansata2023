package homework;

/**
 * subclasa <i>gasStation</i> a clasei <i>Location</i>, adauga numar de studenti
 */
public class gasStation extends Location{
    int numberOfPumps;

    public void setNumberOfPumps(int numberOfPumps) {
        this.numberOfPumps = numberOfPumps;
    }

    public int getNumberOfPumps() {
        return numberOfPumps;
    }


    public gasStation(String name, Double x, Double y) {
        super(name, x, y);
    }
}