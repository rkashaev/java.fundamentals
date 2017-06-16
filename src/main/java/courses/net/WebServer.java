package courses.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class WebServer {

    public static void main(String[] args) throws Throwable {
        final int port = 8080;
        ServerSocket ss = new ServerSocket(port);
        System.out.println("Server is started. Listening to port " + port);
        while (true) {
            Socket s = ss.accept();
            System.out.println("Client accepted");
            new Thread(new SocketProcessor(s)).start();
        }
    }

    private static class SocketProcessor implements Runnable {

        private Socket s;
        private InputStream is;
        private OutputStream os;

        private SocketProcessor(Socket s) throws Throwable {
            this.s = s;
            this.is = s.getInputStream();
            this.os = s.getOutputStream();
        }

        public void run() {
            try {
                readInputHeaders();
                writeResponse("<html><body><h1>Hello from Epam!</h1></body></html>");
            } catch (Throwable t) {
            } finally {
                quietClose(s);
            }
            System.err.println("Client processing finished");
        }

        private void writeResponse(String s) throws Throwable {
            String response = "HTTP/1.1 200 OK\r\n" +
                    "Server: My own Server/2009-09-09\r\n" +
                    "Content-Type: text/html\r\n" +
                    "Content-Length: " + s.length() + "\r\n" +
                    "Connection: close\r\n\r\n";
            String result = response + s;
            os.write(result.getBytes());
            os.flush();
        }

        private void readInputHeaders() throws Throwable {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            System.out.println("Request headers:");
            while (true) {
                String s = br.readLine();
                System.out.println(s);
                if (s == null || s.trim().length() == 0) {
                    break;
                }
            }
        }

        private void quietClose(Closeable s) {
            try {
                s.close();
            } catch (Throwable t) {
            }
        }
    }
}