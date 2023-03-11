package homework;

/**
 * subclasa <i>localRoad</i> a clasei <i>Road</i>, adauga o limita de viteza
 */
public class localRoad extends Road{
    private final int speedLimit=50;

    @Override
    public int getSpeedLimit() {
        return speedLimit;
    }

    public localRoad(String name, Double length, Location start, Location finish) {
        super(name, length, start, finish);
    }
}

