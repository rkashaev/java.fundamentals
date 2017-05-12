package courses.lesson12;

public class Formatters {
    public static void main(String[] args) {
        String a = "abc";
        String b = "def";
        int c = 100;

        System.out.println("a=" + a + "; b=" + b + "; c=" + c);

        System.out.println(String.format("a=%s; b=%s; c=%d", a, b, c));

        System.out.printf("a=%s; b=%s; c=%d\n", a, b, c);
    }
}
