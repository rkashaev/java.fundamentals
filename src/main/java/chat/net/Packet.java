package chat.net;

import java.io.Serializable;

/**
 * Представляет собой пакет, которым обменивются клиент и сервер
 * @author RKashaev
 */
public class Packet implements Serializable {
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
}
