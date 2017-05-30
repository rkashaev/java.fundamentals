package courses.structures;

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
            enlarge();
        }
        arr[size++] = element;
    }

    private void enlarge() {
        // out of memory checks are skipped
        int newSize = (arr.length * 3) / 2;
        Object[] newArr = new Object[newSize];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        arr = newArr;
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
