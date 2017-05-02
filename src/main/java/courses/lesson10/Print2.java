package courses.lesson10;

class Print1 {
    private void print() {
        System.out.println(777);
    }

    void print(Print1 p) {
        p.print();
    }
}

public class Print2 extends Print1 {
    void print() {
        System.out.println(666);
    }

    public static void main(String[] args) {
        Print1 p = new Print1();
        Print2 q = new Print2();
        p.print(q);
    }
}