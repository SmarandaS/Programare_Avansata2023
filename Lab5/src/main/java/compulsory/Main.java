package compulsory;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException, InvalidCatalogException {

        Main app = new Main();
        app.testCreateSave();


    }

    private void testCreateSave() throws IOException {
        Catalog catalog = new Catalog("MyDocuments");
        var book = new Document("1", "article1");
        var article = new Document("2", "book1");
        catalog.addDoc(book);
        catalog.addDoc(article);

        CatalogUtil.save(catalog, "C:/research/catalog.json");

        CatalogUtil.toString(catalog);



    }

    private void testLoadView() throws IOException, InvalidCatalogException {
        Catalog catalog = CatalogUtil.load("C:/research/catalog.json");

    }
}