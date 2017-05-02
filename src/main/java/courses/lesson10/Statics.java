package courses.lesson10;

public class Statics {
    public static Integer variable = 1;

    public static void method1() {
        System.out.println("method 1");
    }

    public static void main(String[] args) {
        System.out.println(new StaticsOneMoreTime().variable);

        StaticsOneMoreTime s1 = new StaticsOneMoreTime();

        StaticsOneMoreTime.method1();
    }

}

class StaticsOneMoreTime extends Statics {
    public static Integer variable = 2;

    public static void method1() {
        System.out.println("method 2");
    }

}