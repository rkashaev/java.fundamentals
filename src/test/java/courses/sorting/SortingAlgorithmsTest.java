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

    @Test
    public void testRandomMergeSort() throws Exception {
        testSortingMethodRandom(new Merge(), COUNT, ARRAY_SIZE);
    }

    @Test
    public void testOrderedMergeSort() throws Exception {
        testSortingMethodOrdered(new Merge(), COUNT, ARRAY_SIZE);
    }

    @Test
    public void testReversedMergeSort() throws Exception {
        testSortingMethodReversed(new Merge(), COUNT, ARRAY_SIZE);
    }

    @Test
    public void testMergeMethodSimple() throws Exception {
        Merge ma = new Merge();

        int[] arrBig = {1, 2, 2, 5};
        int[] tmp = new int[arrBig.length];


        int mid = (arrBig.length) / 2;
        ma.merge(arrBig, tmp, 0, mid, arrBig.length - 1);

        assertTrue(isSorted(arrBig));

        arrBig = new int[]{1, 2, 2, 5, 10};
        tmp = new int[arrBig.length];

        mid = arrBig.length / 2;
        ma.merge(arrBig, tmp, 0, mid, arrBig.length - 1);

        assertTrue(isSorted(arrBig));
    }


    @Test
    public void testMergeMethod() throws Exception {
        Merge ma = new Merge();

        int[] arr1 = fillRandomArray(10);
        int[] arr2 = fillRandomArray(10);

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int[] arrBig = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, arrBig, 0, arr1.length);
        System.arraycopy(arr2, 0, arrBig, arr1.length, arr2.length);

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arrBig));

        int[] tmp = new int[arrBig.length];

        int mid = arr1.length - 1;
        ma.merge(arrBig, tmp, 0, mid, arrBig.length - 1);

        System.out.println(Arrays.toString(arrBig));

        assertTrue(isSorted(arrBig));
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
            res[i] = rnd.nextInt(10);
        }
        return res;
    }

    private int[] copySorted(int[] arr) {
        int[] sorted = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sorted);
        return sorted;
    }

}