package courses.lesson7.inheritance;

public class ConstructorFlow {

    public static void main(String... args) {
        C c = new C();
        // will return 1 4 7 2 5 6 8 9
    }
}

class A {
    static {
        System.out.print("1");
    }

    A() {
        System.out.print("2");
    }

    A(String str) {
        this();
        System.out.print("3");
    }
}

class B extends A {
    static {
        System.out.print("4");
    }

    B() {
        System.out.print("5");
    }

    B(String str) {
        this();
        System.out.print("6");
    }
}

class C extends B {
    static {
        System.out.print("7");
    }

    {
        System.out.print("8");
    }

    C() {
        super("Hello");
        System.out.print("9");
    }
}
