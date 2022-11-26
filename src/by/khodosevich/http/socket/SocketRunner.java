package by.khodosevich.http.socket;

import java.io.*;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class SocketRunner {
    public static void main(String[] args) {
        // http - 80
        // https - 443
        // tcp port

//        Inet4Address (Inet6Address) - works with our address, can send to our Socket as first argument
        InetAddress inetAddress = null;

        try {
            inetAddress = Inet4Address.getByName("localhost");
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }


        try (Socket socket = new Socket(inetAddress, 7777);
             OutputStream outputStream = socket.getOutputStream();
             InputStream inputStream = socket.getInputStream();
             DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
             DataInputStream dataInputStream = new DataInputStream(inputStream);
             Scanner scanner = new Scanner(System.in)
        ) {

           while (scanner.hasNextLine()){
               String requestToServer = scanner.nextLine();
               dataOutputStream.writeUTF(requestToServer);

               String responseFromServer = dataInputStream.readUTF();
               System.out.println(responseFromServer);
           }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
