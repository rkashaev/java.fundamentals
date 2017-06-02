package courses.structures;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class LinkedStackTest {

    LinkedStack<Integer> as;

    @Before
    public void init() throws Exception {
        as = new LinkedStack<>();
    }

    @Test
    public void testPush() throws Exception {
        as.push(10);

        assertThat(as.size(), is(1));
        assertThat(as.top.data, is(10));
    }

    @Test
    public void testPushTwice() throws Exception {
        as.push(1);
        as.push(2);

        assertThat(as.size(), is(2));
        assertThat(as.top.data, is(2));
        assertThat(as.top.next.data, is(1));

    }


    @Test
    public void testStackOrder() throws Exception {
        as.push(1);
        as.push(2);
        as.push(3);
        as.push(4);
        as.push(5);
        as.push(6);

        assertEquals(6, as.size());

        assertEquals(6, (int) as.pop());
        assertEquals(5, (int) as.pop());
        assertEquals(4, (int) as.pop());
        assertEquals(3, (int) as.pop());
        assertEquals(2, (int) as.pop());
        assertEquals(1, (int) as.pop());
    }

    @Test(expected = EmptyStackException.class)
    public void testEmptyStack() throws Exception {
        as.push(10);

        as.pop();
        as.pop();
    }

    @Test()
    public void testIterator() throws Exception {
        as.push(10);
        as.push(11);
        as.push(12);
        as.push(13);
        as.push(14);

        java.util.List<Integer> expected = Arrays.asList(14, 13, 12, 11, 10);
        java.util.List<Integer> actual = new ArrayList<>();
        for (Integer item : as) {
            actual.add(item);
        }
        assertThat(actual, equalTo(expected));
    }
}