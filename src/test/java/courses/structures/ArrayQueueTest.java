package courses.structures;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class ArrayQueueTest {

    @Test
    public void enqueueWithOverload() throws Exception {
        ArrayQueue<Integer> queue = new ArrayQueue<>(5);

        assertThat(queue.size(), is(0));

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);

        assertThat(queue.size(), is(6));
    }

    @Test
    public void dequeue() throws Exception {
        ArrayQueue<Integer> queue = new ArrayQueue<>(5);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        assertThat(queue.dequeue(), is(1));
        assertThat(queue.size(), is(4));

        assertArrayEquals(queue.arr, new Integer[]{null, 2, 3, 4, 5});

        assertThat(queue.dequeue(), is(2));
        assertThat(queue.dequeue(), is(3));
        assertThat(queue.dequeue(), is(4));
        assertThat(queue.dequeue(), is(5));
        assertThat(queue.size(), is(0));
    }

    @Test
    public void dequeueEmpty() throws Exception {
        ArrayQueue<Integer> queue = new ArrayQueue<>(5);

        try {
            queue.dequeue();
            fail("Here should be an exception about empty queue");
        } catch (RuntimeException e) {
        }

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertThat(queue.dequeue(), is(1));
        assertThat(queue.dequeue(), is(2));
        assertThat(queue.dequeue(), is(3));

        try {
            queue.dequeue();
            fail("Here should be an exception about empty queue");
        } catch (RuntimeException e) {
        }
    }

    @Test
    public void cyclicThings() throws Exception {
        ArrayQueue<Integer> queue = new ArrayQueue<>(5);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        queue.dequeue();
        queue.dequeue();

        assertArrayEquals(queue.arr, new Integer[]{null, null, 3, null, null});

        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);

        assertArrayEquals(queue.arr, new Integer[]{6, 7, 3, 4, 5});
    }

    @Test
    public void cyclicGrowth() throws Exception {
        ArrayQueue<Integer> queue = new ArrayQueue<>(5);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        queue.dequeue();
        queue.dequeue();

        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);

        assertArrayEquals(new Integer[]{6, 7, 3, 4, 5}, queue.arr);

        queue.enqueue(8);
        queue.enqueue(9);

        assertThat(queue.size(), is(greaterThan(5)));

        assertArrayEquals(new Integer[]{3, 4, 5, 6, 7, 8, 9, null, null, null}, queue.arr);
    }
}