package courses.net.chat.net;

import java.io.Serializable;

public class Message implements Serializable {
    // тип сообщения
    public static enum Type {
        CONNECT,
        DISCONNECT,
        USERLIST,
        MESSAGE
    }

    // тип сообщения
    public Type type;
    // имя отправителя
    public String name;
    // сообщение 
    public String message;
    // какие-либо данные в пакете (опционально)
    public Object data;

    @Override
    public String toString() {
        return "Message{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
