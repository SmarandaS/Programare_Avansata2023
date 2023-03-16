package homework;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.HashMap;

public class Person implements Comparable<Person>, Node {

    String persName;
    public LocalDate dateOfBirth;
    private Map<Node, String> relationships = new HashMap<>();

    public void addRelationship(Node node, String value) {
        relationships.put(node, value);
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

