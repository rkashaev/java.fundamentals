package courses.structures;

public class MyList<E> implements List<E> {
    Entry<E> first;
    Entry<E> last;
    int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E element) {
        if (first == null) {
            first = new Entry<>(element, null);
            last = first;
        } else {
            Entry<E> newEntry = new Entry<>(element, null);
            last.next = newEntry;
            last = newEntry;
        }
        size++;
    }

    @Override
    public void remove(int i) {
        if (i == 0) {
            first = first.next;
        } else {
            Entry<E> cur = first;
            for (int j = 0; j < i - 1; j++) {
                cur = cur.next;
            }
            // at this point cur points to (i-1)-th element
            if (i == size - 1) {
                last = cur;
            }
            cur.next = cur.next.next;
        }
        size--;
    }

    @Override
    public E get(int i) {
        if (i < 0 || i >= size()) {
            throw new IndexOutOfBoundsException("Index should be less than " + size());
        }
        Entry<E> cur = first;
        for (int j = 0; j < i; j++) {
            cur = cur.next;
        }
        return cur.get();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MyList {");
        Entry<?> cur = first;
        while (cur != null) {
            sb.append(cur.get()).append(", ");
            cur = cur.next;
        }
        sb.append("}");
        return sb.toString();
    }

    static class Entry<E> {
        private E element;
        private Entry<E> next;

        public Entry(E element, Entry<E> next) {
            this.element = element;
            this.next = next;
        }

        public E get() {
            return element;
        }
    }
}
