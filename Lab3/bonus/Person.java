package bonus;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * clasa person contine numele persoanei, data de nastere si getteri pentru acestea, un HashMap pentru relatiile persoanei,
 * functie de adaugare relatie si de returnare a tuturor relatiilor sau a unei relatii cu un nod anume, un constructor default
 * si unul ce include numele si o functie de comparare a persoanelor in functie de nume
 */
public class Person implements Comparable<Person>, Node {

    String persName;
    public LocalDate dateOfBirth;
    private Map<Node, String> relationships = new HashMap<>();

    private List<Node> neighbours = new ArrayList<>();

    public void addRelationship(Node node, String value) {
        relationships.put(node, value);
        neighbours.add(node);
    }

    public List<Node> getNeighbours() {
        return neighbours;
    }

    public void setPersName(String persName) {
        this.persName = persName;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    @Override
    public String getName() {
        return persName;
    }

    public String getPersName() {
        return persName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Map<Node, String> getRelationships() {
        return relationships;
    }

    @Override
    public int compareTo(Person p) {

        if (p == null) throw new NullPointerException();


        return (this.getName().compareTo(p.getName()));


    }


    public int numberOfRelations() {
        return this.relationships.size();
    }

    public String getRelation(Node nod) {
        return relationships.get(nod);
    }

    public Person(String persName, String dateOfBirth) {
        this.persName = persName;
        this.dateOfBirth = LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        this.relationships = new HashMap<Node, String>();
    }

    public Person() {
    }
}

