package compulsory;

public class Company implements Comparable<Node>, Node {

    String compName;

    @Override
    public String getName() {

        return compName;
    }

    @Override
    public int compareTo(Node c) {

        if (c == null) throw new NullPointerException();

        return (this.getName().compareTo(c.getName()));

    }

    public Company(String compName) {
        this.compName = compName;
    }


}
