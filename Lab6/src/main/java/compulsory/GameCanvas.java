package compulsory;

import java.awt.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
public class GameCanvas extends Canvas {

    private Canvas canvas;
    private int nrDots;
    private GraphicsContext gc;
    public GameCanvas(int width, int height) {
        canvas = new Canvas(800, 700);
        gc.setFill(Color.IVORY);
        gc.fillRect(0,0,800,700);
    }

    public void drawDots(int x) {
        this.nrDots = x;
        GraphicsContext gc = getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        int x0 = 400;
        int y0 = 400; //middle of the board
        int radius = 500 / 2 - 10; //board radius
        double alpha = 2 * Math.PI / x; // the angle
        int[] dotsX = new int[x];
        int[] dotsY = new int[x];
        for (int i = 0; i < x; i++) {
            dotsX[i] = x0 + (int) (radius * Math.cos(alpha * i));
            dotsY[i] = y0 + (int) (radius * Math.sin(alpha * i));
            gc.setFill(Color.BLACK);
            gc.fillOval(dotsX[i], dotsY[i], 10, 10);

        }

    }

}
