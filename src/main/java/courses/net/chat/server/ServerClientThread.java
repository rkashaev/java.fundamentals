package courses.net.chat.server;

import net.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.Map;

public class ServerClientThread extends Thread {
    private final Map<String, ServerClientThread> clientMap;
    private String myName;
    private Socket socket;
    private volatile Server server;


    private ObjectOutputStream oos;

    public ServerClientThread(Socket socket, Map<String, ServerClientThread> clients) {
        this.socket = socket;
        this.clientMap = clients;
    }

    @Override
    public void run() {
        //
        try (ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())) {

            // wait for new message
            Message message = (Message) ois.readObject();

            System.out.println(message);

            processMessage(message);

        } catch (SocketException e) {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void processMessage(Message msg) {
        switch (msg.type) {
            case CONNECT:
                String name = msg.name;
                System.out.println("A new client connected " + name);
                sendWelcome(name);

                clientMap.put(name, this);
                break;
        }
    }

    private void sendWelcome(String name) {
        try {
            oos = new ObjectOutputStream(socket.getOutputStream());

            Message msg = new Message();
            msg.type = Message.Type.MESSAGE;
            msg.name = "Server";
            msg.message = "Welcome, " + name;

            oos.writeObject(msg);
            oos.flush();

        } catch (IOException e) {
        }
    }
}
