package courses.lesson8;

import java.util.Date;

public class StaticBlocksInit {

    public static void main(String[] args) throws Exception {
        StaticBlocks sbi;
        System.out.println("step -1");

        //Class.forName("courses.lesson8.StaticBlocks");
        StaticBlocks.staticMethod();

        System.out.println("step 0");

        System.out.println("step 1");

        sbi = new StaticBlocks(3);
    }
}

class StaticBlocks {

    private static int id = 7;

    {  id = 10; System.out.println("logic (3) id="+ id); }

    static { System.out.println("static (1) id="+ id); }

    static {
        System.out.println("static (2) id="+ id);
        Date d = new Date();
        calc(d);
    }

    /**
     * Constructor
     */
    public StaticBlocks(int d) {
        System.out.println("constructor before: id = " + id);
        id = d;
        System.out.println("constructor id=" + id);
    }


    private static void calc(Date d){
        System.out.println(d.getTime());
    }

    public static void staticMethod(int ... ints) {
        for (int i : ints) {
            System.out.println(i);
        }

    }
}
