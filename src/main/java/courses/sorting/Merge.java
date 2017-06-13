package courses.sorting;

public class Merge extends AbstractSortingAlgorithm {
    @Override
    public void sort(Comparable[] a) {

    }

    @Override
    public void sort(int[] a) {
        final int[] tmp = new int[a.length];

        sort(a, tmp, 0, a.length - 1);
    }

    private void sort(int[] a, int[] tmp, int lo, int hi) {
        if (hi <= lo) return;

        final int mid = lo + (hi - lo) / 2;

        sort(a, tmp, lo, mid);
        sort(a, tmp, mid + 1, hi);
        merge(a, tmp, lo, mid, hi);

    }

    void merge(int[] a, int[] tmp, int lo, int mid, int hi) {
        // copy the array first to temporary
        for (int i = lo; i <= hi; i++) {
            tmp[i] = a[i];
        }

        // then merge back to a[]
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            // if the left subarray is exhausted
            if (i > mid) a[k] = tmp[j++];
                // if the right subarray is exhausted
            else if (j > hi) a[k] = tmp[i++];
                // if element from right is less than from left
            else if (less(tmp[j], tmp[i])) a[k] = tmp[j++];
                // else
            else a[k] = tmp[i++];
        }
    }
}
