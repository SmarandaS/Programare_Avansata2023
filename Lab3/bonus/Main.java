package bonus;


import java.time.LocalDate;
import java.util.*;

/**
 * clasa main include o lista de noduri, pe care le afiseaza, o retea cu noduri multiple si relatii intre acestea, o sortare a nodurilor si
 * o afisare a tutuor nodurilor retelei sortate in functie de numarul de relatii pe care le au.
 * Mainul mai afiseaza si pentru fiecare nod relatiile pe care le are si numarul acestora
 * La final apelam metoda de verificare a existentei punctelor de articulatie din retea (din Network) si in functie de
 * rezultatul ei, afisam daca exista sau nu astfel de puncte in reteaua noastra.
 */
public class Main {
    public static void main(String[] args) {


        List<Node> nodes = new ArrayList();

        nodes.add(new Person("Maria", "16.05.2002"));
        nodes.add(new Company("Amazon"));
        nodes.add(new Person("Carolina", "26.01.2002"));
        nodes.add(new Person("Andrei", "27.10.2001"));
        nodes.add(new Person("Ana", "06.03.2001"));
        nodes.add(new Person("Cosmin", "20.09.2000"));
        nodes.add(new Person("Mihaela", "16.11.2004"));
        nodes.add(new Designer("Karla", "19.05.2003", "Versailles"));

        for (Node nod : nodes) {
            if (nod instanceof Company)
                System.out.println("Company name: " + nod.getName());
            if (nod instanceof Person)
                System.out.println("Person name: " + nod.getName() + " and date of birth: " + ((Person) nod).getDateOfBirth());
        }

        Network retea = new Network();

        System.out.println("\n");

        for (int i = 0; i < nodes.size(); i++) {
            retea.addNode(nodes.get(i));
        }

        ((Person) nodes.get(0)).addRelationship(nodes.get(2), "sister");
        ((Person) nodes.get(2)).addRelationship(nodes.get(0), "sister");
        ((Person) nodes.get(0)).addRelationship(nodes.get(1), "employer");
        ((Company) nodes.get(1)).addRelationship(nodes.get(0), "employee");
        ((Person) nodes.get(2)).addRelationship(nodes.get(1), "employer");
        ((Company) nodes.get(1)).addRelationship(nodes.get(2), "employee");
        ((Person) nodes.get(3)).addRelationship(nodes.get(1), "employer");
        ((Company) nodes.get(1)).addRelationship(nodes.get(3), "employee");
        ((Person) nodes.get(4)).addRelationship(nodes.get(1), "employer");
        ((Company) nodes.get(1)).addRelationship(nodes.get(4), "employee");
        ((Person) nodes.get(5)).addRelationship(nodes.get(1), "employer");
        ((Company) nodes.get(1)).addRelationship(nodes.get(5), "employee");
        ((Person) nodes.get(6)).addRelationship(nodes.get(1), "employer");
        ((Company) nodes.get(1)).addRelationship(nodes.get(6), "employee");
        ((Person) nodes.get(7)).addRelationship(nodes.get(1), "employer");
        ((Company) nodes.get(1)).addRelationship(nodes.get(7), "employee");


        for (Node nod : retea.getNodes()) {
            if (nod instanceof Person) {
                System.out.println("The person: " + nod.getName());
                for (Map.Entry<Node, String> entry : ((Person) nod).getRelationships().entrySet()) {
                    System.out.println("Has the relation: " + entry.getKey().getName() + " - " + entry.getValue());
                }
                if (((Person) nod).numberOfRelations() == 1) {
                    System.out.println("Has " + ((Person) nod).numberOfRelations() + " relationship");
                } else {
                    System.out.println("Has " + ((Person) nod).numberOfRelations() + " relationships");
                }

            }
            if (nod instanceof Company) {
                System.out.println("The company: " + nod.getName());
                for (Map.Entry<Node, String> entry : ((Company) nod).getRelationships().entrySet()) {
                    System.out.println("Has the relation: " + entry.getKey().getName() + " - " + entry.getValue());
                }
                if (((Company) nod).numberOfRelations() == 1) {
                    System.out.println("Has " + ((Company) nod).numberOfRelations() + " relationship");
                } else {
                    System.out.println("Has " + ((Company) nod).numberOfRelations() + " relationships");
                }
            }
            System.out.println("\n");
        }

        Collections.sort(retea.getNodes(), new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                Integer o1Rel = 0;
                Integer o2Rel = 0;

                if (o1 instanceof Person) {
                    o1Rel = ((Person) o1).numberOfRelations();
                }
                if (o1 instanceof Company) {
                    o1Rel = ((Company) o1).numberOfRelations();
                }
                if (o2 instanceof Person) {
                    o2Rel = ((Person) o2).numberOfRelations();
                }
                if (o2 instanceof Company) {
                    o2Rel = ((Company) o2).numberOfRelations();
                }

                return (o2Rel - o1Rel);


            }
        });


        for (Node node : retea.getNodes()) {
            if (node instanceof Person) {
                if (((Person) node).numberOfRelations() == 1) {
                    System.out.println(node.getName() + " has " + ((Person) node).numberOfRelations() + " relationship");
                } else {
                    System.out.println(node.getName() + " has " + ((Person) node).numberOfRelations() + " relationships");
                }
            }

            if (node instanceof Company) {
                if (((Company) node).numberOfRelations() == 1) {
                    System.out.println(node.getName() + " has " + ((Company) node).numberOfRelations() + " relationship");
                } else {
                    System.out.println(node.getName() + " has " + ((Company) node).numberOfRelations() + " relationships");
                }
            }

        }


        System.out.println("\n");

        if (retea.isConnected()) {
            System.out.println("There is at least one articulation point in the network");
        } else {
            System.out.println("There are no articulation points in the network");
        }


    }
}
