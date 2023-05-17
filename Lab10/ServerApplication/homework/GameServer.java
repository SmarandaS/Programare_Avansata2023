package homework;



import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class GameServer {

    private ServerSocket serverSocket;

    public GameServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);         //https://stackoverflow.com/questions/2675362/how-to-find-an-available-port

        System.out.println("Server started on port " + port);
    }

    public void start() throws IOException {
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("New client connected: " + clientSocket);

            // thread nou pentru client
            ClientThread clientThread = new ClientThread(clientSocket);
            clientThread.start();
        }
    }

}
