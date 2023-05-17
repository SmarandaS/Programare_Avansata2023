package homework;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    boolean gameOver = false;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        this.board = new Board(15);
    }

    public void start() {
        System.out.println("Game started!");
        while (!isGameOver()) {

        }
        System.out.println("Game over.");
    }

    private boolean isGameOver() {
        return board.isFull() || gameOver;
    }
}

