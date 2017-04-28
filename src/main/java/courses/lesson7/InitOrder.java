package courses.lesson7;

public class InitOrder {
    public static void main (String s[]) {
        Point p = new Point();
        System.out.println(p.x + "," + p.y);
    }
}

class Point {
    int getX() { return x; }

    int y = getX();
    int x = 3;
}