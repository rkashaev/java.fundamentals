package courses.lesson7.inheritance;

public class Constructors02 {

    public static void main(String[] args) {
        Alpha a = new Alpha();
    }
}


class Beta {
    //private - will not compile
    Beta() {
        System.out.print("1");
    }

    protected Beta(String str) {
        System.out.print("2");
    }
}

class Alpha extends Beta {
    public Alpha() {
        this("smth");
    }

    public Alpha(String str) {
    }

}