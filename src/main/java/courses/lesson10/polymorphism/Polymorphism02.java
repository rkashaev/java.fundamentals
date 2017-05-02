package courses.lesson10.polymorphism;

public class Polymorphism02 {

    static class A {
        public String str;

        public void setStr(String str) {
            this.str = str;
        }
    }

    static class B1 extends A {
        public String str;

        public void setStr(String str) {
            this.str = str;
        }
    }

    static class B2 extends A {
        public int str;                    // 1

        public void setStr(int str) {
            this.str = str;
        }
    }

    static void m(A a) {
        a.str = "string";
//        a.setStr("string");
    }

    public static void main(String[] args) throws Exception {
        A a = new A();
        B1 b1 = new B1();
        B2 b2 = new B2();

        m(a);
        m(b1);
        m(b2);                            // 2

        System.out.println(a.str);
        System.out.println(b1.str);
        System.out.println(b2.str);        // 3
    }
}