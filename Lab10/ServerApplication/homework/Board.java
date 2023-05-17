package homework;

public class Board {
    private char[][] grid;
    private int size;
    private int movesCount;

    public Board(int size) {
        this.size = size;
        this.grid = new char[size][size];
        this.movesCount = 0;
        initializeGrid();
    }

    private void initializeGrid() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                grid[row][col] = '-';
            }
        }
    }

    public boolean isFull() {
        return movesCount == size * size;
    }

    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size && grid[row][col] == '-';
    }

    public void makeMove(int row, int col, char symbol) {
        grid[row][col] = symbol;
        movesCount++;
    }

    public boolean hasWon(int row, int col, char symbol) {
        return checkRow(row, symbol) || checkColumn(col, symbol) || checkDiagonals(row, col, symbol);
    }

    private boolean checkRow(int row, char symbol) {
       //verific daca am 5 in a row pe rand
    }

    private boolean checkColumn(int col, char symbol) {
        //verific daca am 5 in a row pe coloana
    }

    private boolean checkDiagonals(int row, int col, char symbol) {
        //verific daca am 5 in a row pe una din diagonale
    }

    public void printBoard() {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(grid[row][col] + " ");
            }
            System.out.println();
        }
    }
}

