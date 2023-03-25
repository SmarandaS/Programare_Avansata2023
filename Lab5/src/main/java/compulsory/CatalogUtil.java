package compulsory;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * clasa CatalogUtil se ocupa cu operatiile legate de un catalog: salvarea acestuia, incarcarea lui si functia toString, ce se
 * foloseste de functia toString din document, pentru afisarea unui catalog anume
 */
public class CatalogUtil {

    private Catalog catalog;

    public static void save(Catalog catalog, String path)
            throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(
                new File(path),
                catalog);
    }
    public static Catalog load(String path)
            throws IOException, InvalidCatalogException {
        ObjectMapper objectMapper = new ObjectMapper();
        Catalog catalog = objectMapper.readValue(
                new File(path),
                Catalog.class);
        return catalog;
    }

    public static String toString(Catalog catalog) {
        StringBuilder sb = new StringBuilder();
        sb.append(catalog.getName()).append("\n");
        for (Document document : catalog.getDocs()) {
            sb.append(document.toString());
            sb.append("\n");
        }
        System.out.println(sb.toString());
        return sb.toString();
    }



}
