package courses.structures;

import org.junit.Test;

import java.io.*;
import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class ArrayStackTest {

    @Test
    public void testPush() throws Exception {
        ArrayStack<Integer> as = new ArrayStack<>(5);
        as.push(10);
        as.push(11);

        assertArrayEquals(new Object[]{10, 11, null, null, null}, as.arr);
    }

    @Test
    public void testPushGrow() throws Exception {
        ArrayStack<Integer> as = new ArrayStack<>(5);
        as.push(1);
        as.push(1);
        as.push(1);
        as.push(1);
        as.push(1);
        as.push(2);

        assertArrayEquals(new Object[]{1, 1, 1, 1, 1, 2, null}, as.arr);
    }

    @Test
    public void testOOME() throws Exception {
        ArrayStack<Integer> as = new ArrayStack<>(5);
        as.push(1);
        as.push(1);

        assertArrayEquals(new Object[]{1, 1, null, null, null}, as.arr);

        as.pop();

        assertArrayEquals(new Object[]{1, null, null, null, null}, as.arr);
    }

    @Test
    public void testStackOrder() throws Exception {
        ArrayStack<Integer> as = new ArrayStack<>(5);
        as.push(1);
        as.push(2);
        as.push(3);
        as.push(4);
        as.push(5);
        as.push(6);

        assertEquals(6, (int) as.pop());
        assertEquals(5, (int) as.pop());
        assertEquals(4, (int) as.pop());
        assertEquals(3, (int) as.pop());
        assertEquals(2, (int) as.pop());
        assertEquals(1, (int) as.pop());
    }

    @Test(expected = EmptyStackException.class)
    public void testEmptyStack() throws Exception {
        ArrayStack<Integer> as = new ArrayStack<>();
        as.push(10);

        as.pop();
        as.pop();
    }

    @Test()
    public void testSout() throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));

        byte[] bytes = baos.toByteArray();

        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
    }

}