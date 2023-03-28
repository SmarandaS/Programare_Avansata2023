package compulsory;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * clasa MainFrame initializeaza fereastra, panoul de configurare de sus si cel de control din partea de jos, radacina, canvasul si
 * contextul grafic(pentru a putea desena in canvas). Contine de asemenea functia de desenare penteu linii si puncte
 */
public class MainFrame extends Application {

    private BorderPane root;
    private Canvas canvas;
    private GraphicsContext gc;
    @Override
    public void start(Stage primaryStage) throws Exception {

        //nume fereastra + dimensiuni
        primaryStage.setTitle("Positional Game");
        primaryStage.setWidth(800);
        primaryStage.setHeight(800);


        root = new BorderPane();

        // configuration panel in partea de sus
        ConfigPanel configPanel = new ConfigPanel();
        root.setTop(configPanel);


        // canvas in centru
        canvas = new Canvas(800, 700);
        gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.IVORY);
        gc.fillRect(0,0,800,700);
        root.setCenter(canvas);
        configPanel.getLines().setValue("0.0");


        // control panel la baza ferestrei
        ControlPanel controlPanel = new ControlPanel();
        root.setBottom(controlPanel);

        //initializare fereastra
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();


        controlPanel.getResetButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent reset) {
                SpinnerValueFactory<Integer> valueFactoryDots = configPanel.getDots().getValueFactory();
                valueFactoryDots.setValue(0);

                configPanel.getLines().setValue("0.0");

                canvas = new Canvas(800, 700);
                gc = canvas.getGraphicsContext2D();
                gc.setFill(Color.IVORY);
                gc.fillRect(0,0,800,700);
                root.setCenter(canvas);

            }
        });

        controlPanel.getExitButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Platform.exit();
            }
        });


        configPanel.getNewGame().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int x = configPanel.getDotsValue();
                double y = configPanel.getLinesValue();
                //System.out.println(x);
                //System.out.println(y);
                drawDotsLines(x,y);

            }
        });
    }

    public void drawDotsLines(int x, double y)
    {
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

        for (int i = 0; i < x; i++) {
            for (int j = i + 1; j < x; j++) {
                if (Math.random() < y) {
                    gc.strokeLine(dotsX[i], dotsY[i], dotsX[j], dotsY[j]);
                }
            }
        }
    }
}
