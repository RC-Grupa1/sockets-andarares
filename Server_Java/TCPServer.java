import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPServer {
    public static void main(String[] args) {
        int port = 5000;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server pornit! Aștept conexiunea pe portul " + port + "...");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Clientul s-a conectat cu succes!");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream(), "UTF-8"));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream(), "UTF-8"));
            Scanner scanner = new Scanner(System.in, "UTF-8");

            while (true) {
                String clientMessage = in.readLine();

                if (clientMessage == null || clientMessage.trim().equalsIgnoreCase("exit")) {
                    System.out.println("Clientul a ieșit din chat. Închid conexiunea...");
                    break;
                }

                System.out.println("Colegul (Python): " + clientMessage);

                System.out.print("Tu (Java): ");
                String myMessage = scanner.nextLine();

                out.write(myMessage + "\n");
                out.flush();

                if (myMessage.trim().equalsIgnoreCase("exit")) {
                    System.out.println("Ai ieșit din chat. Închid conexiunea...");
                    break;
                }
            }
            clientSocket.close();
            scanner.close();

        } catch (IOException e) {
            System.out.println("Eroare la server: " + e.getMessage());
        }
    }
}