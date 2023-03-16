package homework;

import java.time.LocalDate;

public class Designer extends Person {

    public String designSchool;

    public Designer(String persName, String dateOfBirth, String designSchool) {
        super(persName, dateOfBirth);
        this.designSchool = designSchool;
    }

    public Designer() {
    }
}
