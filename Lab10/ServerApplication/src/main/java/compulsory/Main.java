package compulsory;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        GameServer server = new GameServer(1234);
        server.start();
    }

}