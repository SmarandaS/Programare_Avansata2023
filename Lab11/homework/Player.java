package homework;

import java.util.List;

public class Player {


    private String name;
    private String symbol;

    public Player()
    {

    }

    public Player(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }


}
