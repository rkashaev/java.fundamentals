package courses.net.chat.server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Простейший консольный сервер
 * @author RKashaev
 */
public class Server {
    // порт по умолчанию, через который будет происходить общение
    public static final int PORT = 12345;
    // сокет для прослушивания подключений
    private ServerSocket serverSocket;
    // коллекция клиентов по именам
    private Map<String, ServerClientThread> clients;

    public Server() {
        try {
            clients = new ConcurrentHashMap<>();
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
            ServerClientThread ct = new ServerClientThread(socket, clients);
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
