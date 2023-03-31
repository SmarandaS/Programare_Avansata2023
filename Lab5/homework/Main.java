package homework;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException, InvalidDocumentException, InvalidCatalogException {

        Main app = new Main();
        app.testCreateSaveToStrAddListRep();
        app.testLoadView();


    }

    private void testCreateSaveToStrAddListRep() throws IOException, InvalidDocumentException, InvalidCatalogException{
        List<Document> docs = new ArrayList<>();
        Catalog catalog = new Catalog(docs,"Read this month");

        var article = new Document("1", "Tips for Effective Time Management");
        var book = new Document("2", "The Hunger Games", "C:/research/hungerGames.txt");

        article.addTag("Author" , "John Smith");
        article.addTag("Year" , "2018");
        article.setLink("https://corporatefinanceinstitute.com/resources/management/time-management-list-tips/");

        book.addTag("Author" , "Suzanne Collins");
        book.addTag("Publisher" , "Scholastic");
        book.setLink("https://en.wikipedia.org/wiki/The_Hunger_Games");


        AddCommand add = new AddCommand(catalog);
        add.setDocument(book);
        add.execute();
        add.setDocument(article);
        add.execute();


        SaveCommand save = new SaveCommand(catalog,"C:/research/catalog.json.txt");
        save.execute();


        ToStringCommand toStr = new ToStringCommand(catalog);
        toStr.execute();

        ListCommand list = new ListCommand(catalog);
        list.execute();

        ReportCommand rep = new ReportCommand(catalog);
        rep.execute();


    }

    private void testLoadView() throws InvalidCatalogException, IOException {

        LoadCommand load = new LoadCommand("C:/research/catalog.json.txt");
        load.execute();

        ViewCommand view = new ViewCommand("C:/research/catalog.json.txt");
        view.execute();

        ViewCommand view2 = new ViewCommand("C:/research/hungerGames.txt");
        view2.execute();





    }
}