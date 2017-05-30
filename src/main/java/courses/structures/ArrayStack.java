package courses.structures;

import java.util.EmptyStackException;

public class ArrayStack<E> implements Stack<E> {
    Object[] arr;
    int top = 0;

    public ArrayStack() {
        arr = new Object[10];
    }

    public ArrayStack(int capacity) {
        arr = new Object[capacity];
    }

    @Override
    public int size() {
        return top;
    }

    @Override
    public void push(E obj) {
        if (top == arr.length) {
            enlarge();
        }
        arr[top++] = obj;
    }

    @Override
    public E pop() {
        if (top == 0) {
            throw new EmptyStackException();
        }

        E e = (E) arr[--top];
        arr[top] = null;
        return e;
    }

    private void enlarge() {
        // out of memory checks are skipped
        int newSize = (arr.length * 3) / 2;
        Object[] newArr = new Object[newSize];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        arr = newArr;
    }
}
