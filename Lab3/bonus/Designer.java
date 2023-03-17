package bonus;

/**
 * clasa designer extinde clasa person si include si scoala de  design urmata de designer
 */
public class Designer extends Person {

    public String designSchool;

    public Designer(String persName, String dateOfBirth, String designSchool) {
        super(persName, dateOfBirth);
        this.designSchool = designSchool;
    }

    public Designer() {
    }
}
