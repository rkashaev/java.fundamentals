package courses.structures;

import java.util.EmptyStackException;

import static courses.structures.ArrUtils.enlarge;

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
            arr = enlarge(arr, (arr.length * 3) / 2);
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

}
