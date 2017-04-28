package courses.lesson8;


public class SingletonTest {

    public static void main(String[] args) {
//        Singleton s1 = new Singleton();
        Singleton s1 = Singleton.getInstance();
        s1.method();
    }
}

class Singleton {
    private static Singleton instance;

    private Singleton() {
        System.out.println("I'm created!");
    }

    public static Singleton getInstance() {
        System.out.println("get instance invoked");
        if (instance == null) {
            instance = new Singleton();
        }
        String str = "вася";
        if ("вася".equals(str)) {
            System.out.println("Yes!");
        }
        return instance;
    }

    public void method() {

    }
}
