package courses.net;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Networking {
    public static void main(String[] args) throws IOException {
        useSockets("horstmann.com", 80);

//        useUrlConnection("horstman.com");
    }

    private static void useSockets(String host, int port) throws IOException {


        try (Socket socket = new Socket(host, port);
             PrintWriter pw = new PrintWriter(socket.getOutputStream());
             InputStream is = socket.getInputStream();) {

            pw.println("GET / HTTP/1.1");
            pw.println("HOST: " + host);
            pw.println();
            pw.flush();


            printFromInputStream(is);

        }
    }

    private static void useUrlConnection(String urlStr) throws IOException {
        URL url = new URL("http://" + urlStr);
        URLConnection urlConnection = url.openConnection();

        try (InputStream is = urlConnection.getInputStream()) {

            printFromInputStream(is);
        }
    }

    private static void printFromInputStream(InputStream is) throws IOException {
        Scanner sc = new Scanner(is);

        while (sc.hasNext()) {
            System.out.println(sc.nextLine());
        }
    }
}
