package courses.lesson8;

public class StaticClasses01 {
    public static void main(String[] args) {
        Doctor.stMan();
        System.out.println("Run.");

        Doctor doctor = new Doctor();
        System.out.println(doctor.form);

        Doctor.stDoctor();
    }
}

class Man {
    public static String form = "man";

    static {
        System.out.println("static block in Man.");
    }

    public static void stMan() {
        System.out.println("static method in Man.");
    }
}

class Doctor extends Man {
    static {
        System.out.println("static block in Doctor");
    }

    public static void stDoctor() {
        System.out.println("static method in Doctor.");
    }

    public static void stMan() {
        System.out.println("static overriden method in Doctor.");
    }
}
