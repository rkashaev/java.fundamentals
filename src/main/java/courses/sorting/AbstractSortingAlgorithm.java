package courses.sorting;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Abstract class for all sortings
 */
public abstract class AbstractSortingAlgorithm {

    public abstract void sort(Comparable[] a);
    public abstract void sort(int[] a);

    /***************************************************************************
     *  Helper sorting functions.
     ***************************************************************************/

    // is v < w ?
    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // is v < w ?
    public static boolean less(int v, int w) {
        return v < w;
    }

    // is v < w ?
    public static boolean less(Object v, Object w, Comparator comparator) {
        return comparator.compare(v, w) < 0;
    }

    // exchange a[i] and a[j]
    public static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    // exchange a[i] and a[j]  (for indirect sort)
    public static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    /***************************************************************************
     *  Check if array is sorted - useful for debugging.
     ***************************************************************************/
    public static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length);
    }

    // is the array a[lo..hi) sorted
    public static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i < hi; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    public static boolean isSorted(Object[] a, Comparator comparator) {
        return isSorted(a, 0, a.length, comparator);
    }

    // is the array a[lo..hi) sorted
    public static boolean isSorted(Object[] a, int lo, int hi, Comparator comparator) {
        for (int i = lo + 1; i < hi; i++)
            if (less(a[i], a[i - 1], comparator)) return false;
        return true;
    }


    /***************************************************************************
     *  Input-output utils
     ***************************************************************************/
    // print array to standard output
    private static void show(Comparable[] a) {
        System.out.println(Arrays.toString(a));
    }
}
