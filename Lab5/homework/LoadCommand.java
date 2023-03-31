package homework;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

/**
 * clasa LoadCommand incarca catalogul din fisierul extern dat prin path
 */
public class LoadCommand implements Command{

    String path;

    public LoadCommand(String path) {
        this.path = path;
    }

    @Override
    public void execute() throws IOException, InvalidCatalogException{
        ObjectMapper objectMapper = new ObjectMapper();
        Catalog catalog = objectMapper.readValue(new File(path), Catalog.class);


    }
}
