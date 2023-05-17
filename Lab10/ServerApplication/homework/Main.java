package homework;

import compulsory.GameServer;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Board tabla = new Board(14);
        GameServer server = new GameServer(1234);
        server.start();
    }

}