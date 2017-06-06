package courses.structures;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class MyHashMapTest {

    @Test
    public void putWithRewrite() throws Exception {
        MyHashMap<Integer, String> map = new MyHashMap<>(1);
        map.put(1, "test");

        assertThat(map.arr[0].key, is(1));
        assertThat(map.arr[0].value, is("test"));
        assertThat(map.arr[0].next, is(nullValue()));

        map.put(1, "test1");
        assertThat(map.arr[0].key, is(1));
        assertThat(map.arr[0].value, is("test1"));
        assertThat(map.arr[0].next, is(nullValue()));
    }

    @Test
    public void putChain2() throws Exception {
        MyHashMap<Integer, String> map = new MyHashMap<>(1);
        map.put(1, "test");
        map.put(2, "test2");
        map.put(3, "test3");

        assertThat(map.arr[0].key, is(1));
        assertThat(map.arr[0].value, is("test"));
        assertThat(map.arr[0].next.key, is(2));
        assertThat(map.arr[0].next.value, is("test2"));
        assertThat(map.arr[0].next.next.key, is(3));
        assertThat(map.arr[0].next.next.value, is("test3"));
    }

    @Test
    public void get() throws Exception {
        String[] vals = {"test1", "test2", "test3", "test4", "test5"};

        for (int i = 0; i < 5; i++) {
            MyHashMap<Integer, String> map = new MyHashMap<>(4);
            for (int j = 0; j < 5; j++) {
                map.put(j, vals[j]);
            }

            for (int j = 0; j < 5; j++) {
                assertThat(map.get(j), is(vals[j]));
            }
        }

    }

    @Test
    public void getOrDefault() throws Exception {
    }

    @Test
    public void remove() throws Exception {
    }

}