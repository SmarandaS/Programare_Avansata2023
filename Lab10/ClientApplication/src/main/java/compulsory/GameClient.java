package compulsory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GameClient {
    private final String host;
    private final int port;

    public GameClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() throws IOException {
        try (Socket socket = new Socket(host, port);
             BufferedReader keyboardInput = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader serverInput = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter serverOutput = new PrintWriter(socket.getOutputStream(), true)) {

            System.out.println("Connected to server at " + host + ":" + port);
            System.out.println("Enter commands (type 'exit' to stop server or 'stop' to stop the client):");

            String input;
            while ((input = keyboardInput.readLine()) != null) {
                if (input.equalsIgnoreCase("exit")) {
                    break;
                }
                serverOutput.println(input);
                System.out.println("Sent command to server: " + input);
                System.out.println("Server response: " + serverInput.readLine());
            }

            System.out.println("Closing connection...");
        }
    }

    public static void main(String[] args) throws IOException {
        GameClient gameClient = new GameClient("localhost", 1234);
        gameClient.start();
    }
}
