package homework;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
import javax.imageio.ImageIO;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * clasa SaveButtonHandler reprezinta handlerul pentru butonul de save din joc. Se foloseste de clasa Robot din java pentru a realiza
 * o captura de ecran a ferestrei grafice atunci cand apasam butonul "Save"
 */
public class SaveButtonHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {

        // Fac obiect robot care sa faca poza
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
            return;
        }

        //  Setez coordonatele dreptunghiului la care sa faca screenshot
        Rectangle screenRect = new Rectangle(350, 50, 800, 800);


        BufferedImage image = robot.createScreenCapture(screenRect);

        // Salvez ss ul intr-un png
        File file = new File("./src/main/java/homework/screenshot.png");
        System.out.println("Image saved");
        try {
            ImageIO.write(image, "png", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
