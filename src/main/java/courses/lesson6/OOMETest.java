package courses.lesson6;

import java.util.Scanner;

public class OOMETest {

    public static final int SIZE = 10000000;

    public static void main(String[] args) {
//        int[][] c = new int[SIZE][];

        Scanner s = new Scanner(System.in);
        System.out.println("Get ready! ");
        s.nextLine();

        for (int i = 0; i < SIZE; i++) {
            System.out.println("Allocation iteration " + i);
            int[] c = new int[100];
        }

        System.out.println("I'm fine!");
    }
}
