package courses.tasks;

import java.util.BitSet;

public class ArrayUtils {

    static int binarySearch(int el, int[] arr) {
        return bsearch(arr, 0, arr.length - 1, el);
    }

    private static int bsearch(int[] arr, int l, int r, int key) {
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] < key) {
                l = m + 1;
            } else if (arr[m] > key) {
                r = m - 1;
            } else {
                return m;
            }
        }
        //key not found
        return -1;
    }
}
