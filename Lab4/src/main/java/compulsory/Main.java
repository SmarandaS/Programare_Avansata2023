package compulsory;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * clasa main contine metoda mail, unde, cu ajutorul streamurilor cream studentii si proiectele din exemplu, apoi folosind <i>Collections.sort</i>
 * sortam studentii(plasati intr-un LinkedList). Pentru proiecte nu este cazul sa le sortam, deorece sunt pastrate intr-un TreeSet, care sorteaza in
 * mod automat obiectele din el. Apoi afisam si sortam proiectele si studentii
 */
public class Main {
    public static void main(String[] args) {

        LinkedList<Student> students = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Student("S" + i)).collect(Collectors.toCollection(LinkedList::new));


        TreeSet<Project> projects = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> new Project("P" + i)).collect(Collectors.toCollection(TreeSet::new));


        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.compareTo(o2);
            }
        });

        for (Student student : students) {
            System.out.println(student.getName());
        }

        System.out.println("\n");

        for (Project project : projects) {
            System.out.println(project.getName());
        }


    }
}