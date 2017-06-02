package courses.structures;

import java.util.EmptyStackException;
import java.util.Iterator;

public class LinkedStack<E> implements Stack<E>, Iterable<E> {
    Entry<E> top = null;
    int size = 0;


    @Override
    public int size() {
        return size;
    }

    @Override
    public void push(E obj) {
        Entry<E> tmp = new Entry<>(obj);
        tmp.next = top;
        top = tmp;
        size++;
    }

    @Override
    public E pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        Entry<E> tmp = this.top;
        top = tmp.next;
        size--;
        return tmp.data;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedStackIterator<>();
    }

    static class Entry<E> {
        E data;
        Entry<E> next = null;

        Entry(E data) {
            this.data = data;
        }
    }

    class LinkedStackIterator<T> implements Iterator<T> {
        Entry cur = null;

        LinkedStackIterator() {
            cur = top;
        }

        @Override
        public boolean hasNext() {
            return (cur != null);
        }

        @Override
        public T next() {
            T data = (T) cur.data;
            cur = cur.next;
            return data;
        }
    }
}
