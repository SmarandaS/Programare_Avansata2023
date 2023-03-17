package bonus;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * clasa network contine un ArrayList de noduri, un getter pentru acestea, getter pentru nodurile de tip Person si Company din
 * retea, functie de adaugare nod si un constructor default
 * Mai contine si o metoda <i>isConnected</i> pentru verificarea existentei punctelor de articulatie ale retelei.
 * Initial, metoda apeleaza metoda recursiva <i>connected</i>, ce primeste drept parametri un nod si un HashSet visited in
 * care pastreaza nodurile la care se poate ajunge din el. Apeland aceasta metoda la inceputul <i>isConnected</i> verificam daca
 * putem ajunge dintr-un nod in orice alt nod al retelei. Daca nu, reteaua nu este conectata si von returna <i>false</i>
 * altfel, luam nodurile retelei pe rand si pentri fiecare: il eliminam, apelam din nou <i>connected</i> pentru reteaua noastra
 * iar daca reteaua se deconecteaza, nodul respectiv este adaugat intr-un HashSet cu puncte de articulatie si adaugat la loc in
 * lista de noduri ale retelei. Daca dupa trecerea tuturor nodurilor prin acest proces, <i>articulationNodes</i> nu este gol,
 * inseamna ca exista puncte de articulatie in retea(a caror eliminare deconecteaza reteaua).
 */
public class Network {
    private List<Node> nodes = new ArrayList<>();

    public void addNode(Node node) {
        nodes.add(node);
    }

    public List<Node> getNodes() {
        return nodes;
    }


    public boolean isConnected() {
        Set<Node> visited = new HashSet<>();
        connected(nodes.get(0), visited);
        if (visited.size() != nodes.size()) {
            return false;
        }

        Set<Node> articulationNodes = new HashSet<>();

        for (int i = 1; i < nodes.size(); i++) {
            Node current = nodes.get(i);
            nodes.remove(nodes.get(i));

            visited = new HashSet<>();
            connected(nodes.get(0), visited);
            if (visited.size() != nodes.size()) {
                articulationNodes.add(current);
            }

            nodes.add(current);
        }

        if (articulationNodes.size() > 0) {
            return true;
        }

        return false;
    }

    private void connected(Node node, Set<Node> visited) {
        visited.add(node);
        for (Node neighbour : node.getNeighbours()) {
            if (!visited.contains(neighbour))
                connected(neighbour, visited);
        }
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
