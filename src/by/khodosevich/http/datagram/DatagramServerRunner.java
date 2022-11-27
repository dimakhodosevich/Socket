package by.khodosevich.http.datagram;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Arrays;

public class DatagramServerRunner {
    public static void main(String[] args) {
        try (DatagramSocket datagramSocket = new DatagramSocket(7777);
        ) {

            byte[] buffer = new byte[512];
            DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
            datagramSocket.receive(datagramPacket);

            byte[] answer = datagramPacket.getData();

            System.out.println(new String(answer));

        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
