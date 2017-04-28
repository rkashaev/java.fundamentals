package courses.lesson5;

import java.util.Arrays;

public class ArrayTest {

    public static void main(String[] args) {
        int a[] = { 5, 10, 0, -5, 16, -2 };
        int myArray[] = new int[a.length];

        System.out.println(Arrays.toString(a));

        myArray = a.clone();
//        myArray = Arrays.copyOf(a, 5);
//        System.arraycopy(a, 0, myArray, 0, a.length);

        myArray[0] = 100;

        System.out.println(Arrays.toString(a));
        System.out.println("myArray: " + Arrays.toString(myArray));

        int[][] m1 = {
            {1, 1},
            {2, 1},
            {3, 1},
        };


//        System.arraycopy(m1, 0, m2, 0, m1.length);
//        m2 = m1.clone();
//        m2 = Arrays.copyOf(m1, m1.length);

        int[][] m2 = new int[m1.length][];

        for (int i = 0; i < m1.length; i++) {
            m2[i] = Arrays.copyOf(m1[i], m1[i].length);
        }

        m2[0][0] = 100;

        System.out.println();

        System.out.println(Arrays.deepToString(m1));
    }
}
