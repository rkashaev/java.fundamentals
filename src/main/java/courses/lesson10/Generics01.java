package courses.lesson10;

public class Generics01 {
    public static void main(String[] args) {
        Opt<String> o1 = new Opt<>();
        Opt<Integer> o2 = new Opt<>();
        Opt o3 = new Opt();

        System.out.println(o1.getClass());
        System.out.println(o2.getClass());
        System.out.println(o3.getClass());

        System.out.println(o3.<Double>castToE(10.0f));

    }
}

class Opt<T> {
    private T value;

    public Opt() {
    }

    public Opt(T value) {
        this.value = value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public <E extends Number> E castToE(E value) {
        //
        System.out.println(value.getClass());
        return (value);
    }
}
