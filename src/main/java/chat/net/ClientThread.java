package chat.net;

import chat.client.ChatForm;
import chat.server.Server;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * Поток, который инкапсулирует в себе сетевые операции
 * @author RKashaev
 */
public class ClientThread extends Thread {
    private String myName;
    private Socket socket;
    private volatile Server server; // volatile значит, в многопоточной среде эта переменная не будет кешироваться
    private ChatForm clientForm;
    
    private ObjectInputStream ois;
    private ObjectOutputStream oos;

    /**
     * Конструктор для сервера
     * @param myName
     * @param socket
     * @param srv ссылка на сервер
     */
    public ClientThread(String myName, Socket socket, Server srv) {
        this.myName = myName;
        this.socket = socket;
        this.server = srv;
        try {
			// откроем поток на запись
			oos = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            System.out.println("Создан новый поток для: " + myName);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    /**
     * Конструктор для клиента
     * @param myName
     * @param socket
     * @param cf ссылка на клиента
     */
    public ClientThread(String myName, Socket socket, ChatForm cf) {
        this.myName = myName;
        this.socket = socket;
        this.clientForm = cf;
        try {
			// откроем поток на запись
			oos = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            System.out.println("Создан новый поток для: " + myName);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    @Override
    public void run() {
        // тут своя логика при запуске
        try {
			// создаем объектный входной поток (будет здесь ждать, пока кто-то не отправит сюда объект)
			ois = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));

			// пока поток жив
			while (isAlive()) {
				// принимаем сообщения
                Packet packet = (Packet) ois.readObject();
				if (packet != null) {
                    String userName = packet.name;
					switch (packet.type) {
                        case CONNECT:
                            // сервер получает сообщение о подключении
                            myName = userName;
                            System.out.printf("ServerThread.%s: подключился новый клиент: %s\n", myName, userName);
                            // добавляем себя в коллекцию потоков
                            server.clientMap.put(userName, this);
                            // теперь рассылаем всем сообщение о пришествии всем клиентам
                            String msg = "*к чату присоединился новый клиент: " + userName + "*";
                            for (ClientThread chatThread : server.clientMap.values()) {
                                chatThread.sendUserlist(userName, msg);
                            }
                            break;
                        case DISCONNECT:
                            // код выполнится в блоке finally
                            return;
                        case USERLIST:
                            // клиент принял список пользователей
                            clientForm.println(packet.message);
                            break;
                        case MESSAGE:
                            // сервер/клиент принял сообщение
                            if (server != null) {
                                // если это сервер, разошлем сообщение всем юзерам
                                for (ClientThread chatThread : server.clientMap.values()) {
                                    chatThread.sendMessage(userName, packet.message);
                                }
                            } else if (clientForm != null) {
                                // если мы клиент, то просто печатаем сообщение
                                msg = String.format("%s: %s", userName, packet.message);
                                clientForm.println(msg);
                            }
                            break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// закрываем сокеты и все остальное
			safeClose(socket);
			safeClose(ois);
			safeClose(oos);
            // удаляем себя из очереди сервера
            if (server != null) {
                // сервер принял сообщение о выходе
                System.out.printf("ServerThread.%s: клиент вышел из чата: %s\n", myName, myName);
                // убираем себя из коллекции потоков сервера
                server.clientMap.remove(myName);
                // теперь рассылаем всем сообщение о пришествии всем клиентам
                String msg = "*чат покинул клиент: " + myName + "*";
                // теперь всем другим потокам скажем, что кто-то ушел
                for (ClientThread chatThread : server.clientMap.values()) {
                    chatThread.sendUserlist(myName, msg);
                }
            }
		}
    }

    /**
     * Метод, который закрывает все шума и пыли
     * @param resource 
     */
    private void safeClose(Closeable resource) {
        try {
            resource.close();
        } catch (IOException ex) {}
    }
    
    /**
     * Новое сообщение серверу о подключении
     */
    public void sendConnect() {
        try {
            Packet p = new Packet();
            p.type = Packet.Type.CONNECT;
            p.name = myName;
            // отправляем сообщение...
			oos.writeObject(p);
			oos.flush();
        } catch (Exception e) {
			e.printStackTrace();
		} 
    }
    

    private void sendUserlist(String name, String msg) {
        try {
            Packet p = new Packet();
            p.type = Packet.Type.USERLIST;
            p.name = name;
            p.message = msg;
            // вытащим список пользователей и положим его
            List<String> userList = new ArrayList<>(server.clientMap.keySet());
            p.data = userList;
            // отправляем сообщение...
			oos.writeObject(p);
			oos.flush();
        } catch (Exception e) {
			e.printStackTrace();
		} 
    }

    /**
     * Отправка сообщения
     * @param message 
     */
    public void sendMessage(String name, String message) {
        try {
            Packet p = new Packet();
            p.type = Packet.Type.MESSAGE;
            p.name = name;
            p.message = message;
            // отправляем сообщение...
			oos.writeObject(p);
			oos.flush();
        } catch (Exception e) {
			e.printStackTrace();
		} 
    }
}
