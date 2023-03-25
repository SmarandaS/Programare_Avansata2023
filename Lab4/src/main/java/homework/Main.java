package homework;


import com.github.javafaker.Faker;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * clasa main contine metoda main, unde, cu ajutorul streamurilor si fakerului cream proiectele si studentii(si le dam o lista de dimensiune
 * aleatorie de preferinte alese aleator), apoi folosind <i>Collections.sort</i> sortam studentii(plasati intr-un LinkedList). Pentru
 * proiecte nu este cazul sa le sortam, deorece sunt pastrate intr-un TreeSet, care sorteaza in mod automat obiectele din el. Proiectele si
 * studentii sunt asignate instantei <i>prob</i> a problemei. Apoi sortam studentii in functie de numarul de preferinte pe care le au si
 * ii afisam, dupa care afisam studentii cu nr de preferinte sub medie. La final, in functie de ordinea preferintelor fiecarui student si
 * valabilitatea preferintelor pe care le au, le este asignat primul proiect inca valabil din lista lor de preferinte.
 */
public class Main {
    public static void main(String[] args) {

        Faker faker = new Faker();
        Problem prob = new Problem();
        Random rand = new Random();

        TreeSet<Project> projects = IntStream.rangeClosed(0, 6)
                .mapToObj(i -> new Project(faker.book().title())).collect(Collectors.toCollection(TreeSet::new));

        List<Project> shufflingList = new ArrayList<>(projects);

        LinkedList<Student> students = IntStream.rangeClosed(0, 6)
                .mapToObj(i -> {
                    Student stud = new Student(faker.name().fullName());
                    int randInt = rand.nextInt(projects.size()) + 1;
                    Collections.shuffle(shufflingList);
                    List<Project> studPref = new ArrayList<>();
                    for (int j = 0; j < randInt; j++) {
                        studPref.add(shufflingList.get(j));
                    }
                    prob.prefMap.put(stud, studPref);

                    return stud;
                }).collect(Collectors.toCollection(LinkedList::new));


        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.compareTo(o2);
            }
        });

        double average = prob.averagePrefNumber(prob.getPrefMap());

        List<Student> underAvgPref = students.stream().filter(student -> prob.getStudNumberOfPref(student) < average).toList();

        prob.setStudentList(students);
        prob.setProjectList(projects);



        List<Map.Entry<Student, List<Project>>> projLists = new ArrayList<>(prob.prefMap.entrySet());

        Collections.sort(projLists, new Comparator<Map.Entry<Student, List<Project>>>() {
            public int compare(Map.Entry<Student, List<Project>> e1, Map.Entry<Student, List<Project>> e2) {
                return Integer.compare(e1.getValue().size(), e2.getValue().size());
            }
        });


        for (Map.Entry<Student, List<Project>> entry : projLists) {
            System.out.println("The student: " + entry.getKey().getName());
            System.out.println("Has the preferences: ");
            prob.printPreferences(entry.getKey());
            System.out.println("\n");
        }

        System.out.println("The average number of preferences is: " + average);
        System.out.println("The students with a number of preferences below average are: ");

        for(Student student : underAvgPref)
        {
            if(prob.getStudNumberOfPref(student) == 1)
            {
                System.out.println(student.getName() + " has 1 preference");
            }
            else
            {
                System.out.println(student.getName() + " has " + prob.getStudNumberOfPref(student) + " preferences");
            }

        }

        System.out.println("\n");

        List<String> alreadyChosen = new ArrayList<String>();

        for (Map.Entry<Student, List<Project>> value : projLists)
        {
            System.out.println("\n");
            System.out.println("Student: " + value.getKey().getName());
            for(Project proj : value.getValue())
            {
                if(!alreadyChosen.contains(proj.getName()))
                {
                    alreadyChosen.add(proj.getName());
                    System.out.println("The assigned project is: " + proj.getName());
                    break;
                }
            }
        }

    }

}