package courses.structures;

import static courses.structures.ArrUtils.enlarge;

public class MyArrayList<E> implements List<E> {
    Object[] arr;
    int size;

    public MyArrayList() {
        size = 0;
    }

    public MyArrayList(int capacity) {
        this();
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        arr = new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E element) {
        if (arr.length == size) {
            arr = enlarge(arr, (arr.length * 3) / 2);
        }
        arr[size++] = element;
    }

    @Override
    public void remove(int i) {
        checkIndex(i);
        int movedSize = size - i - 1;
        if (movedSize > 0) {
            System.arraycopy(arr, i + 1, arr, i, movedSize);
        }
        arr[--size] = null;
    }

    @Override
    public E get(int i) {
        checkIndex(i);

        return (E) arr[i];
    }

    @Override
    public String toString() {

        int iMax = size - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(String.valueOf(arr[i]));
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        }
    }

    private void checkIndex(int i) {
        if (i < 0 || i >= size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
}
