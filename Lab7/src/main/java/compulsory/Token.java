package compulsory;


/**
 * clasa Token este un wrapper pentru numere intregi, iar obiectele de tip Token vor popula SharedMemory
 */
public class Token {

    private int number;

    public Token(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Token{" +
                "number=" + number +
                '}';
    }
}
