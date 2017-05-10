package courses.lesson7;

public class ImplicitParameter {
    private String st;

    public ImplicitParameter() {
        this(null);
    }

    public ImplicitParameter(String s) {
        st = s;
    }

    public String getSt(/*ImplicitParameter this*/) {

        return st;
    }

    public static void main(String[] args) {
        ImplicitParameter t1 = new ImplicitParameter();
        System.out.println("ok");
    }
}
