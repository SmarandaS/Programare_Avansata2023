package compulsory;

/**
 * interfata node contine un getter pentru nume si o functie comparator, pentru a putea accesa functia de comparare din Person si Student fara a mai
 * casta obiectele de tip Node la una din cele 2 clase
 */
public interface Node {

    public int compareTo(Node p);

    String getName();

}
