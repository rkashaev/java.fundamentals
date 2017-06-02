package courses.structures;


import java.util.EmptyStackException;
import java.util.Iterator;

public class ArrayQueue<E> implements Queue<E>, Iterable<E> {
    Object[] arr;
    int size = 0;
    int head = 0;
    int tail = 0;

    public ArrayQueue() {
        this(10);
    }

    public ArrayQueue(int capacity) {
        arr = new Object[capacity];
    }

    @Override
    public void enqueue(E obj) {
        if (size == arr.length) {
            enlarge();
        }
        arr[tail] = obj;
        tail = inc(tail);
        size++;
    }

    @Override
    public E dequeue() {
        if (size == 0) {
            throw new EmptyQueueException("The queue is empty!");
        }
        size--;
        E e = (E) arr[head];
        arr[head] = null; // hello, GC
        head = inc(head);
        return e;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int cur = head;
            int covered = 0;

            @Override
            public boolean hasNext() {
                return covered < size();
            }

            @Override
            public E next() {
                covered++;
                return (E) arr[cur++ % arr.length];
            }
        };
    }

    private void enlarge() {
        // out of memory checks are skipped
        int newSize = arr.length << 1;
        Object[] newArr = new Object[newSize];
        // cyclic copy
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[(head + i) % arr.length];
        }
        head = 0;
        tail = size;
        arr = newArr;
    }

    private int inc(int idx) {
        return (idx + 1) % arr.length;
    }
}
