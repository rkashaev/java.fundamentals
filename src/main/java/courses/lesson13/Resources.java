package courses.lesson13;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Resources {
    public static void main(String[] args) throws Exception {
        URL resource = Resources.class.getResource("first.properties");

        printFile(resource);
    }

    private static void printFile(URL resource) throws IOException, URISyntaxException {
        Files.readAllLines(giveMePleaseAFile(resource), Charset.forName("cp1251")).forEach(System.out::println);
    }

    private static Path giveMePleaseAFile(URL resource) throws URISyntaxException {
        return Paths.get(resource.toURI());
    }
}
