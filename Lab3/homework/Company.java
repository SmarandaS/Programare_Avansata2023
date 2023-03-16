package homework;

import java.util.HashMap;
import java.util.Map;

public class Company implements Comparable<Company>, Node {

    String compName;

    private Map<Node, String> relationships = new HashMap<>();

    public void addRelationship(Node node, String value) {
        relationships.put(node, value);
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
