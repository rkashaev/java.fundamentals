package courses.lesson18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CollectionTests {
    public static void main(String[] args) {
        Collection<String> col = Arrays.asList("One", "two", "three");
        System.out.println(col);

        //String[] colArr = col.toArray(new String[0]);
        String[] colArr = col.toArray(new String[col.size()]);
        System.out.println(Arrays.toString(colArr));
    }
}
