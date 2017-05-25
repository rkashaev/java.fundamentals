package courses.tasks;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class CaesarCrypt {
    private final static int DEFAULT_OFFSET = 3;

    private static void usage() {
        System.out.println("usage parameters:");
        System.out.println("[-d] inputfile outputfile");
        System.out.println("where -d key means 'decode'");
    }

    public static void main(String[] args) {
        final int argc = args.length;
        if (argc < 2 || argc > 3) {
            usage();
            return;
        }
        int offset = DEFAULT_OFFSET;
        int t = 0;
        if ("-d".equals(args[0])) {
            offset *= -1;
            t++;
        }

        File inputFile = new File(args[t++]);
        File outputFile = new File(args[t++]);

        checkFiles(inputFile, outputFile);

        encodeFile(inputFile, outputFile, offset);

        System.out.printf("File %s successfully %scoded to %s", inputFile, offset > 0 ? "en" : "de", outputFile);
    }

    private static void checkFiles(File inputFile, File outputFile) {
        if (!inputFile.canRead()) {
            throw new IllegalArgumentException("Can't read file " + inputFile);
        }
        if (!outputFile.canWrite()) {
            throw new IllegalArgumentException("Can't write file " + outputFile);
        }
    }

    private static void encodeFile(File inputFile, File outputFile, int offset) {
        try {
            String str = new String(Files.readAllBytes(inputFile.toPath()));
            try (BufferedWriter wr = Files.newBufferedWriter(outputFile.toPath())) {
                wr.write(caesar(str, offset));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Provides simple Caesar encryptors
     * @param string a string to encrypt
     * @param offset offset for Caesar algorithm
     * @return Caesar-cipher encrypted string
     */
    public static String caesar(String string, int offset) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            sb.append((char) (c + offset));
        }
        return sb.toString();
    }
}
