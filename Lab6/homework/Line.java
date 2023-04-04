package homework;

/**
 * clasa line este wrapper pentru elementele de tip linie din joc, tine minte cele 2 puncte care se afla la capatul liniilor
 * (coordonatele acestora si statusul lor) si statusul liniei
 */
public class Line {
    private Dot dot1;
    private Dot dot2;
    private boolean isColored;

    public Line(Dot dot1, Dot dot2) {
        this.dot1 = dot1;
        this.dot2 = dot2;
        this.isColored = false;
    }

    public Dot getDot1() {
        return dot1;
    }

    public Dot getDot2() {
        return dot2;
    }

    public boolean isColored() {
        return isColored;
    }

    public void setColor(boolean color) {
        isColored = color;
    }
}

