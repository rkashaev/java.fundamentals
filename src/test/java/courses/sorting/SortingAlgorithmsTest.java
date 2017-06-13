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
        testSortingMethodRandom(new Selection(), COUNT, 1000);
    }

    @Test
    public void testOrderedSelectionSort() throws Exception {
        testSortingMethodOrdered(new Selection(), COUNT, 1000);
    }

    @Test
    public void testReversedSelectionSort() throws Exception {
        testSortingMethodReversed(new Selection(), COUNT, 1000);
    }

    @Test
    public void testRandomInsertionSort() throws Exception {
        testSortingMethodRandom(new Insertion(), COUNT, 1000);
    }

    @Test
    public void testOrderedInsertionSort() throws Exception {
        testSortingMethodOrdered(new Insertion(), COUNT, 1000);
    }

    @Test
    public void testReversedInsertionSort() throws Exception {
        testSortingMethodReversed(new Insertion(), COUNT, 1000);
    }

    private void testSortingMethodRandom(AbstractSortingAlgorithm sa, int times, int size) {
        long t;
        long totalTime = 0;
        for (int i = 0; i < times; i++) {

            final int[] arr = fillRandomArray(size);
            final int[] sorted = copySorted(arr);

            t = System.currentTimeMillis();
            sa.sort(arr);
            totalTime += System.currentTimeMillis() - t;

            assertArrayEquals(sorted, arr);
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
            final int[] sorted = Arrays.copyOf(arr, arr.length);

            t = System.currentTimeMillis();
            sa.sort(arr);
            totalTime += System.currentTimeMillis() - t;

            assertArrayEquals(sorted, arr);
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
            final int[] sorted = copySorted(arr);

            t = System.currentTimeMillis();
            sa.sort(arr);
            totalTime += System.currentTimeMillis() - t;

            assertArrayEquals(sorted, arr);
        }
        System.out.printf("%d times of sorting %d reverse ordered integers by %s sort took %d ms\n",
                times,
                size,
                sa.getClass().getSimpleName(),
                totalTime);
    }

    private int[] fillOrderedArray(int size, boolean reversed) {
        final int[] res = new int[size];
        final int spot =  size + rnd.nextInt(10_000);
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