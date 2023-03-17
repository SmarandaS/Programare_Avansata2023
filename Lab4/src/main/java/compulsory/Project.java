package compulsory;

/**
 * clasa project contine un nume, getter pentru acesta, un constructor gol si unul cu nume, si functie de comparare
 */
public class Project implements Comparable<Node>, Node {

    String name;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int compareTo(Node p) {

        if (p == null) throw new NullPointerException();


        return (this.getName().compareTo(p.getName()));


    }

    public Project(String name) {
        this.name = name;
    }

    public Project() {
    }
}
