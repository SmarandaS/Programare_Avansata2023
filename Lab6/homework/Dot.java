package homework;


/**
 * clasa Dot este wrapper pentru elementele de tip punct din joc, tine minte coordonatele si statusul punctelor
 */
public class Dot {
    private int x;
    private int y;
    private boolean isColored;

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
        this.isColored = false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isColored() {
        return isColored;
    }

    public void setColor(boolean color) {
        isColored = color;
    }
}

