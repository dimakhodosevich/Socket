package by.khodosevich.http.client;

import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UrlExample {
    public static void main(String[] args) throws IOException {

//        checkFile();
        checkGoogle();
    }

    private static void checkFile() throws IOException {
        // Can use URL for read our files!!!
        URL url = new URL("file:E:\\Servlet\\Servlet\\src\\by\\khodosevich\\http\\datagram\\DatagramRunner.java");
        URLConnection urlConnection = url.openConnection();
        System.out.println(new String(urlConnection.getInputStream().readAllBytes()));
    }

    private static void checkGoogle() throws IOException {
        URL url = new URL("https://google.com");

        URLConnection urlConnection = url.openConnection();

//        urlConnection.setDoOutput(true); //if we want to send body to google.com
//
//        try(OutputStream outputStream = urlConnection.getOutputStream()){
//              outputStream.write("---Code we want to send");
//        }catch (IOException e){
//            System.out.println(e);
//        }

        System.out.println(new String(urlConnection.getInputStream().readAllBytes()));
    }
}
