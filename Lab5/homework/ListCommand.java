package homework;

/**
 * clasa ListCommand ne da o lista a documentelor din catalogul nostru
 */
public class ListCommand implements Command{

    private Catalog catalog;

    public ListCommand(Catalog catalog) {
        this.catalog = catalog;
    }
    @Override
    public void execute() {
        for(Document doc : catalog.getDocs())
        {
            System.out.println(doc.getName());
        }

    }



}
