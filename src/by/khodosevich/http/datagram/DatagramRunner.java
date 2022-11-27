package by.khodosevich.http.datagram;

import java.io.IOException;
import java.net.*;

public class DatagramRunner {
    public static void main(String[] args) {
        try (DatagramSocket datagramSocket = new DatagramSocket()) {

            int size = 515;
            int port = 7777;

            byte bytes[] = new byte[size];

            String msg = "Hello from UDP!!!";

            for (int i = 0; i < msg.length(); i++) {
                bytes[i] = msg.getBytes()[i];
            }

            InetAddress localhost = Inet4Address.getByName("localhost");

            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, localhost, port);
            datagramSocket.send(datagramPacket);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
