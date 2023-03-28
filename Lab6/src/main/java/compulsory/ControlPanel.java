package compulsory;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 * clasa ControlPanel se ocupa de butoanele din partea de jos a ferestrei: load, save, exit, reset
 */
public class ControlPanel extends HBox {

    private final Button loadButton;
    private final Button saveButton;
    private final Button resetButton;
    private final Button exitButton;


    public ControlPanel(){
        super(10);
        setAlignment(Pos.CENTER);
        setStyle("-fx-background-color: GAINSBORO");
        loadButton = new Button("Load");
        saveButton = new Button("Save");
        resetButton = new Button("Reset");
        exitButton = new Button("Exit");
        getChildren().addAll(loadButton, saveButton, resetButton, exitButton);
    }

    public Button getSaveButton() {

        return saveButton;
    }

    public Button getLoadButton() {

        return loadButton;
    }

    public Button getResetButton() {

        return resetButton;
    }

    public Button getExitButton() {

        return exitButton;
    }
}
