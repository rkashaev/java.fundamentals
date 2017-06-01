package courses.structures;

public class ArrUtils {

    public static Object[] enlarge(Object[] arr, int newSize) {
        // out of memory checks are skipped
        Object[] newArr = new Object[newSize];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        return newArr;
    }
}
