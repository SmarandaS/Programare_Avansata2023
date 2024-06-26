package homework;

import java.util.*;

/**
 * clasa network contine un ArrayList de noduri, un getter pentru acestea, getter pentru nodurile de tip Person si Company din
 * retea, functie de adaugare nod si un constructor default
 */
public class Network {
    private List<Node> nodes = new ArrayList<>();

    public void addNode(Node node) {
        nodes.add(node);
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public List<Person> getPeople() {
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < nodes.size(); i++)
            if (nodes.get(i) instanceof Person)
                people.add(((Person) nodes.get(i)));
        return people;


    }

    public List<Company> getCompanies() {
        List<Company> companies = new ArrayList<>();

        for (int i = 0; i < nodes.size(); i++)
            if (nodes.get(i) instanceof Company)
                companies.add(((Company) nodes.get(i)));
        return companies;


    }

    public Network() {
    }
}
