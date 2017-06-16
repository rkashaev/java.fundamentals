package chat.server;

import rk.epam.chat.net.ClientThread;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * Простейший консольный сервер
 * @author RKashaev
 */
public class Server {
    // порт по умолчанию, через который будет происходить общение
    public static final int PORT = 12345;
    // сокет для прослушивания подключений
    private ServerSocket serverSocket;
    // коллекция всех клиентов по именам
    public Map<String, ClientThread> clientMap;

    public Server() {
        try {
            clientMap = new HashMap<>();
            // создаем новый сокет
            serverSocket = new ServerSocket(PORT);
            // узнаем свой собственный IP адрес
            InetAddress ia = InetAddress.getLocalHost();
            System.out.printf("Чат-сервер стартовал. Доступ по адресу: %s:%d\n", ia.getHostAddress(), PORT);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Дожидается подключения нового клиента и создает поток для его обработки
     */
    public void waitClient() {
        try {
            // создает новый сокет для клиента (только когда клиент подключится)
            Socket socket = serverSocket.accept();
            // создаем наш поток-обработчик 
            ClientThread ct = new ClientThread("Chat server by RKashaev v1.0", socket, this);
            // запускаем его
            ct.start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public static void main(String args[]) {
        // тут просто создаем новый сервер
        Server srv = new Server();
        // в бесконечном цикле гоняем его
        while (true) {
            // ждем и обслуживаем очередного клиента
            srv.waitClient();
        }
    }
    
}
