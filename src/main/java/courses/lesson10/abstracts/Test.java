package courses.lesson10.abstracts;

public class Test {
    public static void main(String... args) {
        A a = new C();
        a.m1();
        a.m2();
    }
}

abstract class A {
    public void m1() {
        System.out.println("m1 from A class");
    }
    public abstract void m2();
}

/**
 * ����� �������������� ����� � ������� ��� �����������
 */
abstract class B extends A {
//    public abstract void m1();
}

class C extends B {
    public void m2() {
        System.out.println("m2 from C class");
    }
}