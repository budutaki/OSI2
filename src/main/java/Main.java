import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
        {
            try {
                ServerSocket serverSocket = new ServerSocket(8080);
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                out.println("New connection accepted. Write your name");

                final String name = in.readLine();

                out.println(String.format("Hi %s, are you child? (yes/no)", name));

                final String answer = in.readLine();


                if (answer.equals("yes")) {
                    out.println(String.format("Welcome to the kids area, %s, Let's play!", name));
                }
                if (answer.equals("no")) {
                    out.println(String.format("Welcome to the adult zone, %s, Have a good rest, or a good working day!", name));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}
