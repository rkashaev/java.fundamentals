package courses.lesson3;

public class A {
    private int s = 1;

    //...

    public boolean equals(A another) {
        return (another.s == s);
    }


    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new A();

        System.out.println(a1.equals(a2));
    }

    

}