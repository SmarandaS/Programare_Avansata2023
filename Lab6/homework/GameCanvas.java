package homework;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * clasa GameCanvas initializeaza fereastra de joc din fereastrea grafica
 */
public class GameCanvas extends Canvas {

    private Canvas canvas;
    private int nrDots;
    private GraphicsContext gc;
    public GameCanvas(int width, int height) {
        canvas = new Canvas(800, 700);
        gc.setFill(Color.IVORY);
        gc.fillRect(0,0,800,700);
    }



}
