package homework;

/**
 * subclasa <i>Highway</i> a clasei <i>Road</i>, adauga o limita de viteza
 */
public class Highway extends Road {
    private final int speedLimit = 130;

    public int getSpeedLimit() {
        return speedLimit;
    }

    public Highway(String name, Double length, Location start, Location finish) {
        super(name, length, start, finish);
    }
}
