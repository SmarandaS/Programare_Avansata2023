package homework;

import java.util.ArrayList;
import java.util.List;

/**
 * clasa Board contine listele de linii si puncte din jocul nostru
 */
public class Board {
    private List<Dot> dots;
    private List<Line> lines;

    public Board(List<Dot> dots, List<Line> lines) {
        this.dots = dots;
        this.lines = lines;
    }

    public List<Dot> getDots() {
        return dots;
    }

    public List<Line> getLines() {
        return lines;
    }
}

