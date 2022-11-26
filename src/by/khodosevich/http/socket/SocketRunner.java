package by.khodosevich.http.socket;

import java.io.*;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketRunner {
    public static void main(String[] args) {
        // http - 80
        // https - 443
        // tcp port

//        Inet4Address (Inet6Address) - works with our address, can send to our Socket as first argument
        InetAddress inetAddress = null;

        try {
            inetAddress = Inet4Address.getByName("google.com");
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }


        try (Socket socket = new Socket(inetAddress, 80);
             OutputStream outputStream = socket.getOutputStream();
             InputStream inputStream = socket.getInputStream();
             DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
             DataInputStream dataInputStream = new DataInputStream(inputStream);
        ) {

            dataOutputStream.writeUTF("Hello world");
            byte[] response = dataInputStream.readAllBytes();
            System.out.println(response.length);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
