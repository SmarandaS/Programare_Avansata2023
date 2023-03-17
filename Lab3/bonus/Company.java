package bonus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * clasa company contine numele companiei si getter pentru acesta, un HashMap pentru relatiile companiei, functie de adaugare
 * relatie si de returnare a tuturor relatiilor sau a unei relatii cu un nod anume, un constructor default si unul ce include
 * numele si o functie de comparare a companiilor in functie de nume
 */
public class Company implements Comparable<Company>, Node {

    String compName;

    private Map<Node, String> relationships = new HashMap<>();
    private List<Node> neighbours = new ArrayList<>();

    public void addRelationship(Node node, String value) {
        relationships.put(node, value);
        neighbours.add(node);
    }

    public List<Node> getNeighbours() {
        return neighbours;
    }

    @Override
    public String getName() {

        return compName;
    }

    public Map<Node, String> getRelationships() {
        return relationships;
    }

    @Override
    public int compareTo(Company c) {

        if (c == null) throw new NullPointerException();

        return (this.getName().compareTo(c.getName()));

    }

    public int numberOfRelations() {
        return this.relationships.size();
    }

    public String getRelation(Node nod) {
        return relationships.get(nod);
    }


    public Company(String compName) {
        this.compName = compName;
        this.relationships = new HashMap<Node, String>();
    }


    public Company() {
    }
}
