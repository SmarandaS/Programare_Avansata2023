package compulsory;

public class Person implements Comparable<Node>, Node {

    String persName;

    @Override
    public String getName() {
        return persName;
    }

    @Override
    public int compareTo(Node p) {

        if (p == null) throw new NullPointerException();


        return (this.getName().compareTo(p.getName()));


    }


    public Person(String persName) {
        this.persName = persName;
    }

}
