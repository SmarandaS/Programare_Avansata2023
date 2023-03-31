package homework;

/**
 * clasa AddCommand adauga noi intrari(documente) in catalogul nostru
 */
public class AddCommand implements Command{

    private Catalog catalog;
    private Document document;

    public void setDocument(Document document) {
        this.document = document;
    }

    public AddCommand(Catalog catalog) {
        this.catalog = catalog;

    }

    @Override
    public void execute() {
        catalog.getDocs().add(document);
    }
}
