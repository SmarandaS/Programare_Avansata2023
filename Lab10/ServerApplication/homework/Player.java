package homework;

import java.util.Scanner;

public class Player {
    private String name;
    private char symbol;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public int makeMove() {
        System.out.print("Enter your move (1-196): "); //tabla are 13x13=196 de intersectii. Se va selecta intersectia unde jucatorul doreste sa plaseze piesa de joc
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
