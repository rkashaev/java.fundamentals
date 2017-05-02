package courses.lesson10;

public class Visibility {
    public static void main(String[] args) {
        System.out.println("Ok");
    }
}

class Small {
    Number growUp() {
        System.out.println("I'm big now");
        return 5;
    }
}

class Medium extends Small {
//    protected Number growUp() {
//        System.out.println("I'm small");
//        return 5;
//    }

//    public Integer growUp(int f) {
//        System.out.println("I'm not so big");
//        return 5;
//    }

//    private Number growUp() {
//        System.out.println("I want to be big");
//        return 5;
//    }

//    protected Float growUp(float f) {
//        System.out.println("I want to be bigger");
//        return 5f;
//    }
//
//    private Void growUp() {
//        System.out.println("I want to be big");
//        return null;
//    }
}