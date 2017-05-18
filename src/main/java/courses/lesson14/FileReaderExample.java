package courses.lesson14;

import java.io.*;
import java.net.URISyntaxException;

public class FileReaderExample {
    public static void main(String[] args) {
//        File file = new File(cls.getResource("wiki.html").toURI());

        try (BufferedReader br = new BufferedReader(getResource("wiki.html"))) {
            while (br.ready()) {
                String string = br.readLine();
                System.out.println(string);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static InputStreamReader getResource(String name) {
        Class<FileReaderExample> cls = FileReaderExample.class;
        return new InputStreamReader(cls.getResourceAsStream(name));
    }
}
