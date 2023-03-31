package homework;

import java.io.IOException;

/**
 * clasa ToStringCommand se foloseste de metoda ToString din document si o aplica asupra intregului catalog
 */
public class ToStringCommand implements Command{

    Catalog catalog;

    public ToStringCommand(Catalog catalog) {
        this.catalog = catalog;
    }

    @Override
    public void execute() throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(catalog.getName()).append("\n");
        for (Document document : catalog.getDocs()) {
            sb.append(document.toString());
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }


}
