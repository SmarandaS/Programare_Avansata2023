package homework;

public class Airport extends Location{
    int numberOfTerminals;

    public void setNumberOfTerminals(int numberOfTerminals) {
        this.numberOfTerminals = numberOfTerminals;
    }

    public int getNumberOfTerminals() {
        return numberOfTerminals;
    }


    public Airport(String name, Double x, Double y) {
        super(name, x, y);
    }
}
