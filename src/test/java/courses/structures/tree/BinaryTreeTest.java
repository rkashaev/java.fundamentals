package courses.structures.tree;

import org.junit.Test;

import java.util.*;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BinaryTreeTest {

    @Test
    public void testAddNSearch() throws Exception {
        BinaryTree<Integer> bt = new BinaryTree<>();

        bt.add(1);
        bt.add(2);
        bt.add(3);

        assertTrue(bt.search(1));
        assertTrue(bt.search(2));
        assertTrue(bt.search(3));

        assertFalse(bt.search(4));
        assertFalse(bt.search(0));
        assertFalse(bt.search(-1));
        assertFalse(bt.search(Integer.MAX_VALUE));
        assertFalse(bt.search(Integer.MIN_VALUE));
    }

    @Test
    public void testDepthFirst() throws Exception {
        BinaryTree<Integer> bt = new BinaryTree<>();

        final int[] items = {10, 2, 5, 7, 15, 12, 16, 1};
        final List<Integer> expected = asList(10, 2, 1, 5, 7, 15, 12, 16);

        for (int item : items) {
            bt.add(item);
        }

        assertEquals(expected, bt.depthFirstTraversal());
    }

    @Test
    public void testBreadthFirst() throws Exception {
        BinaryTree<Integer> bt = new BinaryTree<>();

        final int[] items = {10, 2, 5, 7, 15, 12, 16, 1};
        final List<Integer> expected = asList(10, 2, 15, 1, 5, 12, 16, 7);

        for (int item : items) {
            bt.add(item);
        }

        assertEquals(expected, bt.breadthFirstTraversal());
    }
}