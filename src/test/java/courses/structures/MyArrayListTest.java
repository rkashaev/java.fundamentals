package courses.structures;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class MyArrayListTest {
    MyArrayList<Integer> alist = new MyArrayList<>(5);

    @Test
    public void add() throws Exception {
        fillListFrom1To(6);

        System.out.println(alist);
    }

    private void fillListFrom1To(int max) {
        for (int i = 1; i <= max; i++) {
            alist.add(i);
        }
    }

    @Test
    public void removeFirst() throws Exception {
        fillListFrom1To(5);

        alist.remove(0);

        assertThat(alist.size(), is(4));
        assertArrayEquals(alist.arr, new Object[]{2, 3, 4, 5, null});
//        assertThat(alist.arr, arrayContaining(2, 3, 4, 5));

        System.out.println(alist);
    }

    @Test
    public void removeLast() throws Exception {
        fillListFrom1To(5);

        alist.remove(5);

        assertThat(alist.size(), is(4));
        assertArrayEquals(alist.arr, new Object[]{2, 3, 4, 5, null});
//        assertThat(alist.arr, arrayContaining(2, 3, 4, 5));

        System.out.println(alist);
    }

    @Test
    public void get() throws Exception {

    }

}