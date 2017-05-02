package courses.lesson10.polymorphism;

import java.util.ArrayList;
import java.util.List;

class A {
    String name = "a ";
    String test() {
        return "test A ";
    }
}

class B extends A {
    String name = "b ";
    String test() {
        System.out.println("supername = " + super.name);

        return "test B ";
    }
}

/**
 * ����������� ���������������� ������ �� ������
 */
public class Polymorphism01 {
    public static void main(String[] args) {
        new Polymorphism01().go();
    }

    void go() {
        A m = new B();
        System.out.println(m.name + m.test());
    }

    void delete() {
        List a = new ArrayList<Integer>();

    }

    public void doSomething(int a) {
        //...
    }

    public void doSomething() {
        doSomething(100);
    }

    static class A1 {
        public String str;
    }

    static class B1 extends A1 {
        public String str;
    }

    static class B2 extends A1 {
        public int str;
    }

}

interface I1 {
    static int a = 20;
    int te = 20;

}