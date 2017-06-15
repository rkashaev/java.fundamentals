package courses.structures;

import java.util.NoSuchElementException;

public class MaxPQ<K extends Comparable<K>> {
    Object[] arr;                    // store items at indices 1 to n
    int n;                     // number of items on priority queue

    public MaxPQ(int initCapacity) {
        arr = new Object[initCapacity + 1];
        n = 0;
    }

    public MaxPQ() {
        this(16);
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public K max() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue is empty");
        return (K) arr[1];
    }

    public void insert(K x) {

        // double size of array if necessary
        if (n >= arr.length - 1) resize(2 * arr.length);

        // add x, and percolate it up to maintain heap invariant
        arr[++n] = x;
        swim(n);
    }


    public K delMax() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        // find max element
        K max = (K) arr[1];
        // exchange the last element with the root, decrement n
        exch(1, n--);
        // then do sink for the root
        sink(1);
        arr[n + 1] = null;     // make the GC do it's job ;)
        return max;
    }

    void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private boolean less(int i, int j) {
        return ((Comparable<K>) arr[i]).compareTo((K) arr[j]) < 0;
    }

    private void exch(int i, int j) {
        Object swap = arr[i];
        arr[i] = arr[j];
        arr[j] = swap;
    }

    // helper function to double the size of the heap array
    private void resize(int capacity) {
        if (capacity <= n) {
            throw new IllegalArgumentException("The new size must be more than current");
        }
        Object[] temp = new Object[capacity];

        for (int i = 1; i <= n; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }
}
