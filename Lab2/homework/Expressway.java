package homework;

/**
 * subclasa <i>Expressway</i> a clasei <i>Road</i>, adauga o limita de viteza
 */
public class Expressway extends Road{
    private final int speedLimit=100;

    @Override
    public int getSpeedLimit() {
        return speedLimit;
    }

    public Expressway(String name, Double length, Location start, Location finish) {
        super(name, length, start, finish);
    }
}

