package homework;

import java.util.*;

/**
 * clasa problem contine un constructor gol, un HashMap de preferinte(fiecare student cu lista lui de proiecte), un TreeSet cu proiecte si
 * un ArrayList de studenti, gettere si settere pentru acestea. Mai contine de asemenea metode de afisare a studentilor si proiectelor,
 * pentru returnarea numarului de preferinte ale unui student, pentru aflarea numarului mediu de preferinte si pentru afisarea preferintelor
 * unui student.
 */
public class Problem {

    Map<Student, List<Project>> prefMap = new HashMap<>();

    Set<Project> projectList = new TreeSet<>();
    List<Student> studentList = new ArrayList<>();

    public void setProjectList(Set<Project> projectList) {

        this.projectList = projectList;
    }

    public void setStudentList(List<Student> studentList) {

        this.studentList = studentList;
    }

    public Map<Student, List<Project>> getPrefMap() {

        return prefMap;
    }

    public Set<Project> getProjectList() {

        return projectList;
    }

    public List<Student> getStudentList() {

        return studentList;
    }

    public void printStudents() {
        for (Node student : studentList)
            System.out.println(student.getName());
    }
    public void printProjects() {
        for (Node project : projectList)
            System.out.println(project.getName());
    }

    public int getStudNumberOfPref(Student student)
    {
        return prefMap.get(student).size();
    }
    public double averagePrefNumber(Map<Student, List<Project>> preferences)
    {
         return (double) preferences.entrySet().stream().mapToDouble(e -> e.getValue().size()).average().orElse(0);

    }

    public void printPreferences(Student student)
    {
        for(Node project: prefMap.get(student))
        {
            System.out.println(project.getName());
        }
    }

    public Problem() {
    }
}
