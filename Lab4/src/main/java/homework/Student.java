package homework;



/**
 * clasa student contine un nume, getter pentru acesta, un constructor cu nume, si functie de comparare
 */
public class Student implements Comparable<Node>, Node {

    String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Node p) {

        if (p == null) throw new NullPointerException();


        return (this.getName().compareTo(p.getName()));


    }

    public Student(String name) {

        this.name = name;
    }

}
