package courses.lesson4;

public class Transmission {

    public static void main(String[] args) {
        int i = 0;

        System.out.println(i);

        i = helloI(i);

        System.out.println(i);
    }

//    private static int helloI(Integer i) {
//        System.out.println("hello - start: " + i);
//        i[0] = 5;
//        System.out.println("hello - end: " + i);
//        return i[0];
//    }

    private static int helloI(int i) {
        System.out.println("hello - start: " + i);
        i = 5;
        System.out.println("hello - end: " + i);
        return i;
    }
}
