package courses.lesson12;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class Strings {
    public static void main(String[] args) throws UnsupportedEncodingException {
        stringCreation();
        symbolReadingMethods();
    }

    private static void symbolReadingMethods() throws UnsupportedEncodingException {
        byte[] data3 = {(byte) 0xE3, (byte) 0xEE};
        String str = "Мама мыла раму1!";
        byte[] strCP866 = str.getBytes(Charset.forName("cp866"));
        byte[] strCP1251 = str.getBytes("cp1251");

        for (byte b : strCP866) System.out.print(b + " ");
        System.out.println();
        for (byte b : strCP1251) System.out.print(b + " ");
        System.out.println();

        System.out.println(new String(strCP866));
        System.out.println(new String(strCP866, "cp866"));
        System.out.println(new String(strCP1251));

    }

    private static void stringCreation() throws UnsupportedEncodingException {
        String str1 = new String();
        char[] data1 = {'a', 'b', 'c', 'd', 'e', 'f'};
        System.out.println(new String(data1, 2, 3)); // "cde"
        char[] data2 = {'\u004A', '\u0041', '\u0056', '\u0041'};
        System.out.println(new String(data2)); // "JAVA"
        byte ascii[] = {65, 66, 67, 68, 69, 70};
        System.out.println(new String(ascii)); // ”ABCDEF”
        byte[] data3 = {(byte) 0xE3, (byte) 0xEE};
        System.out.println(new String(data3, "CP1251")); // ”го”
        System.out.println(new String(data3, "CP866")); // ”ую”
    }
}
