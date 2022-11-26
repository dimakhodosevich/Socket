package by.khodosevich.http.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerRunner {
    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(7777);
             Socket socket = serverSocket.accept();
             DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream();
             DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());) {

            System.out.println("Client request: " + dataInputStream.readUTF());
            dataOutputStream.writeUTF("Hello from server!!!");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
