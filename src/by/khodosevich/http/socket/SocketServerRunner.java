package by.khodosevich.http.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SocketServerRunner {
    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(7777);
             Socket socket = serverSocket.accept();
             DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
             DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
             Scanner scanner = new Scanner(System.in);
             ) {
            String s = dataInputStream.readUTF();

            while(!s.equals("stop")){
                System.out.println("Client request: " + s);
                String responseFromServer = scanner.nextLine();

                dataOutputStream.writeUTF(responseFromServer);
                s =  dataInputStream.readUTF();
            }

            System.out.println("Close server. Bye, bye!!!");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
