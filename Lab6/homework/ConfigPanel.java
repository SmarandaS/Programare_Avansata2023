package homework;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.layout.HBox;

/**
 * clasa ConfigPanel se ocupa de panoul de configurare din partea de sus a ferestrei, ce contine Spinner pentru nr de puncte, ComboBox
 * pentru probabilitatea liniilor si butonul de newGame.
 */
public class ConfigPanel extends HBox {

    private final Label dotsLabel;
    private final Label linesLabel;
    private final Spinner<Integer> dots;
    ComboBox<String> lines = new ComboBox<>();
    private final Button newGame;

    public ConfigPanel(){
        super(10);
        setAlignment(Pos.CENTER);
        setStyle("-fx-background-color: GAINSBORO");

        dotsLabel  = new Label("Number of dots: ");
        linesLabel  = new Label("Number of lines: ");
        dots = new Spinner<>(0, 100, 0, 1);
        lines.getItems().addAll("0.0","0.1", "0.2", "0.3", "0.4", "0.5", "0.6", "0.7", "0.8", "0.9", "1.0");
        newGame = new Button("Create new game");
        getChildren().addAll(dotsLabel,dots, linesLabel, lines, newGame);

    }

    public int getDotsValue() {
        return Integer.parseInt(dots.getValue().toString());
    }

    public double getLinesValue() {

        return Double.parseDouble(lines.getValue());
    }

    public Spinner<Integer> getDots() {

        return dots;
    }

    public ComboBox<String> getLines() {
        return lines;
    }

    public Button getNewGame() {
        return newGame;
    }
}
