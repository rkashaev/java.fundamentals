package courses.lesson8;

public class Varargs {

    static void method(int a, int ... f) {
        System.out.println("Method 1");
        System.out.println(f.getClass());
    }

    static void method(int a) {
        System.out.println("Method 2");
    }

    public static void main(String[] args) {
        Varargs.method(1);

        Varargs.method(1, new int[]{1,2,3,4});
    }
}
