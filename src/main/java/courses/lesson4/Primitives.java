package courses.lesson4;

public class Primitives {

    public static void main(String[] args) {

        int[][] m = new int[10][10];

        for (int i1 = 0; i1 < m.length; i1++) {
            for (int j = 0; j < m[i1].length; j++) {
                System.out.printf("%3d", m[i1][j]);
            }
            System.out.println();
        }
    }
}
