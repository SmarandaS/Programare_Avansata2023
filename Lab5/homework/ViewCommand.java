package homework;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * clasa ViewCommand ne deschide fisierul dat prin path
 */
public class ViewCommand implements Command{

    private String path;

    public ViewCommand(String path) {
        this.path = path;
    }

    @Override
    public void execute() throws IOException {

        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().open(new File(path));
        }
    }
}
