package courses.tasks;

import org.junit.Test;

import static courses.tasks.ArrayUtils.binarySearch;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ArrayUtilsTest {

    @Test
    public void testBinarySearchOdd() throws Exception {
        int[] arr = {1, 2, 3, 4, 5};

        assertThat(binarySearch(1, arr), is(0));
        assertThat(binarySearch(3, arr), is(2));
        assertThat(binarySearch(5, arr), is(4));

        assertThat(binarySearch(8, arr), is(-1));
    }

    @Test
    public void testBinarySearchEven() throws Exception {
        int[] arr = {1, 2, 3, 4, 5, 6};

        assertThat(binarySearch(1, arr), is(0));
        assertThat(binarySearch(3, arr), is(2));
        assertThat(binarySearch(5, arr), is(4));
        assertThat(binarySearch(6, arr), is(5));

        assertThat(binarySearch(8, arr), is(-1));
        assertThat(binarySearch(0, arr), is(-1));
    }

}