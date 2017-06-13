package courses.sorting;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;

public class SortingAlgorithmsTest {
    private static final int COUNT = 100;
    private Random rnd;

    @Before
    public void setUp() throws Exception {
        rnd = new Random();
    }

    @Test
    public void testRandomSelectionSort() throws Exception {
        testSortingMethodTimes(new Selection(), COUNT);
    }

    @Test
    public void testRandomInsertionSort() throws Exception {
        testSortingMethodTimes(new Insertion(), COUNT);
    }

    private int[] fillRandomArray(int size) {
        final int[] res = new int[size];
        for (int i = 0; i < res.length; i++) {
            res[i] = rnd.nextInt();
        }
        return res;
    }

    private void testSortingMethodTimes(AbstractSortingAlgorithm sa, int cnt) {
        for (int i = 0; i < cnt; i++) {

            final int[] arr = fillRandomArray(1000);
            final int[] sorted = copySorted(arr);

            sa.sort(arr);

            assertArrayEquals(sorted, arr);
        }
    }

    private int[] copySorted(int[] arr) {
        int[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);
        return sorted;
    }

}