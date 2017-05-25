package courses.lesson14;


import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class NioFileReaderExample {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get(getResource("wiki.html"));

        List<String> strings = Files.readAllLines(path);

        for (String s : strings) {
            System.out.println(s);
        }
    }



    private static URI getResource(String name) throws URISyntaxException {
        Class<FileReaderExample> cls = FileReaderExample.class;
        return cls.getResource(name).toURI();
    }
}
