package compulsory;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Node> nodes = new ArrayList();

        nodes.add(new Person("Maria"));
        nodes.add(new Company("Amazon"));
        nodes.add(new Person("Carol"));
        nodes.add(new Company("Apple"));
        nodes.add(new Person("Ana"));
        nodes.add(new Company("Microsoft"));

        for (Node nod : nodes) {
            if (nod instanceof Company)
                System.out.println("Company name: " + nod.getName());
            if (nod instanceof Person)
                System.out.println("Person name: " + nod.getName());
        }


    }
}