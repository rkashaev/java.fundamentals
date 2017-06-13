package courses.sorting;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static courses.sorting.AbstractSortingAlgorithm.isSorted;
import static org.junit.Assert.assertTrue;

public class SortingAlgorithmsTest {
    private static final int COUNT = 10;
    public static final int ARRAY_SIZE = 10_000;
    private Random rnd;

    @Before
    public void setUp() throws Exception {
        rnd = new Random();
    }

    @Test
    public void testRandomSelectionSort() throws Exception {
        testSortingMethodRandom(new Selection(), COUNT, ARRAY_SIZE);
    }

    @Test
    public void testOrderedSelectionSort() throws Exception {
        testSortingMethodOrdered(new Selection(), COUNT, ARRAY_SIZE);
    }

    @Test
    public void testReversedSelectionSort() throws Exception {
        testSortingMethodReversed(new Selection(), COUNT, ARRAY_SIZE);
    }

    @Test
    public void testRandomInsertionSort() throws Exception {
        testSortingMethodRandom(new Insertion(), COUNT, ARRAY_SIZE);
    }

    @Test
    public void testOrderedInsertionSort() throws Exception {
        testSortingMethodOrdered(new Insertion(), COUNT, ARRAY_SIZE);
    }

    @Test
    public void testReversedInsertionSort() throws Exception {
        testSortingMethodReversed(new Insertion(), COUNT, ARRAY_SIZE);
    }

    @Test
    public void testRandomShellSort() throws Exception {
        testSortingMethodRandom(new Shell(), COUNT, ARRAY_SIZE);
    }

    @Test
    public void testOrderedShellSort() throws Exception {
        testSortingMethodOrdered(new Shell(), COUNT, ARRAY_SIZE);
    }

    @Test
    public void testReversedShellSort() throws Exception {
        testSortingMethodReversed(new Shell(), COUNT, ARRAY_SIZE);
    }


    private void testSortingMethodRandom(AbstractSortingAlgorithm sa, int times, int size) {
        long t;
        long totalTime = 0;
        for (int i = 0; i < times; i++) {
            final int[] arr = fillRandomArray(size);

            t = System.currentTimeMillis();
            sa.sort(arr);
            totalTime += System.currentTimeMillis() - t;

            assertTrue(isSorted(arr));
        }
        System.out.printf("%d times of sorting %d random integers by %s sort took %d ms\n",
                times,
                size,
                sa.getClass().getSimpleName(),
                totalTime);
    }

    private void testSortingMethodOrdered(AbstractSortingAlgorithm sa, int times, int size) {
        long t;
        long totalTime = 0;
        for (int i = 0; i < times; i++) {

            final int[] arr = fillOrderedArray(size, false);

            t = System.currentTimeMillis();
            sa.sort(arr);
            totalTime += System.currentTimeMillis() - t;

            assertTrue(isSorted(arr));
        }
        System.out.printf("%d times of sorting %d ordered integers by %s sort took %d ms\n",
                times,
                size,
                sa.getClass().getSimpleName(),
                totalTime);
    }

    private void testSortingMethodReversed(AbstractSortingAlgorithm sa, int times, int size) {
        long t;
        long totalTime = 0;
        for (int i = 0; i < times; i++) {

            final int[] arr = fillOrderedArray(size, true);

            t = System.currentTimeMillis();
            sa.sort(arr);
            totalTime += System.currentTimeMillis() - t;

            assertTrue(isSorted(arr));
        }
        System.out.printf("%d times of sorting %d reverse ordered integers by %s sort took %d ms\n",
                times,
                size,
                sa.getClass().getSimpleName(),
                totalTime);
    }

    private int[] fillOrderedArray(int size, boolean reversed) {
        final int[] res = new int[size];
        final int spot = size + rnd.nextInt(10_000);
        for (int i = 0; i < res.length; i++) {
            if (reversed) {
                res[i] = spot - i;
            } else {
                res[i] = spot + i;
            }
        }
        return res;
    }

    private int[] fillRandomArray(int size) {
        final int[] res = new int[size];
        for (int i = 0; i < res.length; i++) {
            res[i] = rnd.nextInt();
        }
        return res;
    }

    private int[] copySorted(int[] arr) {
        int[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);
        return sorted;
    }

}