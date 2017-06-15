package courses.structures;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MaxPQTest {


    @Test
    public void testInsert() throws Exception {
        MaxPQ<String> pq = new MaxPQ<>(4);

        pq.insert("A");

        assertNull(pq.arr[0]);
        assertEquals("A", pq.arr[1]);

        pq.insert("C");

        assertEquals("C", pq.arr[1]);
        assertEquals("A", pq.arr[2]);

        pq.insert("B");

        assertEquals("C", pq.arr[1]);
        assertEquals("A", pq.arr[2]);
        assertEquals("B", pq.arr[3]);
    }

    @Test
    public void testDelMax() throws Exception {
        MaxPQ<String> pq = new MaxPQ<>(4);

        pq.insert("A");
        pq.insert("B");
        pq.insert("C");
        pq.insert("D");

        assertEquals("D", pq.delMax());
        assertEquals("C", pq.delMax());
        assertEquals("B", pq.delMax());
        assertEquals("A", pq.delMax());
    }

    @Test
    public void testSimpleSwim() throws Exception {
        MaxPQ<String> pq = new MaxPQ<>(4);

        int i = 0;
        pq.arr[++i] = "B";
        pq.arr[++i] = "A";
        pq.arr[++i] = "C";
        pq.n = i;

        pq.swim(3);

        assertEquals("C", pq.arr[1]);
        assertEquals("A", pq.arr[2]);
        assertEquals("B", pq.arr[3]);
    }

    @Test
    public void testSimpleSink() throws Exception {
        MaxPQ<String> pq = new MaxPQ<>(4);

        int i = 0;
        pq.arr[++i] = "A";
        pq.arr[++i] = "B";
        pq.arr[++i] = "C";
        pq.n = i;

        pq.sink(1);

        assertEquals("C", pq.arr[1]);
        assertEquals("B", pq.arr[2]);
        assertEquals("A", pq.arr[3]);
    }

}