package courses.structures;

import java.util.EmptyStackException;

public class LinkedStack<E> implements Stack<E> {
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

    static class Entry<E> {
        E data;
        Entry<E> next = null;

        public Entry(E data) {
            this.data = data;
        }
    }
}
