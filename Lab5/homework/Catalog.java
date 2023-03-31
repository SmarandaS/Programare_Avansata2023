package homework;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * clasa Catalog contine un nume, un arraylist de documente, o functie de adaugare si returnare a unui document anume, un
 * constructor pentru catalog
 */
public class Catalog implements Serializable {
    private List<Document> docs = new ArrayList<>();

    private String name;

    public String getName() {
        return name;
    }

    /*public void addDoc(Document doc){     //AddCommand implements Command
        docs.add(doc);
    }*/

    public List<Document> getDocs() {
        return docs;
    }

    public Document findById(String id) {
        return docs.stream()
                .filter(d -> d.getID().equals(id)).findFirst().orElse(null);
    }


    public Catalog(String name) {
        docs = new ArrayList<>() ;
        this.name = name;
    }

    public Catalog(List<Document> docs, String name) {
        this.docs = docs;
        this.name = name;
    }

    public Catalog() {
    }
}
