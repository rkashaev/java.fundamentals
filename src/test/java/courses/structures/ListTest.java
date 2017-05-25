package courses.structures;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ListTest {
    static final String[] strings = {
            "0 Спят в удаве кролики",
            "1 Спит в компоте слива",
            "2 Крестики без ноликов",
            "3 Дремлют сиротливо"
    };
    MyList<String> list;

    @Before
    public void setUp() throws Exception {
        list = new MyList<>();
    }

    @Test
    public void testAddFirst() {

        list.add(strings[0]);

        assertEquals(strings[0], list.first.get());
    }

    @Test
    public void testAddMore() {
        list.add(strings[0]);
        assertEquals(strings[0], list.first.get());
        assertEquals(1, list.size);

        list.add(strings[1]);
        assertEquals(strings[0], list.first.get());
        assertEquals(strings[1], list.last.get());
        assertEquals(2, list.size);

        list.add(strings[2]);
        assertEquals(strings[0], list.first.get());
        assertEquals(strings[2], list.last.get());
        assertEquals(3, list.size);

        list.add(strings[3]);
        assertEquals(strings[0], list.first.get());
        assertEquals(strings[3], list.last.get());
        assertEquals(4, list.size);
    }

    @Test
    public void testGetElements() throws Exception {
        fillMyList(3);

        assertEquals(strings[0], list.get(0));
        assertEquals(strings[1], list.get(1));
        assertEquals(strings[2], list.get(2));
    }

//    @Test(expected = IndexOutOfBoundsException.class)
    @Test
    public void testGetBoundsCheck() throws Exception {
        fillMyList(3);

        try {
            list.get(3);
            fail("There should be an exception!");
        } catch (IndexOutOfBoundsException e) {
            // gotcha!
        }

        try {
            list.get(-1);
            fail("There should be an exception!");
        } catch (IndexOutOfBoundsException e) {
            // gotcha!
        }
    }

    @Test
    public void testRemoveFirst() throws Exception {
        fillMyList(3);

        list.remove(0);
        assertEquals(2, list.size);

        assertEquals(strings[1], list.get(0));
        assertEquals(strings[2], list.get(1));
    }

    @Test
    public void testRemoveNotFirst() throws Exception {
        fillMyList(3);

        System.out.println("Before deletion:");
        System.out.println(list);

        list.remove(1);

        System.out.println("Deleted 2nd element:");
        System.out.println(list);

        assertEquals(2, list.size);

        assertEquals(strings[0], list.get(0));
        assertEquals(strings[2], list.get(1));
        assertEquals(strings[2], list.last.get());

        list.remove(1);

        System.out.println("Deleted 2nd element:");
        System.out.println(list);

        assertEquals(1, list.size);

        assertEquals(strings[0], list.get(0));
    }

    @Test
    public void testWhenRemoveIShouldNotLoseLast() throws Exception {
        fillMyList(4);

        System.out.println("Before deletion:");
        System.out.println(list);

        list.remove(3);

        System.out.println("Deleted 3rd element:");
        System.out.println(list);

        assertEquals(3, list.size);

        assertEquals(strings[2], list.get(2));
        assertEquals(strings[2], list.last.get());
        System.out.println(list.last.get());
    }

    private void fillMyList(int n) {
        for (int i = 0; i < n; i++) {
            list.add(strings[i]);
        }
    }
}