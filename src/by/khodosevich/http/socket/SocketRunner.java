package by.khodosevich.http.socket;

import java.io.*;
import java.net.Socket;

public class SocketRunner {
    public static void main(String[] args) {
        // http - 80
        // https - 443
        // tcp port

        try {
            Socket socket = new Socket("google.com", 80);

            OutputStream outputStream = socket.getOutputStream();
            InputStream inputStream = socket.getInputStream();

            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            DataInputStream dataInputStream = new DataInputStream(inputStream);

            dataOutputStream.writeUTF("Hello world");

            byte[] response = dataInputStream.readAllBytes();
            System.out.println(response.length);

            socket.close();
            outputStream.close();
            inputStream.close();
            dataOutputStream.close();
            dataInputStream.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
