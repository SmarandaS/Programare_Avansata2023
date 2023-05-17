package homework;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public ClientThread(Socket clientSocket) throws IOException {
        this.clientSocket = clientSocket;
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    @Override
    public void run() {
        try {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Received request from client: " + inputLine);

                if (inputLine.equals("stop")) {
                    out.println("Server stopped");
                    System.exit(0);
                }
                else if(inputLine.equals("create game"))
                {

                }
                else if(inputLine.equals("join game"))
                {

                }
                else if(inputLine.equals("submit move"))
                {

                }
                    else {
                    out.println("Server received the invalid request: " + inputLine);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

